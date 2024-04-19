package flows;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.ANRLocators;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
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
        clickLocationOkBtn();
        Thread.sleep(2000);
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
//                enterUsername("dbmundhra@gmail.com");
//                enterPassword("1234@Test");    //Abcdef123!

//                enterUsername("7290927380");
//                enterPassword("Test@123456");

                enterUsername("jgkaby1247@gmail.com");
                enterPassword("@Test123");
                break;
            case "1":
                enterUsername("7087537187");
                enterPassword("Abcdef123!");    //Abcdef123!
                break;
            case "2":
                enterUsername("roohpreet.kaur@jungleegames.com");
                enterPassword("1234@Test");    //Abcdef123!
                break;
            case "3":
                enterUsername("roohpreet002@gmail.com");
                enterPassword("1234@Test");    //Abcdef123!
                break;
            case "4":
                enterUsername("anushka.shrivastava@jungleegames.com");
                enterPassword("@Test12345");
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
        Thread.sleep(2000);
    }

    public void reloadChips() {
        clickAvatar();
        clickReloadChips();
        clickOkBtnReloadChips();
    }

    public void relaunchApp(String platform) throws InterruptedException {
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
            case "rummydotcom":
                driver.terminateApp("com.rummydotcom.indianrummycashgame");
                driver.activateApp("com.rummydotcom.indianrummycashgame");
                break;
        }
    }

    public void flutterToWebviewPromotions(String platform) throws InterruptedException {
        try {
            closeLoyaltyPopUp();
            closeLobbyPopUp();
            clickLobby();
            clickSideMenuButton();
            if (latestVersionOfapp()) {
                clickNewSideMenuHelp();
                clickContactUS();
            } else {
                goToHelpFromSideMenu();
            }
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
            Thread.sleep(2000);
            clickLobby();
            //  clickBackButtonAndroid();
        } catch (Exception e) {
            try {
                relaunchApp(platform);
            } catch (Exception ex) {
                System.out.println(ex);
                relaunchApp(platform);
            }
        }
    }

    public void flutterToWebviewLeaderboard(String platform) throws InterruptedException {
        closeLobbyPopUp();
        clickSideMenuButton();
        if (latestVersionOfapp()) {
            clickNewSideMenuHelp();
            clickContactUS();
        } else {
            goToHelpFromSideMenu();
        }
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

        if(latestVersionOfapp())
        {
            clickDiscover();
            scrollForLeaderBoard();
        }
        goToLeaderBoardFromSideMenu();
        Thread.sleep(5000);
        scrollAndViewAll();
        clickLobby();

    }

    public void flutterToUnity(String platform,String runEnv) throws InterruptedException, ParseException {
        try {
            if (platform.contains("rummysdk")) {
                clickOnRummy();
            }
            clickLobby();
            goToPracticeTab();
            select2Player();
            clickPlayNowBtn();
            if(runEnv.equalsIgnoreCase("BS"))
            {
                Thread clickPlayNowBtnThread = new Thread(() -> clickPlayNowBtn());
                Thread setNetworkSpeedThread = new Thread(() -> setNetworkSpeedBS("no-network"));
                // Start both threads
                setNetworkSpeedThread.start();
                clickPlayNowBtnThread.start();
                // Wait for both threads to finish
                setNetworkSpeedThread.join();
                clickPlayNowBtnThread.join();
                Thread.sleep(6000);
                setNetworkSpeedBS("no-network");
                Thread.sleep(5000);
                setNetworkSpeedBS("reset");
                //playYoutubeVideo(platform, 20);
                randomRotation(5);
                setNetworkSpeedBS("2g-gprs-lossy");
                Thread.sleep(5000);
                captureScreenshot();
                setNetworkSpeedBS("reset");
            }
            Thread.sleep(80000);
            System.out.println("wait completed");
            if (!(lobby.isDisplayed())) {
                timeStamp();
                System.out.println("Something went wrong. Relaunching the app!");
                relaunchApp(platform);
                driver.activateApp("com.jungleerummy.jungleerummy");
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
           // clickBackButtonAndroid();
            //clickEABackBtn();
            clickAddButton();//Not able to locate Add Cash Button (VIVO Y16)
            //tapByCoordinates(538,1837); // vivo y11
            clickSelectYourBank();
            clickAnyBankInNetBanking();
            randomRotation(5);
            Thread.sleep(6000);
            switch (platform) {
                case "ipa":
                    clickCloseButton();
                    clickJusPayYesCancelBtn();
                    clickPaymentBackBtn();
                    clickSMBackBtn();
                    ClickYes_Button();
                    clickEABackBtn();
                    break;
                default:
                    clickBackButtonAndroid();
                    clickJusPayYesCancelBtn();
                    clickBackButtonAndroid();
                    clickBackButtonAndroid();
                    ClickYes_Button();
                    clickBackButtonAndroid();
            }
            Thread.sleep(2000);
            setNetworkSpeedBS("reset");
            closeLobbyPopUp();
        } catch (Exception e) {
            System.out.println(e);
            relaunchApp(platform);
        }
    }

    public void dropTable() throws InterruptedException {
        Thread.sleep(7000);
        Dimension size = driver.manage().window().getSize();
        System.out.println(size);

        Point topRightPoint = new Point((int) (size.width), (int) (size.height));
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tapAtTopRight = new Sequence(input, 0);

        tapAtTopRight.addAction(input.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), topRightPoint.getX(), topRightPoint.getY()));
        tapAtTopRight.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tapAtTopRight.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Perform the tap action in the top-right corner
        driver.perform(Arrays.asList(tapAtTopRight));


//        Thread.sleep(20000);
//        final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
//        Point tapPoint = new Point(80, 28);
//        Sequence tap = new Sequence(FINGER, 1);
//        tap.addAction(FINGER.createPointerMove(Duration.ofMillis(0),
//                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//        tap.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//        tap.addAction(FINGER.createPointerMove(Duration.ofMillis(50),
//                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//        tap.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//        driver.perform(Arrays.asList(tap));
//
//        Thread.sleep(3000);
//
//        final PointerInput FINGER1 = new PointerInput(PointerInput.Kind.TOUCH, "FINGER1");
//        Point tapPoint1 = new Point(492, 361);
//        Sequence tap1 = new Sequence(FINGER1, 1);
//        tap1.addAction(FINGER1.createPointerMove(Duration.ofMillis(0),
//                PointerInput.Origin.viewport(), tapPoint1.x, tapPoint1.y));
//        tap1.addAction(FINGER1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//        tap1.addAction(FINGER1.createPointerMove(Duration.ofMillis(50),
//                PointerInput.Origin.viewport(), tapPoint1.x, tapPoint1.y));
//        tap1.addAction(FINGER1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//        driver.perform(Arrays.asList(tap1));


    }

    public void randomRotation(int bound) throws InterruptedException {
        Random rand = new Random();
        int randomNumber = rand.nextInt(bound);
        if (randomNumber <= 5) {
            for (int i = 0; i < 5; i++) {
                try {
//                    setOrientation(driver, ScreenOrientation.LANDSCAPE);
//                    setOrientation(driver, ScreenOrientation.PORTRAIT);

                    driver.rotate(ScreenOrientation.LANDSCAPE);
                    driver.rotate(ScreenOrientation.PORTRAIT);

//                    DeviceRotation landScape = new DeviceRotation(0, 0, 90);
//                    driver.rotate(landScape);
//
//                    DeviceRotation portrait = new DeviceRotation(0, 0, 180);
//                    driver.rotate(portrait);

                    //  driver.rotate(new DeviceRotation(0, 0, 90) );


                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
                Thread.sleep(1000);
            }
        }
    }

    public static void setOrientation(AndroidDriver driver, ScreenOrientation orientation) {
        driver.rotate(orientation);
    }

    public void toggleApps(String platform) throws InterruptedException {
        driver.pressKey(new KeyEvent().withKey(AndroidKey.HOME));
        driver.activateApp("com.rummydotcom.indianrummycashgame");
        Thread.sleep(4000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.HOME));
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
            case "rummydotcom":
                driver.activateApp("com.jungleerummy.playcashgameonline");
                break;
        }
        clickLobby();
     //   playYoutubeVideo(platform,5);
    }

    public void tournamentFlow(String platform) {
        clickTournamentTab();
        clickOnFreeTab();
        boolean flag = scrollToLast();
        if (flag) {
            if (verifyYourKycvisible()) {
                closeKYCPopUp();          // handle when users kyc is not done {psrmg}
            } else {
                clickPopUpTournament();
                withDrawFromTournament();
                clickOKOfTournament();
            }
        } else {
            gotoDetailOfFreeTournament();
        }
        clickBackButtonAndroid();
    }

    public void addCashFlowForNonKycUser() {
        clickAddCashLobby();
        closeVerifyKycToContinue();
    }


    public void playYoutubeVideo(String platform, int bound) throws InterruptedException {
        Random rand = new Random();
        int randomNumber = rand.nextInt(bound);
        if (randomNumber <= 5) {
            if (platform.equalsIgnoreCase("ipa")) {
                driver.activateApp("com.google.ios.youtube");
            } else {
                driver.activateApp("com.google.android.youtube");
            }
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
                case "rummydotcom":
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

    public void gameTableLeaveFlow(String platform) throws InterruptedException {
        try {
            goToPracticeTab();
            select2Player();
            clickPlayNowBtn();
            Thread.sleep(5000);
            tapByCoordinates(86,32);
            Thread.sleep(2000);
            tapByCoordinates(620,531);
        } catch (Exception e) {
            System.out.println(e);
            relaunchApp(platform);
        }
    }
}
