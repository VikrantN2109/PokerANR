//package commonMethods;
//
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.pagefactory.AppiumFieldDecorator;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import pageObjects.ANRLocators;
//import utils.ANRUtils;
//
//public class CommonMethods extends ANRLocators {
//
//
//    public CommonMethods(AndroidDriver driver, WebDriverWait wait) {
//        super(driver, wait);
//        this.driver=driver;
//        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
//    }
//
//    public void loginExistingUser(String username, String password) throws InterruptedException {
//        clickAllowPermission();
//        ClickLogIn();
//        ClickLoginUsingPassword();
//        enterUsername(username);
//        enterPassword(password);
//        hideKeyboard_Android();
//        clickLoginButtonExisting();
//        clickSkipButton();
//        closeWelcomeBanner();
//    }
//
//
//
//}
