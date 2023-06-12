package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRelativeLocators {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://qa.way2automation.com");
		driver.manage().window().maximize();
		
		
//		Relative Locators are:
//		above
//		below
//		rightOf
//		leftOf
//		near
		
		WebElement email = driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.tagName("select"))); //This will find the input element that is above the select.
		email.sendKeys("testing@test.com");
		
		System.out.println(email.getSize().height);
		System.out.println(email.getSize().width);
		System.out.println(email.getLocation());//This will get the x and y coordinates. (823, 123) -- for example.
		
//		Capture element screenshot:
		File usernameScreenshot = email.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(usernameScreenshot, new File(".//screenshot//element.jpg")); // note that you have to hover to add the throws declaration for this to work. -- this is saying to take the usernameScreenshot element and then create a new file in the screenshot folder called element.jpg to store the captured screenshot in.
//		note that the screenshot folder doesn't need to already exist. If it doesn't, it will be created when this is ran.
//		This only screenshots the element itself, not the entire page.
		
		
		WebElement city = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.tagName("select"))); //This will find the input element that is below the select.
		city.sendKeys("CityName");
		
//		Capture element screenshot:
		File cityScreenshot = email.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(cityScreenshot, new File(".//screenshot//city.jpg"));
		

		WebElement password = driver.findElement(RelativeLocator.with(By.name("password")).toRightOf(By.tagName("label"))); //This will find the input element that is to the right of the label for the password input.
		password.sendKeys("CityName");

//		WebElement signIn = driver.findElement(RelativeLocator.with(By.linkText("Signin")).toLeftOf(By.xpath("(//input[@type='submit'])[2]"))); //This will find the signing link that is to the left of the signin input button.
//		We had to use [2] because there are two elements that match this xpath -- so we have to specify which one we want, in this case, the 2nd one.
//		signIn.click();
		
		WebElement near = driver.findElement(RelativeLocator.with(By.linkText("ENTER TO THE TESTING WEBSITE")).near(By.linkText("Signin"))); //This will find the a element with text of Signin, and then find the element near it that has linkText of ENTER TO THE TESTING WEBSITE.
		near.click();
		

		driver.quit();
	}

}
