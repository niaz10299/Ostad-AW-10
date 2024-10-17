import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the ChromeDriver path or use WebDriverManager
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testLockedOutUserLogin() {
        // Attempt login with locked_out_user
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Verify error message
        String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assert.assertTrue("Error message not displayed correctly!", errorMessage.contains("Epic sadface"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
