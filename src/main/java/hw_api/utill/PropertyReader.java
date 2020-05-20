package hw_api.utill;

import lombok.SneakyThrows;

import java.util.Properties;

public class PropertyReader {
    private static String propFileName = "test.properties";
    private static Properties prop;

    @SneakyThrows
    public static Properties getProperties() {
        if (prop == null) {
            prop = new Properties();
            prop.load(PropertyReader.class.getClassLoader().getResourceAsStream(propFileName));
        }
        return prop;
    }
}
