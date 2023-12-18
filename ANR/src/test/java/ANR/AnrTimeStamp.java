package ANR;

import baseTest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class AnrTimeStamp extends BaseTest {

    @BeforeClass(alwaysRun = true)
    public void setup() throws InterruptedException {
        try {
            initAppiumDriver();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    @Test
//    public void anr() throws InterruptedException
//    {
//
//        System.out.println("Timestamp from app launch to register page ");
//
//        flows.loginExistingUser();//splash->login   (fresh launch)
//
//        for(int i=1;i<=5;i++)
//        {
//            System.out.println("iteration : " + i);
//            locators.cashTab();
//            driver.terminateApp("com.jungleerummy.playcashgameonline");
//            startActivity("com.jungleerummy.playcashgameonline", "io.jungleerummy.jungleegames.MainActivity");
//
//        }
//    }
//
}

// array ->mai time stamp->sort and then average