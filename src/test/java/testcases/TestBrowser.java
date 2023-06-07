package testcases;

//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowser {

	public static void main(String[] args) {

//		Chrome:
//		WebDriverManager.chromedriver().setup(); // We don't need to add the chrome exe file when we use the WebDriverManager.
//		ChromeDriver driver = new ChromeDriver();
//		
		
//		Firefox:
//		WebDriverManager.firefoxdriver().setup(); 
//		FirefoxDriver driver = new FirefoxDriver();
		
		
//		Edge:
		WebDriverManager.edgedriver().setup(); 
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://www.google.com");
		driver.quit();
	}

}
