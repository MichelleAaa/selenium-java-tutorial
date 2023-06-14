package testcases;

import java.util.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import java.util.Optional;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestDeviceMetrics {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		
//		This sets the device size. Here we are using an iPhone sized screen: - OPTION 1:
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty())); // Optional.empty() is a placeholder that has to be put in fields that are optional which you don't want to use.
		
		
//		OPTION 2:
		Map<String,Object> deviceMetrics = new HashMap<String,Object>()
		{{
			put("width",600);
			put("height", 1000);
			put("mobile", true);
			put("deviceScaleFactor", 50);
		}}; 
		
		((ChromeDriver) driver).executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics); // you have to click on the error and select to add a cast. 

		
		driver.get("https://selenium.dev");
		
	}

}
