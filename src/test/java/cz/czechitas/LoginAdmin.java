package cz.czechitas;

import org.openqa.selenium.*;

public class LoginAdmin {

    private WebDriver driver;
    private final By selectorIdUser = By.id("username");
    private final By selectorIdHeslo = By.id("password");
    private final By tlacitkoLogon = By.id("formSubmitButton");
    private final By chybovaHlaskaClass = By.className("alert-error");
    private final String url = "http://czechitas-shopizer.azurewebsites.net/admin/logon.html";

    public LoginAdmin(WebDriver driver) {
        this.driver = driver;
    }

    public void otevriWeb() {
        driver.navigate().to(url);
    }

    public void vyplnUsername(String username) {
        driver.findElement(selectorIdUser)
                .sendKeys(username);
    }

    public void vyplnHeslo(String heslo) {
        driver.findElement(selectorIdHeslo)
                .sendKeys(heslo);
    }

    public void klikLogon() {
        driver.findElement(tlacitkoLogon)
                .click();
    }

    public String chybovaHlaska() {
        WebElement hlaska = driver.findElement(chybovaHlaskaClass);
        return hlaska.getText();
    }

    public String admin() {
        WebElement prihlasen = driver.findElement(By.className("dropdown-toggle"));
        return prihlasen.getText();
    }

}
