package cz.czechitas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {

    private final By loggedInUserSelector = By.className("dropdown-toggle");
    private final WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public String isLoggedInAs() {
        return driver.findElement(loggedInUserSelector).getText();
    }

}
