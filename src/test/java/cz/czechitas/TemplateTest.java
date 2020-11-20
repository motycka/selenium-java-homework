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

    @BeforeEach
    public void before () {
        driver = Driver.openFirefox();
        page = new Page(driver);
        page.openPage();
    }

    @AfterEach
    public void after () {
        driver.quit();
    }

    @ParameterizedTest
    @DisplayName("there should be a message - wrong password or username")
    @CsvSource({
            "admin@shopizer.com, wrongPassword",
            "wrongEmail@wrongDomain.com, password",
    })
    public void testWrongLogin(String userLogin, String passwordLogin){
        page.login(passwordLogin, userLogin);
        assertEquals("Invalid username or password", page.getErrorMessage(), "Chybová hláška je nesprávná nebo není zobrazena.");
    }

    @Test
    @DisplayName("should be able to login to administration")
    public void testLoginAsAdmin () {
        page.login("password", "admin@shopizer.com");
        assertEquals("true", page.waitForLogin(), "Měli byste být na stránce: " + Settings.homeAdmin);
    }
}
