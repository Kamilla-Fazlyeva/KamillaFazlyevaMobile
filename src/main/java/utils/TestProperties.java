package utils;

import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    public static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        String propertyPath = "test.properties";
        properties.load(TestProperties.class.getClassLoader().getResourceAsStream(propertyPath));

        return properties;
    }
}
