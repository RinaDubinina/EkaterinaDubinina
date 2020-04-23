package hw6.webDriverSingleton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public enum WebDriverSingleton {
    INSTANCE;

    private WebDriver driver;

    public void createdDriver(String browserName) {
        if ("CHROME".equalsIgnoreCase(browserName)) {
           WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    public WebDriver getDriver() {
        if (driver == null) {
            createdDriver("chrome");
        }
        return driver;
    }
}
