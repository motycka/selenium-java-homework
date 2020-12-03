package cz.czechitas;

import javax.print.attribute.standard.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

public class AdminPage {


    private final By SelektorPrihlasovaciJmeno = By.id("username");
    private final By SelektorHeslo = By.id("password");
    private final By SelektorTlacitko = By.id("formSubmitButton");
    private final By SelektorSpatneHeslo = By.className("alert alert-error");
    private final By SelektorAdminStranka = By.className("icon-user");


    private final WebDriver driver;

    public AdminPage(WebDriver driver)  {
        this.driver = driver;

    }

    public void otevritStranku() throws InterruptedException {
        driver.navigate().to("http://czechitas-shopizer.azurewebsites.net/admin/logon.html");
    }

    public void prihlaseni(String username, String password) {
        driver.findElement(SelektorPrihlasovaciJmeno).sendKeys(username);
        driver.findElement(SelektorHeslo).sendKeys(password);
        driver.findElement(SelektorTlacitko).click();
    }

    public String spatnePrihlaseni() {
        return driver.findElement(SelektorSpatneHeslo).getText();
    }

    public String dobrePrihlaseni() {
        return driver.findElement(SelektorAdminStranka).getText();

    }

}
