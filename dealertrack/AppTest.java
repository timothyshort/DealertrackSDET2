package dealertrack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DriverFactory;

public class AppTest {

	public static void main(String[] args) throws InterruptedException {
		// Launch browser
		WebDriver driver = DriverFactory.get("firefox");
		driver.get("https://uat.dealertrackcanada.com");
		
		// Define waits
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		// 1. Login as DIO user
		Thread.sleep(3000);
		System.out.println("Logging in...");
		driver.findElements(By.name("username")).get(1).sendKeys("tshort");
		driver.findElements(By.name("password")).get(1).sendKeys("test1234");
		driver.findElement(By.id("_login")).click();
		System.out.println("  > Finished");
		
		// 2. Click "Create App" link (Nav Frame)
		System.out.println("Clicking Create App...");
		FrameHandling.change(driver, 0);
		driver.findElement(By.id("PrepareApp")).click();
		System.out.println("  > Finished");
		
		
		// 3. Fill out the New App form (Main Frame)
		System.out.println("Filling out form...");
		FrameHandling.change(driver, 1);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ddAsset")));
		new Select(driver.findElement(By.id("ddAsset"))).selectByVisibleText("Automotive");
		wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.id("ddLenders"), By.tagName("option")));
		new Select(driver.findElement(By.id("ddLenders"))).selectByVisibleText("Hyundai Motor Finance");
		wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.id("ddProduct"), By.tagName("option")));
		new Select(driver.findElement(By.id("ddProduct"))).selectByVisibleText("Lease");
		wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.id("ddApplicantType"), By.tagName("option")));
		new Select(driver.findElement(By.id("ddApplicantType"))).selectByVisibleText("Consumer");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));
		driver.findElement(By.id("btnSave")).click();
		System.out.println("  > Finished");
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
