package hw4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class LoginBase {
    private WebDriver driver;

    private final static String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void openSite() {
        driver.get(URL);
        driver.manage().window().maximize();
    }
}
