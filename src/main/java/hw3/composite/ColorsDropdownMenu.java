package hw3.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ColorsDropdownMenu extends AbstractPageComposite {

    @FindBy(css = ".colors select")
    private WebElement colorDropdownElement;

    public ColorsDropdownMenu(WebDriver driver) {
        super(driver);
    }

    public void setColorDropDown(String color) {
        WebElement dropdownColors = wait.until(ExpectedConditions.elementToBeClickable(colorDropdownElement));
        new Select(dropdownColors).selectByVisibleText(color);
    }
}
