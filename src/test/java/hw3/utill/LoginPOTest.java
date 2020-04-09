package hw3.utill;

import hw3.LoginBasePO;
import hw3.pages.DifferentElementsPage;
import hw3.pages.IndexPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPOTest extends LoginBasePO {

    @Test
    public void loginTest() {
        IndexPage indexPage = new IndexPage(getDriver());
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(getDriver());
        //1. Open test site by URL
        openSite();

        //2. Assert Browser title
        assertEquals(indexPage.getBrowserTitle(), "Home Page", "Browser title has incorrect name");

        //3. Perform login
        indexPage.login(PropertyReader.read("user"),PropertyReader.read("password"));

        //4. Assert Username is loggined
        assertTrue(indexPage.getUserName().equals("ROMAN IOVLEV"), "Name is not equals to expected result");


        //5. Open through the header menu Service -> Different Elements Page
        indexPage.getDifferentElementPage();
        assertEquals(differentElementsPage.getBrowserTitle(), "Different Elements", "Wrong title of page");

        //6.Select checkboxes
        differentElementsPage.setCheckBox("Water");
        differentElementsPage.setCheckBox("Wind");

        //7. Select radio
        differentElementsPage.setRadio("Selen");

        //8 Select in dropdown
        differentElementsPage.setColorsDropdownMenu("Yellow");

        //9. Assert that
        //•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //•	for radio button there is a log row and value is corresponded to the status of radio button
        //•	for dropdown there is a log row and value is corresponded to the selected value.
        assertTrue(differentElementsPage.isCheckboxLogDisplayed("Water"),
                "checkbox name and its status are not corresponding to selected");
        assertTrue(differentElementsPage.isCheckboxLogDisplayed("Wind"),
                "checkbox name and its status are not corresponding to selected");
        assertTrue(differentElementsPage.isRadioLogDisplayed("Selen"),
                "radio button name and it status is not corresponding to selected");
        assertTrue(differentElementsPage.isColorLogDisplayed("Yellow"),
                "dropdown name and selected value is not corresponding to selected");

        //10. Close Browser
        //by tearDown() in LoginBase.class
    }

}