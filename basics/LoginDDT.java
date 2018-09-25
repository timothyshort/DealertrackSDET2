package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.DriverFactory;

public class LoginDDT {

	public static void main(String[] args) {
		String[] emails = { "tim@testemail.com", "bademail@mail.com", "montyscorp@gmail.com" };
		String[] passwords = { "password", "password", "Password1@" };
		String[] expectedOutcome = { "pass", "fail", "pass" };
		String[] browserType = { "chrome", "IE", "Firefox" };
		String url = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		String successMessage = "Logged in successfully";
		String failedMessage = "Invalid user name";
		
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
			}
			else {
				System.out.println("TEST FAILED!");
			}
			System.out.println("**********");
			
			// Close browser
			driver.close();
		}
		
	}

}
