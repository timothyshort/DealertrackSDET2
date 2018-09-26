package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AccountManagement.HomePage;
import utilities.Configurations;
import utilities.DriverFactory;

public class LoginEndtoEnd {
	
	WebDriver driver;
	String email = "tim@testemail.com";
	String password = "password";
	
	@Test
	public void test() {
		// Create the HomePage object and call login()
		HomePage home = new HomePage(driver);
		home.login(email, password);
	}
	
	
	@BeforeMethod
	public void setup() {
		driver = DriverFactory.get("Firefox");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(Configurations.ACCOUNTMANAGEMENT_URL);
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}

}
