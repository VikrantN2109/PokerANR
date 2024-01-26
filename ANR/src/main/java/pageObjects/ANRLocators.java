package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
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

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Dismiss\"]/android.view.View/android.view.View/android.view.View/android.widget.Button")
    public WebElement dismissBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Junglee Rummy\"]/XCUIElementTypeWindow[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther")
    public WebElement closeWelcomeBanner;

    @AndroidFindBy(accessibility = "OK")
    @iOSXCUITFindBy(accessibility = "OK")
    public WebElement okBtnReloadChips;

    @AndroidFindBy(accessibility = "ADD CASH")
    @iOSXCUITFindBy(accessibility = "ADD CASH")
    public WebElement addCashLobby;

    @AndroidFindBy(xpath = "(//android.view.View[contains(@content-desc,\"0\")])[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[contains(@name, '0')])[2]")
    public WebElement firstTile;

    @AndroidFindBy(accessibility = "Select your bank….")
    @iOSXCUITFindBy(accessibility = "Select your bank….")
    public WebElement selectYourBank;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,\"ADD \")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'ADD')]")
    public WebElement addCashButton;

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
    @iOSXCUITFindBy(accessibility = "LEADERBOARD")
    public WebElement leaderBoard;

    @AndroidFindBy(accessibility = "Opt- in Now")
    @iOSXCUITFindBy(accessibility = "Opt- in Now")
    public WebElement optIn;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"LOBBY\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"LOBBY\"]")
    public WebElement lobby;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement locationOkButton;

    @AndroidFindBy(accessibility= "Leaderboard")
    @iOSXCUITFindBy(accessibility = "Leaderboard")
    public WebElement leaderBoardAccess;
    @AndroidFindBy(accessibility= "View all")
    @iOSXCUITFindBy(xpath= "(//XCUIElementTypeStaticText[@name=\"View all\"])[2]")
    public WebElement viewALL;

    @AndroidFindBy(xpath= "//android.widget.ImageView[@content-desc=\"CASH\"]")
    public WebElement cashTabButton;

    @AndroidFindBy(xpath= "//*[contains(@text,'LEADERBOARD')]")
    public WebElement rummyComLeaderBoard;

    @AndroidFindBy(accessibility = "Opt-In Now")
    public WebElement optInRummyCom;

    @AndroidFindBy(accessibility = "Lobby")
    public WebElement rummyComLobby;

    @AndroidFindBy(accessibility = "Search")
    public WebElement youtubeSearchBtn;

    @AndroidFindBy(id = "com.google.android.youtube:id/search_edit_text")
    public WebElement editSearch;

    @AndroidFindBy(id = "com.google.android.youtube:id/search_type_icon")
    public WebElement searchIcon;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[contains(@content-desc, \"play video\")]/android.view.ViewGroup[1]/android.widget.ImageView)[2]")
    public WebElement youtubeVideo;

    @AndroidFindBy(accessibility = "qa_1")
    public WebElement selectEnvBox;

    @AndroidFindBy(accessibility = "qa_8")
    public WebElement QAEnv;

    @AndroidFindBy(accessibility = "Proceed")
    public WebElement proceed;

    @AndroidFindBy(accessibility = "Rummy")
    public WebElement rummy;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Chips')]")
    public WebElement profile;

    @AndroidFindBy(accessibility = "Reload Chips")
    public WebElement reloadChips;

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
            click(loginUsingPswd);
        }
    }

    public void ClickLoginViaPassword()
    {
        if(isElementPresent(loginViaPswd)) {
//        {
//            click(loginViaPswd);
//        }
            Rectangle rect = loginViaPswd.getRect();
            int x = rect.getX();
            int y = rect.getY();
            int height = rect.getHeight();
            int width = rect.getWidth();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            tapByCoordinates(x + (width / 2), y + (height / 4));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
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
        click(reloadChips);
    }

    public void clickProfile()
    {
        click(profile);
    }

    public void clickOkBtnReloadChips()
    {
        click(okBtnReloadChips);
    }

    public void clickAddCashLobby()
    {
        click(addCashLobby);
    }

    public void selectFirstTile()
    {
        click(firstTile);
    }

    public void clickSelectYourBank()
    {
        click(selectYourBank);
    }

    public void clickAddButton()
    {
        click(addCashButton);
    }

    public void clickJusPayYesCancelBtn()
    {
        click(juspayYesCancelBtn);
    }

    public void ClickYes_Button()
    {
        click(yesButton);
    }

    public void unCheckExpressCheckout()
    {
        click(uncheckBtn);
    }

    public void clickAnyBankInNetBanking()
    {
        click(bank);
    }

    public void clickSideMenuButton()
    {
        click(sideMenu);
    }

    public void goToHelpFromSideMenu()
    {
        click(help);
    }

    public void clickOnBackBtnHelp()
    {
        click(backBtnHelp);
    }

    public void goToPromotions()
    {
        click(promotions);
    }

    public void clickCloseButton()
    {
        click(closeButtonIPA);
    }

    public void clickPaymentBackBtn()
    {
        click(paymentBackBtn);
    }

    public void clickSMBackBtn()
    {
        click(SMBackBtn);
    }

    public void clickEABackBtn()
    {
        click(EABackBtn);
    }

    public void clickAllowWhileUsingApp()
    {
        try {
            click(allowWhileUsingApp);
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
        click(practiceTab);
    }

    public void select2Player()
    {
        click(select2Player);
    }

    public void clickPlayNowBtn()
    {
        click(playNowBtn);
    }

    public void clickLocationOkBtn()
    {
        click(locationOkButton);
    }

    public void clickLeaderBoard()
    {
        if(isElementPresent(leaderBoard))
        {
            click(leaderBoard);
        }
    }

    public void clickOptIn()
    {
        if(isElementPresent(optIn))
        {
            click(optIn);
        }
    }

    public void clickLobby()
    {
        if(isElementPresent(lobby))
        {
            click(lobby);
        }
    }

    public void goToLeaderBoardFromSideMenu()
    {
        click(leaderBoardAccess);
    }

    public void scrollAndViewAll()
    {
        scrollWithCoordinates(driver, 364, 1257, 350, 183);
        if(isElementPresent(viewALL))
        {
            click(viewALL);
        }
    }

    public void clickSearchBtnYoutube()
    {
        click(youtubeSearchBtn);
    }

    public void searchVideo()
    {
        sendText(editSearch, "4k video");
    }

    public void clickSearchIcon()
    {
        click(searchIcon);
    }

    public void clickOnVideo() {
        click(youtubeVideo);
    }

    public void clickOnSelectEnvBox() {
        click(selectEnvBox);
    }

    public void clickOnQAEnv() {
        click(QAEnv);
    }

    public void clickProceedBtn() {
        click(proceed);
    }

    public void clickOnRummy() {
        click(rummy);
    }
}