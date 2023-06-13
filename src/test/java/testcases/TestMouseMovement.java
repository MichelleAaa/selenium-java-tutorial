package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMouseMovement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://way2automation.com");
		driver.manage().window().maximize();//maximize the screen.
		
//		IMPLICIT WAIT:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		MOUSEOVER:
		WebElement menu = driver.findElement(By.xpath("//*[@id=\"menu-item-27580\"]/a/span[2]"));
		
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform(); //The moveToElement is a hover method that will move the mouse over that element. 
//		Note that the action won't happen until you chain on perform().
//		Once the action has been performed, the html elements that are in the hover menu will be accessible for targeting.
//		You won't see the mouse moving, but it will go to the element specified.
		
		driver.findElement(By.linkText("Lifetime Membership"));


	}

}
