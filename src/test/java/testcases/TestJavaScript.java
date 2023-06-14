package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestJavaScript {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
//		we are switching into the iframe:
		driver.switchTo().frame("iframeResult");
		
		((JavascriptExecutor) driver).executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')", driver.findElement(By.id("mySubmit"))); // last value is the element.
//		This changes the background color and border of the element.

	}

}
