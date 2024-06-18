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

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='PRACTICE']")
    public WebElement practiceButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc , 'MIN BUY-IN')]")
    public WebElement minBuyIn;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='LOBBY']")
    public WebElement lobby;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Skip Tour']")
    public WebElement skipTourButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Update Now']")
    public WebElement updateBottomSheet;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Scrim']")
    public WebElement closeUpdateBottomSheet;


    public void clickLoginField(){ click(loginField); }

    public void enterNumber(String number){
        sendText(loginField, number);
    }

    public boolean isLocationPermissionPopupPresent(){
        return isElementPresent(locationPermission);
    }

    public void allowLocationPermission(){
        if (isElementPresent(locationPermission)) {
            click(locationPermission);
        }
    }

    public boolean isIllustrationPopupPresent(){
        return isElementPresent(oneStopWallet);
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

    public void clickPracticeButton(){
        if (isElementPresent(practiceButton)) {
            click(practiceButton);
        }
    }

    public void clickMinBuyIn(){
        if (isElementPresent(minBuyIn)) {
            click(minBuyIn);
        }
    }

    public void clickLobby(){
        if (isElementPresent(lobby)) {
            click(lobby);
        }
    }

    public boolean isSkipTourButtonPresent(){
        return isElementPresent(skipTourButton);
    }

    public void clickSkipTourButton(){
        if (isSkipTourButtonPresent()) {
            click(skipTourButton);
        }
    }

    public void closeUpdateBottomSheet(){
        if (isElementPresent(updateBottomSheet)) {
            click(closeUpdateBottomSheet);
        }
    }

}
