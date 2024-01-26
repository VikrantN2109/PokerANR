package flows;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.ANRLocators;

import java.time.Duration;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class ANRFlows extends ANRLocators {
    AndroidDriver driver;

    public ANRFlows(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void loginExistingUser(String platform, String deviceIndex) throws InterruptedException {
        selectQAEnv(deviceIndex);
        timeStamp();// splash->login
        if (platform.equalsIgnoreCase("ipa")) {
            clickAllowPermission();
        }
        clickAllowPermission();
        Thread.sleep(2000);
        if (deviceIndex.equalsIgnoreCase("2")) {
            scrollWithCoordinates(driver, 1055, 480, 50, 480);
            tapByCoordinates(600, 1739);
        }
        ClickLogIn();
        ClickLoginUsingPassword();
        ClickLoginViaPassword();
        switch (deviceIndex) {
            case "0":
                enterUsername("dbmundhra@gmail.com");
                enterPassword("1234@Test");
                break;
            case "1":
                enterUsername("7087537187");
                enterPassword("1234@Test");
                break;
            case "2":
                enterUsername("roohpreet.kaur@jungleegames.com");
                enterPassword("1234@Test");
                break;
            case "3":
                enterUsername("roohpreet002@gmail.com");
                enterPassword("1234@Test");
                break;
            case "4":
//                enterUsername("7999465910");
//                enterPassword("@Test1234");
                enterUsername("8979561161");
                enterPassword("Abcdef123!");
                break;
        }
        clickBackButtonAndroid();
        clickLoginButtonExisting();
        Thread.sleep(2000); //use wait for element visible
        if (platform.equalsIgnoreCase("ipa")) {
            clickAllowWhileUsingApp();
        } else {
            clickAllowPermission();
        }
        clickSkipButton();
        closeWelcomeBanner();
        closeWelcomeBanner();
        closeRatingPopUp();
    }

    public void reloadChips() {
        clickSideMenuButton();
        clickProfile();
        clickReloadChips();
        clickOkBtnReloadChips();
    }

    public void relaunchApp(String platform) {
        switch (platform) {
            case "ipa":
                driver.terminateApp("com.jungleerummy.jungleerummy");
                driver.activateApp("com.jungleerummy.jungleerummy");
                break;
            case "psrmg":
                driver.terminateApp("com.jungleerummy.playcashgameonline");
                driver.activateApp("com.jungleerummy.playcashgameonline");
                break;
            case "native":
                driver.terminateApp("io.jungleerummy.jungleegames");
                driver.activateApp("io.jungleerummy.jungleegames");
                break;
            case "rummy.com":
                driver.terminateApp("com.rummydotcom.indianrummycashgame");
                driver.activateApp("com.jungleerummy.playcashgameonline");
                break;
        }
    }

    public void flutterToWebviewPromotions(String platform) throws InterruptedException {
        try {
            //  cashTab();
            clickSideMenuButton();
            goToHelpFromSideMenu();
            if (platform.equalsIgnoreCase("ipa")) {
                clickLobby();
            } else {
                clickOnBackBtnHelp();
            }
            Thread.sleep(3000);
            goToPromotions();
            Thread.sleep(7000);
            clickLeaderBoard();
            Thread.sleep(7000);
            clickOptIn();
            Thread.sleep(5000);
            clickLobby();
            //  clickBackButtonAndroid();
        } catch (TimeoutException e) {
            try {
                swipeToRight();
            } catch (Exception ex) {
                System.out.println(ex);
                relaunchApp(platform);
            }
        }
    }

    public void flutterToWebviewLeaderboard(String platform) throws InterruptedException {
        try {
            clickSideMenuButton();
            setNetworkSpeedBS("2g-gprs-lossy");
            goToHelpFromSideMenu();
            if (platform.equalsIgnoreCase("ipa")) {
                clickLobby();
            } else {
                clickBackButtonAndroid();
            }
            Thread.sleep(5000);
            goToPromotions();
            if (platform.equalsIgnoreCase("ipa")) {
                clickLobby();
            } else {
                clickOnBackBtnHelp();
            }
            clickSideMenuButton();
            setNetworkSpeedBS("reset");
            goToLeaderBoardFromSideMenu();
            Thread.sleep(5000);
            scrollAndViewAll();
            clickLobby();
        } catch (Exception e) {
            System.out.println(e);
            relaunchApp(platform);
        }
    }

    public void flutterToUnity(String platform) throws InterruptedException {
        try {
            if (platform.contains("rummysdk")) {
                clickOnRummy();
            }
            goToPracticeTab();
            select2Player();
            //clickPlayNowBtn();
            Thread clickPlayNowBtnThread = new Thread(() -> clickPlayNowBtn());
            Thread setNetworkSpeedThread = new Thread(() -> setNetworkSpeedBS("2g-gprs-lossy"));
            // Start both threads
            setNetworkSpeedThread.start();
            clickPlayNowBtnThread.start();
            // Wait for both threads to finish
            setNetworkSpeedThread.join();
            clickPlayNowBtnThread.join();
            //Thread.sleep(6000);
            setNetworkSpeedBS("reset");
            //playYoutubeVideo(platform, 20);
            Thread.sleep(5000);
            captureScreenshot();
            randomRotation(5);
            setNetworkSpeedBS("2g-gprs-lossy");
            Thread.sleep(5000);
            setNetworkSpeedBS("reset");
            Thread.sleep(90000);
            System.out.println("wait completed");
            if (!(lobby.isDisplayed())) {
                timeStamp();
                System.out.println("Something went wrong. Relaunching the app!");
                relaunchApp(platform);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addCashJuspayFlow(String platform, String deviceIndex) throws InterruptedException {
        try {
            closeRatingPopUp();
            clickAddCashLobby();
            setNetworkSpeedBS("2g-gprs-lossy");
            selectFirstTile();
            Thread.sleep(4000);
            unCheckExpressCheckout();
            clickBackButtonAndroid();
            //clickEABackBtn();
            clickAddButton();//Not able to locate Add Cash Button (VIVO Y16)
            //tapByCoordinates(538,1837); // vivo y11
            clickSelectYourBank();
            clickAnyBankInNetBanking();
            randomRotation(5);
            Thread.sleep(8000);
            switch (platform) {
                case "android":
                    clickBackButtonAndroid();
                    clickJusPayYesCancelBtn();
                    clickBackButtonAndroid();
                    clickBackButtonAndroid();
                    ClickYes_Button();
                    clickBackButtonAndroid();
                    break;
                case "ipa":
                    clickCloseButton();
                    clickJusPayYesCancelBtn();
                    clickPaymentBackBtn();
                    clickSMBackBtn();
                    ClickYes_Button();
                    clickEABackBtn();
            }
            Thread.sleep(2000);
            setNetworkSpeedBS("reset");
        } catch (Exception e) {
            System.out.println(e);
            relaunchApp(platform);
        }
    }

    public void dropTable() throws InterruptedException {
        Thread.sleep(20000);
        final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
        Point tapPoint = new Point(80, 28);
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
        Point tapPoint1 = new Point(492, 361);
        Sequence tap1 = new Sequence(FINGER1, 1);
        tap1.addAction(FINGER1.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint1.x, tapPoint1.y));
        tap1.addAction(FINGER1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap1.addAction(FINGER1.createPointerMove(Duration.ofMillis(50),
                PointerInput.Origin.viewport(), tapPoint1.x, tapPoint1.y));
        tap1.addAction(FINGER1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap1));
    }

    public void randomRotation(int bound) throws InterruptedException {
        Random rand = new Random();
        int randomNumber = rand.nextInt(bound);
        if (randomNumber <= 5) {
            for (int i = 0; i < 5; i++) {
                try {
                    driver.rotate(ScreenOrientation.LANDSCAPE);
                    driver.rotate(ScreenOrientation.PORTRAIT);
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
                Thread.sleep(1000);
            }
        }
    }

    public void playYoutubeVideo(String platform, int bound) throws InterruptedException {
        Random rand = new Random();
        int randomNumber = rand.nextInt(bound);
        if (randomNumber <= 5) {
            driver.activateApp("com.google.android.youtube");
            driver.rotate(ScreenOrientation.PORTRAIT);
            clickSearchBtnYoutube();
            searchVideo();
            clickSearchIcon();
            clickOnVideo();
            Thread.sleep(20000);
            driver.terminateApp("com.google.android.youtube");
            switch (platform) {
                case "ipa":
                    driver.activateApp("com.jungleerummy.jungleerummy");
                    break;
                case "psrmg":
                    driver.activateApp("com.jungleerummy.playcashgameonline");
                    break;
                case "native":
                    driver.activateApp("io.jungleerummy.jungleegames");
                    break;
                case "rummy.com":
                    driver.activateApp("com.jungleerummy.playcashgameonline");
                    break;
            }
        }
    }

    public void selectQAEnv(String deviceIndex) throws InterruptedException {
        if (deviceIndex.equalsIgnoreCase("2")) {
            Thread.sleep(5000);
            scrollWithCoordinates(driver, 1065, 480, 37, 480);
            tapByCoordinates(600, 1739);
        }
        if (isElementPresent(selectEnvBox)) {
            clickOnSelectEnvBox();
            clickOnQAEnv();
            clickProceedBtn();
        }
    }
}