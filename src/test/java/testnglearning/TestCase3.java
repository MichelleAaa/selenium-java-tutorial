package testnglearning;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase3 {
	
	@Test(priority = 1)
	public void doUserReg() {
		System.out.println("User is registered.");
		Assert.fail("Failing user reg test");
	}
	
//	dependsOnMethods = a test can be dependent on one or more other tests.	@Test(priority = 2, dependsOnMethods = "doUserReg", "secondOne")... That's how you would write it.
//	If any of the dependsOnMethods fails, then this method will not run.
	@Test(priority = 2, dependsOnMethods = "doUserReg")
	public void doLogin() {
		System.out.println("Login completed.");
	}
	
	@Test(priority = 3)
	public void isSkip() {
//		Depending on the condition, you can skip a test:
		if(!true) {
			throw new SkipException("This is how you skip a test - Skipping the test as condition is not met"); // you can add this line to skip a test.
		}
	}

}
