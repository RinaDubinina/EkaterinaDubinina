package hw6.steps;

import hw3.pages.IndexPage;
import hw6.webDriverSingleton.WebDriverSingleton;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class GivenSteps {
    public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    private IndexPage indexPage;

    @Given("I am on Index Page")
    public void iAmOnIndexPage() {
        WebDriverSingleton.INSTANCE.createdDriver("chrome");
        WebDriverSingleton.INSTANCE.getDriver().get(URL);
        indexPage = new IndexPage(WebDriverSingleton.INSTANCE.getDriver());
    }

    @Given("I login as user Roman Iovlev with username: {string} and pass: {string} on Index Page")
    public void iLoginAsUserOnIndexPage(String username, String pass) {
        indexPage.login(username, pass);
    }

    @Given("I go through the header menu Service to Different Elements Page")
    public void iGoToDifferentElements_Page() {
        indexPage.getDifferentElementPage();
    }

}
