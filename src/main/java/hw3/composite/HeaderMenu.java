package hw3.composite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class HeaderMenu extends AbstractPageComposite {
    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(css = ".m-l8 > li")
    private List<WebElement> headerMenuElements;

    @FindBy(css = ".m-l8 .dropdown")
    private WebElement serviceDropdownMenu;


    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public void loginUser(String name, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(userIcon)).click();
        wait.until(ExpectedConditions.attributeToBe(By.className("uui-profile-menu"), "class",
                "dropdown uui-profile-menu open"));
        wait.until(ExpectedConditions.elementToBeClickable(userNameField)).sendKeys(name);
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public String getUserName() {
        return userName.getText();
    }

    public int getHeaderMenuElementsCount() {
        return headerMenuElements.size();
    }

    public List<String> getHeaderMenuElementsText() {
        return headerMenuElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void getDifferentElementPage() {
        wait.until(ExpectedConditions.visibilityOf(serviceDropdownMenu)).click();
        wait.until(ExpectedConditions.attributeToBe(serviceDropdownMenu, "class", "dropdown open"));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("DIFFERENT ELEMENTS"))).click();
    }

}

