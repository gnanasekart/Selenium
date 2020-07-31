package com.org.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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

	@BeforeMethod
	public void setUp()
	{
		initialize();
		login = new Login();
		login.title();
		create = login.landPage(prop.getProperty("username"), prop.getProperty("password"));
		create.createLead();
	}

	@Test(priority=1, enabled=false)
	public void verifypagename()
	{
		create.createLead();
		create.verifyPageName();
	}

	@Test(priority=2, enabled=false)
	public void verifypagetitle()
	{
		create.createLead();
		create.verifyCreateleadPageTitle();		
	}

	@DataProvider
	public Object[][] loginInputdata() throws IOException
	{
		Object[][] data = UtilTest.testData(sheetname);
		return data;
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
	
	@Test
	public void verifyPage()
	{
		create.enterCompanyName(prop.getProperty("companyname"));
		create.enterFirstName(prop.getProperty("firstname"));
		create.enterLastName(prop.getProperty("lastname"));
		create.enterphno(prop.getProperty("phonenumber"));
		create.submit();
		create.verifyFirstName();
	}

	@Test(priority=4, dependsOnMethods="verifyPage", enabled=true)
	public void verifyfirstname()
	{
		create.verifyFirstName();
		//int c = 9/0;
	}

	@Test(priority=5, dependsOnMethods="verifyfirstname", enabled=false)
	public void verifyleadtitle()
	{
		create.verifyViewLeadTitle();	
	}

	@AfterMethod
	public void teardown()
	{
		d.quit();
	}
}
