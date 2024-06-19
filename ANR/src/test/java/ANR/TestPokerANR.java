package ANR;

import baseTest.BaseTest;
import flows.PokerStarANRFlow;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestPokerANR extends BaseTest {

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
    int noOfIterations = 30;
    int toggleBtwApps = 1;
    int F2UFrequency = 1;

    @Test
    @Parameters(value = {"deviceIndex"})
    public void TestANR() throws InterruptedException {

        pokerStarANRFlow = new PokerStarANRFlow(driver, wait);

        for(int i=0 ; i<noOfIterations ; i++) {

            System.out.println("Iteration : " + i );

            pokerStarANRFlow.doLoginFlow("8527029916", "123456");

            flows.randomRotation(10);

            if(i % F2UFrequency == 0) {
                pokerStarANRFlow.lobbyToGameTable(platform, runEnv);
            }
            if(i % toggleBtwApps == 0) {
                flows.playYoutubeVideo(platform, 5);
            }
            pokerStarANRFlow.logoutFlow();
        }
    }
}

