package pages.AccountManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	// 1. Define all page elements
	@FindBy(name = "ctl00$MainContent$txtUserName")
	WebElement txtEmail;
	
	@FindBy(name = "ctl00$MainContent$txtPassword")
	WebElement txtPassword;
	
	@FindBy(name = "ctl00$MainContent$btnLogin")
	WebElement btnLogin;
	
	// 2. Define constructor
	// Initialize web elements
	// attach elements to current page
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// 3. Actions
	
	// login()
	public void login(String email, String password) {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
	
	// clickCreateAccount()
	
	// typeEmail()
	
	// typePassword()

}
