package cz.czechitas;

import org.openqa.selenium.*;

public class AdminLogin {

    private final By fieldUserName = By.id("username");
    private final By fieldPassword = By.id("password");
    private final By searchButtonLogon = By.className("btn");
    private final By errorMessage = By.className("alert-error");
    private final By adminPage=By.className("icon-user");
    private final WebDriver driver;
  

    public AdminLogin (WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.navigate().to(Settings.WebUrl);
    }


    public void writeName (String username) {

        driver.findElement(fieldUserName).sendKeys(username);

    }

    public void writePassword (String password) {
 
        driver.findElement(fieldPassword).sendKeys(password);

    }

    public void clickButton () {
        driver.findElement(searchButtonLogon).click();

    }

    public String getError() {
        return driver.findElement(errorMessage).getText();
    }

    public String adminPage(){
        return driver.findElement(adminPage).getText();

    }

}
