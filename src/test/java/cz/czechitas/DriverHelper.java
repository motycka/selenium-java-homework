package cz.czechitas;

import java.net.*;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class DriverHelper {

    private static String downloadsPath = "";

    public static WebDriver openChrome() {
        setDriver("chrome");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", getPath(downloadsPath));
        ChromeOptions options = new ChromeOptions()
                .addArguments("incognito")
                .setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public static void setDriver(String driver) {
        String os = System.getProperty("os.name").toLowerCase();

        String driverPath = "";
        if (os.contains("win")) {
            driverPath = "drivers/" + driver + "driver.exe";
        } else {
            driverPath = "drivers/" + driver + "driver";
        }

        System.setProperty("webdriver." + driver + ".driver", getPath(driverPath));
    }

    private static String getPath(String path) {
        try {
            return Objects.requireNonNull(DriverHelper.class.getClassLoader().getResource(path)).toURI().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException("Path " + path + " is invalid.");
        }
    }

}