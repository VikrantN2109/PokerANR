package flows;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PokerStarLocators;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PokerStarANRFlow extends PokerStarLocators {

    AndroidDriver driver;

    public PokerStarANRFlow(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void doLoginFlow(String number, String otp) throws InterruptedException {

        Thread.sleep(6000);

        //Click on Login/Signup Field two times
        clickLoginField();
        clickLoginField();

        //Enter mobile no.
        enterNumber(number);

        //Click on OTP text field
        clickOTPField();

        //Enter OTP
        enterOTP(otp);

        //Handle location permission
        if(isLocationPermissionPopupPresent()) {
            //Click on Allow Location Permission
            allowLocationPermission();
        }
        Thread.sleep(3000);

        //Handle update bottom sheet if present
        closeUpdateBottomSheet();

        //Handle Illustration popup
        if(isIllustrationPopupPresent()) {
            //Click to close illustration popup
            clickToCloseIllustration();
        }

        Thread.sleep(3000);

        //Handle update bottom sheet if present
        closeUpdateBottomSheet();

    }

    public void lobbyToGameTable(String platform, String runEnv) throws InterruptedException {

        //Click on lobby
        clickLobby();

        //Click on practice option
        clickPracticeButton();

        //Click on MIN BUY-IN
        clickMinBuyIn();

        //Set network to no network
        setNetworkSpeedBS("2g-gprs-lossy");

        randomRotation(10);

        //click on skip tour button if present
        if(isSkipTourButtonPresent()){
            clickSkipTourButton();
        }

        /*
        if(runEnv.equalsIgnoreCase("BS"))
        {
          Thread clickMinBuyInThread = new Thread(() -> clickMinBuyIn());
          Thread setNetworkSpeedThread = new Thread(() -> setNetworkSpeedBS("2g-gprs-lossy"));

            // Start both threads
            setNetworkSpeedThread.start();
            clickMinBuyInThread.start();

            setNetworkSpeedThread.join();
            clickMinBuyInThread.join();

            Thread.sleep(4000);

            //click on skip tour button if present
            if(isSkipTourButtonPresent()){
                clickSkipTourButton();
            }

            Thread.sleep(4000);

            //Reset network speed
            setNetworkSpeedBS("reset");
        }
         */

        // Reset network speed
        setNetworkSpeedBS("reset");

        Thread.sleep(10000);

    }

    public void logoutFlow(){

        //Click on More Button
        clickMoreButton();

        //Scroll until last element
        scrollUntilLast(logoutOption);

        //Click on Logout Option
        clickLogoutOption();

    }

    public void randomRotation(int bound) throws InterruptedException {
        Random rand = new Random();
        int randomNumber = rand.nextInt(bound);
        if (randomNumber <= 5) {
            for (int i = 0; i < 5; i++) {
                try {

                    driver.rotate(ScreenOrientation.LANDSCAPE);
                    driver.rotate(ScreenOrientation.PORTRAIT);

                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
                Thread.sleep(1000);
            }
        }
    }
}
