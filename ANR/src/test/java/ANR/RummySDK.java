package ANR;

import baseTest.BaseTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RummySDK extends BaseTest {

    String platform = props.getProperty("platform");
    int noOfIterations = 100;
    int reloadChipsFrequency = 10;
    int F2UFrequency = 1;
    int bound = 20;

    @Test
    @Parameters(value = {"deviceIndex"})
    public void anr(@Optional String deviceIndex) throws InterruptedException {
        //flows.loginExistingUser(platform, deviceIndex);

        for (int i = 1; i <= noOfIterations; i++) {

            System.out.println("iteration: " + i); //Use logging
            try {
                if (i % reloadChipsFrequency == 0) {
                    flows.reloadChips();
                }

                if (i % F2UFrequency == 0) {
                    System.out.println("Device Rotation Before Game table!");
                    flows.randomRotation(bound);
                    flows.flutterToUnity(platform);
                    System.out.println("Device Rotation After Game table!");
                    flows.randomRotation(bound);
                }

                System.out.println("Testcase Passed with All Condition=" + i);

            } catch (Exception e) {
                System.out.println("Exception = " + e);
                flows.relaunchApp(platform);
                Thread.sleep(2000);
            }
        }
    }
}
