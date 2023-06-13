package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestiFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");	
//		IMPLICIT WAIT:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
//		To find out how many iframes there are, you could search //iframe in the elements section of the dev tools. Another option is the below. But do note you have to be in the main window for this to give an accurate result. If you already switched into the iframe then you would get 0 if there's no frames inside the ifram.

		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		
		System.out.println(frames.size());
		
		for(WebElement frame: frames) {
			System.out.println(frame.getAttribute("id"));
		}
		
	}
		
		
		driver.switchTo().frame("iframeResult");//you have to provide the frame name or frame id.
		driver.findElement(By.xpath("/html/body/button")).click();
//		This button is inside a separate frame, so we have to switch into the frame before we can access the button.
//		There's an iframe tag that hints that this is the case.



}
