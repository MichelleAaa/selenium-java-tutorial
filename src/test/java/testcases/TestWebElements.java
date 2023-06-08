package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// When doing testing, we typically will check that everything is spelled correctly, that the buttons on the page work, checking for the presence of different elements, etc.

public class TestWebElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); //If the page isn't loaded in 10 seconds or less, it's considered a timeout.
		driver.get("http://gmail.com");
		driver.manage().window().maximize();//maximize the screen.
		
//		IMPLICIT WAIT:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //This will cause a delay of up to 10 seconds. For each process it's going to wait up to 10 seconds for that element to be available. If the element is available sooner, it doesn't wait the full 10 seconds. 
//		Implicit wait is defined once, and only checks the presence of an item.
//		If the company requires strict performance, then they may have requirements that you only use explicit waits instead of implicit. Each company is different.
		
//		EXPLICIT WAIT:
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // This sets up the explicit wait, and we can use it below wherever needs with the following:
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")));//This says to wait until the condition is true. -- There's a lot of options - elementToBeClickable is only one of them.
//		You can use an explicit wait if you want to increase the implict wait time for a specific element.
		
		
		WebElement username = driver.findElement(By.id("identifierId"));//Find the element with the listed id. -- Whatever you choose to use, id, name, etc., make sure it's the only one on the page. ID is good for this purpose.
//		Note that the data type is WebElement, which comes from selenium.
		username.sendKeys("testingthis@gmail.com");//This will enter the text parameter in the input box that has been selected above.
		
//		Method Chaining:
//		driver.findElement(By.id("identifierId")).sendKeys("test@test.com"); // or you can do the above, with method chaining instead.
		

//		driver.getTitle().length();//Another example of method chaining.
		
		WebElement button = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
		button.click();
		
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
		
//		WAITS:
		//In some cases, there will be an error if the item isnt' in the DOM yet, because it hasn't loaded yet. (Sometimes there's a syncronization issue where the element takes time to load.) -- So if you try an xpath and it's not working, then it could be a timing issue.
//		This can especially happen for drop-downs, when you select one then another one has to update, so the options aren't there immediately.
		
//		Thread.sleep(2000);//You have to hover to add the throws declaration. it's not recommended to use this. It would halt the script execution for the referenced them. 2000 is 2 seconds.
//The reason this is not preferred because it involves hardcoding the time. Sometimes it will be too little time still and then still there will be an error.
//		Also, if you have 1k lines of code, maybe you need to write this hundreds of times.
//See implicit wait above
		
//		Get Error Messages:
//		System.out.println(driver.findElement(By.xpath("Enter your xpath here")).getText()); //This will get the text in an html element, such as a p element, etc. You can use it to capture error messages that print, such as if you enter an incorrect password and the system outputs an error message in some element.)
		

		
		driver.quit();
	}

}
