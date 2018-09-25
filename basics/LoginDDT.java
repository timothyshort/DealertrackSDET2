package basics;

import org.openqa.selenium.WebDriver;

import utilities.DriverFactory;

public class LoginDDT {

	public static void main(String[] args) {
		// Fetch browser from framework
		WebDriver driver = DriverFactory.get("ie");
	}

}
