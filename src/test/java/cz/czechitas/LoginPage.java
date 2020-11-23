package cz.czechitas;

import org.openqa.selenium.*;

public class LoginPage {
    private final WebDriver driver;
    private final By errorMessage = By.className("alert-error");
    private final By adminPage=By.className("icon-user");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void openPage(){
        driver.navigate().to (Settings.baseUrl + "admin/logon.html");
    }

    public void adminLogin(String username, String password) {
        WebElement adminField=driver.findElement(By.id("username"));
        adminField.sendKeys(username);
        WebElement passwordField=driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
        WebElement logonButton=driver.findElement(By.id("formSubmitButton"));
        logonButton.click();
    }


    public String getError() {
        return driver.findElement(errorMessage).getText();

    }

    public String adminPage(){
        return driver.findElement(adminPage).getText();

    }

}
