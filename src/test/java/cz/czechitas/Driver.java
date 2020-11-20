package cz.czechitas;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class Driver {

    public static WebDriver openFirefox(){

        System.setProperty(Settings.DRIVER, Settings.DRIVER_PATH);

        FirefoxOptions options = new FirefoxOptions().addArguments("-private")
                .addPreference("browser.download.dir", Settings.PATH)
                .addPreference("browser.download.folderList", 2);
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
}
