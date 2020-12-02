package cz.czechitas;

        import org.junit.jupiter.api.*;
        import org.openqa.selenium.*;

public class TemplateTest {

    private static WebDriver driver;
    private static LoginPage objLoginPage;
    private static AdminPage objAdminPage;


    @BeforeEach
    public void before() {
        driver = DriverHelper.openFirefox();
        objLoginPage= new LoginPage(driver);
        objLoginPage.openPage();
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
        objLoginPage.loginToLoginPage("admin@shopizer.com", "pass");
        
        //verify error message
       Assertions.assertTrue(objLoginPage.getErrorMessage().contains("Invalid username or password"), "Invalid username or password");

    }


    @Test
    @DisplayName("Login with valid user name but wrong password")
    /*Login do admina se správným uživatelem, ale špatným heslem - ověřte chybovou hlášku*/
    public void testInvalidLogin2() {
        //Login to application
        objLoginPage.loginToLoginPage("admin@", "password");

        //verify error message
        Assertions.assertTrue(objLoginPage.getErrorMessage().contains("Invalid username or password"), "Invalid username or password");
    }

    @Test
    @DisplayName("Login with valid data")
    /*Login with the correct username and password - verify that the admin has opened.*/
    public void testValidLogin(){

        objLoginPage.loginToLoginPage("admin@shopizer.com", "password");
        Assertions.assertEquals(objAdminPage.getUrl(), driver.getCurrentUrl(), "You are logged in");
    }

}