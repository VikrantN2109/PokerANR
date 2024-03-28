package ANR;

import baseTest.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ANR extends BaseTest {
    String platform = props.getProperty("platform");
    int appLaunchFrequency = 10; // Integer.MAX_VALUE
    int reloadChipsFrequency = 40;
    int F2WFrequency = 1;
    int addCashFrequency =1;
    int F2UFrequency = 1;
    int runAppInBackGround=5;
    int toggleBetweenApps=5;
    int tournamentsFrequency=1;
    @Test
    @Parameters(value={"deviceIndex"})
    public void anr(String deviceIndex) throws InterruptedException, FileNotFoundException, ParseException {

        int noOfIterations = 250;

        flows.loginExistingUser(platform, deviceIndex);

        for (int i = 1; i <= noOfIterations; i++) {
            System.out.println("iteration: " + i); //Use logging
            try {
//                if (i % appLaunchFrequency == 0) {
//                    flows.relaunchApp(platform);
////                    Thread.sleep(4000);
////                    flows.captureScreenshot();
//                }

                if (i % reloadChipsFrequency == 0) {
                    flows.reloadChips();
                }

                if (i % F2WFrequency == 0) {
                  //  flows.randomRotation(20);
                    flows.flutterToWebviewPromotions(platform);
                    flows.flutterToWebviewLeaderboard(platform);
                }

//                if (i % addCashFrequency == 0) {
//                    System.out.println("Device Rotation Before Add Cash!");
//                    flows.randomRotation(10);
//                    flows.addCashJuspayFlow(platform);
//                }
//
//                if(i % runAppInBackGround ==0) {
//                    driver.runAppInBackground(Duration.ofSeconds(10));
//                }
//
//                if(i % toggleBetweenApps==0) {
//                    flows.toggleApps();
//                }
//
                if (i % F2UFrequency == 0) {
                    System.out.println("Device Rotation Before Game table!");
                   // flows.randomRotation(10);
                    flows.flutterToUnity(platform);
                    System.out.println("Device Rotation After Game table!");
                    flows.randomRotation(5);
                }

//                if(i % tournamentsFrequency==0)
//                {
//                    flows.tournamentFlow(platform);
//                }
                System.out.println("Testcase Passed with All Condition=" + i);

            } catch (Exception e) {
                System.out.println("Exception =" + e);
                flows.relaunchApp(platform);
                Thread.sleep(5000);
            }
        }

//        System.out.println("TWO DIMENSIONAL ARRAY FROM LOBBY TO GAME TABLE");
//        flows.printTwoDArray();
//
//        System.out.println("DIFFERENCE IN TIMESTAMP FROM LOBBY TO GAMETABLE");
//        //  flows.printTimestamp();
//
//



     //  flows.printDeviceLogs(driver);

//        Thread.sleep(5000);
//        logs.readLogs();
//        logs.print2DArray();
//        logs.diffInDuration();


    }
























//    public static void printDeviceLogs(AndroidDriver driver)
//    {
//        List<org.openqa.selenium.logging.LogEntry> logEntries = driver.manage().logs().get("logcat").getAll();
//        for (LogEntry logEntry : logEntries) {
//            System.out.println(logEntry.getMessage());
//        }
//    }

//    public static String executeCommand(String command) {
//        StringBuilder output = new StringBuilder();
//
//        try {
//            Process process = Runtime.getRuntime().exec(command);
//            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//
//            String line;
//            while ((line = reader.readLine()) != null) {
//                output.append(line).append("\n");
//            }
//
//            process.waitFor();
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return output.toString();
//    }

}

//    adb logcat | grep -E "(flutter|Unity)" > /Users/anushkas.hrivastava/Desktop/ANR/ANR/src/test/resources/output.txt