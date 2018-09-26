package pages.shoppingcart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage {
	
	public static void addToCart(WebDriver driver, int rowChoice) {
		driver.findElement(By.xpath("/html/body/font/table[1]/tbody/tr[" + rowChoice +"]/td[3]/a")).click();
	}

}
