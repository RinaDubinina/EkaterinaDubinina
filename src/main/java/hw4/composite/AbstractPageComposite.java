package hw4.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPageComposite {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected AbstractPageComposite(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,7);
        PageFactory.initElements(driver,this);
    }
}
