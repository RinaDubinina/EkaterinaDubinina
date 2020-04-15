package hw5.ex2;


import hw5.utill.PropertyReader;
import hw5.LoginBase;
import hw5.steps.IndexPageSteps;
import hw5.base.AllureScreenshotListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;


@Listeners({AllureScreenshotListener.class})
public class FirstFailedTest extends LoginBase {



    @Feature("Testing home page failed functionality")
    @Story("Login on home page and assert web elements on page")
    @Test
    public void loginTestWithSA() {
        IndexPageSteps indexPageSteps = new IndexPageSteps(driver);

        //1. Open test site by URL
        indexPageSteps.open(PropertyReader.read("url"));

        //2. Assert Browser title
        indexPageSteps.shouldReturnPageTitle("Index Page");

        //3. Perform login
        indexPageSteps.login(PropertyReader.read("user"), PropertyReader.read("password"));

        //4. Assert Username is loggined
        indexPageSteps.shouldReturnUsername("IVAN IOVLEV");

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        indexPageSteps.shouldReturnItemsHeaderAmount(5);
        indexPageSteps.shouldHeaderMenuElementsText(Arrays.asList("HOME", "CONTACT", "SERVICE", "METALS & COLORS"));

        indexPageSteps.softAssertAll();

        //12. Close Browser
        // by tearDown() in LoginBase.class

    }
}