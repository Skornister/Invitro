package core;

import static core.BaseMethods.s$;

import com.codeborne.selenide.SelenideElement;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static final String PROPERTIES_PATH = "strings/";
    private static final Properties PROPERTIES = loadProperties();

    private static Properties loadProperties() {
        String fileNamePrimary = "invitro-web.properties";
        String fileNameSecondary = null;

        Properties properties = new Properties();
        try (InputStream inputPrimary = PropertyReader.class.getClassLoader().getResourceAsStream(PROPERTIES_PATH + fileNamePrimary);
             InputStream inputSecondary = PropertyReader.class.getClassLoader().getResourceAsStream(PROPERTIES_PATH + fileNameSecondary)) {

            properties.load(inputPrimary);

            if (inputPrimary == null) {
                System.out.println("ERROR: No such file " + fileNamePrimary);
                return null;
            }

            if (inputSecondary != null) {
                Properties secondaryProperties = new Properties();
                secondaryProperties.load(inputSecondary);
                properties.putAll(secondaryProperties);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

    public static String s(String key) {
        return PROPERTIES.getProperty(key);
    }

    public static SelenideElement ss(String key) {
        return s$(PROPERTIES.getProperty(key));
    }
}