import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class StandardUserTest extends SauceDemoTest {

    @Test
    public void testStandardUserPurchase() {
        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Reset App State
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("reset_sidebar_link")).click();

        // Add 3 Items to Cart
        List<WebElement> items = driver.findElements(By.className("inventory_item"));
        for (int i = 0; i < 3; i++) {
            items.get(i).findElement(By.className("btn_inventory")).click();
        }

        // Go to Cart and Checkout
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();

        // Fill in checkout information
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();

        // Verify product names and total price
        List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));
        Assert.assertEquals("Incorrect number of products in cart", 3, productNames.size());

        String totalPrice = driver.findElement(By.className("summary_total_label")).getText();
        Assert.assertTrue("Total price is incorrect", totalPrice.contains("$"));

        // Finish Purchase
        driver.findElement(By.id("finish")).click();
        String successMessage = driver.findElement(By.className("complete-header")).getText();
        Assert.assertTrue("Order success message not displayed", successMessage.contains("THANK YOU FOR YOUR ORDER"));

        // Reset App State and Logout
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("reset_sidebar_link")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
    }
}
