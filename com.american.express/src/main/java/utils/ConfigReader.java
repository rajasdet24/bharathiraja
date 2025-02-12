package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            // Load the config.properties file
            FileInputStream file = new FileInputStream("src/test/java/config/config.properties");
            properties = new Properties();
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    // Method to get a property value by key
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

