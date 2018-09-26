package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	
	// Overloading with multiple parameters
	public static void capture(WebDriver driver, String testCase, String testResult, String name) {
		String dir = testCase + "-" + testResult + "-" + name;
		capture(driver, dir);
	}
	
	// Default screenshot capture
	public static void capture(WebDriver driver, String name) {
		// Screenshot: imports: java.io (for File) and selenium.TakesScreenshot (for screenshot)
		File scrnshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String filename = "C:\\DealerTrackTraining\\2018\\TestResults\\" + name + ".jpg";
		File destScrnshot = new File(filename);
		System.out.println("**Taking Screenshot**");
		try {
			FileUtils.copyFile(scrnshot, destScrnshot);
		} catch (IOException e) {
			System.out.println("Error generating screenshot");
			e.printStackTrace();
		}
	}

}
