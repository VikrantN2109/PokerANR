package ANR;

import baseTest.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ANR extends BaseTest {

    String platform = props.getProperty("platform");
    int appLaunchFrequency = 4;
    int reloadChipsFrequency = 45;
    int F2WFrequency = 1;
    int addCashFrequency =1;
    int F2UFrequency = 1;
    //int rotationFrequency = 1;

    @Test
    @Parameters(value={"deviceIndex"})
    public void anr(String deviceIndex) throws InterruptedException {
        int noOfIterations = 50;

        flows.loginExistingUser(platform, deviceIndex);

        for (int i = 1; i <= noOfIterations; i++) {
            System.out.println("iteration: " + i); //Use logging
            try {
                if (i % appLaunchFrequency == 0) {
                    flows.relaunchApp(platform);
                }

                if (i % reloadChipsFrequency == 0) {
                    flows.reloadChips();
                }

                if (i % F2WFrequency == 0) {
                    flows.randomRotation(20);
                    flows.flutterToWebviewPromotions(platform);
                    flows.flutterToWebviewLeaderboard(platform);
                }

                if (i % addCashFrequency == 0) {
                    System.out.println("Device Rotation Before Add Cash!");
                    flows.randomRotation(10);
                    flows.addCashJuspayFlow(platform, deviceIndex);
                }

                if (i % F2UFrequency == 0) {
                    System.out.println("Device Rotation Before Game table!");
                    flows.randomRotation(10);
                    flows.flutterToUnity();
                    System.out.println("Device Rotation After Game table!");
                    flows.randomRotation(5);
                }

                System.out.println("Testcase Passed with All Condition=" + i);
                Thread.sleep(4000);

            } catch (Exception e) {
                System.out.println("Exception =" + e);
                flows.relaunchApp(platform);
                Thread.sleep(5000);
            }
        }
    }
}

