package dockerdemo;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser  implements IRetryAnalyzer{
    int retryLimit =2;
	int counter=1;
	public boolean retry(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE
				&& counter < retryLimit)
		{
				counter ++;
				return true;
		}
		return false;
	}

}
