package ANR;

import baseTest.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObjects.ANRLocators;
import utils.ANRUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;
import java.time.Duration;

public class ANR extends BaseTest {

    @BeforeClass(alwaysRun = true)
    public void loadConfig() throws IOException, InterruptedException {
            try {
                initAppiumDriver();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }

    static int i=0;

    @Test
    public void anr() throws InterruptedException, MalformedURLException {
        int n = 300;
        int count = 0;
        int multi = 1;

        locators.loginExistingUser("7087537187", "Abcdef123!");

        for (int i = 1; i <= n; i++) {
            try {
              //  LoggerUtil.info(myLogger, "iteration: " + i);
                if (i % 4 == 0)
                {
                   // ((AndroidDriver) driver).start();

                    startActivity("com.jungleerummy.playcashgameonline","io.jungleerummy.jungleegames.MainActivity");

                  //  existinguserLoginSuccessfully(profileInterface,"7087537187", "Abcdef123!");
                    // closeAndLaunchApplication(capabilities);

                    //driver=initializeDriver();
                }

                if(i==45*multi)
                {
                    reloadChips();
                    multi++;
                }
//                Firstloop(driver); //menu->help->back->promotions->back
//                Thread.sleep(5000);
//                Secondloop(driver); //menu->help->back->promotions->back
//                Thread.sleep(2000);
////                depositUIModule.makePaymentThroughNetbanking(driver, Constants.Platform.PSRMG, false, "25");
////                Thread.sleep(5000);
////                //depositPage.waitForNavHomeTabVisible();
////                androidHelpers.clickBackButtonAndroid(driver);
////                depositPage.clickJusPayYesCancelBtn();
////                androidHelpers.clickBackButtonAndroid(driver);
////                androidHelpers.clickBackButtonAndroid(driver);
////                PromotionPage promotionPage = new PromotionPage(driver);
////                promotionPage.ClickYes_Button();
////                androidHelpers.clickBackButtonAndroid(driver);
//                Thread.sleep(2000);
//                gotoGametable(driver);
//                System.out.println("Testcase Pass with Both Condition=" + i);
//                // System.out.println("Testcase Pass from lobby to Gametable=" + i);
//
//                count++;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public  void Firstloop(AndroidDriver driver) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//*[contains(@content-desc,'Menu')]")));

        WebElement el1 = driver.findElement(AppiumBy.xpath("//*[contains(@content-desc,'Menu')]"));
        el1.click();

      //  LoggerUtil.info(myLogger, "Clicked On Menu Tab");

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Help"))).click();

     //   LoggerUtil.info(myLogger, "Clicked On Menu Help");

//        Thread.sleep(4000);
//
        WebElement helppage_backBtn =  wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//*[@resource-id='backButton']")));
        helppage_backBtn.click();
        // driver.navigate().back();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Promotions"))).click();
        //android.view.View
      //  LoggerUtil.info(myLogger, "Clicked On Menu Promotion Page");
        Thread.sleep(5000);
        driver.navigate().back();

    }

    public  void Secondloop(AndroidDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement el1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//*[contains(@content-desc,'Menu')]")));
        el1.click();
     //   LoggerUtil.info(myLogger, "Clicked On Menu Tab");

        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Help")));
        el.click();
     //   LoggerUtil.info(myLogger, "Clicked On Menu Help");

//        Thread.sleep(4000);

        driver.navigate().back();
        Thread.sleep(10000);

        WebElement el_prom = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Promotions")));
        el_prom.click();

     //   LoggerUtil.info(myLogger, "Clicked On Menu Promotion Page");

        WebElement helppage_backBtn =   wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//*[@resource-id='backButton']")));
        helppage_backBtn.click();
//        Thread.sleep(4000);


        //driver.navigate().back();


        Thread.sleep(3000);


    }

    public  void gotoGametable(AndroidDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("PRACTICE")));

        WebElement el2 = driver.findElement(AppiumBy.accessibilityId("PRACTICE"));
        el2.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("2"))).click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("PLAY NOW"))).click();

        dropTable();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Promotions")));

        System.out.println("Testcase Pass from lobby to Gametable=" + (++i));

    }

    public void reloadChips() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement el5 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]"));
        el5.click();

        WebElement ok_option = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("OK")));
        ok_option.click();
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


//    public  void existinguserLoginSuccessfully(ProfileInterface ProfileInterface, String username, String password) throws InterruptedException {
//        registerInterface.clickAllowPermission();
//        ProfileInterface.ClickLogIn();
//        ProfileInterface.ClickLoginUsingPassword();
//        ProfileInterface.enterUsername(username);
//        ProfileInterface.enterPassword(password);
//        androidHelpers.hideKeyboard_Android(driver);
//        ProfileInterface.clickLoginButtonExisting();
//        registerInterface.clickSkipButton();
//        lobbyInterface.closeWelcomeBanner();
//    }



}
