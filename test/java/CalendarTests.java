import io.appium.java_client.MobileElement;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CalendarTests extends PageObject {

    WebDriverWait wait = new WebDriverWait(driver, 5);

    String moreOptionsXpath = "//*[@content-desc='More options']";

    String deleteButXpath = "//*[@text='Delete']";

    //data for event and reminder tests

    String eventTitle = "EventTest";
    String reminderTitle = "Reminder_Unique";


    public static boolean isInitialized(By el, WebDriverWait wait) {

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(el));
            return true;
        } catch (Throwable f) {
            return false;
        }
    }


    // @Ignore
    @Test
    public void test1_setGoal() throws NoSuchElementException {
        String goalType = "Exercise";
        String activityType = "Run";
        String howOften = "5 times a week";
        String howLong = "30 minutes";
        String bestTime = "Evening";
        SetGoal setGoalObj = new SetGoal();
        String goalVer = setGoalObj.setGoal(goalType, activityType, howOften, howLong, bestTime);

        try {
            assertThat(goalVer, startsWith("First time is"));
        } finally {
            //removing created goal
            MobileElement looksGoodBut = (MobileElement) driver.findElementByXPath("//*[@text='LOOKS GOOD']");
            looksGoodBut.click();
        }
    }

    //@Ignore
    @Test
    public void test2_setEvent() throws NoSuchElementException {

        SetEvent setEventObj = new SetEvent();
        List < MobileElement > eventsCreated = setEventObj.setEvent(eventTitle);


        assert(eventsCreated.size() != 0);
        for (MobileElement event: eventsCreated) {

            assertThat(event.getAttribute("contentDescription"), containsString(eventTitle));
        }


    }


    @Test

    public void test3_searchEvent() throws NoSuchElementException {

        EventSearch eventSearchObj = new EventSearch();

        Boolean searchEvent = eventSearchObj.eventSearch(eventTitle);

        assertTrue("The Event Not Found", searchEvent);
    }

    //@Ignore
    @Test
    public void test4_eventDisplayingWeek() throws NoSuchElementException {

        EventDisplayingWeek eventDisplayingWeekObj = new EventDisplayingWeek();

        List < MobileElement > eventsOnWeek = eventDisplayingWeekObj.eventWeek(eventTitle);

        assertTrue("The week list does not  contain events", eventsOnWeek.size() != 0);
    }


    //@Ignore

    @Test
    public void test5_turnOffEvents() throws NoSuchElementException {

        TurnOffEvent turnOffEventObj = new TurnOffEvent();

        List < MobileElement > turnedOffEvents = turnOffEventObj.turnOffEvent(eventTitle);

        assertTrue("The week list contains events", turnedOffEvents.isEmpty());
    }


    //@Ignore
    @Test
    public void test6_setReminder() throws NoSuchElementException {

        SetReminder setReminderObj = new SetReminder();

        List < MobileElement > remindersCreated = setReminderObj.setReminder(reminderTitle);




        assertTrue(remindersCreated.size() != 0);
        for (int i = 0; i < remindersCreated.size(); i++) {

            assertThat(remindersCreated.get(i).getAttribute("contentDescription"), containsString(reminderTitle));
        }
    }
    //@Ignore
    @Test
    public void test7_reminderDisplayingMonth() throws NoSuchElementException {

        ReminderDisplayingMonth reminderMonthObj = new ReminderDisplayingMonth();

        List < MobileElement > remindersMonth = reminderMonthObj.reminderDisplay(reminderTitle);
        assertTrue("The month list does not  contain reminders", remindersMonth.size() != 0);

        for (int i = 0; i < remindersMonth.size(); i++) {

            assertThat(remindersMonth.get(i).getAttribute("contentDescription"), containsString(reminderTitle));

        }
    }

    //@Ignore
    @Test
    public void test8_turnOffReminders() throws NoSuchElementException {

        TurnOffReminders turnOffRemObj = new TurnOffReminders();

        Boolean turnOffRem = turnOffRemObj.turnOffRem();

        assertFalse("The month list contains reminders", turnOffRem);


    }

    @Ignore

    @Test
    public void cleanUp() {
        CleanUp cleanUpObj = new CleanUp();
        //cleanUpObj.goalCleanUpGoal ();

        // cleanUpObj.cleanUpEvent();

        cleanUpObj.cleanUpRemonders();

    }
}