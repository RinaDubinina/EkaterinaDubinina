package hw3.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class RadioRow extends  AbstractPageComposite {
    @FindBy(className = "label-radio")
    private List<WebElement> radioButtonElemetnts;

    public RadioRow(WebDriver driver) {
        super(driver);
    }

    public void setRadio(String checkboxName) {
        wait.until(ExpectedConditions.visibilityOfAllElements(radioButtonElemetnts));
        for (WebElement checkBoxElement : radioButtonElemetnts) {
            if(!checkBoxElement.isSelected() & checkBoxElement.getText().equals(checkboxName))
                checkBoxElement.click();
        }
    }
}
