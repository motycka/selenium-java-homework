package cz.czechitas;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class adminLoginPage {

    private final By loginUsernameSelector = By.id("username");
    private final By loginPasswordSelector = By.id("password");
    private final By loginButtonSelector = By.id("formSubmitButton");
    private final By errorAdminLoginSelector = By.className("alert-error");
    private final By adminPageSelector = By.className("body");
    private final WebDriver driver;

    public adminLoginPage(WebDriver driver) {
        this.driver = driver;

    }

    public void openPage() throws InterruptedException {
        driver.navigate().to("http://czechitas-shopizer.azurewebsites.net/admin/logon.html");
        Thread.sleep(10000);
    }

    public void adminLogin(String username, String password) {
        driver.findElement(loginUsernameSelector).sendKeys(username);
        driver.findElement(loginPasswordSelector).sendKeys(password);
        driver.findElement(loginButtonSelector).click();
    }

    public String badAccessError() {
        return driver.findElement(errorAdminLoginSelector).getText();
    }

    public String finallyAdminPage() {
        return driver.findElement(adminPageSelector).getText();
    }
}