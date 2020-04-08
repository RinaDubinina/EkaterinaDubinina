package hw3.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckboxRow extends AbstractPageComposite {
    @FindBy(className = "label-checkbox")
    private List<WebElement> checkBoxElements;

    public CheckboxRow(WebDriver driver) {
        super(driver);
    }

    public void setCheckBox(String checkboxName) {
        wait.until(ExpectedConditions.visibilityOfAllElements(checkBoxElements));
        for (WebElement checkBoxElement : checkBoxElements) {
            if(!checkBoxElement.isSelected() & checkBoxElement.getText().equals(checkboxName))
                checkBoxElement.click();
        }
    }
}
