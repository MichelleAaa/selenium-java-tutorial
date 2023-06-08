package testcases;

//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
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
		 String title = driver.getTitle(); // no matter the title, even if it's numbers, the return type of getTitle will be string.
		
		 System.out.println(title);
		 System.out.println(title.length());
		 
		 String expectedTitle = "Google.com";
		 
		 if(title.equals(expectedTitle)) {
			 System.out.println("Test case passed");
		 } else {
			 System.out.println("Test case failed");
		 }
		 
		 driver.quit();
	}

}
