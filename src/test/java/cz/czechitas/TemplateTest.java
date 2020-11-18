package cz.czechitas;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import static org.junit.jupiter.api.Assertions.*;

public class TemplateTest {

    private static WebDriver driver;
    private static LoginAdmin webovaStranka;
    private static String chybHlaska = "Invalid username or password";
    private static String prihlasenAdmin = "admin@shopizer.com";

    @BeforeEach
    public void before() {
        driver = DriverHelp.openChrome();
        webovaStranka = new LoginAdmin(driver);
        webovaStranka.otevriWeb();
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    @DisplayName("ověrení chybové hlášky - login admin - spravný uživatel, špatné heslo")
    public void test1() {
        webovaStranka.vyplnUsername("admin@shopizer.com");
        webovaStranka.vyplnHeslo("heslicko");
        webovaStranka.klikLogon();
        assertEquals(chybHlaska, webovaStranka.chybovaHlaska(), "chybná chybová hláška");
    }

    @Test
    @DisplayName("ověrení chybové hlášky - login admin - špatný uživatel, správné heslo")
    public void test2() {
        webovaStranka.vyplnUsername("adminek@shopizer.com");
        webovaStranka.vyplnHeslo("password");
        webovaStranka.klikLogon();
        assertEquals(chybHlaska, webovaStranka.chybovaHlaska(), "špatná chybová hláška");
    }

    @Test
    @DisplayName("správné přihlášení admina - správný uživatel, správné heslo")
    public void test3() {
        webovaStranka.vyplnUsername("admin@shopizer.com");
        webovaStranka.vyplnHeslo("password");
        webovaStranka.klikLogon();
        assertEquals(prihlasenAdmin, webovaStranka.admin(), "po přihlášení se nezobrazí stránka admina ");
    }

}
