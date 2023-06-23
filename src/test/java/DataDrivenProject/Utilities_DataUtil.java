package DataDrivenProject;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import utilities.ExcelReader;

public class Utilities_DataUtil extends Base_BaseTest {

//	Since we changed the code in SecondTest, we have to add @DataProvider... here:
	@DataProvider(name="dp")
	public static Object[][] getData(Method m) {
//		The data is in an excel file, in rows and columns. So the data return type is a two dimensional array. The data could be in a number, boolean, string, etc. So the data type is object of a two dimensional array.
		
		String sheetName = m.getName(); // Here we are assuming the method name is the same as the sheet name (which I would have to update the excel sheets for). -- If you don't want to do it this way, you could always pass in a String as a parameter so the sheet name can be provided. But then you would need to Use OPTION 1 instead of OPTION 2 in the SecondTest and LoginTest files to be able to pass in the parameter.
		
		ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\excel\\users-for-way2automation-test.xlsx"); // Here you provide the path to the excel file to load. (just copy the file path where it's saved -- in this case in src/test/resources and add a . to the beginning since that's the route from the root of the project.)
		
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
	
}
