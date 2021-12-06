package dockerdemo;



import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import dockerdemo.reusablemethods.BaseClass;
import dockerdemo.reusablemethods.ReUsableMethods;


public class AutoSuggestDropDownTest extends BaseClass {

	@Test
	public void AutoSuggestDropDownValidationTest() throws IOException
	{
		driver.get("http://www.google.com");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		ReUsableMethods.takeScreenshot(driver, "GoogleHomePage1_"+dtf.format(now));
		  
		driver.findElement(By.name("q")).sendKeys("Artificial Intelligence");
		now = LocalDateTime.now();
		
		ReUsableMethods.takeScreenshot(driver, "GoogleSearchDropDown_"+dtf.format(now));

		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		now = LocalDateTime.now();
		ReUsableMethods.takeScreenshot(driver, "GoogleSearchResult_"+dtf.format(now));

		
		
	}
	


}
