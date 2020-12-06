package cz.czechitas;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import static org.junit.jupiter.api.Assertions.*;

public class AdminLoginTest {

    private static WebDriver driver;
    private static AdminLoginPage adminLoginPage;
    String validUsername = "admin@shopizer.com";
    String inValidUsername = "wrongadmin@shopizer.com";
    String validPassword = "password";
    String invalidPassword = "wrongpassword";
    String failMessage = "Invalid username or password";

    @BeforeEach
    public void before() {
        driver = DriverHelper.openFirefox();
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.openPage();
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    @DisplayName("Admin login failed, wrong password")
    public void testAdminLogin1() {
        adminLoginPage.login(validUsername, invalidPassword);
        assertEquals(failMessage, adminLoginPage.getError(), "Failmessage should display");
    }

    @Test
    @DisplayName("Admin login failed, wrong username")
    public void testAdminLogin2() {
        adminLoginPage.login(inValidUsername, validPassword);
        assertEquals(failMessage, adminLoginPage.getError(), "Failmessage should display");
    }

    @Test
    @DisplayName("Admin login successful")
    public void testAdminLogin3() {

        adminLoginPage.login(validUsername, validPassword);
        assertEquals(validUsername, adminLoginPage.getAdminName(), "Admin should be redirected to admin page");
    }



}
