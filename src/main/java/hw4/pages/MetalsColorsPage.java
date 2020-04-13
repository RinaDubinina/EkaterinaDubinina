package hw4.pages;

import hw4.utill.Summary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MetalsColorsPage extends AbstractPage {

    @FindBy(css = ".radio")
    private List<WebElement> summaryRadio;

    @FindBy(id = "calculate-button")
    private WebElement calculateButton;

    @FindBy(css = ".vertical-group .checkbox")
    private List<WebElement> elementCheckbox;

    @FindBy(css = "button[title='Colors']")
    private WebElement colorDropdown;

    @FindBy(xpath = "//button[@title='Metals']//span[2]")
    private WebElement metalDropdown;

    @FindBy(xpath = "//ul[@class='dropdown-menu inner selectpicker']//li")
    private List<WebElement> colorAndMetalOptions;

    @FindBy(xpath = "//button[@class='btn btn-default dropdown-toggle']")
    private WebElement vegetablesDropdown;

    @FindBy(css = ".dropdown-menu .checkbox > label")
    private List<WebElement> vegetablesCheckbox;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    @FindBy(xpath = "//ul[@class='panel-body-list results']//li")
    private List<WebElement> results;

    public MetalsColorsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.summary = new Summary();
    }

    public List<WebElement> getSummaryRadio() {
        return summaryRadio;
    }

    public Summary getSummary() {
        return summary;
    }

    public WebElement getCalculateButton() {
        return calculateButton;
    }

    public List<WebElement> getElementCheckbox() {
        return elementCheckbox;
    }

    public WebElement getColorDropdown() {
        return colorDropdown;
    }

    public WebElement getMetalDropdown() {
        return metalDropdown;
    }

    public List<WebElement> getColorAndMetalOptions() {
        return colorAndMetalOptions;
    }

    public WebElement getVegetablesDropdown() {
        return vegetablesDropdown;
    }

    public List<WebElement> getVegetablesCheckbox() {
        return vegetablesCheckbox;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void selectElement(List<WebElement> webElements, List<String> elementName) {
        for (WebElement element : webElements) {
            if (elementName.contains(element.getText())) {
                element.click();
            }
        }
    }

    public void selectDefaultVegetablesValue() {
        for (WebElement veg : vegetablesCheckbox) {
            if (veg.getText().contains("Vegetables")) {
                veg.click();
            }
        }
    }

    public List<WebElement> getResults() {
        return results;
    }


}
