package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://echoecho.com/htmlforms11.htm");
		driver.manage().window().maximize();//maximize the screen.
		
//		IMPLICIT WAIT:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[1]/tbody/tr/td/table/tbody/tr[2]/td[3]/select")).sendKeys("Cheese");
		
//		It's standard for a dropdown list to be a select tag, and all the options are inside of options tag. 
//		For some sites as you type entries  show up. Those entries are typically not in select/option tags, they are in p tags or something like that. (The auto fill as type options that populate).
		
		
		
		
		driver.quit();

	}

}
