package com.org.qa.pages;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.org.qa.base.TestBase;

public class Login extends TestBase
{

	@CacheLookup
	@FindBy(how=How.ID, using="username")
	WebElement username_field;

	@FindBy(how=How.ID, using="password")
	WebElement password_field;

	@FindBy(how=How.CLASS_NAME, using="decorativeSubmit")
	WebElement loginbtn;

	@FindBy(how=How.XPATH, using="//div[@for='crmsfa']")
	WebElement crmsfabtn;

	@FindBy(how=How.XPATH, using="//div[@id='logo']//img")
	WebElement logo;

	@FindBy(how=How.XPATH, using="//b[text()='demosalesmanager']")
	WebElement verifyusername;
	
	public Login()
	{
		PageFactory.initElements(d, this);
	}	

	public void title()
	{
		String pagetitle = d.getTitle();
		Assert.assertEquals(pagetitle, "Leaftaps - TestLeaf Automation Platform", "Page Title does not match");
	}

	public boolean logo()
	{
		return logo.isDisplayed();
	}

	public CreateLead landPage(String uname, String pword)
	{	
		clearAndType(username_field, uname);
		clearAndType(password_field, pword);
		loginbtn.click();
		crmsfabtn.click();
		return new CreateLead();
	}
	
	public String verifyUserName()
	{
		String uname = verifyusername.getText();
		return uname;
	}
}
