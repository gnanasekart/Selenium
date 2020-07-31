package com.org.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.org.qa.base.TestBase;

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

	public void createLead()
	{
		clkcreatelead.click();
	}

	public void verifyCreateleadPageTitle()
	{	
		String title = d.getTitle();
		Assert.assertEquals(title, "Create Lead | opentaps CRM", "Wrong Create Lead page title");
	}

	public void verifyPageName()
	{
		String pname = pagename.getText();
		Assert.assertEquals(pname, "Create Lead", "Wrong page name");
	}

	public CreateLead enterCompanyName(String cname)
	{
		clearAndType(companyname, cname);
		return this;
	}

	public CreateLead enterFirstName(String firstname)
	{
		//fname.sendKeys(firstname);
		clearAndType(fname, firstname);
		return this;
	}	
	
	public CreateLead enterLastName(String lastname)
	{
		//fname.sendKeys(firstname);
		clearAndType(lname, lastname);
		return this;
	}	
	
	public CreateLead enterphno(String phnum) 
	{
		//phno.sendKeys(phnum);
		clearAndType(phno, phnum);
		return this;
	}

	public CreateLead submit()
	{
		createleadbtn.click();
		return this;
	}
	
	public CreateLead verifyFirstName()
	{
		String vfname = verifyname.getText();
		Assert.assertEquals(vfname, "manoj", "correct first name");
		return this;
	}
	
	public DuplicateLead verifyViewLeadTitle()
	{
		String viewlead = d.getTitle();
		Assert.assertEquals(viewlead, "View Lead | opentaps CRM", "Correct lead page");
		return new DuplicateLead();
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
