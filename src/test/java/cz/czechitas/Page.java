package cz.czechitas;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class Page {
    WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
    }

    public void login(String loginPassword, String loginUserName){
        WebElement user = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement button = driver.findElement(By.id("formSubmitButton"));
        user.sendKeys(loginUserName);
        password.sendKeys(loginPassword);
        button.click();
    }

    public Boolean getRightAddress(String urlAddress){
        Boolean isAddressRight = new WebDriverWait(driver, 5).until(d->d.getCurrentUrl().equals(urlAddress));
        return isAddressRight;
    }

    public WebElement getElementByClassName(String className){
        WebElement element = new WebDriverWait(driver, 5).until(d->d.findElement(By.className(className)));
        return element;
    }
}
