package baseTest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pageObjects.ANRLocators;
import utils.AppiumUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriverWait wait;
    public AppiumDriverLocalService appiumService;

//    public CommonMethods commonMethods;
    public AndroidDriver driver ;
    public ANRLocators locators;


//    @BeforeSuite(alwaysRun = true)
//    public void loadConfig() throws IOException, InterruptedException {
////        Properties prop = readPropertiesFromFile("browserstack");
////        if (prop.getProperty("browserstack").equals("true")) {
////            initBrowserStackDriver();
////        } else {
//            initAppiumDriver();
////        }
////        initTests();
//    }
//
//    @AfterSuite(alwaysRun = true)
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//        if (appiumService != null) {
//            appiumService.stop();
//        }
//    }

    /*
    Code to initiated Appium Server and
     */

    public AndroidDriver initAppiumDriver() throws IOException, InterruptedException {
//        Properties androidProperties = readPropertiesFromFile("android.capabilities");
//        Properties appiumProperties = readPropertiesFromFile("appium");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("appium:platformName", androidProperties.getProperty("platform"));
//        capabilities.setCapability("appium:deviceName", androidProperties.getProperty("udid"));
//        capabilities.setCapability("appium:automationName", androidProperties.getProperty("automationName"));
//        capabilities.setCapability("appium:appPackage", androidProperties.getProperty("appPackage"));
//        capabilities.setCapability("appium:autoGrantPermissions", androidProperties.getProperty("autoGrantPermission"));
//        capabilities.setCapability("appium:appActivity", androidProperties.getProperty("appActivity"));
//        capabilities.setCapability("appium:newCommandTimeout", Integer.parseInt(androidProperties.getProperty("newCommandTimeout")));
//        capabilities.setCapability("appium:systemPort", Integer.parseInt(androidProperties.getProperty("systemPort")));
//        capabilities.setCapability("appium:noSign", androidProperties.getProperty("noSign"));

//        appiumService = startAppiumService(appiumProperties.getProperty("url"), Integer.parseInt(appiumProperties.getProperty("port")), capabilities);
//        driver = new AndroidDriver(appiumService.getUrl(), capabilities);
//        driver.manage().timeouts().implicitlyWait(Integer.parseInt(appiumProperties.getProperty("driverTimeout")), TimeUnit.SECONDS);
//        System.out.println("reached here");


        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "10BD7S02NE009SG");

        //desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "d85bb9c");

        desiredCapabilities.setCapability("unicodeKeyboard", false);
        desiredCapabilities.setCapability("resetKeyboard", false);


        desiredCapabilities.setCapability("appPackage", "com.jungleerummy.playcashgameonline");
        desiredCapabilities.setCapability("appActivity", "io.jungleerummy.jungleegames.MainActivity");


//        desiredCapabilities.setCapability("appPackage", "com.rummydotcom.indianrummycashgame");
//        desiredCapabilities.setCapability("appActivity", "com.rummydotcom.indianrummycashgame.MainActivity");


//        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("simpleIsVisibleCheck", true);
        desiredCapabilities.setCapability("noReset", false);
        desiredCapabilities.setCapability("fullReset", false);
        //desiredCapabilities.setCapability("adbExecTimeout", 5000);

      //  desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60000);
        desiredCapabilities.setCapability("automationName", "uiautomator2");
//      desiredCapabilities.setCapability("automationName", "Flutter");

    //    desiredCapabilities.setCapability(MobileCapabilityType.UDID, "10BD7S02NE009SG");
        //desiredCapabilities.setCapability(MobileCapabilityType.UDID, "d85bb9c");

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
        Thread.sleep(4000);
        System.out.println(driver.getContextHandles().toString());
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        commonMethods= new CommonMethods(driver,wait);
        locators=new ANRLocators(driver,wait);

        return driver;

    }

    /*
    Boilerplate code to start Browser Stack Driver
     */

    //    @org.testng.annotations.Parameters(value={"deviceIndex"}) String deviceIndex
//    public void initBrowserStackDriver() {
//        JSONParser parser = new JSONParser();
//        JSONObject config = null;
//        try {
//            config = (JSONObject) parser.parse(new FileReader("src//test//resources//com//howzat//browserstack_single//single.conf.json"));
//        } catch (IOException | ParseException e) {
//            throw new RuntimeException(e);
//        }
//        JSONArray envs = (JSONArray) config.get("environments");
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        Map<String, String> envCapabilities = (Map<String, String>) envs.get(0); //Integer.parseInt(deviceIndex)
//        Iterator it = envCapabilities.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry) it.next();
//            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
//        }
//
//        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
//        it = commonCapabilities.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry) it.next();
//            if (capabilities.getCapability(pair.getKey().toString()) == null) {
//                capabilities.setCapability(pair.getKey().toString(), pair.getValue());
//            }
//        }
//        capabilities.setCapability("autoGrantPermissions", "true");
//
//        capabilities.setCapability("browserstack.idleTimeout", "60");
//        capabilities.setCapability("browserstack.networkProfile", "4g-lte-advanced-good");
//        capabilities.setCapability("browserstack.appium_version", "1.22.0");
//
//        /*
//        OTHER BROWSERSTACK CAPABILITIES
//
//        capabilities.setCapability("browserstack.appStoreConfiguration", new HashMap<String, String>() {{ put("username", "abc@gmail.com"); put("password", "hello123"); }});
//        capabilities.setCapability("otherApps", new String[]{"bs://aab"});
//
//        capabilities.setCapability("browserstack.video", "false");
//        capabilities.setCapability("browserstack.debug", "true");
//        capabilities.setCapability("browserstack.appiumLogs", "false");
//        capabilities.setCapability("browserstack.gpsLocation", "25,82");
//        capabilities.setCapability("browserstack.timezone", "New_York");
//
//        capabilities.setCapability("language", "Fr");
//        capabilities.setCapability("locale", "Fr");
//        capabilities.setCapability("deviceOrientation", "landscape");
//        capabilities.setCapability("browserstack.geoLocation", "Fr");
//        capabilities.setCapability("browserstack.customNetwork", "2,3,50,21");
//        capabilities.setCapability("disableAnimations", "true");
//        capabilities.setCapability("browserstack.midSessionInstallApps", new String[]{"bs://aa"});
//        capabilities.setCapability("browserstack.uploadMedia", new String[]{"media://bb"});
//        capabilities.setCapability("browserstack.enablePasscode", "true");
//
//        */
//
//
//        String username = System.getenv("BROWSERSTACK_USERNAME");
//        if (username == null) {
//            username = (String) config.get("username");
//        }
//
//        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
//        if (accessKey == null) {
//            accessKey = (String) config.get("access_key");
//        }
//
//        String app = System.getenv("BROWSERSTACK_APP_ID");
//        if (app != null && !app.isEmpty()) {
//            capabilities.setCapability("app", app);
//        }
//
//        try {
//            driver = new AndroidDriver(new URL("http://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub"), capabilities);
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    private void initTests() throws IOException {
//        wait = new WebDriverWait(driver, Integer.parseInt(readPropertiesFromFile("appium").getProperty("driverTimeout")));
//        //mobilePage = new LoginDefault(driver, wait);
//    }

    public void startActivity(String appPackage, String activity){
        driver.executeScript("mobile: startActivity", ImmutableMap.of("intent",appPackage+"/"+activity));
    }

    public void clearApp(String appPackage){
        driver.executeScript("mobile: clearApp", ImmutableMap.of("appId",appPackage));
    }

//    public void resetApp() throws IOException {
//        Properties androidProperties=readPropertiesFromFile("android.capabilities");
//        String appPackage=androidProperties.getProperty("appPackage");
//        String activity=androidProperties.getProperty("appActivity");
//        clearApp(appPackage);
//    }

}
