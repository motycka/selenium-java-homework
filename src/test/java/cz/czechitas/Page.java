package cz.czechitas;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class Page {

    private WebDriver driver;
    private By searchUsername =  By.id("username");
    private By searchPassword =  By.id("password");
    private By searchButton =  By.id("formSubmitButton");
    private By searchOnAdminPage = By.className("imgSectionHeaderTitleopened");
    private By searchErrorMessage = By.className("alert-error");

    public Page(WebDriver driver){
        this.driver = driver;
    }

    public void openPage(){
        driver.navigate().to(Settings.adminUrl);
    }

    public void login(String loginPassword, String loginUserName){
        WebElement user = driver.findElement(searchUsername);
        WebElement password = driver.findElement(searchPassword);
        WebElement button = driver.findElement(searchButton);
        user.sendKeys(loginUserName);
        password.sendKeys(loginPassword);
        button.click();
    }

    public String waitForLogin(){
        WebElement element = new WebDriverWait(driver, 5).until(d->d.findElement(searchOnAdminPage));
        return element.getAttribute("nowrap");
    }

    public String getErrorMessage(){
        WebElement element = new WebDriverWait(driver, 5).until(d->d.findElement(searchErrorMessage));
        return element.getText();
    }
}
