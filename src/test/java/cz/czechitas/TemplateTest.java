package cz.czechitas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TemplateTest {

    public static WebDriver driver;
    public static AdminLoginPage adminLoginPage;
//    private static final String loginUrl = Settings.baseUrl + "/admin/";



    @BeforeEach
    public void before() {
        driver = DriverHelper.openFirefox();
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.openPage();
        //       adminLoginPage.wait(2000);

    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    @DisplayName("The password is not correct")
    public void test1() {
        adminLoginPage.doLogin("admin@shopizer.com", "xxx");
        try {
            adminLoginPage.wait(2000);
        } catch (Exception e) {}
    }

    @Test
    @DisplayName("The login is not correct")
    public void test2() {
        adminLoginPage.doLogin("some@example.com", "password");
        try {
            adminLoginPage.wait(2000);
        } catch (Exception e) {}
    }

    @Test
    @DisplayName("Successful")
    public void test3() {
        adminLoginPage.doLogin("admin@shopizer.com","password");
        try {
            adminLoginPage.wait(2000);
        } catch (Exception e) {}
    }



}
