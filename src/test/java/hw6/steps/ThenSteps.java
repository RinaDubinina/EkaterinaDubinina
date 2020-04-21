package hw6.steps;

import hw3.pages.DifferentElementsPage;
import hw3.pages.UserTablePage;
import hw6.composite.Users;
import hw6.webDriverSingleton.WebDriverSingleton;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ThenSteps {
    private DifferentElementsPage differentElementsPage;
    private UserTablePage userTablePage;

    @Then("for each checkboxes there is an individual log row and value is corresponded to the status of checkbox")
    public void assertCheckboxLog(List<String> checkboxes) {
        differentElementsPage = new DifferentElementsPage(WebDriverSingleton.INSTANCE.getDriver());
        checkboxes = checkboxes.subList(1, checkboxes.size());
        checkboxes.forEach(e -> assertTrue(differentElementsPage.isCheckboxLogDisplayed(e)));
    }

    @Then("for {string} radio button there is a log row and value is corresponded to the status of radio button")
    public void assertRadioButtonLlog(String radio) {
        assertTrue(differentElementsPage.isRadioLogDisplayed(radio),
                "radio button name and it status is not corresponding to selected");
    }

    @Then("for {string} dropdown there is a log row and value is corresponded to the selected value")
    public void assertDropdownLog(String color) {
        assertTrue(differentElementsPage.isColorLogDisplayed(color),
                "dropdown name and selected value is not corresponding to selected");
    }


    @Then("User Table page should be opened")
    public void assertTitleUserTablePage() {
        userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
        assertEquals(userTablePage.getUserTablePageTitle(), "User Table");
        //  return userTablePage.getUserTablePageTitle();
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table Page")
    public void assertNumberTypeDropdownsAmount(int expectedAmountDropdowns) {
        assertEquals(userTablePage.getNumberTypeDropdownsAmount(), expectedAmountDropdowns);

    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void assertUsernamesAmount(int expectedAmountUsernames) {
        assertEquals(userTablePage.getUserNamesAmount(), expectedAmountUsernames);

    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void assertDescriptionTextsAmount(int expectedTextsAmount) {
        assertEquals(userTablePage.getDescriptionTextsAmount(), expectedTextsAmount);

    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void assertCheckboxesAmount(int expectedCheckboxesAmount) {
        assertEquals(userTablePage.getcheckboxesAmount(), expectedCheckboxesAmount);
    }

    @DataTableType
    public Users users(Map<String, String> user) {
        return new Users(user.get("Number"), user.get("User"), user.get("Description"));
    }

    @Then("User table should contain following values:")
    public void assertUserTableValues(List<Users> usersList) {
        List<String> users = userTablePage.getUserTable();
        for (int i = 0; i < usersList.size(); i++) {
            String actualText = users.get(i).toString().replace("\n", " ");
            String expectedText = usersList.get(i).toString();
            assertEquals(actualText, expectedText);
        }
    }

    @Then("droplist should contain values in column Type for user {string}")
    public void droplistShouldContainValuesForUser(String name, List<String> dropdownValuesList) {
        String actualValues = userTablePage.getUserChecboxValues(name);
        String expectedValues = "";
        for (int i = 1; i < dropdownValuesList.size(); i++) {
            expectedValues += dropdownValuesList.get(i);
        }
        assertEquals(actualValues, expectedValues);
    }


    @Then("{int} log row has {string} text in log section")

    public void assertLogRowHasText(int index, String text) {
        userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
        assertTrue(userTablePage.getLog(index, text));

    }


}
