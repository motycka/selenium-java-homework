package cz.czechitas;

import org.junit.jupiter.api.*;
import org.omg.CORBA.DynAnyPackage.*;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import static java.lang.Thread.*;
import static org.junit.jupiter.api.Assertions.*;

public class TemplateTest {

    private static WebDriver driver;
    private static ShopPage AdminUrlLogin;

    private final int maxWaitInSeconds= 10;

    @BeforeEach
    public void before() {
        driver = DriverHelper.openFirefox();
        AdminUrlLogin = new ShopPage(driver);
        AdminUrlLogin.openPage();
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    @DisplayName ("Admin login failed, wrong password")
    public void testAdminlogin1() {
       AdminUrlLogin.ValidUsernameAdminLogin();
       AdminUrlLogin.InValidPasswordAdminLogin();
       AdminUrlLogin.ConfirmAdminLogin();

       //čekání
       WebElement Waiting = new WebDriverWait(driver,maxWaitInSeconds)
               .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"logon\"]/div[1]/div")));

       WebElement loginfailmessage =driver.findElement(By.xpath("//*[@id=\"logon\"]/div[1]/div"));
       assertTrue(loginfailmessage.isDisplayed(),"Failmessage should be displayed");
    }
    

    @Test
    @DisplayName ("Admin login failed, wrong username")
    public void testAdminlogin2() {
        AdminUrlLogin.InValidUsernameAdminLogin();
        AdminUrlLogin.ValidPasswordAdminLogin();
        AdminUrlLogin.ConfirmAdminLogin();

        WebElement Waiting = new WebDriverWait(driver,maxWaitInSeconds)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"logon\"]/div[1]/div")));

        WebElement loginfailmessage =driver.findElement(By.xpath("//*[@id=\"logon\"]/div[1]/div"));
        assertTrue(loginfailmessage.isDisplayed(),"Failmessage should be displayed");
    }

    @Test
    @DisplayName ("Admin login successful")
    public void testAdminlogin3() {
        AdminUrlLogin.ValidUsernameAdminLogin();
        AdminUrlLogin.ValidPasswordAdminLogin();
        AdminUrlLogin.ConfirmAdminLogin();
    }

}
