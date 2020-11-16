package cz.czechitas;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;


public class TemplateTest {

    private static WebDriver driver;
    private static ShopPage shopPage;


    @BeforeEach
    public void before() {
        driver = DriverHelper.openChrome();
        shopPage = new ShopPage(driver);
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    @DisplayName("Login do admina se správným uživatelem, ale špatným heslem - chybová hláška")
    public void testBadPassword() throws InterruptedException {
        shopPage.openPage();
        shopPage.badPasswordOnPage();

    }

    @Test
    @DisplayName("Login do admina se špatným uživatelem - chybová hláška")
    public void testBadUser() throws InterruptedException {
        shopPage.openPage();
        shopPage.badUserOnPage();


    }

    @Test
    @DisplayName("Login do admina se správným uživatelem i heslem - ověření, že se admin otevřel")
    public void testAllFine() throws InterruptedException {
        shopPage.openPage();
        shopPage.fineUserOnPage();


    }

}
