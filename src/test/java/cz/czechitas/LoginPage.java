package cz.czechitas;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class LoginPage {

    private final WebDriver driver;
    private static final String loginUrl = Settings.baseUrl + "/admin/";
    private final By userName = By.id("username");
    private final By password = By.id("password");
    private final By logon = By.id("formSubmitButton");
    private final By errorMessage = By.className("alert-error");
    private static final String loggedInUrl = Settings.baseUrl + "/admin/home";



    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.navigate().to(loginUrl);
    }
    //Set username in textbox
    public void setUserName (String strUserName) {
        driver.findElement(userName).sendKeys(strUserName);
    }
    //Set password in textbox
    public void setPassword (String strPassword) {
        driver.findElement(password).sendKeys(strPassword);
    }
    //Click on logon button
    public void clickLogon () {
        driver.findElement(logon).click();
    }
    //New login
    public void loginToLoginPage (String strUserName, String strPassword){
        this.setUserName(strUserName);
        this.setPassword(strPassword);
        this.clickLogon();
        new WebDriverWait(driver, 6)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("alert-error")));

    }

    public String getErrorMessage ( ) {
        return driver.findElement(errorMessage).getText();
    }

}