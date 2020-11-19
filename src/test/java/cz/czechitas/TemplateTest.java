package cz.czechitas;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemplateTest {

    private static AdminShopPage administrace;
    private static WebDriver driver;
    private static final String username = ("admin@shopizer.com");
    private static final String password = ("password");

    @BeforeEach
    public void before() {
        driver = DriverHelper.openFirefox();
        administrace = new AdminShopPage(driver);
        administrace.openAdminpage();
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    @DisplayName("Login with the valid username and invalid password")
    public void testLoginValidUsernameInvalidPassword() {
        administrace.fillLoginDetails(username, "heslo");
        administrace.logonClick();
        administrace.waitForClassName("alert");
        String message = administrace.getErrorMessage();
        assertEquals("Invalid username or password", message, "Chybová hláška se zobrazuje špatně");
    }

    @Test
    @DisplayName("Login with the invalid username and invalid password")
    public void testLoginInvalidUsernameInvalidPassword() {
        administrace.fillLoginDetails("bla@shopizer.com", "heslo");
        administrace.logonClick();
        administrace.waitForClassName("alert");
        String message = administrace.getErrorMessage();
        assertEquals("Invalid username or password", message, "Chybová hláška se zobrazuje špatně");
    }

    @Test
    @DisplayName("Login with the valid username and valid password")
    public void testLoginValidUsernameValidPassword() {
        administrace.fillLoginDetails(username, password);
        administrace.logonClick();
        administrace.waitForLinkText("Shipping");
        String url = driver.getCurrentUrl();
        assertEquals(Settings.adminUrl, url, "Přihlášení do administrace neproběhlo");
    }

}




