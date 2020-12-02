package cz.czechitas;


import org.junit.jupiter.api.*;
import org.openqa.selenium.*;


/*

username: admin@shopizer.com
password: password

 */
public class AdminLoginTest {

    private static WebDriver driver;
    private static AdminLogin adminLogin;


    @BeforeEach
    public void before() {

        driver = DriverHelper.openChrome();
        //     WebDriver driver = new ChromeDriver();
        adminLogin = new AdminLogin(driver);
        driver.manage().window().maximize();
        //     driver.get(WebUrl);
        adminLogin.openPage();

    }

        @AfterEach
        public void after() {
            driver.quit();
        }

        @Test
        @DisplayName("Spravny uzivatel_spatne heslo")
        public void test1 () {
                                                
            adminLogin.writeName("admin@shopizer.com");
            adminLogin.writePassword("test1");
            adminLogin.clickButton();
            Assertions.assertEquals("Invalid username or password", adminLogin.getError());
        }

        @Test
        @DisplayName("Spatny uzivatel_spravne heslo")
        public void test2 () {

            adminLogin.writeName("test2@pokus.com");
            adminLogin.writePassword("password");
            adminLogin.clickButton();
            Assertions.assertEquals("Invalid username or password", adminLogin.getError());
        }

        @Test
        @DisplayName("Spravny uzivatel_spravne heslo")
        public void test3 () {

            adminLogin.writeName("admin@shopizer.com");
            adminLogin.writePassword("password");
            adminLogin.clickButton();
            WebElement adminPage = driver.findElement(By.className("icon-user"));
            Assertions.assertEquals(true, adminPage.isDisplayed());
        }

    }
