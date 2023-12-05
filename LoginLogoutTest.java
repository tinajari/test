import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginLogoutTest {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        // Configure Chrome Options for headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        // Set the path to your Chrome driver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void testLoginLogout() throws InterruptedException {
        // Navigate to the application URL
        driver.get("http://54.251.186.47");

        // Enter username and password
        driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.id("password")).sendKeys("test");

        // Click on the Login button
        driver.findElement(By.id("login-button")).click();

        // Verify successful login by checking username on the dashboard
        String username = driver.findElement(By.id("user-name")).getText();
        Assert.assertEquals(username, "Your Username");

        // Click on the Logout button
        driver.findElement(By.id("logout-button")).click();

        // Verify successful logout by checking the login page
        Assert.assertTrue(driver.findElement(By.id("login-form")).isDisplayed());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
