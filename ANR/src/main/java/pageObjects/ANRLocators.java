package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ANRUtils;

public class ANRLocators extends ANRUtils {
    AndroidDriver driver;
    public ANRLocators(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    public WebElement allowButton;

    @AndroidFindBy(accessibility = "Log In")
    public WebElement loginButton;

    @AndroidFindBy(accessibility = "Login Using Password")
    public WebElement loginUsingPswd;

    @AndroidFindBy(xpath = "(//android.widget.ImageView)[4]")
    public WebElement enterUsername;

    @AndroidFindBy(xpath = "(//android.widget.ImageView)[5]")
    public WebElement enterPassword;

    @AndroidFindBy(accessibility = "Login")
    public WebElement loginButtonExisting;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Skip\"]")
    public WebElement skipButton;

    @AndroidFindBy(accessibility = "Log In")
    public WebElement welcomeBanner;


    public void clickAllowPermission()
    {
        if (isElementPresent(allowButton)) {
            click(allowButton);
        }
    }

    public void ClickLogIn()
    {
        waitAndClick(loginButton);

    }
    public void ClickLoginUsingPassword() {
        waitAndClick(loginUsingPswd);

    }

    public void enterUsername(String userName)
    {
        waitAndClick(enterUsername);
        sendText(enterUsername,userName);
    }

    public void enterPassword(String password)
    {
        waitAndClick(enterPassword);
        sendText(enterPassword,password);
    }

    public void hideKeyboard_Android()
    {
        if (((AndroidDriver) driver).isKeyboardShown()) {
            try {
                driver.hideKeyboard();
            } catch (Exception e) {
            }
        }
    }

    public void clickLoginButtonExisting()
    {
        waitAndClick(loginButtonExisting);
    }

    public void clickSkipButton()
    {
        waitAndClick(skipButton);
    }

    public void closeWelcomeBanner()
    {
        waitAndClick(welcomeBanner);
    }


    public void loginExistingUser(String username, String password) throws InterruptedException {
        clickAllowPermission();
        ClickLogIn();
        ClickLoginUsingPassword();
        enterUsername(username);
        enterPassword(password);
        hideKeyboard_Android();
        clickLoginButtonExisting();
        clickSkipButton();
        closeWelcomeBanner();
    }

}
