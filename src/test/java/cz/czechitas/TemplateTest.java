package cz.czechitas;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

public class TemplateTest {

    public static final String username = "username";
    public static final String password = "password";
    public static final String loginButton = "formSubmitButton";

    private final String baseUrl = "http://czechitas-shopizer.azurewebsites.net/admin/logon.html";
    private static WebDriver driver;
    private static DriverHelper loginStrana;
    private static adminLoginPage loginPage;

    @BeforeEach
    public void before() throws InterruptedException {
        driver = DriverHelper.openChrome();
        driver.navigate().to(baseUrl);
        loginPage = new adminLoginPage(driver);
        loginPage.openPage();
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    @DisplayName("Login do admina se správným uživatelem, ale špatným heslem - chybová hláška")
    public void testBadPassword() throws InterruptedException {
//        přes WebElement je to srozumitelnější
        WebElement searchField1 = driver.findElement(By.id("username"));
        searchField1.sendKeys("admin@shopizer.com");
        WebElement searchField2 = driver.findElement(By.id("password"));
        searchField2.sendKeys("abc123");
        WebElement loginButton = driver.findElement(By.id("formSubmitButton"));
        loginButton.click();
        Thread.sleep(5000);
        WebElement errorMessage = driver.findElement(By.className("alert-error"));
        Assertions.assertEquals("Invalid username or password", errorMessage.getText());

    }

    @Test
    @DisplayName("Login do admina se špatným uživatelem - chybová hláška")
    public void testBadUser() throws InterruptedException {
        loginPage.adminLogin("abc123@shopizer.com", "password");
//        přes Page Object Pattern se pošle toto:
//        driver.findElement(By.id("loginField1Selector")).sendKeys("abc123@shopizer.com");
//        driver.findElement(By.id("loginField2Selector")).sendKeys("password");
//        driver.findElement(By.id("loginSubmitButton")).click();
        Thread.sleep(5000);
//        driver.findElement(By.className("errorAdminLoginSelector")).sendKeys("Invalid username or password");
//        String errorMessage = loginPage.badAccessError();
        Assertions.assertEquals("Invalid username or password", loginPage.badAccessError());
    }

    @Test
    @DisplayName("Login do admina se správným uživatelem i heslem - ověření, že se admin otevřel")
    public void testAllFine() throws InterruptedException {
        loginPage.adminLogin("admin@shopizer.com", "password");
//        Page Object Pattern
//        driver.findElement(By.id("loginField1Selector")).sendKeys("admin@shopizer.com");
//        driver.findElement(By.id("loginField2Selector")).sendKeys("password");
//        driver.findElement(By.id("loginSubmitButton")).click();
        Thread.sleep(5000);
//        driver.findElement(By.className("adminPageSelector")).sendKeys("body");
//        String adminPageSelector = loginPage.finallyAdminPage();
        WebElement adminPage = driver.findElement(By.className("body"));
        Assertions.assertEquals(true, adminPage.isDisplayed());
    }

}


