package hw4.pages;

import hw4.composite.HeaderMenu;
import hw4.utill.Summary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected HeaderMenu headerMenu;
    protected Summary summary;
    protected WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 7);
        PageFactory.initElements(driver, this);
    }

}
