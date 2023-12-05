package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class AppiumUtils {

    public AppiumDriverLocalService appiumService;

    public List<HashMap<String,String>> getJsonData(String jsonFilePath) throws IOException {
        String jsonContent= FileUtils.readFileToString(new File(jsonFilePath), String.valueOf(StandardCharsets.UTF_8));
        ObjectMapper mapper=new ObjectMapper();
        return mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
    }

    public AppiumDriverLocalService startAppiumService(String ipAddress, int port, DesiredCapabilities capabilities){
        HashMap environment = new HashMap();
        environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
        appiumService=new AppiumServiceBuilder().usingDriverExecutable(new File("/opt/homebrew/Cellar/node/20.4.0/bin/node"))
                .withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium"))
                .withArgument(() -> "--base-path", "/wd/hub")
                .withEnvironment(environment)
                .withIPAddress(ipAddress)
                .usingPort(port)
                .withCapabilities(capabilities)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL,"error")
                .build();
        appiumService.start();
        return appiumService;
    }

    public Properties readPropertiesFromFile(String fileName) throws IOException{
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//properties//"+fileName+".properties");
        prop.load(fis);
        return prop;
    }

    public String getScreenshotPath(String fileName, AndroidDriver driver) throws IOException{
        Properties prop = readPropertiesFromFile("browserstack");
        File source;
        if(prop.getProperty("browserstack").equals("false")){
            source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        }else{
            source=driver.getScreenshotAs(OutputType.FILE);
        }
        String destination=System.getProperty("user.dir")+"//ExtentReports//screenshots//"+fileName+".png";
        FileUtils.copyFile(source,new File(destination));
        return destination;
    }

}
