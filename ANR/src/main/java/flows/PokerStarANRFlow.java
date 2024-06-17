package flows;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PokerStarLocators;

import java.util.concurrent.ThreadLocalRandom;

public class PokerStarANRFlow extends PokerStarLocators {
    AndroidDriver driver;

    public PokerStarANRFlow(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void doLoginFlow(String number, String otp) throws InterruptedException {

        Thread.sleep(5000);

        //Click on Login/Signup Field
        clickLoginField();
        clickLoginField();

        //Enter mobile no.
        enterNumber(number);

        //Click on OTP text field
        clickLoginField();

        //Enter OTP
        enterNumber(otp);

        //handle location permission
        if(isLocationPermissionPopupPresent()) {
            //Click on Allow Location Permission
            allowLocationPermission();
        }
        //Click to close illustration popup
        clickToCloseIllustration();

    }

    public void lobbyToGameTable() throws InterruptedException {

        //Click on lobby
        clickLobby();

        //Click on practice option
        clickPracticeButton();

        //Click on MIN BUY-IN
        clickMinBuyIn();

        //click on skip tour button if present
        if(isSkipTourButtonPresent()){
            clickSkipTourButton();
        }

        Thread.sleep(5000);

        //Tap on Buy-in via coordinates
        tapByCoordinates(518,599);

        Thread.sleep(2000);

        //Tap on Ok button via coordinates
        tapByCoordinates(528,1251);

        //Tap on hamburger icon on game table screen
        tapByCoordinates(1008,161);

        Thread.sleep(2000);

        //Tap on leave table option
        tapByCoordinates(541,1956);

        Thread.sleep(2000);

        //Click Yes on Confirmation popup
        tapByCoordinates(309,2065);

        //Click back on game table screen
//        clickBackButtonAndroid();
    }

    public void logoutFlow(){

        //Click on More Button
        clickMoreButton();

        //Scroll until last element
        scrollUntilLast(logoutOption);

        //Click on Logout Option
        clickLogoutOption();

    }
}
