package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNewWindowAndTabs {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://way2automation.com");	
//		IMPLICIT WAIT:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		Open a new tab:
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("Hello");
		
//		Open a new window:
		driver.switchTo().newWindow(WindowType.WINDOW);//this will open a new window.
		driver.get("http://gmail.com");

		System.out.println(driver.getWindowHandles().size());//Check how many windows are open. -- this returns 3 because we have two tabs and an additional tab in it's own window.
		
	}

}
