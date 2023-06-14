package testcases;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v111.fetch.model.AuthChallengeResponse.Response;
import org.openqa.selenium.devtools.v111.network.Network;
import org.openqa.selenium.devtools.v111.network.model.Request;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestGetURLRequestAndResponseStatus {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
//		Get request data:
		devTools.addListener(Network.requestWillBeSent(), request->{
			Request req = request.getRequest();
			System.out.println("Request URL is : " + req.getUrl() + " request status is : " + req.getHeaders());
		});
		
		
		driver.get("https://reqres.in/api/users?page=2"); // If you go to a site like flipkart.com -- you will get a lot of messages as there's a lot of requests/responses that get sent when you visit that site. -- the one listed is a simple one.
		
//	Get response data:
	devTools.addListener(Network.responseReceived(), response->{
		org.openqa.selenium.devtools.v111.network.model.Response res = response.getResponse();
		System.out.println("Response URL is : " + res.getUrl() + " response status is : " + res.getStatus());
	});
	
}

}
