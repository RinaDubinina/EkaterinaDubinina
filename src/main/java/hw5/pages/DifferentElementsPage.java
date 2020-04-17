package hw5.pages;

import hw5.composite.LogField;
import hw5.composite.MainContent;
import org.openqa.selenium.WebDriver;


public class DifferentElementsPage extends AbstractPage {
    private LogField logField;
    private MainContent mainContent;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.logField = new LogField(driver);
        this.mainContent = new MainContent(driver);
    }

    public String getBrowserTitle() {
        return driver.getTitle();
    }

    public void setCheckBox(String checkboxName) {
        mainContent.setMainContent(checkboxName, mainContent.getCheckBoxElements());
    }

    public void setRadio(String radioName) {
        mainContent.setMainContent(radioName, mainContent.getRadioButtonElements());
    }

    public void setColorsDropdownMenu(String colorsDropdownValue) {
        mainContent.setColorDropDown(colorsDropdownValue);
    }

    public boolean isCheckboxLogDisplayed(String checkboxName) {
        return logField.isLogElementDisplayed(checkboxName);
    }

    public boolean isRadioLogDisplayed(String radioName) {
        return logField.isLogElementDisplayed(radioName);
    }

    public boolean isColorLogDisplayed(String colorValue) {
        return logField.isLogElementDisplayed(colorValue);
    }
}
