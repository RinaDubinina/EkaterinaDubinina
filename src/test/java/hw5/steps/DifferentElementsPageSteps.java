package hw5.steps;

import hw5.pages.DifferentElementsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPageSteps {

    private WebDriver driver;
    private DifferentElementsPage differentElementsPage;

    public DifferentElementsPageSteps(WebDriver driver) {
        this.driver = driver;
        this.differentElementsPage = new DifferentElementsPage(driver);
    }

    @Step("Page title should have title '{0}'")
    public void shouldReturnBrowserTitle(String expectedTitle) {
        assertEquals(differentElementsPage.getBrowserTitle(), expectedTitle, "Wrong title of page");
    }

    @Step("I select '{0}' checkbox")
    public void selectCheckBox(String checkboxName) {
        differentElementsPage.setCheckBox(checkboxName);
    }

    @Step("I select '{0}' radio button")
    public void selectRadio(String radioName) {
        differentElementsPage.setRadio(radioName);
    }

    @Step("I select dropdown '{0}'")
    public void selectDropdown(String dropdownValue) {
        differentElementsPage.setColorsDropdownMenu(dropdownValue);
    }

    @Step("The log section should have individual log row for '{0}' checkbox")
    public void shouldReturnCheckboxLog(String checkboxName) {
        assertTrue(differentElementsPage.isCheckboxLogDisplayed(checkboxName),
                "checkbox name and its status are not corresponding to selected");
    }

    @Step("The log section should have individual log row for '{0}' radio button")
    public void shouldReturnRadioLog(String radioName) {
        assertTrue(differentElementsPage.isRadioLogDisplayed(radioName),
                "radio button name and it status is not corresponding to selected");
    }

    @Step("The log section should have individual log row for '{0}' dropdown")
    public void shouldReturnDropdownLog(String dropdownName) {
        assertTrue(differentElementsPage.isColorLogDisplayed(dropdownName),
                "dropdown name and selected value is not corresponding to selected");
    }


}
