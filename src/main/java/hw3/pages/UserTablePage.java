package hw3.pages;

import hw3.composite.LogField;
import hw6.composite.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class UserTablePage extends AbstractPage {
    private LogField logField;

    @FindBy(xpath = "//tbody/tr/td[1]")
    private List<WebElement> indexUser;

    @FindBy(tagName = "select")
    private List<WebElement> numberTypeDropdowns;

    @FindBy(xpath = "//td/a")
    private List<WebElement> userNames;

    @FindBy(css = "#user-table span")
    private List<WebElement> descriptionTexts;

    @FindBy(css = ".user-descr label")
    private List<WebElement> checkboxes;

    @FindBy(css = "#user-table tr")
    private List<WebElement> tableUserRow;

    public UserTablePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.logField = new LogField(driver);
    }

    public List<WebElement> getIndexUser() {
        return indexUser;
    }

    public List<String> getUserTable() {
        int rows = tableUserRow.size();
        Users user;
        List<String> usersList = new ArrayList<>();
        for (int i = 0; i < rows - 1; i++) {
            String number = indexUser.get(i).getText();
            String name = userNames.get(i).getText();
            String disc = descriptionTexts.get(i).getText();
            user = new Users(number, name, disc);
            usersList.add(user.toString());
        }
        return usersList;
    }

    public String getUserChecboxValues(String name) {
        int rows = tableUserRow.size();
        String typeDropdown = null;
        for (int i = 0; i < rows - 1; i++) {
            if (userNames.get(i).getText().equals(name)) {
                typeDropdown = numberTypeDropdowns.get(i).getText().replace(" ", "").replace("\n", "");
            }
        }
        return typeDropdown;
    }

    public String getUserTablePageTitle() {
        return driver.getTitle();
    }

    public int getNumberTypeDropdownsAmount() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(numberTypeDropdowns)).size();
    }

    public int getUserNamesAmount() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(userNames)).size();
    }

    public int getDescriptionTextsAmount() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(descriptionTexts)).size();
    }

    public int getcheckboxesAmount() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(checkboxes)).size();
    }

    public void clickCheckboxForUser(String userName) {
        for (WebElement row : tableUserRow) {
            if (row.getText().contains(userName)) {
                row.findElement(By.tagName("label")).click();
            }
        }
    }

    public boolean getLog(int index, String text) {

        return logField.isLogTextDisplayed(index, text);
    }


}
