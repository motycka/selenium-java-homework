package cz.czechitas;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

public class TemplateTest {

    private static WebDriver driver;
    private static AdminPage adminLogonUrl;

    @BeforeEach
    public void before() {
        driver = DriverHelper.openFirefox();
        adminLogonUrl = new AdminPage (driver);
        adminLogonUrl.openPage();

    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    @DisplayName("Login failed - wrong password")
    public void testWrongPassword() {

        adminLogonUrl.ValidUsernameLogin();
        adminLogonUrl.InvalidPasswordLogin();
        adminLogonUrl.ConfirmLogin();
    }

    @Test
    @DisplayName ("Login failed, wrong username")
    public void testWrongUsername() {
        adminLogonUrl.InvalidUsernameLogin();
        adminLogonUrl.ValidPasswordLogin();
        adminLogonUrl.ConfirmLogin();
    }

    @Test
    @DisplayName ("Successful login")
    public void testSuccessfulLogin() {
        adminLogonUrl.ValidUsernameLogin();
        adminLogonUrl.ValidPasswordLogin();
        adminLogonUrl.ConfirmLogin();
    }

}
