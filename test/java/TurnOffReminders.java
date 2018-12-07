import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TurnOffReminders extends PageObject {
    @AndroidFindBy(xpath = "//*[@content-desc='Show Calendar List and Settings drawer']")
    private MobileElement optionList;

    String calendOptionList = "Show Calendar List and Settings drawer";



    @AndroidFindBy(xpath = "//*[@text='Month']")
    private MobileElement monthBt;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'reminders:')]")
    private MobileElement remindersList;

    @AndroidFindBy(xpath = "//*[@content-desc='Close']")
    private MobileElement backBut;

    @AndroidFindBy(className = "android.widget.CheckBox")
    private List < MobileElement > checkBoxes;

    WebDriverWait wait = new WebDriverWait(driver, 30);

    public Boolean turnOffRem() {

        try {

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='Close']")));

            backBut.click();

            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("android.widget.ImageButton")));

            List < MobileElement > optionCalList = driver.findElementsByClassName("android.widget.ImageButton");

            optionCalList.get(1).click();
        } catch (Throwable f) {

            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("android.widget.ImageButton")));

            List < MobileElement > optionCalList = driver.findElementsByClassName("android.widget.ImageButton");

            optionCalList.get(1).click();
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.CheckBox")));

        checkBoxes.get(1).click();

        monthBt.click();

        try {

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[contains(@content-desc,'reminders:')]")));

            return true;
        } catch (Throwable f) {

            try {

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[contains(@content-desc,'Reminder:')]")));

                return true;

            } catch (Throwable fn) {
                return false;
            }
        }
    }
}