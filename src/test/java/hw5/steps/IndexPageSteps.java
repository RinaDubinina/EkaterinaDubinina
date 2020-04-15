package hw5.steps;

import hw5.pages.IndexPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class IndexPageSteps {

    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected IndexPage indexPage;
    protected final static String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    public IndexPageSteps(WebDriver driver) {
        this.driver = driver;
        softAssert = new SoftAssert();
        indexPage = new IndexPage(driver);
    }

    @Step("I open test site")
    public void open(String url) {
        driver.get(url);
    }

    @Step("Page title should have title '{0}'")
    public void shouldReturnPageTitle(String expectedTitle) {
        softAssert.assertEquals(indexPage.getBrowserTitle(), expectedTitle);
    }

    @Step("I login as '{0}'")
    public void login(String name, String password) {
        indexPage.login(name, password);
    }

    @Step("Username should be '{0}'")
    public void shouldReturnUsername(String expectedName) {
        softAssert.assertTrue(indexPage.getUserName().equals(expectedName),
                "Name is not equals to expected result");
    }

    @Step("The header section contains '{0}' items")
    public void shouldReturnItemsHeaderAmount(int expectedAmount) {
        softAssert.assertEquals(indexPage.getHeaderMenuElementsCount(),
                expectedAmount, "Wrong number of items in header");
    }

    @Step("The items should have proper texts")
    public void shouldHeaderMenuElementsText(List<String> expectedText) {
        softAssert.assertEquals(indexPage.getHeaderMenuElementsText(),
                expectedText, "Menu buttons have not proper texts");
    }

    @Step("The Index Page should have '{0}' icons")
    public void shouldReturnIconsAmount(int expectedAmount) {
        softAssert.assertEquals(indexPage.getBenefitIconCount(),
                expectedAmount, "The amount of images is incorrect");
    }

    @Step("All icons should have text")
    public void shouldReturnIconTextElementCount(int expectedAmount) {
        softAssert.assertEquals(indexPage.getBenefitTextElementCount(), expectedAmount);
    }

    @Step("All icons should have proper text")
    public void shouldReturnIconText(List<String> expectedText) {
        softAssert.assertEquals(indexPage.getBenefitTexts(), expectedText, "Texts under icons are incorrect");
    }

    @Step("The iframe with “Frame Button” should be displayed")
    public void shouldReturnFrame() {
        softAssert.assertTrue(indexPage.isFrameDisplayed(), "The iframe is not exists");
    }

    @Step("I switch to the frame")
    public void switchToFrame() {
        indexPage.switchToFrame();
    }

    @Step("Frame button should be displayed")
    public void shouldReturnFrameButton() {
        softAssert.assertTrue(indexPage.isFrameButtonDisplayed(), "The “Frame Button” is not exists");
    }

    @Step("I switch to Home page back")
    public void switchToOriginalWindow() {
        indexPage.switchToOriginalWindow();
    }

    @Step("The Left Section contains '{0}' items")
    public void shouldReturnLeftSectionItemsAmount(int expectedAmount) {
        softAssert.assertEquals(indexPage.getSideBarMenuCountElements(), expectedAmount);
    }

    @Step("Items should have proper text")
    public void shouldReturnLeftSectionItemsTests(List<String> expectedText) {
        softAssert.assertEquals(indexPage.getSideBarMenu(), expectedText, "Left section menu items have incorrect proper text");

    }

    @Step("I open Different Elements Page through the header menu Service")
    public void shouldOpenDifferentElementPage() {
        indexPage.getDifferentElementPage();
    }

    public void softAssertAll() {
        softAssert.assertAll();
    }

}
