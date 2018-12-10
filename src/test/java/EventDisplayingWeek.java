import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class EventDisplayingWeek extends PageObject {

    @AndroidFindBy(xpath = "//*[@content-desc='Show Calendar List and Settings drawer']")
    private MobileElement optionList;

    @AndroidFindBy(xpath = "//*[@text='Week']")
    private MobileElement weekBt;


    public List < MobileElement > eventWeek(String eventTitle) {

        optionList.click();
        weekBt.click();

        List < MobileElement > eventsOnWeekList = driver.findElementsByXPath("//android.view.View[contains(@content-desc,'" + eventTitle + "')]");
        return eventsOnWeekList;


    }
}