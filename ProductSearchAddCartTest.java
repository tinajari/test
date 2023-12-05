import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProductSearchAddCartTest {

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
    public void testProductSearchAddCart() throws InterruptedException {
        // Navigate to the application URL
        driver.get("http://54.251.186.47");

        // Enter product name in the search bar
        driver.findElement(By.id("search-bar")).sendKeys("EverGlide Portable Bluetooth Speaker");

        // Click on the search button
        driver.findElement(By.id("search-button")).click();

        // Verify the searched product is displayed
        Assert.assertTrue(driver.findElement(By.cssSelector(".product-card[data-name='EverGlide Portable Bluetooth Speaker']")).isDisplayed());

        // Click on the product image or title to view details
        driver.findElement(By.cssSelector(".product-card[data-name='EverGlide Portable Bluetooth Speaker']")).click();

        // Select desired quantity
        driver.findElement(By.id("quantity")).sendKeys("2");

        // Click on "Add to Cart" button
        driver.findElement(By.id("add-to-cart")).click();

        // Verify a success message is displayed
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-success")).isDisplayed());

        // Open the cart and verify the added product
        driver.findElement(By.id("cart-link")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(".cart-item[data-name='EverGlide Portable Bluetooth Speaker']")).isDisplayed());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
