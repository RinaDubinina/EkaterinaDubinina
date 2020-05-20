package hw_api;

import hw_api.utill.PropertyReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public class BaseTest {

    protected RequestSpecification REQUEST_SPECIFICATION;

    @SneakyThrows
    private Properties getProperties() {
        Properties prop = new Properties();
        String propFileName = "test.properties";
        prop.load(getClass().getClassLoader().getResourceAsStream(propFileName));
        return prop;
    }

    @BeforeMethod
    public void setup() {
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(PropertyReader.getProperties().getProperty("URL"))
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }
}
