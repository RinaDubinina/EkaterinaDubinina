package hw4.ex2;

import hw4.LoginBase;
import hw4.builder.TestData;
import hw4.pages.IndexPage;
import hw4.pages.MetalsColorsPage;
import hw4.utill.PropertyReader;
import hw4.utill.Summary;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ExTwoWithBuilderTest extends LoginBase {


    @Test(dataProviderClass = MetalsColorsDataProvider.class, dataProvider = "contentData")
    public void exerciseTwoTest(TestData testData) {
        IndexPage indexPage = new IndexPage(getDriver());
        MetalsColorsPage metalsColorsPage = new MetalsColorsPage(getDriver());

        //1. Open test site by URL
        openSite();

        //2. Perform login
        indexPage.login(PropertyReader.read("user"), PropertyReader.read("password"));

        //3. Click on the link on the Header section
        indexPage.getMetalsColorsPage();

        //4. Fill form on the page

        if (testData.getSummary() != null) {
            metalsColorsPage.selectElement(metalsColorsPage.getSummaryRadio(), testData.getSummary());
        }
        if (testData.getElements() != null) {
            metalsColorsPage.selectElement(metalsColorsPage.getElementCheckbox(), testData.getElements());
        }
        if (testData.getColors() != null) {
            metalsColorsPage.getColorDropdown().click();
            metalsColorsPage.selectElement(metalsColorsPage.getColorAndMetalOptions(), testData.getColors());
        }

        if (testData.getMetals() != null) {
            metalsColorsPage.getMetalDropdown().click();
            metalsColorsPage.selectElement(metalsColorsPage.getColorAndMetalOptions(), testData.getMetals());
        }
        if (testData.getVegetables() != null) {
            metalsColorsPage.getVegetablesDropdown().click();
            metalsColorsPage.selectDefaultVegetablesValue();
            metalsColorsPage.selectElement(metalsColorsPage.getVegetablesCheckbox(), testData.getVegetables());
        } else {
            metalsColorsPage.getVegetablesDropdown().click();
            metalsColorsPage.selectDefaultVegetablesValue();
        }

        //5. Click “Submit” button
        metalsColorsPage.clickSubmitButton();

        //6. Check Results block output on the right-side
        for (WebElement result : metalsColorsPage.getResults()) {

            if (testData.getSummary() != null && result.getText().contains("Summary")) {
                assertTrue(result.getText().contains(metalsColorsPage.getSummary().getSum(testData.getSummary())));
            }

            if (testData.getElements() != null && result.getText().contains("Elements")) {
                String elements = testData.getElements().toString();
                assertTrue(result.getText().contains(elements.substring(1, elements.length() - 1)));
            }
            if (testData.getMetals() != null && result.getText().contains("Metal")) {
                String metals = testData.getMetals().toString();
                assertTrue(result.getText().contains(metals.substring(1, metals.length() - 1)));
            }
            if (testData.getColors() != null && result.getText().contains("Color")) {
                String colors = testData.getColors().toString();
                assertTrue(result.getText().contains(colors.substring(1, colors.length() - 1)));
            }
            if (testData.getVegetables() != null && result.getText().contains("Vegetables")) {
                String vegetables = testData.getVegetables().toString();
                assertTrue(result.getText().contains(vegetables.substring(1, vegetables.length() - 1)));
            }

        }
        //10. Close Browser
        //by tearDown() in LoginBase.class
    }
}