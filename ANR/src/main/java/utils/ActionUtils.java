package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.openqa.selenium.devtools.v116.dom.DOM.moveTo;

public class ActionUtils {
   public AndroidDriver driver;
   public WebDriverWait wait;
   public ArrayList<Integer> timestamp=new ArrayList<Integer>();
   public ArrayList<ArrayList<Long>> timeStamp2DArray = new ArrayList<ArrayList<Long>>();

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
        while(n>1) {
            try {
                wait.until(ExpectedConditions.visibilityOf(locator)).click();
                return;
            } catch (Exception e) {
                n -= 1;
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

    public void swipeToRight(int startX,int endX,int startY,int endY)
    {
        try {
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

    public Timestamp timeStamp()
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        return timestamp;
    }

    public void printDeviceLogs(AndroidDriver driver) throws FileNotFoundException, ParseException, InterruptedException {
        String filePath="/Users/anushkas.hrivastava/Desktop/ANR/ANR/src/test/resources/output.txt";
        PrintStream fileStream = new PrintStream(new File(filePath));
        // Redirect System.out to the file stream
        System.setOut(fileStream);

        long t0 = 0;
        long t1 = 0;

        List<org.openqa.selenium.logging.LogEntry> logEntries = driver.manage().logs().get("logcat").getAll();
        for (LogEntry logEntry : logEntries) {

//            if (logEntry.getMessage().contains("flutter : Lobby Event Added ::  lobby_play_now_clicked")) {
//                t0=logEntry.getTimestamp();
//                System.out.println(logEntry.getMessage());
//            }
//
//            if (logEntry.getMessage().contains("Unity   : Changing orientation from Game Table current Orientation Portrait change to LandscapeLeft")) {
//                t1=logEntry.getTimestamp();
//                System.out.println(logEntry.getMessage());
//            }

            System.out.println(logEntry.getMessage());


        }
        Thread.sleep(20000);
        fileStream.close();

    }

//    public void print2DArray()
//    {
//        System.out.print("             t0 (lobby)      " + " || ");
//        System.out.print("        t1 (game table)            " );
//        System.out.println();
//        for (int i = 0; i < timeStamp2DArray.size(); i++) {
//            for (int j = 0; j < timeStamp2DArray.get(i).size(); j++) {
//                System.out.print(timeStamp2DArray.get(i).get(j) + " || ");
//            }
//            System.out.println();
//        }
//    }

    public void diffenceinDuration(long t0, long t1) throws ParseException {

//        String timestamp0=t0.toString();
//        String timestamp1=t1.toString();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String timestamp0 = sdf.format(new Date(t0));
        String timestamp1 = sdf.format(new Date(t1));

        Date date1 = sdf.parse(timestamp0);
        Date date2 = sdf.parse(timestamp1);

        // Calculate the time difference in milliseconds
        long timeDifference = date2.getTime() - date1.getTime();

        // Convert milliseconds to seconds
        long secondsDifference = timeDifference / 1000;

        // Print the result
        System.out.println("Time difference: " + secondsDifference + " seconds");

        timestamp.add((int) secondsDifference);

    }

    public void printTimestamp()
    {
        // Print elements using a traditional for loop
        System.out.println("AFTER FILESTREAM CLOSE");

        for (int i = 0; i < timestamp.size(); i++) {
            System.out.println("iteration " + i + " : " + timestamp.get(i) + " secs ");
        }
    }

//    public void readLogs()
//    {
//        String filePath = "/Users/anushkas.hrivastava/Desktop/ANR/ANR/src/test/resources/output.txt"; // Replace with the actual path to your log file
//        try {
//
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
//            String line;
//
//            // DateTimeFormatter for parsing timestamps
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd HH:mm:ss.SSS");
//
//            while ((line = bufferedReader.readLine()) != null) {
//                try {
//                    // Attempt to parse timestamp in each line
//                    String timestampString = line.substring(0, 18); // Assuming timestamp is always at the beginning
//                   // formatter.parse(timestampString);
//                    System.err.println("Timestamp: " + timestampString);
//                } catch (Exception e) {
//                    // Ignore lines without a valid timestamp
//                    System.out.println("Exception is : " + e );
//                }
//            }
//
////        try {
////            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
////            String line;
////            // Regular expression pattern to match timestamps (assuming the format in your logs)
////            Pattern pattern = Pattern.compile("((.*)\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d+(.*))");
////            while ((line = bufferedReader.readLine()) != null) {
////                // Find timestamp in each line using the regular expression
////                Matcher matcher = pattern.matcher(line);
////                if (matcher.find()) {
////                    String timestamp = matcher.group();
////                    System.out.println("Current Timestamp: " + timestamp);
////                }
////            }
//
//            // Close the resources
//            bufferedReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void captureScreenshot() {
        String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        String fileName = "GameTable_" + timestamp + ".png";

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path destination = Paths.get("/Users/anushkas.hrivastava/Desktop/Screenshots/" + fileName);

        try {
            Files.copy(screenshot.toPath(), destination);
            System.out.println("Screenshot captured: " + destination.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
