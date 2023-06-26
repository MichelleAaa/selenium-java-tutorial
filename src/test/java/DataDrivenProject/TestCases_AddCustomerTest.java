package DataDrivenProject;

import org.openqa.selenium.Alert;
import org.testng.Assert;

public class TestCases_AddCustomerTest extends Base_BaseTest {

	public void addCustomerTest(String firstName, String lastName, String postCode) {
		
		click("addCustBtn_CSS");
		type("firstName_CSS",firstName);
		type("lastName_CSS",lastName);
		type("postCode_CSS",postCode);
		click("addCustomer_CSS");
		Alert alert = driver.switchTo().alert();
		Assert.assertTrue(alert.getText().contains("Customer added successfully"), "Customer not added successfully");//Second parameter is a message if it fails.
		alert.accept();//This accepts the alert to close the pop-up box.
	}
}
