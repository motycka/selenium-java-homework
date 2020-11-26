package cz.czechitas;

import java.util.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import okhttp3.internal.http2.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName ("Domaci ukol - automatizovane testovani")
public class TemplateTest {

    private static final String shopUrl = Settings.baseUrl + "/admin/";
    private static WebDriver driver;

    private static String alertError = "Invalid username or password";
    private static String administrationPage = "Recent orders";

    @BeforeEach
    public void before() {
        driver = DriverHelper.openFirefox();
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    @DisplayName ("Test spatne heslo")
    public void testShop1() {
        driver.navigate().to(shopUrl);

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin@shopizer.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("spatne");

        WebElement formSubmitButton = driver.findElement(By.id("formSubmitButton"));
        formSubmitButton.click();

        String expected ="Invalid username or password";
        assertEquals(expected, alertError, "" + expected);
    }

    @Test
    @DisplayName ("Test spatny uzivatel")
    public void testShop2() {
        driver.navigate().to(shopUrl);

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin@shopizer.ccc");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password");

        WebElement formSubmitButton = driver.findElement(By.id("formSubmitButton"));
        formSubmitButton.click();

        String expected ="Invalid username or password";
        assertEquals(expected, alertError, "" + expected);

    }

    @Test
    @DisplayName ("Test spravne prihlaseni")
    public void testShop3() {
        driver.navigate().to(shopUrl);

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin@shopizer.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password");

        WebElement formSubmitButton = driver.findElement(By.id("formSubmitButton"));
        formSubmitButton.click();

        String expected ="Recent orders";
        assertEquals(expected, administrationPage, "" + expected);
    }

}
