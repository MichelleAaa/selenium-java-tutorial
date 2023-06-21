package extentreports;

import java.io.IOException;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//extentreports creates HTML reports.

public class TestCase1 {

	public ExtentSparkReporter htmlReporter; //This class is responsible for creating the HTML file and adding basic configuration to the HTML report (document title, report name, theme, etc.)
	public ExtentReports extent; //We attach all the configuration we need to provide to this class, and any additional information, such as build number, organization, etc... Any information you want to attach to this report.
	public ExtentTest test; //This generates the logs for our testcases in our HTML report. (Such as reporting pass, fail, etc. -- Whenever there's a test case pass or fail we will add it manually.)
	
	@BeforeTest
	public void setReport() {
//		This code is our one-time configuration:
		htmlReporter = new ExtentSparkReporter("./reports/extent.html");//This will create a folder called reports in the root directory of the project and create the file extent.html. 
		
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("W2A Automation Reports"); // Add Title
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);//STANDARD or DARK is available for the report theme.
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Automation Tester", "MA");
		extent.setSystemInfo("Organization", "WAy2Automation");
		extent.setSystemInfo("Build-No", "W2A");
	
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();//Reports are not generated until extent.flush() is called.
	}
	
	@Test
	public void doLogin() {
		test = extent.createTest("Login Test"); //This creates a testcase for the extentreports. (A section will be created in the html report.) -- It's required for each test in the report.
		test.log(Status.INFO, "Inside doLogin Test");//This will add the listed comment to your report.
		
		
		
//		SOME METHODS WITH EXTENTREPORTS:
//		test.info(null);//Any information you want to add can be added with this.
//		test.log(Status.INFO, exceptionInfo);// Here you would add the status as FAIL, INFO, DEBUG, and then you can give information in the second parameter.
//		test.pass(null);//This reports the test as a passed.
//		test.fail(null);//This would report the test as a failure.
	
	}
	
	@Test
	public void doUserReg() {
		test = extent.createTest("User Reg Test"); 
		test.log(Status.INFO, "Enter Username");
		test.log(Status.INFO, "Enter Password");
		test.log(Status.FAIL, "Failing the Test - Screenshot attached");
		Assert.fail("Failing user reg test");
	}
	
	@Test
	public void validateTitle() {
		test = extent.createTest("Validate Title Test"); 
		test.log(Status.INFO, "Validating Title");
		throw new SkipException("Skipping the test case.");
	}
	
	@AfterMethod // This will run after every test case.
	public void tearDown(ITestResult result) {
//		iTestResult is from TestNG. It stores the status of your test results.
		
		if(result.getStatus() == ITestResult.FAILURE) {;//This will tell you whether the test is passed, failed, or skipped.
			String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
			test.fail(exceptionMessage); //Fails the test and adds the exception message.
		
			String screenshot = "./screenshot/city.jpg"; // You need the full path to a screenshot here.
			test.fail("<b><font color=red>Screenshot of Failure</font></b><br>", MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());//First parameter is the message - You can add HTML or quasi-html as well. - Second allows you to add a screenshot to the HTML report.
			
			String methodName = result.getMethod().getMethodName();//First we retrieve the method name, and then pass it below:
			String text = "<b>TEST CASE: - " + methodName.toUpperCase() + " FAILED";
		
			Markup m = MarkupHelper.createLabel(text, ExtentColor.RED);//Title for the first parameter and color for the second. (Your title will show up in the color specified.)
			
			test.log(Status.FAIL, m);//Here we are adding a failing status to the log for this report.
		} else if(result.getStatus() == ITestResult.SUCCESS) {
			
			String methodName = result.getMethod().getMethodName();
			String text = "<b>TEST CASE: - " + methodName.toUpperCase() + " PASSED";
		
			Markup m = MarkupHelper.createLabel(text, ExtentColor.GREEN);
			
			test.log(Status.PASS, m);
		} else if(result.getStatus() == ITestResult.SKIP) {
			
			String methodName = result.getMethod().getMethodName();
			String text = "<b>TEST CASE: - " + methodName.toUpperCase() + " SKIPPED";
		
			Markup m = MarkupHelper.createLabel(text, ExtentColor.YELLOW);
			
			test.log(Status.SKIP, m);
		}
	}
}
