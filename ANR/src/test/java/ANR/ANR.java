package ANR;

import baseTest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ANR extends BaseTest {

    @BeforeClass(alwaysRun = true)
    public void setup() throws InterruptedException {
        try {
            initAppiumDriver();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    int appLaunchFrequency = 4;
    int reloadChipsFrequency = 45;
    int F2WFrequency = 1;
    int addCashFrequency = 1;
    int F2UFrequency = 1;
    int rotationFrequency = 1;

    @Test
    public void anr() throws InterruptedException {
        int n = 50;

        flows.loginExistingUser();

        for (int i = 1; i <= n; i++)
        {
            System.out.println("iteration: " + i); //Use logging

            try
            {
                if (i % appLaunchFrequency == 0)
                {
                    driver.terminateApp("io.jungleerummy.jungleegames");
                    startActivity("io.jungleerummy.jungleegames", "io.jungleerummy.jungleegames.MainActivity");
                }

                if (i % reloadChipsFrequency == 0) {
                    flows.reloadChips();
                }

                if (i % F2WFrequency == 0) {
                   // flows.randomRotation(20);
                   // flows.cashTab();
                    flows.flutterToWebviewPromotions();
                    flows.flutterToWebviewLeaderboard();
                }

                if (i % addCashFrequency == 0) {
                    System.out.println("Device Rotation Before Add Cash!");
                    flows.randomRotation(5);
                    flows.addCashJuspayFlow();
                }

                if (i % F2UFrequency == 0)
                {
                    System.out.println("Device Rotation Before Game table!");
                    flows.randomRotation(5);
                    flows.flutterToUnity();
                    System.out.println("Device Rotation After Game table!");
                    flows.randomRotation(5);
                }

                System.out.println("Testcase Passed with All Condition=" + i);
            }
            catch (Exception e) {
                System.out.println("Exception =" + e);
                driver.terminateApp("io.jungleerummy.jungleegames");
                startActivity("io.jungleerummy.jungleegames", "io.jungleerummy.jungleegames.MainActivity");
            }

        }
    }
}

