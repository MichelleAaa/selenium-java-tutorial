package testcases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAlert {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
//		driver.manage().window().maximize();//maximize the screen.
		
//		IMPLICIT WAIT:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.findElement(By.name("proceed")).click();
		//Here we are trying to click on proceed without filling in the username/password. So the website has a javascript alert box that pops up.
		
//		switchTo can switch to a different frame or window. Technically the alert is in a different window, and we need to switch our focus to reach it. (switchTo can also be used for other things)
		
		Alert alert = driver.switchTo().alert();
		alert.getText();
		Thread.sleep(2000);
		alert.accept();//this accepts the alert.
		
	}

}
