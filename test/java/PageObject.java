import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class PageObject extends BaseSet{

    public PageObject() {

        PageFactory.initElements(new AppiumFieldDecorator (driver, 5, TimeUnit.SECONDS), this);
    }
}