package hw2.ex1;

import hw2.LoginBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LoginSeleniumTestWithSoftAssert extends LoginBase {

    @Test
    public void loginTestWithSA() {
        SoftAssert softAssert = new SoftAssert();
        //1. Open test site by URL
        openSite();

        //2. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page","Browser title has incorrect name");

        //3. Perform login
        loginUser("Roman", "Jdi1234");

        //4. Assert Username is loggined
        softAssert.assertTrue(driver.findElement(
                By.id("user-name")).getText().equals("ROMAN IOVLEV"),"Name is not equals to expected result");

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertEquals(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".m-l8 > li")))
                .size(), 4, "Wrong number of items in header");
        List<WebElement> elements = driver.findElements(By.className(".m-18"));//className("uui-header dark-gray")));
        List<String> expectedText = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<String> actualText = elements.stream().map(WebElement::getText).collect(Collectors.toList());
        softAssert.assertEquals(actualText, expectedText, "Menu buttons have not proper texts");

        //6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("benefit-icon"))).size(),
                4, "The amount of images is incorrect");

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitsText = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("benefit-txt")));
        softAssert.assertEquals(benefitsText.size(), 4);
        List<String> expectedBenefitTexts = Arrays.asList(
                "To include good practices\n" + "and ideas from successful\n" + "EPAM project\n",
                "To be flexible and\n" + "customizable\n",
                "To be multiplatform\n",
                "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");
        List<String> actualBenefitTexts = benefitsText.stream().map(WebElement::getText).collect(Collectors.toList());
        softAssert.assertEquals(actualBenefitTexts, expectedBenefitTexts, "Texts under icons are incorrect");

        //8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("frame"))).isDisplayed(),"The iframe is not exists");

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        softAssert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("button-frame"))).isSelected(),"The “Frame Button” is not exists");

        //10. Switch to original window back
        driver.switchTo().defaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftSection = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='mCSB_1_container']//div[@id='mCSB_1_container']")));
        softAssert.assertEquals(leftSection.size(), 5);
        List<String> expectedLeftSectionTexts = leftSection.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> actaulLeftSectionTexts = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        softAssert.assertEquals(actaulLeftSectionTexts, expectedLeftSectionTexts,"Left section menu items have incorrect proper text");
    }
}