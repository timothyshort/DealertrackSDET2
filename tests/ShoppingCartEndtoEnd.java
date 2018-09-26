package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.shoppingcart.CartPage;
import pages.shoppingcart.ResultsPage;
import pages.shoppingcart.SearchPage;
import utilities.DriverFactory;

public class ShoppingCartEndtoEnd {
	
	WebDriver driver;
	String product = "tv";
	int rowSearchResult = 2;

	@Test
	public void test() {
		SearchPage.searchForProduct(driver, product);
		ResultsPage.addToCart(driver, rowSearchResult);
		CartPage.changeQuantity(driver, "3");
		
		// Checkout
		
		// Confirmation
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
