package DataDrivenProject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelReader;

public class TestCases_SecondTest extends Base_BaseTest{

//	@Test(dataProvider="dp")
//	public void secondtest(String firstName, String lastName) {
//		System.out.println(firstName + "---" + lastName);
//	}
//	
////		We moved the getData function into Utilities_DataUtil. So now we are just passing in the sheet name only:
//		@DataProvider(name="dp")
//		public Object[][] getData() {
//			
//			return Utilities_DataUtil.getData("SecondTest");
//		}
	
		
//		OPTION 2:

		@Test(dataProviderClass = Utilities_DataUtil.class, dataProvider="dp")
		public void secondtest(String firstName, String lastName) {
			System.out.println(firstName + "---" + lastName);
		}
}
