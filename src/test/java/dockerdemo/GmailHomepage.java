package dockerdemo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import dockerdemo.reusablemethods.BaseClass;
import dockerdemo.reusablemethods.ReUsableMethods;

public class GmailHomepage extends BaseClass{
	
	@Test
	public void gmailHomepageTest() throws IOException
	{
		driver.get("http://www.google.com");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		ReUsableMethods.takeScreenshot(driver, "GoogleHomePage_"+dtf.format(now));
		
		driver.findElement(By.xpath("//a[text()='Gmail']")).click();
		now = LocalDateTime.now();
		ReUsableMethods.takeScreenshot(driver, "GmailHomePage_"+dtf.format(now));
	}

}
