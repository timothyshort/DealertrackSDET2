package dealertrack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.DriverFactory;

public class AppTest {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		// Launch browser
		driver = DriverFactory.get("chrome");
		driver.get("https://uat.dealertrackcanada.com");
		
		// Define waits
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		
		// Login as DIO user
		Thread.sleep(3000);
		System.out.println("Logging in...");
		driver.findElements(By.name("username")).get(1).sendKeys("tshort");
		driver.findElements(By.name("password")).get(1).sendKeys("test1234");
		driver.findElement(By.id("_login")).click();
		System.out.println("  > Finished");
	}
	
	@Test
	public void checkDeal() {
		// Click "Status" link (Nav Frame)
		System.out.println("Clicking Status...");
		FrameHandling.change(driver, 0);
		driver.findElement(By.id("Status")).click();
		System.out.println("  > Finished");
		
		FrameHandling.change(driver, 1);
		
		String dealNumber = "10302915";
		String[] validStatus = { "AD", "AP" };
		
		// Extract all deals
		List<WebElement> deals = driver.findElements(By.xpath("//*[@id=\"divView3_datagridbody\"]/tr"));
		for (WebElement deal : deals) {
			System.out.println(deal.findElement(By.xpath("td[3]")).getText());
			String dealTable = deal.findElement(By.xpath("td[3]")).getText();
			if (dealNumber.equals(dealTable)) {
				// Extract validation photo image name from src attribute
				String imageName = deal.findElement(By.xpath("td[9]")).getAttribute("src");
				System.out.println(imageName);
				for (String validImageName : validStatus) {
					if (imageName.contains(validImageName)) {
						System.out.println("DEAL STATUS APPROVED!");
						break;
					}
				}
				System.out.println("TEST FAILED");
			}
		}
		
	}
	
	

	@Test(enabled=false)
	public void submitDeal() throws InterruptedException {
		// Click "Create App" link (Nav Frame)
		System.out.println("Clicking Create App...");
		FrameHandling.change(driver, 0);
		driver.findElement(By.id("PrepareApp")).click();
		System.out.println("  > Finished");
		
		//  Fill out the New App form (Main Frame)
		System.out.println("Filling out form...");
		FrameHandling.change(driver, 1);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ddAsset")));
		new Select(driver.findElement(By.id("ddAsset"))).selectByVisibleText("Automotive");
		wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.id("ddLenders"), By.tagName("option")));
		new Select(driver.findElement(By.id("ddLenders"))).selectByVisibleText("Hyundai Motor Finance");
		
		Thread.sleep(3500);
		new Select(driver.findElement(By.id("ddProduct"))).selectByVisibleText("Lease");
		Thread.sleep(3500);
		new Select(driver.findElement(By.id("ddApplicantType"))).selectByVisibleText("Consumer");
		Thread.sleep(3500);
		driver.findElement(By.id("btnSave")).click();
		System.out.println("  > Finished");
		
		// 4. Click Search under the applicants tab (Main Frame)
		System.out.println("Searching for applicant...");
		Thread.sleep(10000);
		FrameHandling.change(driver, 1);
		// wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl19_ctl18_ctl00_btnLoad")));
		driver.findElement(By.id("ctl19_ctl18_ctl00_btnLoad")).click();
		driver.findElement(By.id("txtNameLookup")).sendKeys("hort");
		driver.findElement(By.id("__input2")).click();
		wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.id("LoadApplicantSelect"), By.tagName("option")));
		new Select(driver.findElement(By.id("LoadApplicantSelect"))).selectByIndex(0);
		driver.findElement(By.id("DTC$ModalPopup$OK")).click();
		Thread.sleep(5000);
		
		// 8-9. Update Address & Employment to 4 years
		driver.findElement(By.id("ctl19_ctl21_ctl00_CDurationCurrentAddress_Y")).clear();
		driver.findElement(By.id("ctl19_ctl21_ctl00_CDurationCurrentAddress_Y")).sendKeys("4");
		driver.findElement(By.id("ctl19_ctl24_ctl00_CDurationCurrentEmployerAddress_Y")).clear();
		driver.findElement(By.id("ctl19_ctl24_ctl00_CDurationCurrentEmployerAddress_Y")).sendKeys("4");
		
		// 10. Click on Worksheet
		driver.findElement(By.id("ctl19_btnWORKSHEET")).click();
		Thread.sleep(7000);
		FrameHandling.change(driver, 1);
		
		// 11. Update Program Selection
		try {
			new Select(driver.findElement(By.id("ctl00_ddlProgram"))).selectByVisibleText("PD - Sept Program ");
		} catch (NoSuchElementException e) {
			System.out.println(">> Program - NO SPACE");
			new Select(driver.findElement(By.id("ctl00_ddlProgram"))).selectByVisibleText("PD - Sept Program");
		}
		driver.findElement(By.id("ctl00$txtMileage")).sendKeys("400");

	}
	
}
	











	/* development code
	 * 
	 * 
	 * 
	 * 
	 * // Initialize
		WebDriver driver = DriverFactory.get("Firefox");
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.get("https://uat.dealertrackcanada.com");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		// Login
		Thread.sleep(2000);
		System.out.println("Logging in...");
		driver.findElements(By.name("username")).get(1).sendKeys("tshort");
		driver.findElements(By.name("password")).get(1).sendKeys("test1234");
		driver.findElement(By.id("_login")).click();
		System.out.println(" DONE");
		
		// Switch to Nav Frame (frame 0)
		System.out.println("Switching Nav Frame...");
		FrameHandling.switchToFramesetFrame(driver, 0);
		System.out.println(" DONE");
		
		// Click on Submit New Application
		System.out.println("Click Create App...");
		driver.findElement(By.id("PrepareApp")).click();
		System.out.println(" DONE");
		
		// Switch to Main Frame (frame 1)
		System.out.println("Switching Frames to Main...");
		FrameHandling.switchToFramesetFrame(driver, 1);
		System.out.println(" DONE");
		
		// Fill Out Form Options for New App
		System.out.println("Filling out form options...");
		wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.id("ddAsset"), By.tagName("option")));
		new Select(driver.findElement(By.id("ddAsset"))).selectByVisibleText("Automotive");
		new Select(driver.findElement(By.id("ddLenders"))).selectByVisibleText("Hyundai Motor Finance");
		
		//wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.id("ddProduct"), By.tagName("option")));
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("ddProduct"))).selectByVisibleText("Lease");
		
		// wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.id("ddApplicantType"), By.tagName("option")));
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("ddApplicantType"))).selectByVisibleText("Consumer");
		
		driver.findElement(By.name("btnSave")).click();
		System.out.println(" DONE");
		
		// Populate Applicant
		Thread.sleep(10000);
		System.out.println("Switching Frames to Main");
		FrameHandling.switchToFramesetFrame(driver, 1);
		System.out.println(" DONE");
		System.out.println("Searching for Applicant");
		Thread.sleep(3000);
		WebElement searchLink = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Search"))));
		searchLink.click();
		driver.findElement(By.id("txtNameLookup")).sendKeys("hort");
		driver.findElement(By.id("__input2")).click();
		wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.id("LoadApplicantSelect"), By.tagName("option")));
		new Select(driver.findElement(By.id("LoadApplicantSelect"))).selectByIndex(0);
		driver.findElement(By.id("DTC$ModalPopup$OK")).click();
		System.out.println(" DONE");
		
				
		/*
		numOfFrames = driver.findElements(By.tagName("iframe")).size();
		System.out.println(numOfFrames);
		for (int i=0; i<numOfFrames; i++) {
			System.out.println(driver.switchTo().frame(i));
			System.out.println("Frame: " + i);
		}
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		WebElement loginForm = wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(By.name("username")).get(1)));	
		loginForm.sendKeys("tshort");
		ArrayList <WebElement> usernames = driver.findElements(By.name("username"));
		*/
