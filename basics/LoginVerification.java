package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginVerification {

	public static void main(String[] args) {
		String email = "bademail@testemail.com";
		String resultMessage = "Invalid User name, try again!";
		
		// Setup browser
		System.setProperty("webdriver.gecko.driver", "C:\\DealerTrackTraining\\2018\\Software\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		System.out.println("Page Title: " + driver.getTitle());
		
		// Login to the application
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(email);
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("password");
		driver.findElement(By.id("MainContent_btnLogin")).click();
		
		// Verify a successful login
		
		// Method 1: Look for an element
		/*
		if (confMessage.equals("Logged in successfully")) {
			System.out.println("TEST PASSED");
		}
		*/
		
		// Method 2: Implement try-catch
		/*
		try {
			String confMessage = driver.findElement(By.id("conf_message")).getText();
			System.out.println("TEST PASSED");
		} catch (NoSuchElementException e) {
			System.out.println("TEST FAILED");
		}
		*/
		
		// Method 3: Get page source
		if (driver.getPageSource().toLowerCase().contains(resultMessage.toLowerCase())) {
			System.out.println("TEST PASSED");
		} else {
			System.out.println("TEST FAILED");
		}

	}

}
