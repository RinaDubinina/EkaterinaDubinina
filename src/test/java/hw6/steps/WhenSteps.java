package hw6.steps;

import hw3.pages.DifferentElementsPage;
import hw3.pages.IndexPage;
import hw3.pages.UserTablePage;
import hw6.webDriverSingleton.WebDriverSingleton;
import io.cucumber.java.en.When;

public class WhenSteps {
    private DifferentElementsPage differentElementsPage;
    private IndexPage indexPage;
    private UserTablePage userTablePage;

    @When("I select checkboxes {string} and {string} on Different Elements Page")
    public void iSelectCheckboxes(String firstCheckbox, String secondCheckbox) {
        differentElementsPage = new DifferentElementsPage(WebDriverSingleton.INSTANCE.getDriver());
        differentElementsPage.setCheckBox(firstCheckbox);
        differentElementsPage.setCheckBox(secondCheckbox);
    }

    @When("I select {string} radio on Different Elements Page")
    public void iSelectRadio(String radio) {
        differentElementsPage.setRadio(radio);
    }

    @When("I select {string} dropdown on Different Elements Page")
    public void iSelectDropdown(String color) {
        differentElementsPage.setColorsDropdownMenu(color);
    }


    @When("I click on Service button in Header")
    public void iClickOnServiceButton() {
        indexPage = new IndexPage(WebDriverSingleton.INSTANCE.getDriver());
        indexPage.clickServiceDropdownMenu();
    }

    @When("I click on User Table button in Service dropdown")
    public void iClickOnUserTableButton() {
        indexPage.getUserTablePage();
    }

    @When("I select 'vip' checkbox for {string}")
    public void iSelectVipCheckboxForUser(String nameUser) {
        userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
        userTablePage.clickCheckboxForUser(nameUser);
    }


}
