package testcases;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTabsAndPopups {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://the-internet.herokuapp.com/windows");	
//		IMPLICIT WAIT:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.linkText("Click Here")).click();//here we are clicking on a link that opens a new window.
		
		Set<String> windowIds = driver.getWindowHandles();//This will provide the window ids of all open windows in the current session. (aka the tabs that are open in this browser.)-- after we clicked above, another tab opened, so there should be two ids.
//		Window ids are always unique so we are using set instead of list.
		Iterator<String> iterator = windowIds.iterator();
		
		iterator.next();//next returns a string. -- it provides the first value in the Set. -- If you want to get the second index, you can write this phrase iterator.next(); again. And so on.
		String firstWindow = iterator.next();//second window.
		System.out.println(firstWindow);
		
		String secondWindow = iterator.next();//here we are switching to the next window, which is the new window opened after the link was clicked.
		
		driver.switchTo().window(secondWindow);
		
		driver.findElement(By.xpath("/html/body/div/h3")).getText();
		
//		NEEDS EDITS:
		
//		driver.close();//Becuase we are in the second window, this will close that 2nd window.
//		note that even if we close the 2nd window, selenium doesn't automatically move the focus to the first window. You have to switch to the window.
//		driver.switchTo().window(firstWindow);
		
		driver.switchTo().defaultContent();//This will also move you to the main window.
		

		driver.close();
		
//		Another option is driver.quit(), as that will close all tabs.
	}

}
