package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSliders {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		driver.manage().window().maximize();//maximize the screen.
		
//		IMPLICIT WAIT:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		int width = driver.findElement(By.xpath("//*[@id=\"slider\"]")).getSize().width/2;//this is the main element, that track that it's in.
		
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span")); // This is the slider indicator that you drag.
		
//		This is an alternative syntax than what was used in the TestMouseMovement section, with new Actions(driver).
		new Actions(driver).dragAndDropBy(slider, width, 0).perform();//This accepts the element, then the x and y axis you want it to be dragged to. -- some sliders you can only drag to the x axis, so leave y zero in that case.
//		Note that for width, we got half of the width of the container, the track where the slider moves in. 
//		Again, the action won't be performed unless you chain on perform() at the end.
		
	
	}

}
