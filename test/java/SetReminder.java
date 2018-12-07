import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SetReminder extends PageObject {

    @AndroidFindBy(id = "com.google.android.calendar:id/action_today")
    private MobileElement pickToday;

    @AndroidFindBy(id = "com.google.android.calendar:id/floating_action_button")
    private MobileElement addTask;

    @AndroidFindBy(id = "com.google.android.calendar:id/input")
    private MobileElement inputText;

    @AndroidFindBy(xpath = "//*[@text='Reminder']")
    private MobileElement reminderButton;

    @AndroidFindBy(id = "com.google.android.calendar:id/input")
    private MobileElement inputReminderName;


    @AndroidFindBy(xpath = "//*[@text='DONE']")
    private MobileElement doneButton;

    @AndroidFindBy(xpath = "//*[@text='SAVE']")
    private MobileElement saveButton;

    @AndroidFindBy(xpath = "//*[@content-desc='Show Calendar List and Settings drawer']")
    private MobileElement calendarOptionList;

    @AndroidFindBy(xpath = "//*[@text='Day']")
    private MobileElement dayBt;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'reminders:')]")
    private MobileElement remindersList;

    WebDriverWait wait = new WebDriverWait(driver, 30);



    public List < MobileElement > setReminder(String reminderTitle) {
        pickToday.click();

        for (int i = 1; i < 3; i++) {
            String reminderTitleNumbered = reminderTitle + " " + ((Object) i).toString();
            addTask.click();

            reminderButton.click();

            inputText.click();

            inputReminderName.sendKeys(reminderTitleNumbered);

            doneButton.click();

            saveButton.click();
        }

        calendarOptionList.click();

        dayBt.click();

        try {

            List < MobileElement > remListCl = driver.findElementsByClassName("//android.view.View");
            remListCl.get(0).click();
            List < MobileElement > createdReminders = driver.findElementsByXPath("//android.view.View[contains(@content-desc,'" + reminderTitle + "')]");
            return createdReminders;
        } catch (Throwable f) {
            List < MobileElement > createdReminders = driver.findElementsByXPath("//android.view.View[contains(@content-desc,'" + reminderTitle + "')]");
            return createdReminders;
        }
    }
}