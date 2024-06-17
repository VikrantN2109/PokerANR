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

    @Test
    @Parameters(value = {"deviceIndex"})
    public void TestANR() throws InterruptedException {

        pokerStarANRFlow = new PokerStarANRFlow(driver, wait);
        pokerStarANRFlow.doLoginFlow("8527029916", "123456");
    }
}

