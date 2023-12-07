package flows;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.ANRLocators;

import java.time.Duration;
import java.util.Arrays;

public class ANRFlows extends ANRLocators {
    AndroidDriver driver;
    public ANRFlows(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void loginExistingUser() throws InterruptedException {
        clickAllowPermission();
        ClickLogIn();
        ClickLoginUsingPassword();
        enterUsername("7087537187");
        enterPassword("Abcdef123!");
        hideKeyboard_Android();
        clickLoginButtonExisting();
        Thread.sleep(2000); //use wait for element visible
        clickAllowPermission();
        clickSkipButton();
        closeWelcomeBanner();
    }

    public void reloadChips() {
        clickReloadChips();
        clickOkBtnReloadChips();
    }

    public void flutterToWebviewPromotions() throws InterruptedException {
        try
        {
            // tapByCoordinates(973, 2095);
            clickSideMenuButton();
            goToHelpFromSideMenu();
            clickOnBackBtnHelp();
            Thread.sleep(3000);
            // tapByCoordinates(133, 2100);
            goToPromotions();
            Thread.sleep(7000);
            clickLeaderBoard();
            Thread.sleep(7000);
            clickOptIn();
            Thread.sleep(5000);
            clickLobby();
          //  clickBackButtonAndroid();
        }
        catch (TimeoutException e)
        {
            try
            {
                swipeToRight();
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
        }
    }

    public void flutterToWebviewLeaderboard() throws InterruptedException {
      //  tapByCoordinates(973, 2095);
        clickSideMenuButton();
        goToHelpFromSideMenu();
        clickBackButtonAndroid();
        Thread.sleep(5000);
        // tapByCoordinates(133, 2100);
        goToPromotions();
        clickOnBackBtnHelp();
        clickSideMenuButton();
        goToLeaderBoardFromSideMenu();
        Thread.sleep(5000);
        scrollAndViewAll();
        clickLobby();

    }

    public void flutterToUnity() throws InterruptedException {
        goToPracticeTab();
        select2Player();
        clickPlayNowBtn();
        Thread.sleep(1000);
        dropTable();
        //tapByCoordinates(133, 2100);
        goToPromotions();
    }

    public void addCashJuspayFlow() throws InterruptedException {
        Thread.sleep(2000);
        closeRatingPopUp();
        clickAddCashLobby();
        unCheckExpressCheckout();
        tapByCoordinates(542, 1328); //Not able to locate Add Cash Button
        clickSelectYourBank();
        clickAnyBankInNetBanking();
        Thread.sleep(8000);
       // waitForNavHomeTabVisible(); //Wait for Juspay webview to load
        clickBackButtonAndroid();
        clickJusPayYesCancelBtn();
        clickBackButtonAndroid();
        clickBackButtonAndroid();
        ClickYes_Button();
        clickBackButtonAndroid();
        Thread.sleep(2000);
    }

    public void dropTable() throws InterruptedException {
        Thread.sleep(20000);
        final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
        Point tapPoint = new Point(106, 42);
        Sequence tap = new Sequence(FINGER, 1);
        tap.addAction(FINGER.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
        tap.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(FINGER.createPointerMove(Duration.ofMillis(50),
                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
        tap.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));

        Thread.sleep(3000);

        final PointerInput FINGER1 = new PointerInput(PointerInput.Kind.TOUCH, "FINGER1");
        Point tapPoint1 = new Point(710, 523);
        Sequence tap1 = new Sequence(FINGER1, 1);
        tap1.addAction(FINGER1.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint1.x, tapPoint1.y));
        tap1.addAction(FINGER1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap1.addAction(FINGER1.createPointerMove(Duration.ofMillis(50),
                PointerInput.Origin.viewport(), tapPoint1.x, tapPoint1.y));
        tap1.addAction(FINGER1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap1));
    }
}
