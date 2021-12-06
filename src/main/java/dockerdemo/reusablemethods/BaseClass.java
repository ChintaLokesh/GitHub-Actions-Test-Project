package dockerdemo.reusablemethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//public 	DesiredCapabilities caps;
	//public RemoteWebDriver driver;
	public WebDriver driver;
	public Properties prop;
	@BeforeMethod
	public void configure() throws FileNotFoundException, IOException
	{
		System.out.println("Test Execution is started ");
		//caps=DesiredCapabilities.chrome();
		prop=new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir")+"/config.properties"));
		//driver= new RemoteWebDriver(new URL(prop.getProperty("REMOTE.URL")),caps);
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		System.out.println("Test Execution is completed ");

	}
	
}
