package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropdown2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();//maximize the screen.
		
//		IMPLICIT WAIT:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]")).sendKeys("Eesti"); // This doesn't work, because it's a dropdown meny and it went on to espanol. sendKeys is typing, which is why sometimes you could bounce around the list and end up on the wrong selection.
//		There's a dedicated tag for a dropdown list.
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Eesti"); // This works correctly.
		//Another option with option tags is to target the value tag. That's useful if you are working with non-English characters that you can't type.
		select.selectByValue("hi");
		select.selectByIndex(0); // This is another option. There's a lot listed in the website documentation.
//		https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/Select.html

//		find elements: (When we find elements they are returned as a WebElement. In this case a list of web elements would be returned.)
		List<WebElement> values = driver.findElements(By.tagName("option"));//This will get all the option tags.
		
		System.out.println("Total values in dropdown is: " + values.size());
//		If you wanted to verify if this is valid in the browser - inspect the page - then in the Elements section - search - enter //option -- this will show you the list of total option tags on the page (This is assuming there's only one drop-down. 
//		If there are multiple select tags, then enter // followed by the xpath of the container for all of the options that you want to count.
		
		System.out.println("First value: " + values.get(0).getText()); //Get will return the webelement at the specified index of the list.From the webelement, we pull the text with getText().
		System.out.println("First value: " + values.get(0).getAttribute("lang"));
//		
//		Print out all the values:
		
		for(int i = 0; i < values.size(); i++) {
			System.out.println(values.get(i).getText());
			//Note that when it's not English characters it prints ???? instead.
		}
		
		System.out.println("--Print all links---");
		
//		Note that you can also create a unique xpath to only target some of the elements - such as only a elements inside of a container div.
//		driver.findElements(By.id("abc")).get(1).click();
		
		
//		do something like dropdown.findElemetns(by.tagName(....) -- Then the varaible could be used for fin
		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println(links.size());
		
		for(WebElement link: links) {
			System.out.println(link.getText()+ "--URL: " + link.getAttribute("href"));
		}
		
		driver.quit();
	}

}
