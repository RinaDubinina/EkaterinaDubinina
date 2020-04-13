package hw4.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TableWithPages extends AbstractPageComposite {

    @FindBy(tagName = "select")
    private WebElement tableLengthValue;

    @FindBy(css = ".dataTables_filter input")
    private WebElement searchField;

    @FindBy(xpath = "//tbody//tr")
    List<WebElement> entriesRow;


    public TableWithPages(WebDriver driver) {
        super(driver);
    }

    public String getTableLengthDefaultValue() {
        WebElement dropdownTableValues = wait.until(ExpectedConditions.visibilityOf(tableLengthValue));
        return new Select(dropdownTableValues).getFirstSelectedOption().getText();
    }

    public void setTableLengthValue(String value) {
        WebElement dropdownTableValues = wait.until(ExpectedConditions.elementToBeClickable(tableLengthValue));
        new Select(dropdownTableValues).selectByVisibleText(value);
    }

    public int getEntriesAmount() {
        return entriesRow.size();
    }

    public boolean isEntriesContainSearchValue(String searchValue) {
        boolean isContain = false;
        for (WebElement entry : entriesRow) {
            if (entry.getText().toLowerCase().contains(searchValue)) {
                isContain = true;
            }
        }
        return isContain;
    }

    public void setSearchFieldText(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(searchField)).sendKeys(text);
    }

}
