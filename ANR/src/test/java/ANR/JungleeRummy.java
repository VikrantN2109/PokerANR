package ANR;

import baseTest.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.Duration;

public class JungleeRummy extends BaseTest {
    @BeforeMethod(alwaysRun = true)
    @Parameters(value = {"deviceIndex"})
    public void setup(String deviceIndex) {
        try {
            if (props.getProperty("runEnv").equalsIgnoreCase("local")) {
                driver = initAppiumDriver();
            } else {
                driver = launchBSDriverMultipleDevices(deviceIndex);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    String platform = props.getProperty("platform");
    String runEnv = props.getProperty("runEnv");
    int appLaunchFrequency = 10; // Integer.MAX_VALUE
    int reloadChipsFrequency = 30;
    int F2WFrequency = 1;
    int addCashFrequency = 1;
    int F2UFrequency = 1;
    int runAppInBackGround = 5;
    int toggleBetweenApps = 5;
    int tournamentsFrequency = 5;
    int addCashFlowForNonKycUserFrequency = 1;

    @Test
    @Parameters(value = {"deviceIndex"})
    public void anr(String deviceIndex) throws InterruptedException, FileNotFoundException, ParseException {

        System.out.println(platform);

        int noOfIterations = 50;

        flows.loginExistingUser(platform, deviceIndex);

        for (int i = 1; i <= noOfIterations; i++) {
            System.out.println("iteration: " + i); //Use logging
            try {
                if (i % appLaunchFrequency == 0) {
                    Thread.sleep(4000);
                    flows.relaunchApp(platform);
                }

                if (i % reloadChipsFrequency == 0) {
                    flows.reloadChips();
                }

                if (i % F2WFrequency == 0) {
                    //  flows.randomRotation(20);
                    flows.flutterToWebviewPromotions(platform);
                    flows.flutterToWebviewLeaderboard(platform);
                }

                if (platform.equalsIgnoreCase("psrmg") && props.getProperty("kycVerifiedUser").equalsIgnoreCase("false")) {
                    if (i % addCashFlowForNonKycUserFrequency == 0) {
                        flows.addCashFlowForNonKycUser();
                    }
                } else {
                    if (i % addCashFrequency == 0) {
                        System.out.println("Device Rotation Before Add Cash!");
                        flows.randomRotation(10);
                        flows.addCashJuspayFlow(platform, deviceIndex);
                    }
                }

                if (i % runAppInBackGround == 0) {
                    driver.runAppInBackground(Duration.ofSeconds(10));
                }

                if (i % toggleBetweenApps == 0) {
                    flows.toggleApps(platform,runEnv);
                }

                if (i % F2UFrequency == 0) {
                    System.out.println("Device Rotation Before Game table!");
                    // flows.randomRotation(10);
                    flows.flutterToUnity(platform, runEnv);
                    System.out.println("Device Rotation After Game table!");
                    flows.randomRotation(5);
                }

                if (i % tournamentsFrequency == 0) {
                    flows.tournamentFlow(platform);
                }

                System.out.println("Testcase Passed with All Condition=" + i);

            } catch (Exception e) {
                System.out.println("Exception =" + e);
                flows.relaunchApp(platform);
                Thread.sleep(5000);
            }
        }

    }

}

//    adb logcat | grep -E "(flutter|Unity)" > /Users/anushkas.hrivastava/Desktop/ANR/ANR/src/test/resources/output.txt