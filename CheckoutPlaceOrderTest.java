import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckoutPlaceOrderTest {

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
    public void testCheckoutPlaceOrder() throws InterruptedException {
        // Navigate to the application URL
        driver.get("http://54.251.186.47");

        // Add product to cart (assuming product is already added)

        // Open the cart page
        driver.findElement(By.id("cart-link")).click();

        // Click on "Proceed to Checkout" button
        driver.findElement(By.id("checkout-button")).click();

        // Enter valid shipping information
        driver.findElement(By.id("name")).sendKeys("test");
        driver.findElement(By.id("address")).sendKeys("test");
        driver.findElement(By.id("city")).sendKeys("Islamabad");
        driver.findElement(By.id("state")).sendKeys("Islamabad");
        driver.findElement(By.id("zip")).sendKeys("44000");

        // Select a payment method
        driver.findElement(By.id("payment-method")).click();
        driver.findElement(By.id("payment-method-option")).click();

        // Click on "Place Order" button
        driver.findElement(By.id("place-order-button")).click();

        // Verify a success message and order confirmation is displayed
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-success")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".order-confirmation")).isDisplayed());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}