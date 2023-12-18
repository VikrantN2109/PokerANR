package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
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
    @iOSXCUITFindBy(accessibility = "Allow")
    public WebElement allowButton;

    @AndroidFindBy(accessibility = "Log In")
    @iOSXCUITFindBy(accessibility = "Log In")
    public WebElement loginButton;

    @iOSXCUITFindBy(accessibility = "Allow While Using App")
    public WebElement allowWhileUsingApp;

    @AndroidFindBy(accessibility = "Login Using Password")
    @iOSXCUITFindBy(accessibility = "Login Using Password")
    public WebElement loginUsingPswd;

    @AndroidFindBy(accessibility = "Login via password")
    @iOSXCUITFindBy(accessibility = "Login via password")
    public WebElement loginViaPswd;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, \"7 Crore\")]/android.view.View[1]/android.widget.ImageView[1]")
    @iOSXCUITFindBy(accessibility = "Email or Mobile")
    public WebElement enterUsername;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, \"7 Crore\")]/android.view.View[1]/android.widget.ImageView[2]")
    @iOSXCUITFindBy(accessibility = "Password")
    public WebElement enterPassword;

    @AndroidFindBy(accessibility = "Login")
    @iOSXCUITFindBy(accessibility = "Login")
    public WebElement loginButtonExisting;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Skip\"]")
    @iOSXCUITFindBy(accessibility = "Skip")
    public WebElement skipButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\" \"]/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Junglee Rummy\"]/XCUIElementTypeWindow[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther")
    public WebElement welcomeBanner;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Junglee Rummy\"]/XCUIElementTypeWindow[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther")
    public WebElement closeWelcomeBanner;

    @AndroidFindBy(accessibility = "OK")
    @iOSXCUITFindBy(accessibility = "OK")
    public WebElement okBtnReloadChips;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Junglee Rummy\"]/XCUIElementTypeWindow[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeImage[2]")
    public WebElement reloadChips;

    @AndroidFindBy(accessibility = "ADD CASH")
    @iOSXCUITFindBy(accessibility = "ADD CASH")
    public WebElement addCashLobby;

    @AndroidFindBy(xpath = "(//android.view.View[contains(@content-desc,\"0\")])[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[contains(@name, '0')])[2]")
    public WebElement firstTile;

    @AndroidFindBy(accessibility = "Select your bank….")
    @iOSXCUITFindBy(accessibility = "Select your bank….")
    public WebElement selectYourBank;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"State Bank of India\"]")
    @iOSXCUITFindBy(accessibility = "State Bank of India")
    public WebElement bank;

    @iOSXCUITFindBy(accessibility = "Close")
    public WebElement closeButtonIPA;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Menu')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Menu')]")
    public WebElement sideMenu;

    @AndroidFindBy(accessibility = "Help")
    @iOSXCUITFindBy(accessibility = "Help")
    public WebElement help;

    @AndroidFindBy(xpath = "//*[@resource-id='backButton']")
    public WebElement backBtnHelp;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Promotions\"]")
    @iOSXCUITFindBy(accessibility = "Promotions")
    public WebElement promotions;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Junglee Rummy\"]/XCUIElementTypeWindow[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeButton[1]")
    public WebElement paymentBackBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Junglee Rummy\"]/XCUIElementTypeWindow[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeButton")
    public WebElement SMBackBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Junglee Rummy\"]/XCUIElementTypeWindow[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeButton[1]")
    public WebElement EABackBtn;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Pay')]/android.widget.ImageView")
    public WebElement uncheckBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")
    @iOSXCUITFindBy(accessibility = "Yes")
    public WebElement juspayYesCancelBtn;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Yes\"]")
    @iOSXCUITFindBy(accessibility = "Yes")
    public WebElement yesButton;

    @AndroidFindBy(accessibility = "nav-home-tab")
    public WebElement navHomeTab;

    @AndroidFindBy(accessibility = "PRACTICE")
    @iOSXCUITFindBy(accessibility = "PRACTICE")
    public WebElement practiceTab;

    @AndroidFindBy(accessibility = "2")
    @iOSXCUITFindBy(accessibility = "2")
    public WebElement select2Player;

    @AndroidFindBy(accessibility = "PLAY NOW")
    @iOSXCUITFindBy(accessibility = "PLAY NOW")
    public WebElement playNowBtn;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'How would you rate')]/android.view.View")
    public WebElement ratingPopUp;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[2]/android.widget.ListView/android.view.View[3]")
    public WebElement leaderBoard;

    @AndroidFindBy(accessibility = "Opt- in Now")
    public WebElement optIn;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"LOBBY\"]")
    @iOSXCUITFindBy(accessibility = "LOBBY")
    public WebElement lobby;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement locationOkButton;

    @AndroidFindBy(accessibility= "Leaderboard")
    public WebElement leaderBoardAccess;
    @AndroidFindBy(accessibility= "View all")
    public WebElement viewALL;

    @AndroidFindBy(xpath= "//android.widget.ImageView[@content-desc=\"CASH\"]")
    public WebElement cashTabButton;

    @AndroidFindBy(xpath= "//*[contains(@text,'LEADERBOARD')]")
    public WebElement rummyComLeaderBoard;

    @AndroidFindBy(accessibility = "Opt-In Now")
    public WebElement optInRummyCom;

    @AndroidFindBy(accessibility = "Lobby")
    public WebElement rummyComLobby;


    public void clickAllowPermission()
    {
        if (isElementPresent(allowButton)) {
            click(allowButton);
        }
    }

    public void ClickLogIn()
    {
        if(isElementPresent(loginButton))
        {
            click(loginButton);
        }

    }

    public void ClickLoginUsingPassword() {
        if(isElementPresent(loginUsingPswd))
        {
            waitAndClick(loginUsingPswd);
        }
    }

    public void ClickLoginViaPassword()
    {
        if(isElementPresent(loginViaPswd))
        {
            waitAndClick(loginViaPswd);
        }
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
        try {
            Thread.sleep(2000);
            click(closeWelcomeBanner);
        } catch (InterruptedException e) {
            System.out.println("Banner not present");
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

    public void clickCloseButton()
    {
        click(closeButtonIPA);
    }

    public void clickPaymentBackBtn()
    {
        waitAndClick(paymentBackBtn);
    }

    public void clickSMBackBtn()
    {
        waitAndClick(SMBackBtn);
    }

    public void clickEABackBtn()
    {
        waitAndClick(EABackBtn);
    }

    public void clickAllowWhileUsingApp()
    {
        try {
            waitAndClick(allowWhileUsingApp);
        } catch (Exception e) {
            System.out.println(e);
        }
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

    public void cashTab()
    {
//        try{
//            FluentWait<AndroidDriver> wait = new FluentWait<>(driver)
//                    .withTimeout(Duration.ofSeconds(30))
//                    .pollingEvery(Duration.ofSeconds(2))
//                    .ignoring(NoSuchElementException.class);
//            wait.until(ExpectedConditions.visibilityOf(cashTabButton));
//            timeStamp();//login->lobby
//            System.out.println("Timestamp form app launch to lobby ");
//        }catch(Exception e){
//            System.out.println(cashTabButton.toString()+" not found");
//        }

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"CASH\"]")));
        timeStamp();//login->lobby
        System.out.println("Timestamp form app launch to lobby ");
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

    public void clickLocationOkBtn()
    {
        waitAndClick(locationOkButton);
    }

    public void clickLeaderBoard()
    {
        if(isElementPresent(leaderBoard))
        {
            waitAndClick(leaderBoard);
        }

        if(isElementPresent(rummyComLeaderBoard))
        {
            waitAndClick(rummyComLeaderBoard);
        }

    }

    public void clickOptIn()
    {
        if(isElementPresent(optIn))
        {
            waitAndClick(optIn);
        }

        if(isElementPresent(optInRummyCom))
        {
            waitAndClick(optInRummyCom);
        }
    }

    public void clickLobby()
    {
        if(isElementPresent(lobby))
        {
            waitAndClick(lobby);
        }

        if(isElementPresent(rummyComLobby))
        {
            waitAndClick(rummyComLobby);
        }
    }

    public void goToLeaderBoardFromSideMenu()
    {
        waitAndClick(leaderBoardAccess);
    }

    public void scrollAndViewAll()
    {
        scrollWithCoordinates(driver, 364, 1257, 350, 183);
        if(isElementPresent(viewALL))
        {
            waitAndClick(viewALL);
        }
    }
}
