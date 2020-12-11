package PracticesDemo;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.util.RetryAnalyzerCount;

import Practices.Pages.RetryAnalyzer;

public class TestCase
{
	//@Test(retryAnalyzer = Practices.Pages.RetryAnalyzer.class) --> for test level
@Test()
public void Test1()
{
Assert.assertEquals(true, false);
}

@Test()
public void Test2()
{
Assert.assertEquals(false, true);
}

}
