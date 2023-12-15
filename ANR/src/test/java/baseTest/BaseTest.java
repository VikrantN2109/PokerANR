package baseTest;

import com.google.common.collect.ImmutableMap;
import flows.ANRFlows;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.NetworkSpeed;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.ANRLocators;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public WebDriverWait wait;
    public AppiumDriverLocalService appiumService;
    public AndroidDriver driver ;
    public ANRLocators locators;
    public ANRFlows flows;

    public AndroidDriver initAppiumDriver() throws IOException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "10BD7S02NE009SG");
        desiredCapabilities.setCapability("unicodeKeyboard", false);
        desiredCapabilities.setCapability("resetKeyboard", false);

//        desiredCapabilities.setCapability("appPackage", "com.jungleerummy.playcashgameonline");
//        desiredCapabilities.setCapability("appActivity", "io.jungleerummy.jungleegames.MainActivity");

//        desiredCapabilities.setCapability("appPackage", "io.jungleerummy.jungleegames");
//        desiredCapabilities.setCapability("appActivity", "io.jungleerummy.jungleegames.MainActivity");

        desiredCapabilities.setCapability("appPackage", "com.rummydotcom.indianrummycashgame");
        desiredCapabilities.setCapability("appActivity", "com.rummydotcom.indianrummycashgame.MainActivity");


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
        System.out.println(driver.getContextHandles().toString());
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

//    public void resetApp() throws IOException {
//        Properties androidProperties=readPropertiesFromFile("android.capabilities");
//        String appPackage=androidProperties.getProperty("appPackage");
//        String activity=androidProperties.getProperty("appActivity");
//        clearApp(appPackage);
//    }
}
