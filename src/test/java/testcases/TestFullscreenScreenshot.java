package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.TakesScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFullscreenScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		Chrome Specific:
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("headless");//This asks the browser to mount in a headless mode -- meaning you won't see the browser. (The screenshot will still be captured in headless mode.)

//		Chrome:
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		
//		Firefox:
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		
		driver.get("http://qa.way2automation.com");
		driver.manage().window().maximize();
		
		if(driver instanceof FirefoxDriver) {

			File screenshot = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile(screenshot, new File(".//screenshot//firefoxFullScreenshot.jpg")); // note that the entire page screenshot isn't available in TakeScreenshot, it's avaialble in FirefoxDriver.
			
		} else if(driver instanceof ChromeDriver) {
//			This only gives a screenshot of the current view of the page, (such as the top section of the page) not the entire page:
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile(screenshot, new File(".//screenshot//ChromeScreenshot.jpg"));
//			When you are working with chrome you may not be able to get the full screenshot.
			
		}

		
	}

}
