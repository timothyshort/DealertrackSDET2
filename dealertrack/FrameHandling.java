package dealertrack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHandling {
	
	public static void change(WebDriver driver, int index) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.tagName("frameset")).findElements(By.tagName("frame")).get(index));		
	}
	
	
	

	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	/*
	public static void switchToFramesetFrame(WebDriver driver, int index) {
		// driver.navigate().refresh();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		// driver.navigate().refresh();
		driver.switchTo().frame(driver.findElement(By.tagName("frameset")).findElements(By.tagName("frame")).get(index));
	}
	
	public static void switchToFramesetFrame(WebDriver driver, String text) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		for (WebElement frame : driver.findElement(By.tagName("frameset")).findElements(By.tagName("frame"))) {
			driver.switchTo().frame(frame);
			if (frame.getText().contains("text")) {
				break;
			}
		}
	}
	*/
