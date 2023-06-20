package testnglearning;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 {
	
//	You can have two groups, if you include them in {}.
	@Test(groups = {"high", "medium"})
	public void validateTitle() {
		String actual_title = "Gmail.com";
		String expected_title = "Yahoo.com";
		
		if(actual_title.equals(expected_title)) {
			System.out.println("Test case passed");
		} else {
			System.out.println("Test case failed");
		}
		
//		Instead of doing the above, you can us:
//		Assert is a built-in class in TestNG. All the methods are static in this class, so you can access it by typing Assert. and it will show you the list.
		
		Assert.assertEquals(actual_title, expected_title, "This is an optional third parameter -- if you want to add a failure message --example: Titles are not matching");
	}
	
	@Test(priority = 1, groups = "med")
	public void testing() {
		
		
		
//		Note that as soon as there is an error, it will break further execution. But for something like a title check, we don't really want execution to stop as it's a smaller matter. 
//		One thing you can do is a try/catch block for each assertion, so then it will try each and continue to execute through the other try/catches.
//		Then in the catch blocks, you can use Assert.fail()f.getMessage(); -- however, whenever you use Assert.fail, it will break the execution.

		
		try {
		
	System.out.println("Beginning");
	
//	You can use this with isElementPresent() and then pass in the xpath.
	Assert.assertTrue(false,"This is for the failure message. Element not found"); //-- First parameter must equate to true or false. If it's false then the test case will fail.


	Assert.fail("Forcefully failing");//Here you can enter a mandatory failure message.
	
	System.out.println("End");
		} catch(Throwable t) {
			System.out.println("Ending");
			Assert.fail(t.getMessage());
		}
	
//		To be able to get all the tests to run, get all of them on the report, then we can use SoftAssertions instead.
		SoftAssert asrt = new SoftAssert();
		
		System.out.println("Begin");
		asrt.assertEquals(true, true);
		asrt.assertTrue(false, "Element not found");
		asrt.fail("Forcefully failing this");
		
		System.out.println("End");
		
		asrt.assertAll();//The failures aren't reported until this is listed in the code. So you will see beginning, ending, and then the results of the tests.
		
	}
}
