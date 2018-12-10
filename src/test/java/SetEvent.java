import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SetEvent extends PageObject {

    @AndroidFindBy(id = "com.google.android.calendar:id/action_today")
    private MobileElement pickToday;

    @AndroidFindBy(id = "com.google.android.calendar:id/floating_action_button")
    private MobileElement addTask;

    @AndroidFindBy(id = "com.google.android.calendar:id/save")
    private MobileElement doneButton;

    @AndroidFindBy(id = "com.google.android.calendar:id/save")
    private MobileElement saveBt;

    @AndroidFindBy(xpath = "//*[@text='Event']")
    private MobileElement eventButton;

    @AndroidFindBy(id = "com.google.android.calendar:id/input")
    private MobileElement inputText;

    @AndroidFindBy(id = "com.google.android.calendar:id/input")
    private MobileElement inputEventName;

    WebDriverWait wait = new WebDriverWait(driver, 10);



    String saveBtXpath = "//*[@text='SAVE']";



    public List < MobileElement > setEvent(String eventTitle) {

        pickToday.click();

        for (int i = 1; i < 3; i++) {
            String eventTitleNumered = eventTitle + " " + ((Object) i).toString();
            addTask.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Event']")));


            eventButton.click();


            inputText.click();

            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@content-desc='Calendar']")));

            inputEventName.sendKeys(eventTitleNumered);



            //wait.until(ExpectedConditions.elementToBeClickable (By.className ("android.widget.Button")));

            List < MobileElement > doneBut = driver.findElementsByClassName("android.widget.Button");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@content-desc='Calendar']")));
            doneBut.get(0).click();

            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@content-desc='Calendar']")));

            // wait.until(ExpectedConditions.elementToBeClickable (By.xpath (saveBtXpath)));


            saveBt.click();
        }



        List < MobileElement > createdEvents = driver.findElementsByXPath("//android.view.View[contains(@content-desc,'" + eventTitle + "')]");
        return createdEvents;



    }
}