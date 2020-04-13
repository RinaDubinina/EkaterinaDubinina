package hw4.pages;

import hw4.composite.HeaderMenu;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class IndexPage extends AbstractPage {

    public IndexPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.headerMenu = new HeaderMenu(driver);

    }

    public String getBrowserTitle() {
        return driver.getTitle();
    }

    public void login(String name, String password) {
        headerMenu.loginUser(name, password);
    }

    public String getUserName() {
        return headerMenu.getUserName();
    }

    public int getHeaderMenuElementsCount() {
        return headerMenu.getHeaderMenuElementsCount();
    }

    public List<String> getHeaderMenuElementsText() {
        return headerMenu.getHeaderMenuElementsText();
    }

    public void getTableWithPagesElementPage() {
        headerMenu.getTableWithPagesElementPage();
    }

    public void getMetalsColorsPage() {
        headerMenu.getMetalsColorsPage();
    }

}

