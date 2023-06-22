package testnglearning;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {

	@DataProvider(name="dp") //The DataProvider will provide data to another function. note below for doLogin we list the getData function as the data provider. -- The name is optional.
	public Object[][] getData() {
//		The data is in an excel file, in rows and columns. So the data return type is a two dimensional array. The data could be in a number, boolean, string, etc. So the data type is object of a two dimensional array.
		
//		THIS IS how you can implement a data operator:(We hard-coded here just to see how it looks, but normally we would be looping over the data.)
		Object[][] data = new Object[3][2]; // you have to specify the total number of rows and columns. -- our excel sheet has 3 rows and two columns.
		
		data[0][0] = "testtest@test.com";
		data[0][1] = "asdfsdfs";
		
		data[1][0] = "testtest@test.com";
		data[1][1] = "asdfsdfs";
		
		data[2][0] = "testtest@test.com";
		data[2][1] = "asdfsdfs";
		
		return data;
	}
	
//	@Test(dataProvider="getData") // If you are not giving a name to your DataProvider (aka getData above) then you would provide the name of the function.
	@Test(dataProvider="dp") // When you create a name for the data provider, you provide the name here instead of the function name of the data provider.
	public void doLogin(String username, String password) {
		System.out.println(username + "---" + password);
		
//		When working with selenium, you would typically:
//		driver.findelement(By.id(password)).sendKeys(username);
//		driver.findElement(By.id(password)).sendKeys(password);
	}
}
