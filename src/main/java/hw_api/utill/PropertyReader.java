package hw_api.utill;

import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;

import java.util.Properties;

public class PropertyReader {
    private RequestSpecification REQUEST_SPECIFICATION;
    @SneakyThrows
    public static Properties getProperties() {
        Properties prop = new Properties();
        String propFileName = "test.properties";
        prop.load(PropertyReader.class.getClassLoader().getResourceAsStream(propFileName));
        return prop;
    }
}
