package cz.czechitas;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {

    public static final String configurationFile = "automation.properties";

    public static String getProperty(String key) {
        String automationPropertiesFilePath = System.getProperty("user.home") + "/" + configurationFile;
        try (InputStream input = new FileInputStream(automationPropertiesFilePath)) {
            Properties properties = new Properties();
            properties.load(input);
            System.out.print("Reading property " + key + ": ");
            String value = properties.getProperty(key);
            System.out.println(value);
            return value;
        } catch (IOException ex) {
            System.out.println("Could not read file " + automationPropertiesFilePath);
            ex.printStackTrace();
        }
        return null; // toto neni uplne spravne, ale nechtela jsem kod komplikovat handlovanim vyjimek
    }

}
