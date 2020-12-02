package cz.czechitas;

import org.openqa.selenium.*;

public class AdminPage {


    private final WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl( ) {
        return Settings.baseUrl + "/admin/home.html";
    }

}
