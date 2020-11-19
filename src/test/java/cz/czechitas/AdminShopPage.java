package cz.czechitas;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import okhttp3.internal.http2.*;

public class AdminShopPage {


    WebDriver driver;
   


    public AdminShopPage(WebDriver driver) {
        this.driver = driver;
    }


    public void openAdminpage() {
        driver.navigate().to(Settings.adminLogonUrl);
    }

    public void fillLoginDetails (String username, String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
    }

    public void logonClick() {
        WebElement logonField = driver.findElement(By.id("formSubmitButton"));
        logonField.click();
    }


    public String getErrorMessage () {
        WebElement errorMessageField = driver.findElement(By.className("alert"));
        return errorMessageField.getText();
    }

    public void waitForLinkText (String linkText) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
    }

    public void waitForClassName (String linkText) {
        WebDriverWait wait = new WebDriverWait(driver, 10); // seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(linkText)));
    }
}