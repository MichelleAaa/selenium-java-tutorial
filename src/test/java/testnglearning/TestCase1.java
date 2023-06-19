package testnglearning;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//Note that with TestNG we aren't using the main method (That's using java standard, but now with the framework TestNG we don't use that standard.)

// Right click - Run as - TestNG Test

public class TestCase1 {
	
//	This will run the function once, before the first test.
	@BeforeTest
	public void createDbConn() {
		System.out.println("Creating db conn");
	}
	
//	This will run the function once, after all of the @Tests have been completed.
	@AfterTest
	public void closeDbConn() {
		System.out.println("Closing the DB conn.");
	}
	
	public void add() {
		
	}
	
//	This will be ran before each @Test.
	@BeforeMethod
	public void launchBrowser() {
		System.out.println("launching a browser");
		add();// you can also call methods from within, as we are calling add here.
	}
	
//	@AfterMethod will run after every @Test
	@AfterMethod
	public void closeBrowser() {
		System.out.println("Closing the browser");
	}
	
//	Note that the sequence where you list the methods doesn't matter, it will still run in the same priority, as defined by TestNG. (So you can't just copy/paste the methods) - TestNG runs in alphabetical order.
	
//	If you want priority defined, you can list (priority = 1) or whatever number. 1 is the highest priority.

//	@Test before a class means it will be ran when you run as a TestNG Test. You can have as many as you want.
	@Test(priority = 2)
	public void doLogin() {
		
		System.out.println("Executing Login Test");
	}
	
	@Test(priority = 1)
	public void doUserReg() {
		
		System.out.println("Executing Login Test");
	}
	
}
