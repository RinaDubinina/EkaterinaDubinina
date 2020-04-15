package hw5.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public enum WebDriverSingleton {
    INSTANCE;

    private WebDriver driver;

    public void createdDriver(String browserName) {
     //   WebDriverManager.chromedriver().setup();
        if ("CHROME".equalsIgnoreCase(browserName)) {
           WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    public WebDriver getDriver() {
        if (driver == null) {
            createdDriver("chrome");
        }
        return driver;
    }
}
