package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.console.Console;
import org.openqa.selenium.devtools.v85.log.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestChromeConsoleLogs {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		
		devTools.send(Log.enable());
//		Logs will print to the console and in eclipse.
		devTools.send(Console.enable());
		
//		This isn't working:
		devTools.addListener(Log.entryAdded(), entry->{
			System.out.println("Text is : " + entry.getText());
			System.out.println("Timestamp is : " + entry.getTimestamp());
			System.out.println("Level is : " + entry.getLevel());
			System.out.println("Source is : " + entry.getSource());
		});
//		This works:
		devTools.addListener(Console.messageAdded(), message->{
			System.out.println("Console log is : " + message.getText());
		});
		
		driver.get("http://flipkart.com");
		
//		This works:
		((JavascriptExecutor) driver).executeScript("console.log('Hi, how are you?')"); //JavascriptExecutor allows us to execute javascript at runtime.
		

	}

}
