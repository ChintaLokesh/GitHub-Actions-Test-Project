package dockerdemo.reusablemethods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ReUsableMethods {

	public static void takeScreenshot(WebDriver driver,String name ) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dst=new File(System.getProperty("user.dir")+"/screenshots/"+name+".jpg");
		System.out.println(dst.toString());
		FileUtils.copyFile(src,dst);
	}
	
}
