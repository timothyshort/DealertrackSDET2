package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	
	// This function returns a WebDriver browser
	public static WebDriver get(String browserType) {
		if (browserType.equalsIgnoreCase("firefox")) {
			System.out.println("***Launching FIREFOX Browser***");
			System.setProperty("webdriver.gecko.driver", "C:\\DealerTrackTraining\\2018\\Software\\geckodriver.exe");
			return new FirefoxDriver();
		}
		else if (browserType.equalsIgnoreCase("chrome")) {
			System.out.println("***Launching CHROME Browser");
			System.setProperty("webdriver.chrome.driver", "C:\\DealerTrackTraining\\2018\\Software\\chromedriver.exe");
			return new ChromeDriver();
		}
		else if (browserType.equalsIgnoreCase("ie")) {
			System.out.println("***Launching IE Browser");
			System.setProperty("webdriver.ie.driver", "C:\\DealerTrackTraining\\2018\\Software\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		else {
			System.out.println("***Could not interpret input. Launching Firefox as default");
			System.setProperty("webdriver.gecko.driver", "C:\\DealerTrackTraining\\2018\\Software\\geckodriver.exe");
			return new FirefoxDriver();
		}
	}

}
