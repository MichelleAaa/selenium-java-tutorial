package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCheckboxes {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
//		driver.manage().window().maximize();//maximize the screen.
		
//		IMPLICIT WAIT:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//		These are the checkboxes:
//		driver.findElement(By.xpath("//div[4]/input[1]")).click();
//		driver.findElement(By.xpath("//div[4]/input[2]")).click();
//		driver.findElement(By.xpath("//div[4]/input[3]")).click();
//		driver.findElement(By.xpath("//div[4]/input[4]")).click();
	
	
//		We can also loop over them instead:
//		for(int i = 1; i <= 4; i++) {
//			driver.findElement(By.xpath("//div[4]/input[" + i + "]")).click(); //note that we have to use string and variable concatenation to access i.
			
//		}
		
//		Another option: 
		
		int i = 1;
		
		while(i <= 4) {
			driver.findElement(By.xpath("//div[4]/input[" + i + "]")).click();
			i++;
		}
		
//		Another option -- which is the one commonly used:
		
		List<WebElement> checkboxes = driver.findElements(By.name("sports"));
		
		System.out.println(checkboxes.size());
		
		for(WebElement checkbox: checkboxes) {
			checkbox.click();
		}
		
//		Another option is to target a specific bock, and then find the elements in that block, instead of the driver as a whole.
//		This is especially helpful if the selectors/classes are not unique on the page, maybe at least there's a unique parent id or something you can target before targeting a general selector.
		WebElement block = driver.findElement(By.xpath("/html/body/table[3]"));
		List<WebElement> checkboxes2 = block.findElements(By.name("sports"));
		
		System.out.println(checkboxes2.size());
	
	}

}
