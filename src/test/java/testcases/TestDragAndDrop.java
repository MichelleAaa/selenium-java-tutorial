package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDragAndDrop {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().window().maximize();//maximize the screen.
		
//		IMPLICIT WAIT:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement draggable = driver.findElement(By.id("draggable")); 
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		new Actions(driver).dragAndDrop(draggable, droppable).perform();//We pass in the draggable element and the place where it should be dropped.
//		Again, the action won't be performed unless you chain on perform() at the end.

	}

}
