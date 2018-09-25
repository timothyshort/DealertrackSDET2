package basics;

import org.openqa.selenium.WebDriver;

import utilities.DriverFactory;

public class LoginDDT {

	public static void main(String[] args) {
		String[] emails = { "tim@testemail.com", "bademail@mail.com", "montyscorp@gmail.com" };
		String[] passwords = { "password", "password", "Password1@" };
		String[] expectedOutcome = { "pass", "fail", "pass" };
		String[] browserType = { "chrome", "IE", "Firefox" };
		
		// For loop to iterate through records
		for (int i=0; i<emails.length; i++) {
			System.out.println("\nTEST STARTING");
			System.out.println("Browser: " + browserType[i]);
			System.out.println("EMAIL: " + emails[i]);
			System.out.println("PASSWORD: " + passwords[i]);
			System.out.println("EXPECTATION: " + expectedOutcome[i]);
		}
		
	}

}
