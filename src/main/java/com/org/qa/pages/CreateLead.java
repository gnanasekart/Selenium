package com.org.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.org.qa.base.TestBase;

import io.qameta.allure.Step;

public class CreateLead extends TestBase
{

	@FindBy(how=How.ID, using="sectionHeaderTitle_leads")
	WebElement pagename;

	@FindBy(how=How.LINK_TEXT, using="Create Lead")
	WebElement clkcreatelead;

	@FindBy(how=How.ID, using="createLeadForm_companyName")
	WebElement companyname;

	@FindBy(how=How.ID, using="createLeadForm_firstName")
	WebElement fname;
	
	@FindBy(how=How.ID, using="createLeadForm_lastName")
	WebElement lname;

	@FindBy(how=How.ID, using="createLeadForm_primaryEmail")
	WebElement email;

	@FindBy(how=How.ID, using="createLeadForm_primaryPhoneNumber")
	WebElement phno;

	@FindBy(how=How.XPATH, using="//input[@class='smallSubmit']")
	WebElement createleadbtn;

	@FindBy(how=How.ID, using="viewLead_firstName_sp")
	WebElement verifyname;
	
	@FindBy(how=How.LINK_TEXT, using="Find Leads")
	WebElement findlead;

	public CreateLead()
	{
		PageFactory.initElements(d, this);
	}
	
	@Step("Launch into CreateLead Page....")
	public void createLead()
	{
		clkcreatelead.click();
	}

	@Step("verifying the page title....")
	public String verifyPageTitle()
	{	
		String title = d.getTitle();
		return title;
	}

	public String verifyPageName()
	{
		String pname = pagename.getText();
		return pname;
	}
	
	@Step("Entering company name as : {0}")
	public CreateLead enterCompanyName(String cname)
	{
		clearAndType(companyname, cname);
		return this;
	}

	@Step("Entering first name as : {0}")
	public CreateLead enterFirstName(String firstname)
	{
		clearAndType(fname, firstname);
		return this;
	}	
	
	@Step("Entering last name as : {0}")
	public CreateLead enterLastName(String lastname)
	{
		clearAndType(lname, lastname);
		return this;
	}	
	
	public CreateLead enterphno(String phnum) 
	{
		clearAndType(phno, phnum);
		return this;
	}

	public CreateLead submit()
	{
		createleadbtn.click();
		return this;
	}
	
	public String verifyFirstName()
	{
		String vfname = verifyname.getText();
		return vfname;
	}

	public MergeLead verifyMergePage()
	{
		findlead.click();
		return new MergeLead();
	}
	
	public EditLead verifyEditPage()
	{
		findlead.click();
		return new EditLead();
	}

	public DeleteLead verifyDeletePage()
	{
		findlead.click();
		return new DeleteLead();
	}
	
	public DuplicateLead verifyDuplicatePage()
	{
		findlead.click();
		return new DuplicateLead();
	}
}
