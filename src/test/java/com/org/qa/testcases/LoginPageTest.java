package com.org.qa.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.org.qa.base.TestBase;
import com.org.qa.pages.CreateLead;
import com.org.qa.pages.Login;
import com.org.qa.util.UtilTest;

public class LoginPageTest extends TestBase
{
	Login login;
	CreateLead create;
	UtilTest util;

	public LoginPageTest()
	{
		super();
	}

	@BeforeSuite
	public void setup() throws MalformedURLException
	{
		initialize();
		d.get(prop.getProperty("url"));
		login = new Login();
	}

	@Test(priority=2)
	public void verifyPageTitle()
	{
		login.title();
		
	}

	@Test(priority=1)
	public void verifylogo()
	{
		Boolean flag = login.logo();
		Assert.assertTrue(flag);
	}

	@Test(priority=3)
	public void loginTest()
	{
		create = login.landPage(prop.getProperty("username"),(prop.getProperty("password")));
		Assert.assertEquals(login.verifyUserName(), "demosalesmanager", "Username does not match");
	}

	@AfterSuite
	public void teardown()
	{
		d.quit();
	}
}
