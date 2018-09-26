package basics;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.DriverFactory;

public class ShoppingCart {
	
	WebDriver driver;
	String product = "tv";
	
	@Test
	public void shoppingCartTest() {
		// 1. Search for product
		driver.findElement(By.name("txtSearch")).sendKeys(product);
		driver.findElement(By.id("Go")).click();
		// Assert that we see <phones> on this page
		
		// 2. Add product to cart
		// driver.findElement(By.id("btnApple_Iphone_6.jpg")).click();
		// driver.findElement(By.xpath("//*[@id=\"btnPanasonic_65in_Viera_Plasma_TC-P65S1.jpg\"]")).click();
		driver.findElement(By.xpath("/html/body/font/table[1]/tbody/tr[1]/td[3]/a")).click();
		
		// 3. Modify cart (if necessary)
		driver.findElement(By.cssSelector("input[name='cmdSubmit'][value='Proceed to Checkout']")).click();
		
		// 4. Checkout (payment)
		// Extract the grand total
		String totalCharge = driver.findElement(By.xpath("html/body/font/form/table[2]/tbody/tr[5]/td[2]/font")).getText();
		System.out.println("TOTAL CHARGE: " + totalCharge);
		driver.findElement(By.cssSelector("input[value='Submit Order']")).click();
		
		// 5. Confirmation
		String confMessage = driver.findElement(By.xpath("/html/body/font")).getText();
		// System.out.println(confMessage);
		
		// Extract order number from message
		Pattern r = Pattern.compile("Order# (.*) safe"); // describe pattern
		Matcher m = r.matcher(confMessage); // using java regex library
		m.find();
		String confNumber = m.group(1);
		System.out.println("ORDER NUMBER: " + confNumber);
	}
	
	@BeforeMethod
	public void setup() {
		driver = DriverFactory.get("Firefox");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://sdettraining.com/online/default.asp");
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}

}
