package cz.czechitas;

import org.openqa.selenium.*;

public class AdminPage {

    WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;

    }

    public void openPage() throws InterruptedException {
        driver.navigate().to("http://czechitas-shopizer.azurewebsites.net/admin/logon.html");
        Thread.sleep(5000L);

    }

    public void login(String text, String text2) {
        WebElement name = driver.findElement(By.name("username"));
        WebElement pass = driver.findElement(By.name("password"));
        WebElement button = driver.findElement(By.id("formSubmitButton"));

        name.sendKeys(text);
        pass.sendKeys(text2);
        button.click();
    }
}
