package Practices.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateLeadPage extends BaseProject
{
	@Test
	public void createLead()
	{
		d.findElementByLinkText("Create Lead").click();
		
		d.findElementById("createLeadForm_companyName").sendKeys("Amazon");
		WebElement fname = d.findElementById("createLeadForm_firstName");
		fname.sendKeys("manoj");
		
		WebElement job = d.findElementById("createLeadForm_dataSourceId");
		Select dd = new Select(job);
		dd.selectByValue("LEAD_EMPLOYEE");
	
		d.findElementById("createLeadForm_firstNameLocal").sendKeys("manoj");
		d.findElementById("createLeadForm_lastName").sendKeys("kumar");
		d.findElementById("createLeadForm_personalTitle").sendKeys("Test");
		d.findElementById("createLeadForm_generalProfTitle").sendKeys("Testing");
		d.findElementById("createLeadForm_annualRevenue").sendKeys("1L");
		
		WebElement domain = d.findElementById("createLeadForm_industryEnumId");
		Select jd = new Select(domain);
		jd.selectByVisibleText("Computer Software");
		
		WebElement owner = d.findElementById("createLeadForm_ownershipEnumId");
		Select own = new Select(owner);
		own.selectByVisibleText("Sole Proprietorship");
		
		d.findElementById("createLeadForm_sicCode").sendKeys("001");
		d.findElementById("createLeadForm_description").sendKeys("New description");
		d.findElementById("createLeadForm_marketingCampaignId").sendKeys("new job opening");
		d.findElementById("createLeadForm_lastNameLocal").sendKeys("sk");
		d.findElementById("createLeadForm_birthDate").sendKeys("05/7/20");
		
		WebElement camp = d.findElementById("createLeadForm_marketingCampaignId");
		Select market = new Select(camp);
		market.selectByValue("CATRQ_CARNDRIVER");
		
		d.findElementById("createLeadForm_departmentName").sendKeys("IT");
		d.findElementById("createLeadForm_numberEmployees").sendKeys("500");
		d.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("222333");
		d.findElementById("createLeadForm_primaryEmail").sendKeys("tgs@gmail.com");
		d.findElementByXPath("//input[@class='smallSubmit']").click();
		
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String name = d.findElementById("viewLead_firstName_sp").getText();
		System.out.println(name);
		
		if(name.equals("manoj"))
		{
			System.out.println("Correct name and record created");
		}
		else
		{
			System.out.println("Wrong name");
		}
		}
}
