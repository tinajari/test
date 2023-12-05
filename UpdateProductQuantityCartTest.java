import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UpdateProductQuantityCartTest {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        // Configure Chrome Options for headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        // Set the path to your Chrome driver executable
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void testUpdateProductQuantityCart() throws InterruptedException {
        // Navigate to the application URL
        driver.get("http://54.251.186.47");

        // Add product to cart (assuming product is already added)

        // Open the cart page
        driver.findElement(By.id("cart-link")).click();

        // Enter new quantity for an item
        driver.findElement(By.cssSelector(".cart-item[data-name='EverGlide Portable Bluetooth Speaker'] input[type='number']")).clear();
        driver.findElement(By.cssSelector(".cart-item[data-name='EverGlide Portable Bluetooth Speaker'] input[type='number']")).sendKeys("3");

        // Click on "Update" button
        driver.findElement(By.cssSelector(".cart-item[data-name='EverGlide Portable Bluetooth Speaker'] button[type='submit']")).click();

        // Verify the cart total price is updated accordingly
        String price = driver.findElement(By.cssSelector(".cart-total")).getText();
        Assert.assertTrue(price.contains("updated_price"));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
