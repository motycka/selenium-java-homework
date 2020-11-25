package cz.czechitas.admin;

import cz.czechitas.DriverHelper;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test admin login")
public class AdminLoginTest {

    private WebDriver driver;
    private AdminLoginPage adminLoginPage;

    private final String validUsername = "admin@shopizer.com";
    private final String validPassword = "password";
    private final String invalidLoginMessage = "Invalid username or password";

    @BeforeEach
    public void before() {
        driver = DriverHelper.openChrome();
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.openPage();
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    @DisplayName("it sucessfully login")
    public void testValidLogin() {
        AdminPage adminPage = adminLoginPage.login(validUsername, validPassword);
        assertEquals(validUsername, adminPage.isLoggedInAs(), "User should be redirected to admin page");
    }

    @Test
    @DisplayName("it should require username and password")
    public void testUsernameAndPasswordAreRequired() {
        adminLoginPage.login("", "");
        assertEquals("*", adminLoginPage.getUsernameHelp(), "Username field should be marged as required by *");
        assertEquals("*", adminLoginPage.getPasswordHelp(), "Password field should be marged as required by *");
        assertFalse(adminLoginPage.errorIsDisplayed(), "Error should not be displayed");
    }

    @Test
    @DisplayName("it should require valid username")
    public void testInvalidUsername() {
        adminLoginPage.login("invalid", validPassword);
        assertEquals(invalidLoginMessage, adminLoginPage.getError(), "There should be error: " + invalidLoginMessage);
        assertTrue(adminLoginPage.isOnPage(), "User should not be redirected anywhere");
    }

    @Test
    @DisplayName("it should require valid password")
    public void testInvalidPassword() {
        adminLoginPage.login(validUsername, "invalid");
        assertEquals(invalidLoginMessage, adminLoginPage.getError(), "There should be error: " + invalidLoginMessage);
        assertTrue(adminLoginPage.isOnPage(), "User should not be redirected anywhere");
    }

}
