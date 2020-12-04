package cz.czechitas;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DriverHelper {

    private static final String downloadsPath = "";

    public static WebDriver openFirefox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions()
                .addArguments("-private")
                .addPreference("browser.download.dir", getPath(downloadsPath))
                .addPreference("browser.download.folderList", 2);
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver openChrome() {
        WebDriverManager.chromedriver().setup();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", getPath(downloadsPath));
        ChromeOptions options = new ChromeOptions()
                .addArguments("incognito")
                .setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
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
