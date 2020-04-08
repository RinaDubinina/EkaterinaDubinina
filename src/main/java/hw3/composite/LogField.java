package hw3.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LogField extends AbstractPageComposite {

    @FindBy(xpath = "//li[contains(text(),'Water')]")
    private WebElement waterLogs;
    @FindBy(xpath = "//li[contains(text(),'Wind')]")
    private WebElement windLogs;
    @FindBy(xpath = "//li[contains(text(),'Selen')]")
    private WebElement selenLogs;
    @FindBy(xpath = "//li[contains(text(),'Yellow')]")
    private WebElement yellowLogs;

    public LogField(WebDriver driver) {
        super(driver);
    }

    public String isWaterCheckboxDisplayed() {
        return waterLogs.getText().toString().substring(9);
    }

    public String isWindCheckboxDisplayed() {
        return windLogs.getText().toString().substring(9);
    }

    public String isSelenRadioDisplayed() {
        return selenLogs.getText().toString().substring(9);
    }

    public String isYellowColorDisplayed() {
        return yellowLogs.getText().toString().substring(9);
    }
}



