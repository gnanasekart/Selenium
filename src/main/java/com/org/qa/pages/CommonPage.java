package com.org.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.org.qa.base.TestBase;

public class CommonPage extends TestBase {
	
	@FindBy(linkText="Find Leads")
	WebElement findlead;
	
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
