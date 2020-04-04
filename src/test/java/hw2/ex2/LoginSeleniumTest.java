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
        assertEquals(getDriver().getTitle(), "Home Page", "Browser title has incorrect name");

        //3. Perform login
        loginUser("Roman", "Jdi1234");

        //4. Assert Username is loggined
        assertTrue(getDriver().findElement(By.id("user-name")).getText().equals("ROMAN IOVLEV"),"Name is not equals to expected result");

        //5. Open through the header menu Service -> Different Elements Page
        getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("Service"))).click();
        getWait().until(ExpectedConditions.elementToBeClickable(By.linkText("Different elements"))).click();
        assertEquals(getDriver().getTitle(), "Different Elements", "Wrong title of page");

        //6.Select checkboxes
        WebElement checkboxWater = getDriver().findElement(By.xpath("//label[normalize-space() = 'Water']"));
        WebElement checkboxWind = getDriver().findElement(By.xpath("//label[normalize-space() = 'Wind']"));
        getWait().until(ExpectedConditions.elementToBeClickable(checkboxWater)).click();
        getWait().until(ExpectedConditions.elementToBeClickable(checkboxWind)).click();

        //7. Select radio
        WebElement radioSelen = getDriver().findElement(By.xpath("//label[normalize-space() = 'Selen']"));
        getWait().until(ExpectedConditions.elementToBeClickable(radioSelen)).click();

        //8 Select in dropdown
        WebElement dropdownColors = getWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector(".colors select")));
        new Select(dropdownColors).selectByVisibleText("Yellow");

        //9. Assert that
        //•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //•	for radio button there is a log row and value is corresponded to the status of radio button
        //•	for dropdown there is a log row and value is corresponded to the selected value.
        String logWater = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Water')]"))).getText().toString().substring(9);
        String logWind = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Wind')]"))).getText().toString().substring(9);
        String logSelen = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Selen')]"))).getText().toString().substring(9);
        String logYellow = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Yellow')]"))).getText().toString().substring(9);

        assertEquals(logWater,"Water: condition changed to true","checkbox name and its status are not corresponding to selected");
        assertEquals(logWind, "Wind: condition changed to true","checkbox name and its status are not corresponding to selected");
        assertEquals(logSelen,"metal: value changed to Selen","radio button name and it status is not corresponding to selected");
        assertEquals(logYellow, "Colors: value changed to Yellow","dropdown name and selected value is not corresponding to selected");

        //10. Close Browser
        //by tearDown() in LoginBase.class

    }

}