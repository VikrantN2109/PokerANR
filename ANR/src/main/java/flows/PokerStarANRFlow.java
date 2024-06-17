package flows;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PokerStarLocators;

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

        //Click on Allow Location Permission
        allowLocationPermission();

        //Click to close illustration popup
        clickToCloseIllustration();

        //Click on More Button
        clickMoreButton();

        //Scroll until last element
        scrollUntilLast(logoutOption);

        //Click on Logout Option
        clickLogoutOption();

    }
}
