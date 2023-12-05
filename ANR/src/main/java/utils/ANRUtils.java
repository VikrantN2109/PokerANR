package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.ANRLocators;

import java.util.List;
import java.util.NoSuchElementException;

public class ANRUtils {
   public AndroidDriver driver;
   public WebDriverWait wait;

    public ANRUtils(AndroidDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
    }

   // ANRLocators anrLocators = new ANRLocators(driver, wait);

    protected void waitVisibility (WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void sleep (long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void click (WebElement locator, boolean... takeScreenshot) {

        TouchAction touchAction = new TouchAction(driver);
        TapOptions tapOptions = new TapOptions();
        tapOptions.withElement(ElementOption.element(locator)).withTapsCount(1);
        touchAction.tap(tapOptions).perform();
//        if(takeScreenshot[0]){
//
//        }
    }

    protected void tapByCoordinates(int x,int y){
        TouchAction touchAction = new TouchAction(driver);
        PointOption tapOption = new PointOption();
        tapOption.withCoordinates(x,y);
        touchAction.tap(tapOption).perform();
    }

    protected boolean isElementPresent(WebElement element) {
        boolean isPresent=false;
        try{
            isPresent=element.isDisplayed();
        }catch(Exception e){
            System.out.println(element.toString()+" not found");
        }
        return isPresent;
    }

    protected void waitAndClick (WebElement locator) {
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

    protected void keyCodeBack(){
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    protected List<WebElement> waitAndFindElements (WebElement element) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    protected WebElement waitAndFindElement (WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    protected String getText(WebElement element) {
        return waitAndFindElement(element).getText();
    }

    protected void sendText (WebElement element, String text) {
        waitAndFindElement(element).sendKeys(text);
    }

    protected void assertEquals (String actual, String expected) {
        Assert.assertEquals(actual,expected, "Two texts are not equal!" + "Actual: " + actual + " Expected: " + expected);
    }


}
