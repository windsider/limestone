import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SetGoal extends PageObject {
    @AndroidFindBy(id = "com.google.android.calendar:id/floating_action_button")
    private WebElement addTask;

    @AndroidFindBy(id = "com.google.android.calendar:id/date_picker_text_view")
    private WebElement pickMonth;

    @AndroidFindBy(id = "com.google.android.calendar:id/action_today")
    private WebElement pickToday;

    @AndroidFindBy(xpath = "//*[@text='Goal']")
    private WebElement goalButton;

    @AndroidFindBy(xpath = "//*[@text='Exercise']")
    private WebElement exerciseButton;

    @AndroidFindBy(xpath = "//*[@text='CONNECT']")
    private WebElement connect;

    @AndroidFindBy(id = "com.google.android.calendar:id/floating_action_button")
    private WebElement okIcon;

    @AndroidFindBy(id = "com.google.android.calendar:id/first_line_text")
    private WebElement firtsLine;




    public String setGoal(String goalType, String activityType, String howOften, String howLong, String bestTime) {

        pickToday.click();

        addTask.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Goal']")));


        goalButton.click();


        // exerciseButton.click ();

        WebElement goal = driver.findElementByXPath("//*[@text='" + goalType + "']");
        goal.click();

        WebElement runItem = driver.findElementByXPath("//*[@text='" + activityType + "']");
        runItem.click();

        WebElement fiveTimes = driver.findElementByXPath("//*[@text='" + howOften + "']");
        fiveTimes.click();

        WebElement thirtyMin = driver.findElementByXPath("//*[@text='" + howLong + "']");
        thirtyMin.click();

        WebElement evening = driver.findElementByXPath("//*[@text='" + bestTime + "']");
        evening.click();


        connect.click();


        okIcon.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.google.android.calendar:id/first_line_text")));

        WebElement firtsLine = driver.findElementById("com.google.android.calendar:id/first_line_text");

        return firtsLine.getText();

    }
}