package cz.czechitas;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TemplateTest {


    private static WebDriver driver;
    private static LoginPage loginPage;

    @BeforeEach
    public void before() throws InterruptedException {
        driver = DriverHelper.openChrome();
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        Thread.sleep(2000);
    }


    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    @DisplayName("wrong password")
    public void wrongPassword() throws InterruptedException {
        loginPage.adminLogin("admin@shopizer.com", "abcdefghijk");
        Assertions.assertEquals("Invalid username or password", loginPage.getError());
    }


    @Test
    @DisplayName("wrong admin")
    public void wrongUser() throws InterruptedException {
        loginPage.adminLogin("xxx@shopizer.com", "password");
        Assertions.assertEquals("Invalid username or password", loginPage.getError());
    }

    @Test
    @DisplayName("Correct admin and password")
    public void correctLogin() throws InterruptedException {
        loginPage.adminLogin("admin@shopizer.com", "password");
        WebElement adminPage = driver.findElement(By.className("icon-user"));
        Assertions.assertEquals(true, adminPage.isDisplayed());
    }

}