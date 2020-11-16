package cz.czechitas;

import org.openqa.selenium.*;
import okhttp3.internal.http2.*;

public class ShopPage {
    WebDriver driver;

    public ShopPage(WebDriver driver) {
        this.driver = driver;

}
    public void openPage() throws InterruptedException {
        driver.navigate().to("http://czechitas-shopizer.azurewebsites.net/admin/logon.html");
        Thread.sleep(10000);
    }

    public void badPasswordOnPage() {

        driver.findElement(By.id("username"));
        WebElement username = driver.findElement(By.id("username"));

        driver.findElement(By. id("password"));
        WebElement password = driver.findElement(By.id("password"));

        driver.findElement(By.id("formSubmitButton"));
        WebElement loginButton = driver.findElement(By.id("formSubmitButton"));

        
        username.sendKeys("admin@shopizer.com");
        password.sendKeys("abc123");
        loginButton.click();
    }

    public void badUserOnPage() {

        driver.findElement(By.id("username"));
        WebElement username = driver.findElement(By.id("username"));

        driver.findElement(By. id("password"));
        WebElement password = driver.findElement(By.id("password"));

        driver.findElement(By.id("formSubmitButton"));
        WebElement loginButton = driver.findElement(By.id("formSubmitButton"));


        username.sendKeys("abc123@shopizer.com");
        password.sendKeys("password");
        loginButton.click();
    }

    public void fineUserOnPage() {

        driver.findElement(By.id("username"));
        WebElement username = driver.findElement(By.id("username"));

        driver.findElement(By. id("password"));
        WebElement password = driver.findElement(By.id("password"));

        driver.findElement(By.id("formSubmitButton"));
        WebElement loginButton = driver.findElement(By.id("formSubmitButton"));


        username.sendKeys("admin@shopizer.com");
        password.sendKeys("password");
        loginButton.click();
    }
}