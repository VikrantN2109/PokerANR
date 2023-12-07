package ANR;

import baseTest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ANR extends BaseTest {
    int n = 300;
    int appLaunchFrequency = 4;
    int reloadChipsFrequency = 45;
    int F2WFrequency = 1;
    int addCashFrequency = 1;
    int F2UFrequency = 1;
    int rotationFrequency = 1;

    @Test(dataProvider = "deviceIds")
    public void anr(String deviceId) throws InterruptedException, IOException {
        initAppiumDriver(deviceId);

        flows.loginExistingUser();

        for (int i = 1; i <= n; i++) {
            try {
                System.out.println("iteration: " + i); //Use logging

                if (i % appLaunchFrequency == 0) {
                    driver.terminateApp("com.jungleerummy.playcashgameonline");
                    startActivity("com.jungleerummy.playcashgameonline", "io.jungleerummy.jungleegames.MainActivity");
                }

                if (i % reloadChipsFrequency == 0) {
                    flows.reloadChips();
                }

                if (i % F2WFrequency == 0) {
                    flows.randomRotation(20);
                    flows.flutterToWebviewPromotions();
                    flows.flutterToWebviewLeaderboard();
                }

                if (i % addCashFrequency == 0) {
                    flows.randomRotation(20);
                    flows.addCashJuspayFlow();
                }

                if (i % F2UFrequency == 0) {
                    flows.randomRotation(20);
                    flows.flutterToUnity();
                }
                System.out.println("Testcase Passed with All Condition = " + i);
            } catch (Exception e) {
                System.out.println("Exception =" + e);
                driver.terminateApp("com.jungleerummy.playcashgameonline");
                startActivity("com.jungleerummy.playcashgameonline", "io.jungleerummy.jungleegames.MainActivity");
            }
        }
    }
}

