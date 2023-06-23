package DataDrivenProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.DbManager;
import utilities.ExcelReader;

public class Base_BaseTest {
	
	public static WebDriver driver;
	public static Logger log = Logger.getLogger(Base_BaseTest.class.getName());
	public Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\excel\\users-for-way2automation-test.xlsx");
	public static WebDriverWait wait;
	
	
//	This is our base class which we will extend in other classes. We include the startup, end, and also functions like click and type that we can use in our test cases in other files.
	
	public static boolean isElementPresent(String key) {
		
		
		try {
//		note that for this method to work, we have to set up our OR.properties file to end a property name with _XPATH, _ID etc. so we can identify them here:
		if(key.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(key)));
		} else if(key.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(key)));
		} else if(key.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(key)));
		}
		log.info("Finding an Element: " + key);
		return true;
		} catch(Throwable t) {
			log.info("Error while finding an Element: " + key + "Error log is: " + t.getMessage());
			return false;
		}
	}
	
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
	
	
	
	@BeforeSuite
	public void setUp() {
		
//		We may need to call setUp more than once, and if that happens, then we want to ensure we only initiate the driver once.
		if(driver==null) {
			PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j2.properties");
			
			
//			Load OR:
			try {
			fis = new FileInputStream(".\\src\\test\\resources\\properties\\OR2.properties");
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
			OR.load(fis);
			log.info("OR Properaties Loaded.");
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			
//			Load Config:
			try {
			fis = new FileInputStream(".\\src\\test\\resources\\properties\\Config2.properties");
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
			OR.load(fis);
			log.info("Config Properaties Loaded.");
			} catch(IOException e) {
				e.printStackTrace();
			}
		
//			Launch Browser:
			if(Config.getProperty("browser").equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				log.info("Chrome Browser Launched");
			} else if(Config.getProperty("browser").equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				log.info("Firefox Browser Launched");
			} 
			
			driver.get(Config.getProperty("testsiteurl"));
			log.info("Navigating to the URL : " + Config.getProperty("testsiteurl"));
			DbManager.setMysqlDbConnection();
			log.info("Database connection established");
//			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")), TimeUnit.SECONDS);
			
			wait = new WebDriverWait(driver, Config.getProperty("explicit.wait"));//5 seconds
			
		}
		
	}
	
	@AfterSuite
	public void tearDown() {
		
		driver.quit();
		log.info("Test Execution Completed.");
	}

}
