package hw3.ex1;


import hw3.LoginBasePO;
import hw3.pages.IndexPage;
import hw3.utill.PropertyReader;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;


public class LoginPOTestWithSoftAssert extends LoginBasePO {

    @Test
    public void loginTestWithSA() {
        SoftAssert softAssert = new SoftAssert();
        IndexPage indexPage = new IndexPage(getDriver());
        //1. Open test site by URL
        openSite();

        //2. Assert Browser title
        softAssert.assertEquals(indexPage.getBrowserTitle(), "Home Page", "Browser title has incorrect name");

        //3. Perform login
        indexPage.login(PropertyReader.read("user"), PropertyReader.read("password"));

        //4. Assert Username is loggined
        softAssert.assertTrue(indexPage.getUserName().equals("ROMAN IOVLEV"), "Name is not equals to expected result");

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertEquals(indexPage.getHeaderMenuElementsCount(), 4, "Wrong number of items in header");
        List<String> expectedText = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<String> actualText = indexPage.getHeaderMenuElementsText();
        softAssert.assertEquals(actualText, expectedText, "Menu buttons have not proper texts");

        //6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(indexPage.getBenefitIconCount(),
                4, "The amount of images is incorrect");

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertEquals(indexPage.getBenefitTextElementCount(), 4);
        List<String> expectedBenefitTexts = Arrays.asList(
                "To include good practices\n" + "and ideas from successful\n" + "EPAM project",
                "To be flexible and\n" + "customizable",
                "To be multiplatform",
                "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");
        List<String> actualBenefitTexts = indexPage.getBenefitTexts();
        softAssert.assertEquals(actualBenefitTexts, expectedBenefitTexts, "Texts under icons are incorrect");

        //8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(indexPage.isFrameDisplayed(), "The iframe is not exists");

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        indexPage.switchToFrame();
        softAssert.assertTrue(indexPage.isFrameButtonDisplayed(), "The “Frame Button” is not exists");

        //10. Switch to original window back
        indexPage.switchToOriginalWindow();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        softAssert.assertEquals(indexPage.getSideBarMenuCountElements(), 5);
        List<String> expectedLeftSectionTexts = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        List<String> actualLeftSectionTexts = indexPage.getSideBarMenu();
        softAssert.assertEquals(actualLeftSectionTexts, expectedLeftSectionTexts, "Left section menu items have incorrect proper text");
        softAssert.assertAll();

        //12. Close Browser
        // by tearDown() in LoginBase.class

    }
}