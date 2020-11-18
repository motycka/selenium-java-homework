package cz.czechitas;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class TemplateTest {

    private static WebDriver driver;
    private static Page page;
    private static String adminUrl = "http://czechitas-shopizer.azurewebsites.net/admin/logon.html";
    private static String homeAdmin = "http://czechitas-shopizer.azurewebsites.net/admin/home.html";

    @BeforeEach
    public void before () {
        driver = Driver.openFirefox();
        driver.navigate().to(adminUrl);
        page = new Page(driver);
    }

    @AfterEach
    public void after () {
        driver.quit();
    }

    // zkusila jsem udělat parametrizovaný test, který by spojil první dva testy, ty jsem ponechala a
    // označila @Disabled
    @ParameterizedTest
    @DisplayName("there should be a message - wrong password or username")
    @CsvSource({
            "admin@shopizer.com, wrongPassword",
            "wrongEmail@wrongDomain.com, password",
    })
    public void testWrongLogin(String userLogin, String passwordLogin){
        page.login(passwordLogin, userLogin);
        page.getElementByClassName("alert-error");
        assertTrue(driver.findElement(By.className("alert-error")).isDisplayed(), "Chybová hláška není zobrazena.");
    }

    @Disabled
    @Test
    @DisplayName("there should be a message - wrong password ")
    public void testWrongPassword () {
        page.login("wrongPassword", "admin@shopizer.com");
        page.getElementByClassName("alert-error");
        assertTrue(driver.findElement(By.className("alert-error")).isDisplayed(), "Chybová hláška není zobrazena.");
    }

    @Disabled
    @Test
    @DisplayName("there should be a message - wrong username ")
    public void testWrongUsername () {
        page.login("password", "wrongEmail@wrongDomain.com");
        page.getElementByClassName("alert-error");
        assertTrue(driver.findElement(By.className("alert-error")).isDisplayed(), "Chybová hláška není zobrazena.");
    }

    @Test
    @DisplayName("should be able to login to administration")
    public void testLoginAsAdmin () {
        page.login("password", "admin@shopizer.com");
        page.getRightAddress(homeAdmin);
        assertEquals(homeAdmin, driver.getCurrentUrl(), "Měli byste být na stránce: " + homeAdmin);
    }
}
