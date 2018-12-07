import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class BaseSet {
    protected static AppiumDriver driver;

    public static void setUpAppium() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("VERSION", "8.1.0");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.google.android.apps.nexuslauncher");
        capabilities.setCapability("appActivity", ".NexusLauncherActivity t1389");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, capabilities);
        String sessionId = driver.getSessionId().toString();

    }

    @BeforeClass
    public static void setUp() throws Exception {
        BaseSet bs = new BaseSet();
        bs.setUpAppium();

        //close calendar if it runs before tests

         WebDriverWait wait = new WebDriverWait(driver, 5);


        try {
            ((AndroidDriver) driver).pressKeyCode(187);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.systemui:id/dismiss_task")));
            WebElement dismissCal = driver.findElementById("com.android.systemui:id/dismiss_task");
            dismissCal.click();
            ((AndroidDriver) driver).pressKeyCode(3);
        } catch (Throwable e) {
            ((AndroidDriver) driver).pressKeyCode(3);
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Apps list']")));
        MobileElement appsMenu = (MobileElement) driver.findElementByXPath("//*[@content-desc='Apps list']");
        appsMenu.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Calendar']")));
        MobileElement calendarIcon = (MobileElement) driver.findElementByXPath("//*[@text='Calendar']");
        calendarIcon.click();

    }

    @AfterClass
    public static void tearDown() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        ((AndroidDriver) driver).pressKeyCode(187);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.systemui:id/dismiss_task")));
        WebElement dismissCal = driver.findElementById("com.android.systemui:id/dismiss_task");
        dismissCal.click();
        ((AndroidDriver) driver).pressKeyCode(3);


        driver.quit();
    }
}