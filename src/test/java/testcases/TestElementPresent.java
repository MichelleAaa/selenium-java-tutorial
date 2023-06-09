package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestElementPresent {
	
	public static WebDriver driver; //To use driver inside a method, we have to declare it globally.
	
	
//	Note that witht his method you can only use it for xpaths. If you were going to use id's, names, etc. you may need more methods. 
	public static boolean isElementPresent(String xpath) {
// one option:
//		try {
//		driver.findElement(By.xpath(xpath));
//		return true;
//		} catch(Throwable t) {
//			return false;
//		}
		
//		Another option:
		int size = driver.findElements(By.xpath(xpath)).size();
		
		if(size == 0) {
			return false;
		} else {
			return true;
		}
	}

	// This way will allow multiple selectors, such as id, name, xpath, etc.
	public static boolean isElementTypePresent(By by) {
		
	//	Another option:
		int size = driver.findElements(by).size();
		
		if(size == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://echoecho.com/htmlforms11.htm");
//		driver.manage().window().maximize();//maximize the screen.
		
//		IMPLICIT WAIT:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println(driver.findElement(By.xpath("//td[3]/select")).isDisplayed());//This will tell us if the element is there or not on the page.
		
		System.out.println(isElementPresent("//td[5]/select"));
		
		System.out.println(isElementTypePresent(By.name("dropdownmenu"))); // Now we can pass in By.name, By.id, etc. and we don't need to create multiple methods.
		
		driver.quit();

	}

}
