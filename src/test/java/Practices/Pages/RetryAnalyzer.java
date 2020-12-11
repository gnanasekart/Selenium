package Practices.Pages;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer
{
int count = 0;
int retrylimit = 3; // this denoted no of time to retry after test cases failed

public boolean retry(ITestResult result)
{
if(count < retrylimit)
{
count++; 
return true;
}
else
return false;
}
}