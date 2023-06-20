package testnglearning;

import org.testng.ITestContext ;		
import org.testng.ITestListener ;		
import org.testng.ITestResult ;
import org.testng.Reporter;	

// Hover over the error, add unimplemented methods.-- This will auto-fill the method bodies.
public class CustomListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		Reporter.log("Screenshot");
//		Whenever you are adding html you need to add this:
		System.setProperty("org.uncommons.reporting.escape-output", "false"); // Its a package we are adding with a false flag.
		
//		Reporter.log("<a href=\"error.html\" target=\"_target\">Screenshot link</a>"); // you can add the path to a screenshot and add it with the a tag for a link to it.
//		Reporter.log("<br>");//Here, we got to the next line.
//		Reporter.log("<a><img src=\"path-to-image.jpg\" height=200 width=200></a>");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
}
