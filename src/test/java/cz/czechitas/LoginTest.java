package cz.czechitas;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

public class LoginTest {

    private static WebDriver driver;
    private static LoginPage LoginPage;


    @BeforeEach
    public void before() {
        driver = DriverHelper.openFirefox();
        LoginPage= new LoginPage(driver);
        LoginPage.openPage();
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    @Test
    @DisplayName("Login with valid user name but wrong password")
    /*Login do admina se správným uživatelem, ale špatným heslem - ověřte chybovou hlášku*/
    public void testInvalidLogin1() {
        //Login to application
        LoginPage.loginToLoginPage("admin@shopizer.com", "pass");
        
        //verify error message
        Assertions.assertEquals("Invalid username or password", LoginPage.getErrorMessage(), "Try again with valid data");

    }


    @Test
    @DisplayName("Login with valid user name but wrong password")
    /*Login do admina se správným uživatelem, ale špatným heslem - ověřte chybovou hlášku*/
    public void testInvalidLogin2() {
        //Login to application
        LoginPage.loginToLoginPage("admin@", "password");
        //verify error message
        Assertions.assertEquals("Invalid username or password", LoginPage.getErrorMessage(), "Try again with valid data");
    }

    @Test
    @DisplayName("Login with valid data")
    /*Login with the correct username and password - verify that the admin has opened.*/
    public void testValidLogin(){

        LoginPage.loginToLoginPage("admin@shopizer.com", "password");
       Assertions.assertEquals("admin@shopizer.com", LoginPage.getAdminIcon(), "You are logged in");

    }

}