package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkbox {
	
	// This function takes boolean value for a checkbox item and the checkbox web element
	// and determines whether or not to click, and then takes the appropriate action
	public static void selectCheckbox(boolean checkbox, By checkboxElement, WebDriver driver) {
		if (checkbox) {
			if (!driver.findElement(checkboxElement).isSelected()) {
				driver.findElement(checkboxElement).click();
			}
		} else {
			if (driver.findElement(checkboxElement).isSelected()) {
				driver.findElement(checkboxElement).click();
			}
		}
	}

}
