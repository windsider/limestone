import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CleanUp extends PageObject{

    @AndroidFindBy(xpath = "//*[@content-desc='Show Calendar List and Settings drawer']")
    private MobileElement optionList;

    @AndroidFindBy(xpath = "//*[@text='Search']")
    private MobileElement searchBt;

    @AndroidFindBy(id = "com.google.android.calendar:id/search_edit_text")
    private MobileElement searchField;

    @AndroidFindBy(xpath = "//*[@content-desc='Back']")
    private MobileElement backBt;

     WebDriverWait wait = new WebDriverWait (driver, 30);
     String moreOptionsXpath ="//*[@content-desc='More options']";
     String deleteButXpath = "//*[@text='Delete']";

   // public CleanUp ( AppiumDriver driver ) {
       // super (driver);}

    public static void main (String [] args) {
        //CleanUp cleanUpObj = new CleanUp ();
       // cleanUpObj.goalCleanUp ();

    }

    public  void goalCleanUpGoal () {
       // MobileElement calendarList = (MobileElement) driver.findElementByXPath ("//*[@content-desc='Show Calendar List and Settings drawer']");
        //calendarList.click ();



        //optionList.click ();

        //MobileElement month = (MobileElement) driver.findElementByXPath ("//*[@text='Month']");
      //  month.click ();

        MobileElement monthGoals = (MobileElement) driver.findElementByXPath ("//android.view.View[contains(@content-desc,'Goal')]");
        monthGoals.click ();

       // searchBt.click();

       // wait.until(ExpectedConditions.presenceOfElementLocated (By.id ("com.google.android.calendar:id/search_edit_text")));

       // searchField.sendKeys ("Run");

      //  ( (AndroidDriver) driver).pressKeyCode(66);






        List <MobileElement> createdGoals =  driver.findElementsByXPath ("//android.view.View[contains(@content-desc,'Goal')]");

for (int i = 0; i < new ArrayList<MobileElement> (createdGoals).size(); i++) {


    List <MobileElement> newList =  new ArrayList<MobileElement> (createdGoals);




    wait.until (ExpectedConditions.presenceOfElementLocated (By.xpath ("//android.view.View[contains(@content-desc,'Goal')]")));
   MobileElement definedGoal = (MobileElement) driver.findElementByXPath ("//android.view.View[contains(@content-desc,'Goal')]");

   // System.out.println ("size " +  newList.size ());
    definedGoal.click ();

   // TouchAction action = new TouchAction (driver);
    //action.press (452,2226);
   // action.release ();
   // action.perform ();


    //System.out.println ("location " +  definedGoal.getLocation ());

   MobileElement moreOptions = (MobileElement) driver.findElementByXPath (moreOptionsXpath);
    moreOptions.click ();

    wait.until (ExpectedConditions.presenceOfElementLocated (By.xpath ("//*[@text='Delete']")));

   MobileElement deleteBut = (MobileElement) driver.findElementByXPath (deleteButXpath);
    deleteBut.click ();
    wait.until (ExpectedConditions.presenceOfElementLocated (By.xpath ("//*[@text='All following sessions (and stop scheduling)']")));

    MobileElement allSessions = (MobileElement) driver.findElementByXPath ("//*[@text='All following sessions (and stop scheduling)']");
    allSessions.click ();

    MobileElement oKBut = (MobileElement) driver.findElementByXPath ("//*[@text='OK']");
    oKBut.click ();

    //MobileElement backBut = (MobileElement) driver.findElementByXPath ("//*[@content-desc='Close']");
   // backBut.click ();



  //  searchField.sendKeys ("Run");


   // MobileElement clearBt = (MobileElement) driver.findElementByXPath ("//*[@content-desc='Clear search']");
    //clearBt.click ();

 //  searchField.sendKeys ("Run");

    //( (AndroidDriver) driver).pressKeyCode(66);





}

    }

    public void cleanUpEvent () {

      //  optionList.click ();

        //MobileElement month = (MobileElement) driver.findElementByXPath ("//*[@text='Month']");
       //month.click ();

        //wait.until (ExpectedConditions.presenceOfElementLocated (By.xpath ("//android.view.View[contains(@content-desc,'EventTest')]")));

      // MobileElement monthEvents = (MobileElement) driver.findElementByXPath ("//android.view.View[contains(@content-desc,'EventTest')]");
      // monthEvents.click ();

       List <MobileElement> eventsList =  driver.findElementsByXPath ("//android.view.View[contains(@content-desc,'EventTest')]");


        for (int i = 0; i < new ArrayList<> (eventsList).size();) {
            i++;
            //  wait.until (ExpectedConditions.invisibilityOfElementLocated (By.xpath ("//*[@content-desc='Calendar']")));
            MobileElement event  = (MobileElement) driver.findElementByXPath ("//android.view.View[contains(@content-desc,'EventTest')]");
            event.click();

            wait.until (ExpectedConditions.invisibilityOfElementLocated (By.xpath ("//*[@content-desc='Calendar']")));

            wait.until (ExpectedConditions.presenceOfElementLocated (By.xpath ("//*[@content-desc='More options']")));
            MobileElement moreOptions = (MobileElement) driver.findElementByXPath (moreOptionsXpath);
            moreOptions.click ();


            wait.until (ExpectedConditions.presenceOfElementLocated (By.xpath ("//*[@text='Delete']")));
            MobileElement deleteBut = (MobileElement) driver.findElementByXPath (deleteButXpath);
            deleteBut.click ();

            wait.until (ExpectedConditions.invisibilityOfElementLocated (By.xpath ("//*[@content-desc='Calendar']")));

            wait.until (ExpectedConditions.presenceOfElementLocated (By.xpath ("//*[@text='DELETE']")));
            MobileElement deleteConf = (MobileElement) driver.findElementByXPath ("//*[@text='DELETE']");
            deleteConf.click ();
        }
    }

    public void cleanUpRemonders () {
       // MobileElement Reminders = (MobileElement) driver.findElementByXPath ("(//android.view.View[contains(@content-desc,'"+ reminderTitle +"')])[1");
        MobileElement remindersList = (MobileElement) driver.findElementByXPath ("//android.view.View[contains(@content-desc,'reminders:')]");
        remindersList.click ();

        List <MobileElement> remnMonth = driver.findElementsByXPath ("//android.view.View[contains(@content-desc,'Reminder_Test')]");


        for (int i = 0; i < new ArrayList<> (remnMonth).size(); i++) {

            // System.out.println ("Location " +  remindersCreated.get(i).getLocation());


            TouchAction action = new TouchAction (driver);
            action.press (259,322);
            action.release ();
            action.perform ();

            wait.until (ExpectedConditions.presenceOfElementLocated (By.xpath (moreOptionsXpath)));

            MobileElement moreOptions = (MobileElement) driver.findElementByXPath (moreOptionsXpath);
            moreOptions.click ();
            MobileElement deleteBut = (MobileElement) driver.findElementByXPath (deleteButXpath);
            deleteBut.click ();
            MobileElement deleteConf = (MobileElement) driver.findElementByXPath ("//*[@text='OK']");
            deleteConf.click ();

        }

    }
}
