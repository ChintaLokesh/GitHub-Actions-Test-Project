package dockerdemo.reusablemethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseClass {
	public WebDriver driver;
	public Properties prop;
	@BeforeMethod
	public void configure() throws FileNotFoundException, IOException
	{
		System.out.println("Test Execution is started ");
		prop=new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir")+"/config.properties"));
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--no-sandbox");
		 options.addArguments("--disable-dev-shm-usage");
		 options.addArguments("--headless");
		 driver = new ChromeDriver(options);
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		System.out.println("Test Execution is completed ");

	}
	
}
