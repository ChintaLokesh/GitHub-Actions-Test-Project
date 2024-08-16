package dockerdemo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import dockerdemo.reusablemethods.ReUsableMethods;

public class FirstTest {
	WebDriver driver;
	@Test(retryAnalyzer  = dockerdemo.RetryAnalyser.class )
	public void login() throws InterruptedException, IOException, AWTException
	{
		
		File file=new File(System.getProperty("user.dir")+"//Screenshots");
		if( file.exists())
		{
			for( File f:file.listFiles())
			{
				System.out.println("File is deleted :"+f.delete());
			}
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_YYYY_HH_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--no-sandbox");
		 options.addArguments("--disable-dev-shm-usage");
		 options.addArguments("--headless");
		 
		driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		WebElement wb9=driver.findElement(By.id("name"));


		((JavascriptExecutor)driver).executeScript("arguments[0].value='lokesh';", wb9);
		
		WebElement wb10=driver.findElement(By.id("alertbtn"));
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", wb10);
		
		
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().accept();
		
		System.out.println(driver.findElements(By.xpath("//label[contains(@for,'radio')]")).size());
		

		((JavascriptExecutor)driver).executeScript("arguments[0].value='udaya'", wb9);
		
		WebElement wb11=driver.findElement(By.id("confirmbtn"));
		
		
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", wb11);
		
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().dismiss();
		
		driver.findElements(By.xpath("//label[contains(@for,'radio')]//input"))
		.stream().filter(ele -> ele.getAttribute("value").equalsIgnoreCase("radio2")).
		forEach(element -> element.click());
		
		
		
		driver.findElement(By.id("autocomplete")).sendKeys("Ind");
		
		Thread.sleep(3000);
		driver.findElements(By.xpath("//ul[@id='ui-id-1']//li//div"))
		.stream().filter(ele -> ele.getText().equalsIgnoreCase("British Indian Ocean Territory"))
		.forEach(ele -> ele.click());
		
		WebElement select=driver.findElement(By.id("dropdown-class-example"));
		Select sel=new Select(select);
		sel.getOptions().stream()
		.filter(ele -> ele.getText().equalsIgnoreCase("Option1"))
		.forEach(ele -> ele.click());
		
		
		sel.selectByVisibleText("Option3");
		
		
		File f=new File(System.getProperty("user.dir")+"//Screenshots");
		boolean status=f.createNewFile();
		System.out.println("status is:"+status);
		
		

		ReUsableMethods.takeScreenshot(driver, "123_"+dtf.format(now));
		sel.selectByIndex(1);

		ReUsableMethods.takeScreenshot(driver, "456_"+dtf.format(now));
		sel.selectByValue("option2");
		

		ReUsableMethods.takeScreenshot(driver, "789_"+dtf.format(now));
		

		ReUsableMethods.takeScreenshot(driver, "101_"+dtf.format(now));
		driver.findElements(By.xpath("//div[@id='checkbox-example']//label"))
		.stream()
		.forEach(ele1 -> System.out.println("text value is:"+ele1.findElement(By.xpath("//div[@id='checkbox-example']//label//input")).getAttribute("value")));

		
		WebElement wb=driver.findElements(By.xpath("//div[@id='checkbox-example']//label"))
		.stream().filter(ele -> ele.getText().trim().equalsIgnoreCase("Option1"))
		.findFirst()
		.orElseThrow( () -> new WebDriverException(" No Such Element"));
		
		System.out.println(wb.getText());

		wb.findElement(By.xpath(".//input")).click();

				
		String mainHandle=driver.getWindowHandle();
		System.out.println("main handle is:"+mainHandle);
		driver.findElement(By.cssSelector("#openwindow")).click();
		
		driver.findElement(By.id("openwindow")).click();

		
		driver.getWindowHandles().stream().map(ele -> driver.switchTo().window(ele))
		.filter( ele -> ele.getCurrentUrl().equalsIgnoreCase("https://www.qaclickacademy.com/"))
		.findFirst()
		.orElseThrow(() -> new WebDriverException("No such window"));
		
		System.out.println("url is:"+driver.getCurrentUrl());
		
		Wait<WebDriver> wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Access all our Courses']")));
		
		driver.findElement(By.xpath("//a[text()='Access all our Courses']")).click();
		
		driver.close();
		
		
		driver.switchTo().window(mainHandle);
		
		Wait<WebDriver> wait1=new FluentWait<WebDriver>(driver)
				.pollingEvery(Duration.ofSeconds(2))
				.withTimeout(Duration.ofSeconds(10))
				.ignoring(NoSuchElementException.class);
		
		wait1.until(dr -> dr.findElement(By.id("name")) );
		
		driver.findElement(By.id("name")).sendKeys("lokesh");
		
		driver.findElement(By.id("opentab")).click();
		
		driver.getWindowHandles()
		.stream().map( ele -> driver.switchTo().window(ele))
		.filter(ele -> ele.getCurrentUrl().contains("https://www.qaclickacademy.com/"))
		.findFirst()
		.orElseThrow(() -> new WebDriverException(" No Such Window Exception"));
		
		
		driver.findElement(By.xpath("//a[text()='Access all our Courses']")).click();
		
		driver.close();
		
		
		driver.switchTo().window(mainHandle);
		
		List<String> list=driver.findElements(By.xpath("//table//tr//td"))
		.stream().map(ele -> ele.getText())
		.collect(Collectors.toList());
		
		System.out.println("------------------");
		list.stream().forEach(e -> System.out.println(e));
		
		System.out.println("------------------");
		
		
		WebElement wb5=driver.findElements(By.xpath("//table//tr//td"))
		.stream().map( ele -> ele.findElement(By.xpath("//table//tr//td[text()='0']")))
				.findFirst()
				.orElseThrow(() -> new WebDriverException("no such Element"));
		
		System.out.println("wb5"+wb5.getText());

		WebElement wb6=driver.findElements(By.xpath("//table//tr//td"))
		.stream().filter( ele -> ele.getText().contains("0"))
				.findFirst()
				.orElseThrow(() -> new WebDriverException("no such Element lokesh"));
		System.out.println("wb6"+wb6.getText());
		
		System.out.println(wb6.findElement(By.xpath("./preceding-sibling::td")).getText());
		
		System.out.println("------------------");
		
		
		wb6.findElements(By.xpath(".//preceding-sibling::td"))
		.stream().forEach(ele -> System.out.println(ele.getText()));
		WebElement wb7=driver.findElement(By.xpath("//div[@class='mouse-hover']"));
		Actions act = new Actions(driver);
		act.moveToElement(wb7).build().perform();
		
		act.moveToElement(wb7.findElement(By.xpath(".//a[text()='Top']"))).click().build().perform();
		act.moveToElement(wb7).build().perform();
		act.moveToElement(wb7.findElement(By.xpath(".//a[text()='Reload']"))).click().build().perform();
		
		
		act.moveToElement(driver.findElement(By.id("courses-iframe"))).build().perform();
		
		driver.switchTo().frame(driver.findElement(By.id("courses-iframe")));
		
		System.out.println(driver.findElement(By.xpath("//li[contains(text(),'contact@rahulshettyacademy.com')]")).getText());
		
		driver.switchTo().defaultContent();
		
//		driver.findElement(By.id("name")).sendKeys("lokesh");
//		act.moveToElement(wb7).build().perform();
//		act.moveToElement(wb7.findElement(By.xpath(".//a[text()='Top']"))).click().build().perform();
		
		
	
		driver.quit();
//		Assert.assertTrue(false);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
