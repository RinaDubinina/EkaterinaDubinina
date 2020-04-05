package hw2.ex1;

import hw2.LoginBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;


public class LoginSeleniumTestWithSoftAssert extends LoginBase {

    @Test
    public void loginTestWithSA() {
        SoftAssert softAssert = new SoftAssert();
        //1. Open test site by URL
        openSite();

        //2. Assert Browser title
        softAssert.assertEquals(getDriver().getTitle(), "Home Page", "Browser title has incorrect name");

        //3. Perform login
        loginUser("Roman", "Jdi1234");

        //4. Assert Username is loggined
        softAssert.assertTrue(getDriver().findElement(
                By.id("user-name")).getText().equals("ROMAN IOVLEV"), "Name is not equals to expected result");

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertEquals(getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".m-l8 > li")))
                .size(), 4, "Wrong number of items in header");
        String expectedText = "HOME\n" + "CONTACT FORM\n" + "SERVICE\n" + "METALS & COLORS";
        String actualText = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.className("m-l8"))).getText();
        softAssert.assertEquals(actualText, expectedText, "Menu buttons have not proper texts");

        //6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("benefit-icon"))).size(),
                4, "The amount of images is incorrect");

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitsText = getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("benefit-txt")));
        softAssert.assertEquals(benefitsText.size(), 4);
        String expectedBenefitTexts = "To include good practices\n" + "and ideas from successful\n" + "EPAM project\n" +
                "To be flexible and\n" + "customizable\n" +
                "To be multiplatform\n" +
                "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…";
        String actualBenefitTexts = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.className("benefits"))).getText();
        softAssert.assertEquals(actualBenefitTexts, expectedBenefitTexts, "Texts under icons are incorrect");

        //8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(getWait().until(ExpectedConditions.visibilityOfElementLocated(
                By.id("frame"))).isDisplayed(), "The iframe is not exists");

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        getDriver().switchTo().frame("frame");
        softAssert.assertTrue(getWait().until(ExpectedConditions.visibilityOfElementLocated(
                By.id("button-frame"))).isDisplayed(), "The “Frame Button” is not exists");

        //10. Switch to original window back
        getDriver().switchTo().defaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftSection = getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".sidebar-menu > li")));
        softAssert.assertEquals(leftSection.size(), 5);
        String expectedLeftSectionTexts = "Home\n" + "Contact form\n" + "Service\n" + "Metals & Colors\n" + "Elements packs";
        String actualLeftSectionTexts = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sidebar-menu")))
                .getText();
        softAssert.assertEquals(actualLeftSectionTexts, expectedLeftSectionTexts, "Left section menu items have incorrect proper text");
        softAssert.assertAll();

        //12. Close Browser
        // by tearDown() in LoginBase.class
    }
}