package pages.shoppingcart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

	public static void searchForProduct(WebDriver driver, String product) {
		driver.findElement(By.name("txtSearch")).sendKeys(product);
		driver.findElement(By.id("Go")).click();
	}
	
}
