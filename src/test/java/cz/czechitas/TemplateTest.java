package cz.czechitas;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import cz.czechitas.*;

public class TemplateTest {

    public static final String username = "username";
    public static final String password = "password";
    public static final String loginButton = "formSubmitButton";

    private final String baseUrl = "http://czechitas-shopizer.azurewebsites.net/admin/logon.html";
    private static WebDriver driver;
    private static AdminPage admin;

    @BeforeEach
    public void before() throws InterruptedException {
        driver = DriverHelper.openFirefox();
        driver.navigate().to(baseUrl);
        admin = new AdminPage (driver);
        admin.otevritStranku();

    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    @DisplayName("1. Login do admina se správným uživatelem, ale špatným heslem - ověřte chybovou hlášku")
    public void testSpatneHeslo () throws InterruptedException {
        WebElement searchFieldA = driver.findElement(By.id("username"));
        searchFieldA.sendKeys("admin@shopizer.com");

        WebElement searchFielB = driver.findElement(By.id("password"));
        searchFielB.sendKeys("heslo12345");

        WebElement loginButton = driver.findElement(By.id("formSubmitButton"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.className("alert alert-error"));
        Assertions.assertEquals("Invalid username or password",errorMessage.getText());
    }

    @Test
    @DisplayName("2.Login do admina se špatným uživatelem - ověřte chybovou")
    public void testSpatnyUzivatel() throws InterruptedException {

        admin.prihlaseni("admin123@shopizer.com", "password");
        Thread.sleep(8000);
        Assertions.assertEquals("Invalid username or password",admin.spatnePrihlaseni());

    }
    @Test
    @DisplayName("3. Login do admina se správným uživatelem i heslem - ověření, že se admin otevřel")
    public void testOK() throws InterruptedException {
        admin.prihlaseni("admin@shopizer.com", "password");
        Thread.sleep(8000);
        WebElement adminPage =  driver.findElement(By.className("icon-user"));
        Assertions.assertEquals(true, adminPage.isDisplayed());
    }

}
