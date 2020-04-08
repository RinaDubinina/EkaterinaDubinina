package hw3.pages;

import hw3.composite.*;
import org.openqa.selenium.WebDriver;


public class DifferentElementsPage extends AbstractPage {
    private LogField logField;
    private CheckboxRow checkboxRow;
    private RadioRow radioRow;
    private ColorsDropdownMenu colorsDropdownMenu;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.logField = new LogField(driver);
        this.checkboxRow = new CheckboxRow(driver);
        this.radioRow = new RadioRow(driver);
        this.colorsDropdownMenu = new ColorsDropdownMenu(driver);
    }

    public String getBrowserTitle() {
        return driver.getTitle();
    }

    public void setCheckBox(String checkboxName) {
        checkboxRow.setCheckBox(checkboxName);
    }

    public void setRadio(String radioName) {
        radioRow.setRadio(radioName);
    }

    public void setColorsDropdownMenu(String colorsDropdownValue) {
        colorsDropdownMenu.setColorDropDown(colorsDropdownValue);
    }


    public String isWaterCheckboxLogDisplayed() {
        return logField.isWaterCheckboxDisplayed();
    }
    public String isWindCheckboxLogDisplayed() {
        return logField.isWindCheckboxDisplayed();
    }

    public String isSelenRadioLogDisplayed()
    {
        return logField.isSelenRadioDisplayed();
    }

    public String isYellowColorLogDisplayed() {
        return logField.isYellowColorDisplayed();
    }
}
