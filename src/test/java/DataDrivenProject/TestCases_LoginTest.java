package DataDrivenProject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelReader;

//We set up the BaseTest class with our startup code, such as starting the webdriver, and the quit code. Now for each test case we are just going to extend the Base_BaseTest class so we have access to all of those methods.
public class TestCases_LoginTest extends Base_BaseTest {

//	@Test(dataProvider="dp")
//	public void loginTest(String username, String password) {
//		
////		Type and click are coming from Base_BaseTest:
//		type("username_ID", username);
//		click("nextBtn_XPATH");
//
//	}
//	
//	
////	We moved the getData function into Utilities_DataUtil. So now we are just passing in the sheet name only:
//	@DataProvider(name="dp")
//	public Object[][] getData() {
//		
//		return Utilities_DataUtil.getData("LoginTest");
//	}
	
//	OPTION 2:
	
	@Test(dataProviderClass = Utilities_DataUtil.class, dataProvider="dp")
	public void loginTest(String username, String password) {
		
//		Type and click are coming from Base_BaseTest:
		type("username_ID", username);
		click("nextBtn_XPATH");

	}
	
}
