package testframeworks;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.DriverFactory;

public class TestNGDemo {
	
	WebDriver driver;
	
	@Test
	public void testDemo() {
		System.out.println("Executing test");
		driver.get("http://www.google.com");
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Initializing...");
		driver = DriverFactory.get("Firefox");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing...");
		driver.close();
	}

}
