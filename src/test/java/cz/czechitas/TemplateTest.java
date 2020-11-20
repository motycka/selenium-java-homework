package cz.czechitas;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

import java.lang.*;
import java.lang.String;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemplateTest {

    private static final String shopUrl = Settings.baseUrl + "/shop/";
    private static WebDriver driver;

    @BeforeEach
    public void before() {
        driver = DriverHelper.openFirefox();
        driver.navigate().to(shopUrl);

    }

    @AfterEach
    public void after() {
        driver.quit();

    }

    @Test
    @DisplayName("Login admin správný uživatel-špatné heslo")
    public void test() {
        WebElement searchField = driver.findElement(By.id("username"));
        searchField.sendKeys("admin@shopizer.com");
        WebElement searchField2 = driver.findElement(By.id("password"));
        searchField2.sendKeys("heslo");
        WebElement searchButton = driver.findElement(By.id("formSubmitButton"));
        searchButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]/div")));

        assertEquals(driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div")).getText(), "Invalid username or password");

        System.out.println("PASS");

        //varianta porovnání adresy
        //String actualUrl="http://czechitas-shopizer.azurewebsites.net/admin/logon.html?login_error=true";
        //String expectedUrl= driver.getCurrentUrl();

    }

    @Test
    @DisplayName("Login admin špatný uživatel-správné heslo")
    public void test2() {
        WebElement searchField = driver.findElement(By.id("username"));
        searchField.sendKeys("admin@admin.com");
        WebElement searchField2 = driver.findElement(By.id("password"));
        searchField2.sendKeys("password");
        WebElement searchButton = driver.findElement(By.id("formSubmitButton"));
        searchButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]/div")));

        assertEquals(driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div")).getText(), "Invalid username or password");
        System.out.println("PASS");

        //varianta porovnání adresy
        // String actualUrl="http://czechitas-shopizer.azurewebsites.net/admin/logon.html?login_error=true";
        // String expectedUrl= driver.getCurrentUrl();

        // assertEquals(expectedUrl,actualUrl);

        //String actualUrl="http://czechitas-shopizer.azurewebsites.net/admin/logon.html?login_error=true";
        //String expectedUrl= driver.getCurrentUrl();

    }

    @Test
    @DisplayName("Login admin správný uživatel-správné heslo")
    public void test3() {
        WebElement searchField = driver.findElement(By.id("username"));
        searchField.sendKeys("admin@shopizer.com");
        WebElement searchField2 = driver.findElement(By.id("password"));
        searchField2.sendKeys("password");
        WebElement searchButton = driver.findElement(By.id("formSubmitButton"));
        searchButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[1]/a")));

        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, "http://czechitas-shopizer.azurewebsites.net/admin/home.html");

    }

}
