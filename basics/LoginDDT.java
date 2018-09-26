package basics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import utilities.DriverFactory;
import utilities.Screenshot;

public class LoginDDT {

	public static void main(String[] args) {
		String[] emails = { "montyscorp@gmail.com", "bademail@mail.com", "tim@testemail.com" };
		String[] passwords = { "Password1@", "password", "password"  };
		String[] expectedOutcome = { "pass", "fail", "pass" };
		String[] browserType = { "firefox", "firefox", "Firefox" };
		String url = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		String successMessage = "Logged in successfully";
		String failedMessage = "Invalid";
		
		// For loop to iterate through records
		for (int i=0; i<emails.length; i++) {
			System.out.println("\nTEST STARTING");
			System.out.println("Browser: " + browserType[i]);
			System.out.println("EMAIL: " + emails[i]);
			System.out.println("PASSWORD: " + passwords[i]);
			System.out.println("EXPECTATION: " + expectedOutcome[i]);
			
			// Initialize expected message
			String message = successMessage;
			if (expectedOutcome[i].equals("fail")) {
				message = failedMessage;
			}
			System.out.println(" MESSAGE: " + message);
			
			// Launch browser
			WebDriver driver = DriverFactory.get(browserType[i]);
			driver.get(url);
			
			// Fill out form
			driver.findElement(By.id("MainContent_txtUserName")).sendKeys(emails[i]);
			driver.findElement(By.id("MainContent_txtPassword")).sendKeys(passwords[i]);
			driver.findElement(By.id("MainContent_btnLogin")).click();
			
			// Verification
			if (driver.getPageSource().contains(message)) {
				System.out.println("TEST PASSED!");
				Screenshot.capture(driver, "login", "pass", emails[i]);
			}
			else {
				System.out.println("TEST FAILED!");
				Screenshot.capture(driver, "login", "fail", emails[i]);
			}
			System.out.println("**********");
			
			// Close browser
			driver.close();
		}
		
	}

}
