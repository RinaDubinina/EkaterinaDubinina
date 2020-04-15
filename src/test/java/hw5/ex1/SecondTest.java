package hw5.ex1;

import hw5.LoginBase;
import hw3.utill.PropertyReader;
import hw5.steps.DifferentElementsPageSteps;
import hw5.steps.IndexPageSteps;
import hw5.base.AllureScreenshotListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners({AllureScreenshotListener.class})
public class SecondTest extends LoginBase {

    @Feature("Different elements page functionality")
    @Story("Entering different elements page through index page header menu and testing functionality of " +
            "radio, checkboxes and dropdown")
    @Test
    public void loginTest() {
        IndexPageSteps indexPageSteps = new IndexPageSteps(driver);
        DifferentElementsPageSteps differentElementsPageSteps = new DifferentElementsPageSteps(driver);

        //1. Open test site by URL
        indexPageSteps.open(PropertyReader.read("url"));

        //2. Assert Browser title
        indexPageSteps.shouldReturnPageTitle("Home Page");

        //3. Perform login
        indexPageSteps.login(PropertyReader.read("user"), PropertyReader.read("password"));

        //4. Assert Username is loggined
        indexPageSteps.shouldReturnUsername("ROMAN IOVLEV");

        //5. Open through the header menu Service -> Different Elements Page
        indexPageSteps.shouldOpenDifferentElementPage();
        differentElementsPageSteps.shouldReturnBrowserTitle("Different Elements");

        //6.Select checkboxes
        differentElementsPageSteps.selectCheckBox("Water");
        differentElementsPageSteps.selectCheckBox("Wind");

        //7. Select radio
        differentElementsPageSteps.selectRadio("Selen");

        //8 Select in dropdown
        differentElementsPageSteps.selectDropdown("Yellow");

        //9. Assert that
        //•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //•	for radio button there is a log row and value is corresponded to the status of radio button
        //•	for dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPageSteps.shouldReturnCheckboxLog("Water");
        differentElementsPageSteps.shouldReturnCheckboxLog("Wind");
        differentElementsPageSteps.shouldReturnRadioLog("Selen");
        differentElementsPageSteps.shouldReturnDropdownLog("Yellow");

        //10. Close Browser
        //by tearDown() in LoginBase.class
    }

}