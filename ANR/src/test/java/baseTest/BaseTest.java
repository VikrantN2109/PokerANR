package baseTest;

import com.google.common.collect.ImmutableMap;
import flows.ANRFlows;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.NetworkSpeed;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageObjects.ANRLocators;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class BaseTest {

    public WebDriverWait wait;
    public AppiumDriverLocalService appiumService;
    public AndroidDriver driver ;
    public ANRLocators locators;
    public ANRFlows flows;
    public Properties props;
    public BaseTest(){
        FileReader propertyFile = null;
        try {
            propertyFile = new FileReader("src/test/resources/config.properties");
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        props = new Properties();
        try {
            props.load(propertyFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(props.getProperty("runEnv"));
    }
    //@BeforeMethod(alwaysRun = true)
    public AndroidDriver initAppiumDriver() throws IOException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "10BD7S02NE009SG");
        desiredCapabilities.setCapability("unicodeKeyboard", false);
        desiredCapabilities.setCapability("resetKeyboard", false);

        if(props.getProperty("platform").equalsIgnoreCase("psrmg") || props.getProperty("platform").equalsIgnoreCase("ipa"))
        {
            desiredCapabilities.setCapability("appPackage", "com.jungleerummy.playcashgameonline");
            desiredCapabilities.setCapability("appActivity", "io.jungleerummy.jungleegames.MainActivity");
        }
        else if(props.getProperty("platform").equalsIgnoreCase("native"))
        {
            desiredCapabilities.setCapability("appPackage", "io.jungleerummy.jungleegames");
            desiredCapabilities.setCapability("appActivity", "io.jungleerummy.jungleegames.MainActivity");
        }
        else {
            desiredCapabilities.setCapability("appPackage", "com.rummydotcom.indianrummycashgame");
            desiredCapabilities.setCapability("appActivity", "com.rummydotcom.indianrummycashgame.MainActivity");
        }

        desiredCapabilities.setCapability("simpleIsVisibleCheck", true);
        desiredCapabilities.setCapability("noReset", false);
        desiredCapabilities.setCapability("fullReset", false);
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("newCommandTimeout", "200");
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingAnyFreePort();
        builder.withAppiumJS(new File("/opt/homebrew/bin/appium"));
        builder.withCapabilities(desiredCapabilities);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        builder.withArgument(() -> "--base-path", "/wd/hub");
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
        service.start();
        URL url = service.getUrl();
        driver = new AndroidDriver(url, desiredCapabilities);
       // driver.setNetworkSpeed(NetworkSpeed.valueOf("250")); // Replace with your desired speed
        Thread.sleep(4000);
      //  System.out.println(driver.getContextHandles().toString());
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        locators=new ANRLocators(driver,wait);
        flows =new ANRFlows(driver,wait);
        return driver;
    }

    public AndroidDriver launchBSDriverSingleDevice() throws IOException {
        String browserstackHubURL = "https://" + props.getProperty("browserstack_user") + ":" + props.getProperty("browserstack_key") +
                "@hub-cloud.browserstack.com/wd/hub/";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String buildNumber = dateFormat.format(new Date());
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        HashMap<String, String> googleCredentials = new HashMap<>();
        googleCredentials.put("username", "roohpreet002@gmail.com");
        googleCredentials.put("password", "Roohpreet25!");
        desiredCapabilities.setCapability("browserstack.appStoreConfiguration", googleCredentials);
        desiredCapabilities.setCapability("browserstack.user", props.getProperty("browserstack_user"));
        desiredCapabilities.setCapability("browserstack.key", props.getProperty("browserstack_key"));
        desiredCapabilities.setCapability("project", "Product Rummy");
        desiredCapabilities.setCapability("build", "ANR Build : " + buildNumber);
        desiredCapabilities.setCapability("name", "ANR Suite");
        desiredCapabilities.setCapability("appiumVersion", "2.0.1");
        desiredCapabilities.setCapability("app", props.getProperty("psrmg_app"));
        desiredCapabilities.setCapability("interactiveDebugging", "true");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "Vivo Y21");
        desiredCapabilities.setCapability("os_version", "11");
        desiredCapabilities.setCapability("unicodeKeyboard", false);
        desiredCapabilities.setCapability("resetKeyboard", false);
        desiredCapabilities.setCapability("newCommandTimeout", "200");
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("noReset", false);
        desiredCapabilities.setCapability("fullReset", false);
        AndroidDriver driver = new AndroidDriver(new URL((browserstackHubURL)), desiredCapabilities);

        System.out.println("Session ID : " + driver.getSessionId());
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        locators=new ANRLocators(driver,wait);
        flows =new ANRFlows(driver,wait);
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters(value={"deviceIndex"})
    public AndroidDriver launchBS(String deviceIndex) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/ANRConfig.json"));
        JSONArray envs = new JSONArray();
        String app = "";
        if(props.getProperty("platform").equalsIgnoreCase("ipa")) {
            envs = (JSONArray) config.get("iOSEnvironments");
        } else {
            envs = (JSONArray) config.get("androidEnvironments");
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();

        Map<String, String> envCapabilities = (Map<String, String>) envs.get(Integer.parseInt(deviceIndex));
        Iterator it = envCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
        }

        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        it = commonCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(capabilities.getCapability(pair.getKey().toString()) == null){
                capabilities.setCapability(pair.getKey().toString(), pair.getValue());
            }
        }

        String username = System.getenv("BROWSERSTACK_USERNAME");
        if(username == null) {
            username = (String) config.get("username");
        }

        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        if(accessKey == null) {
            accessKey = (String) config.get("access_key");
        }

        switch (props.getProperty("platform")) {
            case "ipa":
                app = (String) config.get("ipa");
                break;
            case "psrmg":
                app = (String) config.get("psrmg_app");
                break;
            case "native":
                app = (String) config.get("native_app");
                break;
            case "rummy.com":
                app = (String) config.get("rummycom_app");
                break;
        }
        if(app != null && !app.isEmpty()) {
            capabilities.setCapability("app", app);
        }

        HashMap<String, String> googleCredentials = new HashMap<>();
        googleCredentials.put("username", "roohpreet002@gmail.com");
        googleCredentials.put("password", "Roohpreet25!");
        capabilities.setCapability("browserstack.appStoreConfiguration", googleCredentials);
        executeADBCommand("adb shell am broadcast -a android.intent.action.MEMORY_FULL");
        driver = new AndroidDriver(new URL("http://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        locators=new ANRLocators(driver,wait);
        flows =new ANRFlows(driver,wait);
        return driver;
    }

    public void startActivity(String appPackage, String activity){
        driver.executeScript("mobile: startActivity", ImmutableMap.of("intent",appPackage+"/"+activity));
    }

    public void clearApp(String appPackage){
        driver.executeScript("mobile: clearApp", ImmutableMap.of("appId",appPackage));
    }

    private static void executeADBCommand(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown() throws Exception {
        // Invoke driver.quit() to indicate that the test is completed.
        // Otherwise, it will appear as timed out on BrowserStack.
        driver.quit();
    }
}
