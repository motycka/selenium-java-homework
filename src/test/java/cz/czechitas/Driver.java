package cz.czechitas;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class Driver {

    public static final String PATH = "C:\\Users\\JitkaM\\Desktop\\selenium-java-homework";

    public static WebDriver openFirefox(){

        System.setProperty("webdriver.gecko.driver", PATH + "/src/test/resources/drivers/geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions().addArguments("-private")
                .addPreference("browser.download.dir", PATH)
                .addPreference("browser.download.folderList", 2);
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
}
