package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowser2 {
	
	public static String browser = "chrome";
	public static WebDriver driver; //If we only were using Chrome, we would write ChromeDriver driver. But in this case we may need any of the browsers listed below. Instead of listing one of the browserdrivers, we are listing RemoteWebDriver so we can access any of the the browser drivers. -- RemoteWebDriver is a parent class of all of them. -- you can use RemoteWebDriver or WebDriver. -- Whenever you want to switch between browsers it's ideal to use WebDriver.
//	SearchContext is at the top. The child is WebDriver, which extends SearchContext. Then RemoteWebDriver is the child of WebDriver, which implements WebDriver. Then under RemoteWebDriver are the child classes, like FirefoxDriver, ChromeDriver, etc. classes.

	public static void main(String[] args) {
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup(); 
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup(); 
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup(); 
			driver = new EdgeDriver(); 
		}

		driver.get("http://www.google.com");
		 String title = driver.getTitle(); // no matter the title, even if it's numbers, the return type of getTitle will be string.
		
		 System.out.println(title);
		 System.out.println(title.length());
		 
		 String expectedTitle = "Google";
		 
		 if(title.equals(expectedTitle)) {
			 System.out.println("Test case passed");
		 } else {
			 System.out.println("Test case failed");
		 }
		 
		 driver.quit();
	}

}
