package Practices.Pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.manage().window().maximize();
		
		d.get("http://leaftaps.com/opentaps/control/main");	
		d.findElementById("username").sendKeys("Demosalesmanager");
		d.findElementById("password").sendKeys("crmsfa");
		d.findElementByClassName("decorativeSubmit").click();
		
		d.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);		
		d.findElementByXPath("//div[@for=\"crmsfa\"]").click();
		d.findElementByLinkText("Create Lead").click();
		String parentwindow = d.getWindowHandle();
		System.out.println("parent window -" +parentwindow);
		WebElement clickElement = d.findElementByXPath("//input[@id = 'createLeadForm_parentPartyId']//following::img[1]");
		 
		for(int i = 0; i < 5; i++)
		{
		clickElement.click();
		Thread.sleep(5000);
		}
		
		Set<String> windhandle = d.getWindowHandles();
		
		String lastwindow ="";
		for(String handle :windhandle)
		{
			System.out.println("output -" +handle);
			
			d.switchTo().window(handle);
			
			String childwindow = d.getWindowHandle();
			System.out.println("child window -" +childwindow);
			d.findElementByXPath("//label[text()='Account ID:']//following::input[1]").sendKeys("Company");
			d.findElementByXPath("//button[text()='Find Accounts']").click();
			
			//d.get("www.google.co.in");
			//lastwindow = handle;
		}

		/*d.switchTo().window(parentwindow);
		d.close();
		
		d.switchTo().window(lastwindow);
		d.get("www.google.com"); 
	*/	
		
	
	/*
	 * package Practices.Pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class DeleteLeadPage extends BaseProject{

	
	@Test(alwaysRun=true)
	public void deleteLeads() throws InterruptedException
	{
		d.findElementByXPath("//a[text()='Leads']").click();
		d.findElementByLinkText("Find Leads").click();
		d.findElementByXPath("//span[text()='Phone']").click();
	//	d.findElementByXPath("//input[@name='phoneAreaCode']").sendKeys("044");
		d.findElementByXPath("//input[@name='phoneNumber']").sendKeys("222333");
		d.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		WebElement id = d.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		String idno = id.getText();
		Thread.sleep(2000);
		d.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();
		d.findElementByClassName("subMenuButtonDangerous").click();
		d.findElementByXPath("//a[text()='Find Leads']").click();
		d.findElementByXPath("//label[text()='Lead ID:']/following::input[1]").sendKeys(idno);
		d.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		
		WebElement errormsg = d.findElementByXPath("//div[@class='x-paging-info']");
		String text = errormsg.getText().toString();
		System.out.println(text);
		
		if(text.equalsIgnoreCase("No records to display"))
		{
			System.out.println("No data found");
		}
		else
		{
			System.out.println("data present");
		}
		}
	
	@Test(alwaysRun=true)
	public void deleteLead() throws InterruptedException
	{
		d.findElementByXPath("//a[text()='Leads']").click();
		d.findElementByXPath("//a[text()='Find Leads']").click();
		d.findElementByXPath("//span[text()='Phone']").click();
		d.findElementByXPath("(//label[text()='Phone Number:'])[4]//following::input[3]").sendKeys("222333");
		d.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		String result;
		//Below link to check if the record is available in table if not move to result else block
		if(d.findElementByXPath("//div[@class='x-grid3-body']/div").isDisplayed()) //if block
		{
		String Leadid = d.findElementByXPath("(//table[@class='x-grid3-row-table']//a)[1]").getText();
		d.findElementByXPath("(//table[@class='x-grid3-row-table']//a)[1]").click();
		d.findElementByXPath("//a[text()='Delete']").click();
		d.findElementByXPath("//a[text()='Find Leads']").click();
		d.findElementByXPath("//label[text()='Lead ID:']//following::input[1]").sendKeys(Leadid);
		d.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		result = d.findElementByXPath("//div[text()='No records to display']").getText().toString();
		System.out.println(result);
		if(result.equalsIgnoreCase("No records to display"))
		{	System.out.println("No result found");
			d.close();}
		else
		{	System.out.println("wrong result");
		}}
		else//else block
		{	
		//result = d.findElementByXPath("//div[@class='x-toolbar x-small-editor']//div[1]").getText();
		result = d.findElementByXPath("//div[text()='No records to display']").getText().toString();
		System.out.println(result);
		if(result.equalsIgnoreCase("No records to display"))
		{	System.out.println("No result found");
			d.close();
		}
		else
		{	System.out.println("wrong result");
		}}}
		}

	 * }
	 */
}}
