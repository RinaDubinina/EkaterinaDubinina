package hw3.pages;

import hw3.composite.Benefits;
import hw3.composite.FramePage;
import hw3.composite.HeaderMenu;
import hw3.composite.SideBarMenu;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class IndexPage extends AbstractPage {
    private Benefits benefits;
    private FramePage framePage;

    public IndexPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.headerMenu = new HeaderMenu(driver);
        this.benefits = new Benefits(driver);
        this.framePage = new FramePage(driver);
        this.sideBarMenu = new SideBarMenu(driver);
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

    public void getDifferentElementPage() {
        headerMenu.getDifferentElementPage();
    }

    public int getBenefitIconCount() {
        return benefits.getBenefitIconCount();
    }

    public int getBenefitTextElementCount() {
        return benefits.getBenefitTextElementCount();
    }

    public List<String> getBenefitTexts() {
        return benefits.getBenefitTexts();
    }

    public boolean isFrameDisplayed() {
        return framePage.isFrameDisplayed();
    }

    public void switchToFrame() {
        framePage.switchToFrame();
    }

    public boolean isFrameButtonDisplayed() {
        return framePage.isFrameButtonDisplayed();
    }

    public void switchToOriginalWindow() {
        framePage.switchToOriginalWindow();
    }

    public int getSideBarMenuCountElements() {
        return sideBarMenu.getSideBarMenuCountElements();
    }

    public List<String> getSideBarMenu() {
        return sideBarMenu.getSideBarMenuText();
    }
}

