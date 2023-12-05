import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomepageLoadTimeTest {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        // Configure Chrome Options for headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        // Set the path to your Chrome driver executable
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        driver = new ChromeDriver(options);
    }

    @Test
    public void testHomepageLoadTime() {
        long startTime = System.currentTimeMillis();

        // Navigate to the application URL
        driver.get("http://54.251.186.47");

        // Wait for page to load completely
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("main-content")));

        long endTime = System.currentTimeMillis();

        // Calculate and display load time
        long loadTime = endTime - startTime;
        System.out.println("Homepage load time: " + loadTime + " milliseconds");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
