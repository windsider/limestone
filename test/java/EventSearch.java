import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class EventSearch extends PageObject {

    @AndroidFindBy(xpath = "//*[@content-desc='Show Calendar List and Settings drawer']")
    private MobileElement optionList;

    String calendOptionList = "Show Calendar List and Settings drawer";

    @AndroidFindBy(xpath = "//*[@text='Search']")
    private MobileElement searchBt;

    @AndroidFindBy(id = "com.google.android.calendar:id/search_edit_text")
    private MobileElement searchField;

    @AndroidFindBy(xpath = "//*[@content-desc='Back']")
    private MobileElement backBt;

    WebDriverWait wait = new WebDriverWait(driver, 5);


    public Boolean eventSearch(String eventTitle) {


        List < MobileElement > optionCalList = driver.findElementsByClassName("android.widget.ImageButton");


        optionCalList.get(1).click();


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Search']")));

        searchBt.click();

        // wait.until(ExpectedConditions.elementToBeClickable (By.className ("android.widget.EditText")));

        List < MobileElement > searchFld = driver.findElementsByClassName("android.widget.EditText");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@content-desc='Calendar']")));

        searchFld.get(0).sendKeys(eventTitle);

        ((AndroidDriver) driver).pressKeyCode(66);

        try {

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[contains(@content-desc,'" + eventTitle + "')]")));
            return true;

        } catch (Throwable f) {
            return false;
        } finally {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@content-desc='Calendar']")));
            backBt.click();
        }

    }
}