package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestResizable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/resources/demos/resizable/default.html");
		driver.manage().window().maximize();//maximize the screen.
		
//		IMPLICIT WAIT:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement resizable = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]")); // This is the slider indicator that you drag.
		
//		This is an alternative syntax than what was used in the TestMouseMovement section, with new Actions(driver).
		new Actions(driver).dragAndDropBy(resizable, 400, 400).perform();//We pass in the element and the xy and y. This will re-size the resizable box.
//		Again, the action won't be performed unless you chain on perform() at the end.

	}

}
