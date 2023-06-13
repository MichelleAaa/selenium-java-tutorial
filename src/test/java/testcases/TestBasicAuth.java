package testcases;

import java.time.Duration;

import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBasicAuth {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver(); //		Note that to use register we had to use CrhomeDriver driver. -- if you want to use WebDriver here, then you have to use:
//		((HasAuthentication) driver).register(UsernameAndPassword("admin", "admin")); -- instead of the below:
		driver.register(UsernameAndPassword.of("admin", "admin"));
		driver.get("https://the-internet.herokuapp.com/basic_auth");

//		Simple Hack option 1:
//		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");//here we have provided the password and username at the start of the url.
		
		
//		IMPLICIT WAIT:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

		
		

	}

}
