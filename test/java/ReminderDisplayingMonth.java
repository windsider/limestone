import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ReminderDisplayingMonth extends PageObject {

    @AndroidFindBy(xpath = "//*[@content-desc='Close']")
    private MobileElement backBut;

    @AndroidFindBy(xpath = "//*[@content-desc='Show Calendar List and Settings drawer']")
    private MobileElement optionList;

    @AndroidFindBy(xpath = "//*[@text='Month']")
    private MobileElement month;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'reminders:')]")
    private MobileElement remindersList;

    WebDriverWait wait = new WebDriverWait(driver, 30);

    public List < MobileElement > reminderDisplay(String reminderTitle) {

        try {

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='Close']")));
            backBut.click();


            optionList.click();

        } catch (Throwable f) {


            List < MobileElement > optionCalList = driver.findElementsByClassName("android.widget.ImageButton");

            optionCalList.get(1).click();
        }


        month.click();



        try {

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[contains(@content-desc,'reminders:')]")));
            remindersList.click();

            List < MobileElement > remindersMonth = driver.findElementsByXPath("//android.view.View[contains(@content-desc,'" + reminderTitle + "')]");
            return remindersMonth;
        } catch (Throwable f) {
            List < MobileElement > remindersMonth = driver.findElementsByXPath("//android.view.View[contains(@content-desc,'" + reminderTitle + "')]");
            return remindersMonth;
        }

    }
}