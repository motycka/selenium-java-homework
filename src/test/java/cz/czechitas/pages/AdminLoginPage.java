package cz.czechitas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage {

    private final By usernameSelector = By.id("username");
    private final By usernameHelpSelector = By.id("username_help");
    private final By passwordSelector = By.id("password");
    private final By passwordHelpSelector = By.id("password_help");
    private final By loginButtonSelector = By.id("formSubmitButton");
    private final By errorSelector = By.className("alert-error");
    private final WebDriver driver;
    private final String baseUrl;

    public AdminLoginPage(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
    }

    public void openPage() {
        driver.navigate().to(this.baseUrl + "/admin/logon.html");
    }

    public boolean isOnPage() {
        return driver.findElement(usernameSelector).isDisplayed() && driver.findElement(passwordSelector).isDisplayed();
    }

    public AdminPage login(String username, String password) {
        driver.findElement(usernameSelector).sendKeys(username);
        driver.findElement(passwordSelector).sendKeys(password);
        driver.findElement(loginButtonSelector).click();
        return new AdminPage(driver);
    }

    public String getUsernameHelp() {
        return driver.findElement(usernameHelpSelector).getText();
    }

    public String getPasswordHelp() {
        return driver.findElement(passwordHelpSelector).getText();
    }

    public boolean errorIsDisplayed() {
        try {
            return driver.findElement(errorSelector).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public String getError() {
        return driver.findElement(errorSelector).getText();
    }

}
