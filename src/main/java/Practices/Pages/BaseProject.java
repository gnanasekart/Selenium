package Practices.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseProject {
	
	public long starttime;
	public long endtime;
	ChromeDriver d;
	public String excelfilename;
	
	@Parameters({"username","password"})
	@BeforeMethod
	public void Launchapp(String uname, String pword)
	{
		starttime = System.currentTimeMillis();
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();		
		d.get("http://leaftaps.com/opentaps/control/main");	
		d.findElementById("username").sendKeys(uname);
		d.findElementById("password").sendKeys(pword);
		d.findElementByClassName("decorativeSubmit").click();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);		
		d.findElementByXPath("//div[@for=\"crmsfa\"]").click();	
	}
	
	@AfterMethod
	public void close()
	{
		endtime = System.currentTimeMillis();
		System.out.println("Time is"+(endtime - starttime)+ "ms");
		d.close();
	}
}