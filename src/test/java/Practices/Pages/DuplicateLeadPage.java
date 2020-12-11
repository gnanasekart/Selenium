package Practices.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DuplicateLeadPage extends BaseProject{

	@Test
	public void duplicateLead() throws InterruptedException 
	{
		d.findElementByXPath("//a[text()='Leads']").click();
		d.findElementByXPath("//a[text()='Find Leads']").click();
		d.findElementByXPath("//span[text()='Email']").click();
		d.findElementByXPath("//input[@name='emailAddress']").sendKeys("tgs@gmail.com");
		d.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		String fname = d.findElementByXPath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a").getText();
		d.findElementByXPath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a").click();
		d.findElementByXPath("//a[text()='Duplicate Lead']").click();
		
		if(d.getTitle().contains("Duplicate Lead"))
		{
			d.findElementByXPath("//input[@value='Create Lead']").click();
		}
		String firstname = d.findElementById("viewLead_firstName_sp").getText();

		if(firstname.equals(fname))
		{
			System.out.println("name match and duplicate created");
			}
	}
}
