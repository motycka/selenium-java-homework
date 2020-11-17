package cz.czechitas;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import static org.junit.jupiter.api.Assertions.*;

public class TemplateTest {

    private static WebDriver driver;
    private static AdminPage adminPage;

    @BeforeEach
    public void before() throws InterruptedException {
        driver = DriverHelper.openFirefox();
        adminPage = new AdminPage(driver);
        adminPage.openPage();
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    @DisplayName("Login with invalid password")
    public void invalidPasswordTest() throws InterruptedException {
        adminPage.login("admin@shopizer.com", "password1");
        Thread.sleep(5000L);
        String expectedErrorMessage = "Invalid username or password";
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-error']"));
        String actualErrorMessage = errorMessage.getText();
        assertEquals(actualErrorMessage, expectedErrorMessage, "Login enabled with wrong password");
    }

    @Test
    @DisplayName("Login with invalid username")
    public void invalidUsernameTest() throws InterruptedException {
        adminPage.login("admin@shopizer1.com", "password");
        Thread.sleep(5000L);
        String expectedErrorMessage = "Invalid username or password";
        WebElement errorMessage = By.xpath("//div[@class='alert alert-error']").findElement(driver);
        String actualErrorMessage = errorMessage.getText();
        assertEquals(actualErrorMessage, expectedErrorMessage, "Login enabled with wrong username");
    }

    @Test
    @DisplayName("Login with valid data")
    public void validRegistrationTest() throws InterruptedException {
        adminPage.login("admin@shopizer.com", "password");
        Thread.sleep(5000L);
        String expectedUrl = "http://czechitas-shopizer.azurewebsites.net/admin/home.html";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(actualUrl, expectedUrl, "Admin page was not opened");

    }

}
