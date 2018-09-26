package pages.shoppingcart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	
	// changeQuantity()
	public static void changeQuantity(WebDriver driver, String newQuantity) {
		// Update quantity
		driver.findElement(By.name("txtItemQty1")).clear();
		driver.findElement(By.name("txtItemQty1")).sendKeys(newQuantity);
		// Recalculate order
		driver.findElement(By.id("Recalc")).click();
	}
	
	// clickCheckout()
	
	
	// clickAddMoreProducts()

}
