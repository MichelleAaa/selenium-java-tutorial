package testnglearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader; // The below code relies on this utility, which was created to read excel files. -- Just look through the ExcelReader file to see all the methods that can be used after instantiating an object of it's class. 

public class TestParamWithExcel {
	
	public static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	@DataProvider(name="dp") //The DataProvider will provide data to another function. note below for doLogin we list the getData function as the data provider. -- The name is optional.
	public Object[][] getData() {
//		The data is in an excel file, in rows and columns. So the data return type is a two dimensional array. The data could be in a number, boolean, string, etc. So the data type is object of a two dimensional array.
		
		ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\excel\\users-for-way2automation-test.xlsx"); // Here you provide the path to the excel file to load. (just copy the file path where it's saved -- in this case in src/test/resources and add a . to the beginning since that's the route from the root of the project.)
		
		String sheetName = "LoginTest";
		
		int rowCount = excel.getRowCount(sheetName);
		int colCount = excel.getColumnCount(sheetName);
		
		System.out.println("Total rows are: " + rowCount + "... Total columns are: " + colCount);
		
//		THIS IS how you can implement a data operator:(We hard-coded here just to see how it looks, but normally we would be looping over the data.)
		Object[][] data = new Object[rowCount - 1][colCount]; // you have to specify the total number of rows and columns. -- We are - 1 to rowCount to skip the top row, which is where the titles are.
		
//		getCellData is an overridden method that has a few different options for the parameters.
//		Here we are getting the data using the getCellData method, and setting it into the data two-dimensional object:
//		data[0][0] = excel.getCellData(sheetName, 0, 2); // This returns the data from the first row we are getting data from -- aka 0 is the 2nd row as we are skipping row 1. 
//		data[0][1] = excel.getCellData(sheetName, 1, 2);
//		
//		data[1][0] = excel.getCellData(sheetName, 0, 3);
//		data[1][1] = excel.getCellData(sheetName, 1, 3);
//		
//		data[2][0] = excel.getCellData(sheetName, 0, 4);
//		data[2][1] = excel.getCellData(sheetName, 1, 4); 
		
//		To do the above dynamically, we will use a loop:
		
//		Loop over the rows and also the columns:
		for(int rows=2; rows <= rowCount; rows++) {
			
			for(int cols = 0; cols < colCount; cols++) {
//				We want data[0][0] for the first one, so we are subtracting 2 from the rows because we are starting at 2 for the row variable.
				data[rows - 2][cols] = excel.getCellData(sheetName, cols, rows);
			}
		}
	
		return data;
	}
	
//	@Test(dataProvider="getData") // If you are not giving a name to your DataProvider (aka getData above) then you would provide the name of the function.
	@Test(dataProvider="dp") // When you create a name for the data provider, you provide the name here instead of the function name of the data provider.
	public void doLogin(String username, String password) {
		System.out.println(username + "---" + password);
		
		driver.get("http://facebook.com");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
	}

}
