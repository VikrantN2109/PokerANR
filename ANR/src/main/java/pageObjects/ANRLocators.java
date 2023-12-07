package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ActionUtils;

import java.time.Duration;
import java.util.NoSuchElementException;

public class ANRLocators extends ActionUtils {
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

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\" \"]/android.widget.ImageView")
    public WebElement welcomeBanner;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]")
    public WebElement closeWelcomeBanner;

    @AndroidFindBy(accessibility = "OK")
    public WebElement okBtnReloadChips;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")
    public WebElement reloadChips;

    @AndroidFindBy(accessibility = "ADD CASH")
    public WebElement addCashLobby;

    @AndroidFindBy(xpath = "(//android.view.View[contains(@content-desc,\"0\")])[2]")
    public WebElement firstTile;

    @AndroidFindBy(accessibility = "Select your bank….")
    public WebElement selectYourBank;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"State Bank of India\"]")
    public WebElement bank;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Menu')]")
    public WebElement sideMenu;

    @AndroidFindBy(accessibility = "Help")
    public WebElement help;

    @AndroidFindBy(xpath = "//*[@resource-id='backButton']")
    public WebElement backBtnHelp;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Promotions\"]")
    public WebElement promotions;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Pay')]/android.widget.ImageView")
    public WebElement uncheckBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")
    public WebElement juspayYesCancelBtn;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Yes\"]")
    public WebElement yesButton;

    @AndroidFindBy(accessibility = "nav-home-tab")
    public WebElement navHomeTab;

    @AndroidFindBy(accessibility = "PRACTICE")
    public WebElement practiceTab;

    @AndroidFindBy(accessibility = "2")
    public WebElement select2Player;

    @AndroidFindBy(accessibility = "PLAY NOW")
    public WebElement playNowBtn;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'How would you rate')]/android.view.View")
    public WebElement ratingPopUp;

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
        if (isElementPresent(welcomeBanner)) {
            click(closeWelcomeBanner);
        }
    }

    public void closeRatingPopUp()
    {
        if (isElementPresent(ratingPopUp)) {
            click(ratingPopUp);
        }
    }

    public void clickReloadChips()
    {
        waitAndClick(reloadChips);
    }

    public void clickOkBtnReloadChips()
    {
        waitAndClick(okBtnReloadChips);
    }

    public void clickAddCashLobby()
    {
        waitAndClick(addCashLobby);
    }

    public void selectFirstTile()
    {
        waitAndClick(firstTile);
    }

    public void clickSelectYourBank()
    {
        waitAndClick(selectYourBank);
    }

    public void clickJusPayYesCancelBtn()
    {
        click(juspayYesCancelBtn);
    }

    public void ClickYes_Button()
    {
        waitAndClick(yesButton);
    }

    public void unCheckExpressCheckout()
    {
        waitAndClick(uncheckBtn);
    }

    public void clickAnyBankInNetBanking()
    {
        waitAndClick(bank);
    }

    public void clickSideMenuButton()
    {
        waitAndClick(sideMenu);
    }

    public void goToHelpFromSideMenu()
    {
        waitAndClick(help);
    }

    public void clickOnBackBtnHelp()
    {
        waitAndClick(backBtnHelp);
    }

    public void goToPromotions()
    {
        waitAndClick(promotions);
    }

    public void waitForNavHomeTabVisible()
    {
        try{
            FluentWait<AndroidDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.visibilityOf(navHomeTab));
        }catch(Exception e){
            System.out.println(navHomeTab.toString()+" not found");
        }
    }

    public void goToPracticeTab()
    {
        waitAndClick(practiceTab);
    }

    public void select2Player()
    {
        waitAndClick(select2Player);
    }

    public void clickPlayNowBtn()
    {
        waitAndClick(playNowBtn);
    }
}
