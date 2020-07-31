package Practices.Pages;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGClass 
{
	WebDriver d;

	@BeforeSuite
	public void startup()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver84.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();		
		d.manage().deleteAllCookies();
		d.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
	}

	@BeforeClass
	public void setup()
	{
		d.get("http://leaftaps.com/opentaps/control/main");
	}
	
	@Test
	public void Login()
	{
		d.findElement(By.id("username")).sendKeys("demosalesmanager");
		d.findElement(By.id("password")).sendKeys("crmsfa");
		d.findElement(By.className("decorativeSubmit")).click();
	}

	@Test(dependsOnMethods="Login")
	public void crm()
	{
		d.findElement(By.xpath("//div[@for=\"crmsfa\"]")).click();	
		String title = d.getTitle();
		System.out.println(title);
	Assert.assertEquals(title, "My Home | opentaps CRM", "Wrong title name");
	
	}

	@Test(dependsOnMethods="crm")
	public void lead()
	{
		d.findElement(By.linkText("Create Lead")).click();	
	}

	@Test(dependsOnMethods="lead")
	public void cname()
	{
		d.findElement(By.id("createLeadForm_companyName")).sendKeys("Amazon");
	}
	
	//@Test(dependsOnMethods="cname", invocationCount=5)
	@Test(dependsOnMethods="lead")
	public void name()
	{
		WebElement fname = d.findElement(By.id("createLeadForm_firstName"));
		fname.sendKeys("manoj");
		fname.clear();
	}
	
	@AfterClass
	public void teardown()
	{
		d.manage().deleteAllCookies();
	}

	@AfterSuite
	public void clearCookies()
	{
		d.quit();
	}




//	@Test(expectedExceptions=NumberFormatException.class)
//	public void number()
//	{
//		String a= "100A";
//		Integer.parseInt(a);
//	}
//	
//	@Test(invocationTimeOut=2)
//	public void InfiniteLoop()
//	{
//		int i =1;
//		while(i==1)
//		{
//			System.out.println(i);
//		}
//	}

/*
	
	@BeforeSuite
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver84.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();		
		d.manage().deleteAllCookies();
		d.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		//d.get("https://www.google.com/");
	}

@BeforeTest
public void url()
{
	d.get("https://www.google.com/");
}

@Test
public void title()
{
	String title = d.getTitle();
	Assert.assertEquals(title, "Google", "not correct title");
}

@Test
public void logo()
{
	boolean log = d.findElement(By.id("hplogo")).isDisplayed();
	Assert.assertTrue(log, "it is false");
}

@AfterTest
public void clearcookie()
{
	d.manage().deleteAllCookies();
}
	
	
@AfterSuite
public void teardown()
{
	d.quit();
}

*/

}
