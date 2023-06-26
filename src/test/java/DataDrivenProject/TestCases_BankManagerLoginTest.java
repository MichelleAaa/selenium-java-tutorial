package DataDrivenProject;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCases_BankManagerLoginTest extends Base_BaseTest {

	@Test
	public void loginTest() {
		
//		These methods are coming from Base_BaseTest:
		click("bmlBtn_CSS");
		Assert.assertTrue(isElementPresent("addCustBtn_CSS"), "Bank Manager not logged in.");
		
		
	}
}
