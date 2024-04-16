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

public class ANRFlows extends ANRLocators {
    AndroidDriver driver;

    public ANRFlows(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void loginExistingUser(String platform, String deviceIndex) throws InterruptedException {
        timeStamp();// splash->login
        if (platform.equalsIgnoreCase("ipa")) {
            clickAllowPermission();
        }
        clickAllowPermission();
        clickLocationOkBtn();
        Thread.sleep(2000);
        ClickLogIn();
        ClickLoginUsingPassword();
        ClickLoginViaPassword();
        switch (deviceIndex) {
            case "0":
//                enterUsername("dbmundhra@gmail.com");
//                enterPassword("1234@Test");    //Abcdef123!

                enterUsername("7290927380");
                enterPassword("Test@123456");

//                enterUsername("jgkaby1247@gmail.com");  //  anushka.shrivastava@jungleegames.com //
//                enterPassword("@Test123"); //@Test12345
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
                enterUsername("6386967595");
                enterPassword("1234@Test");    //Abcdef123!
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
            case "rummydotcom":
                driver.terminateApp("com.rummydotcom.indianrummycashgame");
                driver.activateApp("com.rummydotcom.indianrummycashgame");
                break;
        }
    }

    public void flutterToWebviewPromotions(String platform) throws InterruptedException {
        try {
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

    public void flutterToUnity(String platform) throws InterruptedException, ParseException {
        System.out.println("Timestamp at lobby :  ");
        Timestamp t0 = timeStamp();  // t0
        goToPracticeTab();
        select2Player();
        clickPlayNowBtn();
        Thread.sleep(80000);//10000
        closeLobbyPopUp();
        clickLobby();
    }

    public void addCashJuspayFlow(String platform) throws InterruptedException {
        Thread.sleep(2000);
        closeRatingPopUp();
        clickAddCashLobby();
        //  selectFirstTile();
        Thread.sleep(4000);
        unCheckExpressCheckout();
        tapByCoordinates(542, 1328); //Not able to locate Add Cash Button (VIVO Y16)
        clickSelectYourBank();
        clickAnyBankInNetBanking();
        randomRotation(5);
        Thread.sleep(8000);
        switch (platform) {
            case "ipa":
                clickCloseButton();
                clickJusPayYesCancelBtn();
                clickPaymentBackBtn();
                clickSMBackBtn();
                ClickYes_Button();
                clickEABackBtn();
                break;
            default :
                clickBackButtonAndroid();
                clickJusPayYesCancelBtn();
                clickBackButtonAndroid();
                clickBackButtonAndroid();
                ClickYes_Button();
                clickBackButtonAndroid();
        }

        Thread.sleep(2000);
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
        int random = rand.nextInt(bound);
        if (random <= 5) {
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

    //    private void diffenceinDuration(Timestamp t0, Timestamp t1) throws ParseException {
//
//        String timestamp0=t0.toString();
//        String timestamp1=t1.toString();
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date1 = sdf.parse(timestamp0);
//        Date date2 = sdf.parse(timestamp1);
//
//        // Calculate the time difference in milliseconds
//        long timeDifference = date2.getTime() - date1.getTime();
//
//        // Convert milliseconds to seconds
//        long secondsDifference = timeDifference / 1000;
//
//        // Print the result
//        System.out.println("Time difference: " + secondsDifference + " seconds");
//
//        timestamp.add((int) secondsDifference);
//
//    }
//    public void printTimestamp()
//    {
//        // Print elements using a traditional for loop
//        for (int i = 0; i < timestamp.size(); i++) {
//            System.out.println("iteration " + i + " : " + timestamp.get(i) + " secs ");
//        }
//
//    }
    public void toggleApps() throws InterruptedException {
        driver.pressKey(new KeyEvent().withKey(AndroidKey.HOME));
        driver.activateApp("com.rummydotcom.indianrummycashgame");
        Thread.sleep(4000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.HOME));
        // driver.activateApp("io.jungleerummy.jungleegames");
        driver.activateApp("com.jungleerummy.playcashgameonline");
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

}
