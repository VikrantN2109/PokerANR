package ANR;

import baseTest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class ANR extends BaseTest {

    //    @BeforeClass(alwaysRun = true)
//    public void setup() throws InterruptedException {
//        try {
//            if(props.getProperty("runEnv").equalsIgnoreCase("local")) {
//                driver = initAppiumDriver();
//            } else {
//                driver = launchBSDriverSingleDevice();
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    String platform = props.getProperty("platform");
    int noOfIterations = 100;
    int appLaunchFrequency = 4;
    int reloadChipsFrequency = 10;
    int F2WFrequency = 1;
    int addCashFrequency = Integer.MAX_VALUE;
    int F2UFrequency = 1;
    int bound = 5;

    @Test
    @Parameters(value={"deviceIndex"})
    public void anr(@Optional String deviceIndex) throws InterruptedException {
        //flows.playYoutubeVideo(platform);
        flows.loginExistingUser(platform, deviceIndex);

        for (int i = 1; i <= noOfIterations; i++) {

            System.out.println("iteration: " + i); //Use logging
            try {
                if (i % appLaunchFrequency == 0) {
                    Thread.sleep(5000);
                    flows.relaunchApp(platform);
                }

                if (i % reloadChipsFrequency == 0) {
                    flows.reloadChips();
                }

                if (i % F2WFrequency == 0) {
                    flows.randomRotation(bound);
                    flows.flutterToWebviewPromotions(platform);
                    flows.flutterToWebviewLeaderboard(platform);
                }

                if (i % addCashFrequency == 0) {
                    System.out.println("Device Rotation Before Add Cash!");
                    flows.randomRotation(bound);
                    flows.addCashJuspayFlow(platform, deviceIndex);
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