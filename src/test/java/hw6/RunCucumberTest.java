package hw6;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        strict = true,
        //     plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        features = "src/test/resources/hw6",
        glue = "hw6"
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
