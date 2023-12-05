package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ActionUtils {
   public AndroidDriver driver;
   public WebDriverWait wait;

    public ActionUtils(AndroidDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
    }

    public void waitVisibility (WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void sleep (long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void click(WebElement locator, boolean... takeScreenshot) {
        TouchAction touchAction = new TouchAction(driver);
        TapOptions tapOptions = new TapOptions();
        tapOptions.withElement(ElementOption.element(locator)).withTapsCount(1);
        touchAction.tap(tapOptions).perform();
    }

    public void tapByCoordinates(int x,int y){
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(x, y)).perform();
    }

    public void clickBackButtonAndroid(){
        driver.navigate().back();
    }

    public boolean isElementPresent(WebElement element) {
        boolean isPresent=false;
        try{
            isPresent=element.isDisplayed();
        }catch(Exception e){
            System.out.println(element.toString()+" not found");
        }
        return isPresent;
    }

    public void waitAndClick(WebElement locator) {
        int n=3;
        while(n>1){
            try{
                wait.until(ExpectedConditions.visibilityOf(locator)).click();
                return;
            }catch(Exception e){
                n-=1;
            }
        }
    }

    public void keyCodeBack(){
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public List<WebElement> waitAndFindElements (WebElement element) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public WebElement waitAndFindElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public String getText(WebElement element) {
        return waitAndFindElement(element).getText();
    }

    public void sendText(WebElement element, String text) {
        waitAndFindElement(element).sendKeys(text);
    }

    public void assertEquals (String actual, String expected) {
        Assert.assertEquals(actual,expected, "Two texts are not equal!" + "Actual: " + actual + " Expected: " + expected);
    }

    public void hideKeyboard_Android()
    {
        if (driver.isKeyboardShown()) {
            try {
                driver.hideKeyboard();
            } catch (Exception e) {
            }
        }
    }

    public void swipeToRight()
    {
        try {
            Dimension size = driver.manage().window().getSize();
//            int startX = size.width / 2;
//            int startY = (int) (size.height * 0.8); // Start from 80% down the screen
//            int endY = (int) (size.height * 0.6); // End at 20% down the screen

            int startX = (int) (size.width * 0.8); // 80% from the left
            int endX = (int) (size.width * 0.2);   // 20% from the left
            int startY = size.height / 3;

            TouchAction<?> action = new TouchAction<>(driver);
            action.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))) // Add a wait action
                    .moveTo(PointOption.point(startX, endX))
                    .release()
                    .perform();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "swipeToBottom method failed");
        }


    }
}
