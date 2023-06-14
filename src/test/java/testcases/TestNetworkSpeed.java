package testcases;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNetworkSpeed {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(false, 100, 20000, 10000, Optional.of(ConnectionType.CELLULAR2G)));
//		Note that to get this to work, you have to ensure that the Network and ConnectionType imports at the top are for the same version. If they are not it may not function properly. 
//		When you type ConnectionType. -- it will show you a lot of different options to choose from. You then have to adjust your Network connection as it may only update the ConnectionType version.
		

		driver.get("http://makemytrip.com");
	}

}
