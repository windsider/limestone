import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TurnOffEvent extends PageObject {

    @AndroidFindBy(xpath = "//*[@content-desc='Show Calendar List and Settings drawer']")
    private MobileElement optionList;

    @AndroidFindBy(xpath = "//*[@text='Week']")
    private MobileElement weekBt;

    @AndroidFindBy(className = "android.widget.CheckBox")
    private List < MobileElement > checkBoxes;


    public List < MobileElement > turnOffEvent(String eventTitle) {



        List < MobileElement > optionCalList = driver.findElementsByClassName("android.widget.ImageButton");

        optionCalList.get(1).click();


        checkBoxes.get(0).click();

        weekBt.click();

        List < MobileElement > eventsOnWeekList = driver.findElementsByXPath("//android.view.View[contains(@content-desc,'" + eventTitle + "')]");
        return eventsOnWeekList;


    }
}