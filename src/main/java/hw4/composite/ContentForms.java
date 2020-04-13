package hw4.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContentForms extends AbstractPageComposite {
    @FindBy(css = ".radio")
    private List<WebElement> summaryRadio;

    @FindBy(id = "calculate-button")
    private WebElement calculateButton;

    @FindBy(css = ".vertical-group .checkbox")
    private List<WebElement> elementCheckbox;

    @FindBy(css = ".colors select")
    private List<WebElement> colorDropdown;

    @FindBy(css = "..metal select")
    private List<WebElement> metalDropdown;

    @FindBy(css = ".dropdown-menu .checkbox")
    private List<WebElement> vegetablesCheckbox;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    protected ContentForms(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSummaryRadio() {
        return summaryRadio;
    }

    public WebElement getCalculateButton() {
        return calculateButton;
    }

    public List<WebElement> getElementCheckbox() {
        return elementCheckbox;
    }

    public List<WebElement> getColorDropdown() {
        return colorDropdown;
    }

    public List<WebElement> getMetalDropdown() {
        return metalDropdown;
    }

    public List<WebElement> getVegetablesCheckbox() {
        return vegetablesCheckbox;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }


}
