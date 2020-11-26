package cz.czechitas;

import org.openqa.selenium.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

public class AdminLoginPage {

    //proměnná
    private final WebDriver driver;

    private final By usernameSelector = By.id("username");
    private final By passwordSelector = By.id("password");
    private final By loginButtonSelector = By.id("formSubmitButton");
    private final By loginFailmessageSelector = By.xpath("//*[@id=\"logon\"]/div[1]/div");
    private final By logedAdminSelector = By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/ul[1]/li/a");

    private final int maxWaitInSeconds = 10;

    //konstruktor, přijímá driver

    public AdminLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //metoda navigace na stránku
    public void openPage() {
        String adminUrl = Settings.baseUrl;
        driver.navigate().to(adminUrl);
    }

    //metoda pro login do admina,
    public void login(String username, String password) {
        driver.findElement(usernameSelector).sendKeys(username);
        driver.findElement(passwordSelector).sendKeys(password);
        driver.findElement(loginButtonSelector).click();
    }

    //metoda ověření viditelnosti logedAdminSelector
    public String getAdminName() {
        WebElement element = new WebDriverWait(driver, maxWaitInSeconds)
                .until(ExpectedConditions.visibilityOfElementLocated(logedAdminSelector));

        return element.getText();
    }

    //metoda ověření viditelnosti loginFailmessageSelector
    public String getError() {
        WebElement element = new WebDriverWait(driver, maxWaitInSeconds)
                .until(ExpectedConditions.visibilityOfElementLocated(loginFailmessageSelector));

        return element.getText();
    }
}