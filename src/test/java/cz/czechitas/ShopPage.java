package cz.czechitas;

import org.openqa.selenium.*;
import okhttp3.internal.http2.*;

public class ShopPage {
  //proměnná
    private final WebDriver driver;

    private final By usernameadminlogin = By.id("username");
    private final By passwordadminlogin = By.id("password");
    private final By adminloginbutton = By.id("formSubmitButton");


  //konstruktor
    public ShopPage(WebDriver driver)
    {
        this.driver = driver;
    }

  //metoda navigace na stránku
    public void openPage ()
    {
      String adminUrl = Settings.baseUrl + "/shop admin/";
      driver.navigate().to(adminUrl);
    }

  //metoda pro login s validním username do admina,
    public void ValidUsernameAdminLogin()
    {
      String ValidUsername ="admin@shopizer.com";
      driver.findElement(usernameadminlogin).sendKeys(ValidUsername);
    }

  //metoda pro login s nevalidním username do admina,
    public void InValidUsernameAdminLogin()
    {
      String InValidUsername ="wrongadmin@shopizer.com";
      driver.findElement(usernameadminlogin).sendKeys(InValidUsername);
    }

    //metoda pro login s validním password do admina
    public void ValidPasswordAdminLogin()
    {
      String ValidPassword ="password";
      driver.findElement(passwordadminlogin).sendKeys(ValidPassword);
    }

  //metoda pro login s nevalidním password do admina
     public void InValidPasswordAdminLogin()
    {
      String InValidPassword ="wrongpassword";
      driver.findElement(passwordadminlogin).sendKeys(InValidPassword);
    }

 //metod pro příhlášení, click na adminloginbutton
    public void ConfirmAdminLogin()
    {
        driver.findElement(adminloginbutton).click();
    }

}
