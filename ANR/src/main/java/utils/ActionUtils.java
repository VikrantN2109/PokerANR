package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.Duration;
import java.util.List;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        try{
            // Wait for the element to be clickable
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            // Click on the element
            locator.click();
        }catch(Exception e){
            System.out.println(locator.toString()+" not found");
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

    public void scrollWithCoordinates(AndroidDriver driver, int startX, int startY, int endX, int endY) {
        final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point start = new Point(startX, startY);
        Point end = new Point(endX, endY);
        Sequence swipe = new Sequence(FINGER, 1)
                .addAction(
                        FINGER.createPointerMove(
                                Duration.ofMillis(0),
                                PointerInput.Origin.viewport(),
                                start.getX(),
                                start.getY()))
                .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(
                        FINGER.createPointerMove(
                                Duration.ofMillis(1000),
                                PointerInput.Origin.viewport(),
                                end.getX(),
                                end.getY()))
                .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(java.util.Arrays.asList(swipe));
    }

    public void setNetworkSpeedBS(String networkProfile) {
        String username = "roohpreetkaur_rJOCtg";
        String accessKey = "XgrmR7L4zwj9HHEpC6sB";
        String sessionId = String.valueOf(driver.getSessionId());
        String apiUrl = "https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId + "/update_network.json";
        String customNetworkProfile = networkProfile; //150,90,600,5
        String payload = "{\"networkProfile\":\"" + customNetworkProfile + "\"}";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic " + getAuthHeader(username, accessKey))
                .PUT(HttpRequest.BodyPublishers.ofString(payload))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getAuthHeader(String username, String accessKey) {
        return java.util.Base64.getEncoder().encodeToString((username + ":" + accessKey).getBytes());
    }

    public void timeStamp()
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
    }

    public static void executeADBCommand(AndroidDriver driver, String command) {
        driver.executeScript("mobile: shell", "adb shell " + command);
    }

    public static void enableWifi(AndroidDriver driver) {
        executeADBCommand(driver, "svc wifi enable");
    }

    public static void disableWifi(AndroidDriver driver) {
        executeADBCommand(driver, "svc wifi disable");
    }

    public static void runShellScript(String command) {
        int iExitValue;
        String sCommandString;
        sCommandString = command;
        CommandLine oCmdLine = CommandLine.parse(sCommandString);
        DefaultExecutor oDefaultExecutor = new DefaultExecutor();
        oDefaultExecutor.setExitValue(0);
        try {
            iExitValue = oDefaultExecutor.execute(oCmdLine);
        } catch (ExecuteException e){
            System.out.println("Fail");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("Denied");
            e.printStackTrace();
        }
    }

    public static void toggleNetworkSpeed(String speed) throws IOException {
        String charlesControlUrl = "http://localhost:8888/control/throttle/" + speed;

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(charlesControlUrl);

            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                handleResponse(response);
            }
        }
    }

    private static void handleResponse(CloseableHttpResponse response) {
        int statusCode = response.getStatusLine().getStatusCode();

        if (statusCode == 200) {
            System.out.println("Network speed changed successfully.");
        } else {
            System.err.println("Failed to change network speed. Response code: " + statusCode);
        }
    }
}