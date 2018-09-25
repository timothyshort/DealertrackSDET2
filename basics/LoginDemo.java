package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginDemo {

	public static void main(String[] args) {
		// Configuration
		System.setProperty("webdriver.gecko.driver", "C:\\DealerTrackTraining\\2018\\Software\\geckodriver.exe");		
		
		// Open firefox
		WebDriver driver = new FirefoxDriver();
		
		// Enter URL
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		// Enter email address
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
		
		// Enter password: use "password"
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("password");
		
		// Click login
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}

}
