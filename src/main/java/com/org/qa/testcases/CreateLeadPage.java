package com.org.qa.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.org.qa.base.TestBase;
import com.org.qa.pages.CreateLead;
import com.org.qa.pages.CreateLead;
import com.org.qa.pages.Login;
import com.org.qa.util.UtilTest;

public class CreateLeadPage extends TestBase {

	Login login;
	CreateLead create;
	UtilTest utils;
	String sheetname = "Createlead";

	public CreateLeadPage()
	{
		super();
	}

	@BeforeTest
	public void setUp() throws MalformedURLException
	{
		initialize();
		d.get(prop.getProperty("url"));
		login = new Login();
		login.title();
		create = login.landPage(prop.getProperty("username"), prop.getProperty("password"));
		create.createLead();
	}

	@Test(priority=1)
	public void verifypagename()
	{
		String pageName = create.verifyPageName();
		Assert.assertEquals(pageName, "Create Lead", "Wrong page name");
	}

	@Test(priority=2)
	public void verifypagetitle()
	{
		String pagetitle = create.verifyCreateleadPageTitle();	
		Assert.assertEquals(pagetitle, "Create Lead | opentaps CRM", "Wrong Create Lead page title");
	}

	@Test(priority=3, dataProvider="loginInputdata", enabled=false)
	public void verifyPage(String Companyname, String Firstname, String Lastname, String Phonenumber)
	{
		create.enterCompanyName(Companyname);
		create.enterFirstName(Firstname);
		create.enterLastName(Lastname);
		create.enterphno(Phonenumber);
		create.submit();
	}
	
	@Test(priority=3, enabled=true)
	public void verifyPage()
	{
		create.enterCompanyName(prop.getProperty("companyname"));
		create.enterFirstName(prop.getProperty("firstname"));
		create.enterLastName(prop.getProperty("lastname"));
		create.enterphno(prop.getProperty("phonenumber"));
		create.submit();
		//create.verifyFirstName();
	}

	@Test(priority=4, enabled=true)
	public void verifyfirstname()
	{
		String firstname = create.verifyFirstName();
		Assert.assertEquals(firstname.toLowerCase(), "manoj", "correct first name");
	}

	@Test(priority=5, enabled=true)
	public void verifyleadtitle()
	{
		String viewlead = create.verifyViewLeadTitle();
		Assert.assertTrue(viewlead.contains("View Lead"));
		Assert.assertEquals(viewlead, "View Lead | opentaps CRM", "Correct lead page");
	}

	@AfterTest
	public void teardown()
	{
		d.quit();
	}
	
	@DataProvider
	public Object[][] loginInputdata() throws IOException
	{
		Object[][] data = UtilTest.testData(sheetname);
		return data;
	}
}
