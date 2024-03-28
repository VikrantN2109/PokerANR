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

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,\"kaby\")]")
    @iOSXCUITFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,\"kaby\")]")
    public WebElement clickAvatarButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"8 Crore+\n" +
            "Players\n" +
            "18+\n" +
            "No Bots\n" +
            "certified\n" +
            "RNG\n" +
            "Certified\"]/android.view.View[1]/android.widget.ImageView[1]")
    public WebElement enterUsername;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"8 Crore+\n" +
            "Players\n" +
            "18+\n" +
            "No Bots\n" +
            "certified\n" +
            "RNG\n" +
            "Certified\"]/android.view.View[1]/android.widget.ImageView[2]")
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
    public WebElement okBtn;

    @AndroidFindBy(accessibility = "Reload Chips")
    @iOSXCUITFindBy(accessibility = "Reload Chips")
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

    @AndroidFindBy(xpath ="//android.view.View[@content-desc=\"Select Amount Enter Amount (Up to ₹10,000) You Get ₹1,000 Pay Using ****8622\"]/android.widget.ImageView")
    public WebElement uncheckBtnCard;

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

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"8 Crore+\n" +
            "Players\n" +
            "18+\"]/android.view.View[1]/android.widget.ImageView[1]")
    public WebElement sendKeysForUserName;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"8 Crore+\n" +
            "Players\n" +
            "18+\"]/android.view.View[1]/android.widget.ImageView[2]")
    public WebElement sendKeysForPswd;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"10 Million+ Players\"]/android.view.View[1]/android.widget.ImageView[1]")
    public WebElement rummyComUsername;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"10 Million+ Players\"]/android.view.View[1]/android.widget.ImageView[2]")
    public WebElement rummyComPswd;

    @AndroidFindBy(accessibility = "TOURNAMENTS")
    @iOSXCUITFindBy(accessibility = "TOURNAMENTS")
    public WebElement TOURNAMENTS;

    @AndroidFindBy(accessibility = "Free")
    @iOSXCUITFindBy(accessibility = "Free")
    public WebElement FREE_TOURNAMENTS;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Join\"]//parent::android.view.View/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//android.widget.Button[@content-desc=\"Join\"]//parent::android.view.View/android.widget.ImageView")
    public WebElement clickDetails;

    @AndroidFindBy(accessibility = "Join Now")
    @iOSXCUITFindBy(accessibility = "Join Now")
    public WebElement JOIN_NOW;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Dismiss\"]/android.view.View/android.view.View/android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//android.view.View[@content-desc=\"Dismiss\"]/android.view.View/android.view.View/android.view.View[1]")
    public WebElement closePopUp;

    @AndroidFindBy(accessibility = "Withdraw")
    @iOSXCUITFindBy(accessibility = "Withdraw")
    public WebElement withDrawFromTourn;

    @AndroidFindBy(accessibility = "WITHDRAW")
    @iOSXCUITFindBy(accessibility = "WITHDRAW")
    public WebElement withDraw;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, '8 Crore')]/android.view.View[1]/android.widget.ImageView[1]")
    @iOSXCUITFindBy(accessibility = "Email or Mobile")
    public WebElement oldenterUsername;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, '8 Crore')]/android.view.View[1]/android.widget.ImageView[2]")
    @iOSXCUITFindBy(accessibility = "Password")
    public WebElement oldenterPassword;

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
        // old login page
        if(isElementPresent(loginViaPswd)) {
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

        // new login page
        if(isElementPresent(loginViaPswd)) {
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
            tapByCoordinates(x + (width / 2), y + (height / 3)+10);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void enterUsername(String userName) throws InterruptedException {

        if(isElementPresent(oldenterUsername))
        {
            waitAndClick(oldenterUsername);
            sendText(oldenterUsername,userName);
        }

        if(isElementPresent(enterUsername))
        {
            waitAndClick(enterUsername);
            sendText(sendKeysForUserName,userName);
        }

        if(isElementPresent(rummyComUsername))
        {
            waitAndClick(rummyComUsername);
            sendText(rummyComUsername,userName);
        }

    }

    public void enterPassword(String password)
    {
        if(isElementPresent(oldenterPassword))
        {
            waitAndClick(oldenterPassword);
            sendText(oldenterPassword,password);
        }
        if(isElementPresent(sendKeysForPswd))
        {
            waitAndClick(sendKeysForPswd);
            sendText(sendKeysForPswd,password);
        }

        if(isElementPresent(rummyComPswd))
        {
            waitAndClick(rummyComPswd);
            sendText(rummyComPswd,password);
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

    public void clickAvatar()
    {
        waitAndClick(clickAvatarButton);
    }

    public void clickReloadChips()
    {
        waitAndClick(reloadChips);
    }

    public void clickOkBtnReloadChips()
    {
        waitAndClick(okBtn);
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
        if(uncheckBtn.isDisplayed())
        {
            waitAndClick(uncheckBtn);
        }
//        if(uncheckBtnCard.isDisplayed())
//        {
//            waitAndClick(uncheckBtnCard);
//        }

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

    public void clickTournamentTab()
    {
        if(isElementPresent(TOURNAMENTS))
        {
            waitAndClick(TOURNAMENTS);
        }
    }

    public void clickOnFree(String platform)
    {

        if(platform.equalsIgnoreCase("rummydotcom"))
        {
            swipeToRight(553,65,430,430);
        }
        if(isElementPresent(FREE_TOURNAMENTS))
        {
            waitAndClick(FREE_TOURNAMENTS);
        }
    }

    public void gotoDetailOfFreeTournament()
    {
        if(isElementPresent(clickDetails))
        {
            waitAndClick(clickDetails);
        }
    }
    public void clickJoinNow()
    {
        if(isElementPresent(JOIN_NOW))
        {
            waitAndClick(JOIN_NOW);
        }
    }
    public void clickPopUp()
    {
        if(isElementPresent(closePopUp))
        {
            waitAndClick(closePopUp);
        }
    }

    public void withDrawFromTournament()
    {
        if(isElementPresent(withDrawFromTourn))
        {
            waitAndClick(withDrawFromTourn);
            waitAndClick(withDraw);
        }
    }

    public void clickOKOfTournament()
    {
        if(isElementPresent(okBtn))
        {
            waitAndClick(okBtn);
        }
    }

    public boolean lobbyVisible()
    {
        if(isElementPresent(cashTabButton)) return true;
        else return false;
    }
}
