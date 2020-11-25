package cz.czechitas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AdminLoginPage {
    private final By searchUsernameSelector = By.id("username");
    private final By searchPasswordSelector = By.id("password");
    private final By searchFormSubmitButtonSelector = By.className("btn");
    //  private final int maxWaitInSeconds = 10;
    private final WebDriver driver;


    public AdminLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.navigate().to(Settings.baseUrl + "/admin/");
    }

    public void doLogin(String login, String passwd) {
        // List<WebElement> productsAwaited = new WebDriverWait(driver, maxWaitInSeconds);

        driver.findElement(searchUsernameSelector).sendKeys(login);
        driver.findElement(searchPasswordSelector).sendKeys(passwd);
        driver.findElement(searchFormSubmitButtonSelector).click();
        // try {
        //   driver.wait(maxWaitInSeconds);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //   }

    }
}

