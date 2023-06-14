package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v112.emulation.Emulation;


public class TestGeoLocation {

	public static void main(String[] args) {

//		This feature will only work with the chrome browser for the moment. -- they are available in the ChromeDriver class.
//		In some cases we are in one country but want to test how the website is working in another country.
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
//		Another option is to do type casting and import it through WebDriver
//		WebDriver driver = new ChromeDriver();
		
//		Typecasting would be done as so:
//		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		
	
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Emulation.setGeolocationOverride(Optional.of(51.507351), Optional.of(-0.127758), Optional.of(100))); //latitude, longitude, accuracy. 100 is 100% for accuracy.
		
//		Note, --- .setGeolocationOverride was showing an error. To get it to work, you have to update the pom.xml file to add the following:
//		  <properties>
//		  <maven.compiler.target>1.8</maven.compiler.target>
//		  <maven.compiler.source>1.8</maven.compiler.source>
//	  </properties>
//	  
//	  <build>
//		  <plugins>
//			  <plugin>
//			  <artifactId>maven-compiler-plugin</artifactId>
//			  <configuration>
//				  <source>1.8</source>
//				  <target>1.8</target>
//			  </configuration>
//			  </plugin>
//		  </plugins>
//	  </build>
		
		
		driver.get("https://mylocation.org/");
		

	}

}
