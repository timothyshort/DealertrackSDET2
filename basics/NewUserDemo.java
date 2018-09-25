package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewUserDemo {

	public static void main(String[] args) {
		String name;
		String country = "Canada";
		String gender = "male";
		double phoneNumber = 888999;
		boolean weeklyEmail = true;
		boolean monthlyEmail = false;
		boolean occasionalEmail = false;

		System.setProperty("webdriver.gecko.driver", "C:\\DealerTrackTraining\\2018\\Software\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		// Go to URL
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

		// Click "Create Account"
		driver.findElement(By.linkText("Create Account".toUpperCase())).click();

		// Enter information
		// Normal textfield elements

		// Convert double to string
		driver.findElement(By.name("ctl00$MainContent$txtHomePhone")).sendKeys(String.valueOf(phoneNumber));

		// Radio button
		if (gender.equals("female")) {
			driver.findElement(By.id("MainContent_Female")).click();
		} else if (gender.equals("male")) {
			driver.findElement(By.id("MainContent_Male")).click();
		}

		// Select / Drop-Down menu
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText(country);

		// Checkbox
		selectCheckbox(weeklyEmail, By.id("MainContent_checkWeeklyEmail"), driver);
		selectCheckbox(monthlyEmail, By.id("MainContent_checkMonthlyEmail"), driver);
		selectCheckbox(occasionalEmail, By.id("MainContent_checkUpdates"), driver);

		// Click submit

		// Validate
	}

	// checkbox algorithm function
	private static void selectCheckbox(boolean checkbox, By checkboxElement, WebDriver driver) {
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
