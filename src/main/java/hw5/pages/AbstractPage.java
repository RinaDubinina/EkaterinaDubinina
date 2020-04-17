package hw5.pages;

import hw5.composite.HeaderMenu;
import hw5.composite.SideBarMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected SideBarMenu sideBarMenu;

    protected HeaderMenu headerMenu;

    protected WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        //this.wait = new WebDriverWait(driver, 7);
        PageFactory.initElements(driver, this);
    }
}
