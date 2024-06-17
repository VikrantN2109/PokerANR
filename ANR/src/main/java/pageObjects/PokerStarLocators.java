package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ActionUtils;

public class PokerStarLocators extends ActionUtils {

    AndroidDriver driver;

    public PokerStarLocators(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement loginField;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
    public WebElement locationPermission;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='One-Stop Wallet']")
    public WebElement oneStopWallet;

    @AndroidFindBy(xpath = "//android.view.View/android.widget.Button")
    public WebElement closeIllustrartionPopup;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='MORE']")
    public WebElement moreButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Log Out']")
    public WebElement logoutOption;


    public void clickLoginField(){
        if (isElementPresent(loginField)) {
            click(loginField);
        }
    }

    public void enterNumber(String number){
        sendText(loginField, number);
    }

    public void allowLocationPermission(){
        if (isElementPresent(locationPermission)) {
            click(locationPermission);
        }
    }

    public void clickToCloseIllustration(){
        if (isElementPresent(oneStopWallet)) {
            click(closeIllustrartionPopup);
        }
    }

    public void clickMoreButton(){
        if (isElementPresent(moreButton)) {
            click(moreButton);
        }
    }

    public void clickLogoutOption(){
        if (isElementPresent(logoutOption)) {
            click(logoutOption);
        }
    }


}
