package hw3.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MainContent extends AbstractPageComposite {

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkBoxElements;

    @FindBy(className = "label-radio")
    private List<WebElement> radioButtonElements;

    @FindBy(css = ".colors select")
    private WebElement colorDropdownElement;

    public MainContent(WebDriver driver) {
        super(driver);
    }
    public void setMainContent(String contentName,List<WebElement> contentType) {
        wait.until(ExpectedConditions.visibilityOfAllElements(contentType));
        for (WebElement content : contentType) {
            if(!content.isSelected() & content.getText().equals(contentName))
                content.click();
        }

    }
    public void setColorDropDown(String color) {
        WebElement dropdownColors = wait.until(ExpectedConditions.elementToBeClickable(colorDropdownElement));
        new Select(dropdownColors).selectByVisibleText(color);
    }
    public List<WebElement> getCheckBoxElements() {
        return checkBoxElements;
    }

    public List<WebElement> getRadioButtonElements() {
        return radioButtonElements;
    }

}
