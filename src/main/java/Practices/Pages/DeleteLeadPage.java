package Practices.Pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class DeleteLeadPage extends BaseProject{
	@Test
	public void deleteLeads() throws InterruptedException
	{
		d.findElementByXPath("//a[text()='Leads']").click();
		d.findElementByLinkText("Find Leads").click();
		d.findElementByXPath("//span[text()='Phone']").click();
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
		}}}