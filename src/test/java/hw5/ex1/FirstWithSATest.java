package hw5.ex1;


import hw5.LoginBase;
import hw3.utill.PropertyReader;
import hw5.steps.IndexPageSteps;
import hw5.base.AllureScreenshotListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.Arrays;


@Listeners({AllureScreenshotListener.class})
public class FirstWithSATest extends LoginBase {

    @Feature("Home page functionality")
    @Story("Login on home page and assert web elements on page")

    @Test
    public void loginTestWithSA() {
        IndexPageSteps indexPageSteps = new IndexPageSteps(driver);
        //1. Open test site by URL
        indexPageSteps.open(PropertyReader.read("url"));

        //2. Assert Browser title
        indexPageSteps.shouldReturnPageTitle("Home Page");

        //3. Perform login
        indexPageSteps.login(PropertyReader.read("user"), PropertyReader.read("password"));

        //4. Assert Username is loggined
        indexPageSteps.shouldReturnUsername("ROMAN IOVLEV");

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        indexPageSteps.shouldReturnItemsHeaderAmount(4);
        indexPageSteps.shouldHeaderMenuElementsText(Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));

        //6. Assert that there are 4 images on the Index Page and they are displayed

        indexPageSteps.shouldReturnIconsAmount(4);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        indexPageSteps.shouldReturnIconTextElementCount(4);

        indexPageSteps.shouldReturnIconText(Arrays.asList(
                "To include good practices\n" + "and ideas from successful\n" + "EPAM project",
                "To be flexible and\n" + "customizable",
                "To be multiplatform",
                "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"));

        //8. Assert that there is the iframe with “Frame Button” exist
        indexPageSteps.shouldReturnFrame();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        indexPageSteps.switchToFrame();
        indexPageSteps.shouldReturnFrameButton();

        //10. Switch to original window back
        indexPageSteps.switchToOriginalWindow();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        indexPageSteps.shouldReturnLeftSectionItemsAmount(5);
        indexPageSteps.shouldReturnLeftSectionItemsTests(Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs"));

        indexPageSteps.softAssertAll();

        //12. Close Browser
        // by tearDown() in LoginBase.class

    }
}