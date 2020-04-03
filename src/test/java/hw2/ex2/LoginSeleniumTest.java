package hw2.ex2;

import hw2.LoginBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginSeleniumTest extends LoginBase {
    @Test
    public void loginTest() {
        //1. Open test site by URL
        openSite();

        //2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page", "Browser title has incorrect name");

        //3. Perform login
        loginUser("Roman", "Jdi1234");

        //4. Assert Username is loggined
        assertTrue(driver.findElement(By.id("user-name")).getText().equals("ROMAN IOVLEV"),"Name is not equals to expected result");

        //5. Open through the header menu Service -> Different Elements Page
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Service')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Different elements')]"))).click();
        assertEquals(driver.getTitle(), "Different Elements", "Wrong title of page");

        //6.Select checkboxes
        WebElement checkboxWater = driver.findElement(By.xpath("//label[normalize-space() = 'Water']"));
        WebElement checkboxWind = driver.findElement(By.xpath("//label[normalize-space() = 'Wind']"));
        wait.until(ExpectedConditions.elementToBeClickable(checkboxWater)).click();
        wait.until(ExpectedConditions.elementToBeClickable(checkboxWind)).click();

        //7. Select radio
        WebElement radioSelen = driver.findElement(By.xpath("//label[normalize-space() = 'Selen']"));
        wait.until(ExpectedConditions.elementToBeClickable(radioSelen)).click();

        //8 Select in dropdown
        WebElement dropdownColors = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".colors select")));
        new Select(dropdownColors).selectByVisibleText("Yellow");

        //9. Assert that
        //•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //•	for radio button there is a log row and value is corresponded to the status of radio button
        //•	for dropdown there is a log row and value is corresponded to the selected value.
        assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Water: condition changed to true')]")))
                .isDisplayed(), "checkbox name and its status are not corresponding to selected");
        assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Wind: condition changed to true')]")))
                .isDisplayed(), "checkbox name and its status are not corresponding to selected");
        assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'metal: value changed to  Selen')]")))
                .isDisplayed(),"radio button name and it status is not corresponding to selected");
        assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Colors: value changed to Yellow')]")))
                .isDisplayed(), "dropdown name and selected value is not corresponding to selected");

        //10. Close Browser
        //by tearDown() in LoginBase.class

    }
/*
    //6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("benefit-icon"))).

    size(),
                4,"The amount of images is incorrect");

    //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
    List<WebElement> benefitsText = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("benefit-txt")));
        softAssert.assertEquals(benefitsText.size(),4);
    List<String> expectedBenefitTexts = Arrays.asList(
            "To include good practices\n" + "and ideas from successful\n" + "EPAM project\n",
            "To be flexible and\n" + "customizable\n",
            "To be multiplatform\n",
            "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");
    List<String> actualBenefitTexts = benefitsText.stream().map(WebElement::getText).collect(Collectors.toList());
        softAssert.assertEquals(actualBenefitTexts,expectedBenefitTexts,"Texts under icons are incorrect");

    //8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frame"))).

    isDisplayed());

    //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().

    frame("frame");
        softAssert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-frame"))).

    isSelected());

    //10. Switch to original window back
        driver.switchTo().

    defaultContent();

    //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
    List<WebElement> leftSection = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='mCSB_1_container']//div[@id='mCSB_1_container']")));
        softAssert.assertEquals(leftSection.size(),5);
    List<String> expectedLeftSectionTexts = leftSection.stream().map(WebElement::getText).collect(Collectors.toList());
    List<String> actaulLeftSectionTexts = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        softAssert.assertEquals(actaulLeftSectionTexts,expectedLeftSectionTexts);
}*/
}