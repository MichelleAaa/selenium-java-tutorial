package testcases;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;

public class TestProperties {
	
	public static WebDriver driver;
//	Here we are accessing the OR.properties file that we set up in the srs/test/resources/properties section.
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
//	Note that we declare these two globally so they will be available inside of methods.
	
//	Steps to set up logs:
//	Add log4j dependency to the pom.xml file.
//	Logger - getLogger(); -- this will initiate the logs
//	log4j appenders are properties of how your logs will look. Such as the format of the timestamp. There's also different levels of the logs - Info, Error, Debug -- provided in the log4j.properties file. -- Info is the top most. Error is lower, meaning you may not be able to print the info logs. If you set your log4jrootLogger to INFO, you should be able to see all logs. -- You can use FileAppender or ConsoleAppender -- but it's typical to use FileAppender so you have a log of the files saved.HTML is another option but it's not used much.
//	PropertyConfigurator 
	
	public static Logger log = Logger.getLogger(TestProperties.class.getName());//This initates the logs. -- must always add through apache.log4j.Logger.
//	It adds the logs along with the class.
//	If you don't write this, then you can use getLogger() to get logs.
	
	public static void click(String key) {
		
//		note that for this method to work, we have to set up our OR.properties file to end a property name with _XPATH, _ID etc. so we can identify them here:
		if(key.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(key))).click();
		} else if(key.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(key))).click();
		} else if(key.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(key))).click();
		}
		log.info("Clicking on an Element: " + key);
	}
	
public static void type(String key, String value) {
		
//		note that for this method to work, we have to set up our OR.properties file to end a property name with _XPATH, _ID etc. so we can identify them here:
		if(key.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);
		} else if(key.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(key))).sendKeys(value);
		} else if(key.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(key))).sendKeys(value);
		}
		log.info("Typing in an Element: " + key + "entered the value as: " + value);
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\log4j.properties");
		
	
////		Here we are accessing the OR.properties file that we set up in the srs/test/resources/properties section.
//		Properties OR = new Properties();
//		Properties Config = new Properties();
//		Note that the above was moved outside of the main method, to become global variables so they can be used in methods like click() etc.
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		
		FileInputStream fis2 = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		
		OR.load(fis);//Load accepts your input stream.
		Config.load(fis2);
		
		
//		driver.findElement(By.id(OR.getProperty("username_ID"))).sendKeys(); -- This is an example of how you would use this in your test files.
		
		System.out.println(OR.getProperty("username_ID"));//The key is the locator key from your OR.properties file.
		
		System.out.println(Config.getProperty("testsiteurl"));

		
//		Logger.getLogger(TestProperties.class.getName()).info("OR Properties loaded"); // This adds an info log with the listed message.
//		The above is a statement that you can write again and again, but instead, we just wrote it above as variable name log. Instead of writing the entire string out, we can now just refer to the variable instead, log.
		log.info("OR Properties Loaded");
		
		if(Config.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
//			System.setProperty("webdriver.chrome.driver", ""); -- This is another way you can launch the chrome driver.
			driver = new ChromeDriver();
			log.info("Chrome browser launched");
		} else if(Config.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox browser launched");
		}
		
		driver.get(Config.getProperty("testsiteurl"));
		log.info("Navigated to: " + Config.getProperty("testsiteurl"));
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")), TimeUnit.SECONDS);
		
		
		
//		driver.findElement(By.id(OR.getProperty("username_ID"))).sendKeys("testtest@gmail.com");
//		log.info("Typing in an Element : and entered value." );
		
//		This is an alternative way of performing the above two lines. Instead of writing driver.findElement....sendKeys() AND the log.info... statement, you can write:
		type("username_ID", "testingtest@gmail.com");
		
//		driver.findElement(By.xpath(OR.getProperty("nextBtn_XPATH"))).click();
		
//		This is an alternative method of performing the above:
		click("nextBtn_XPATH");
		
		
		driver.quit();
		log.info("Test execution completed");
	}

}
