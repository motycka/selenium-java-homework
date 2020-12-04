package cz.czechitas;

import cz.czechitas.pages.AdminLoginPage;
import cz.czechitas.pages.AdminPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test admin login")
public class AdminLoginTest {

    private WebDriver driver;
    private AdminLoginPage adminLoginPage;

    private final String baseUrl = Settings.getProperty("baseUrl");
    private final String validUsername = Settings.getProperty("username");
    private final String validPassword = Settings.getProperty("password");
    private final String invalidLoginMessage = "Invalid username or password";

    @BeforeEach
    public void before() {
        driver = DriverHelper.openChrome();
        adminLoginPage = new AdminLoginPage(driver, baseUrl);
        adminLoginPage.openPage();
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    @DisplayName("should login successfully")
    public void testValidLogin() {
        AdminPage adminPage = adminLoginPage.login(validUsername, validPassword);
        assertEquals(validUsername, adminPage.isLoggedInAs(), "User should be redirected to admin page");
    }

    @Test
    @DisplayName("should require valid username")
    public void testInvalidUsername() {
        adminLoginPage.login("invalid", validPassword);
        assertEquals(invalidLoginMessage, adminLoginPage.getError(), "There should be error: " + invalidLoginMessage);
        assertTrue(adminLoginPage.isOnPage(), "User should not be redirected anywhere");
    }

    @Test
    @DisplayName("should require valid password")
    public void testInvalidPassword() {
        adminLoginPage.login(validUsername, "invalid");
        assertEquals(invalidLoginMessage, adminLoginPage.getError(), "There should be error: " + invalidLoginMessage);
        assertTrue(adminLoginPage.isOnPage(), "User should not be redirected anywhere");
    }

    @Test
    @DisplayName("should require username and password")
    public void testUsernameAndPasswordAreRequired() {
        adminLoginPage.login("", "");
        assertEquals("*", adminLoginPage.getUsernameHelp(), "Username field should be marked as required by *");
        assertEquals("*", adminLoginPage.getPasswordHelp(), "Password field should be marked as required by *");
        assertFalse(adminLoginPage.errorIsDisplayed(), "Error should not be displayed");
    }
}
