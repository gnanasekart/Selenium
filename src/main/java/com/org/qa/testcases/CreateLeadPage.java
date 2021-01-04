package com.org.qa.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.org.qa.Report.TestAllureReports;
import com.org.qa.base.TestBase;
import com.org.qa.pages.CreateLead;
import com.org.qa.pages.CreateLead;
import com.org.qa.pages.Login;
import com.org.qa.util.UtilTest;

@Listeners({TestAllureReports.class})
//@Listeners({ExtentITestListenerClassAdapter.class})
public class CreateLeadPage extends TestBase {

	Login login;
	CreateLead create;
	UtilTest utils;
	String sheetname = "Createlead";

	public CreateLeadPage()
	{
		super();
	}

	@BeforeTest(description = "Initialize the browser")
	public void setUp() throws MalformedURLException
	{
		initialize();
		d.get(prop.getProperty("url"));
		login = new Login();
		login.title();
		create = login.landPage(prop.getProperty("username"), prop.getProperty("password"));
		create.createLead();
	}
/*
 * @Test - TestNG level
 * @Severity, @Description, @Story - from Allure report level
 * 
 */
	@Test(priority=1, description = "This Test case From Test level to verify Page name")
	/*@Epic("To Create lead")
	* @Feature("Create lead feature")
	  @Step("Verifying the page name")
	  @Link("http://leaftap.com")
	  @Severity(SeverityLevel.CRITICAL)
	  @Description("This test cases is from Allure report level to verify Page name")
	  @Story("This is from allure story level to verify Page name")
	*/
	public void verifypagename()
	{
		String pageName = create.verifyPageName();
		Assert.assertEquals(pageName, "Create Lead", "Wrong page name");
	}

	@Test(priority=2, description = "This Test case From Test level to verify Page title")
	/*@Severity(SeverityLevel.MINOR)
	@Description("This test cases is from Allure report level to verify page title")
	@Story("This is from allure story level to verify page title")
	*/
	public void verifypagetitle()
	{
		String pagetitle = create.verifyPageTitle();	
		Assert.assertEquals(pagetitle, "Create Lead | opentaps CRM", "Wrong Create Lead page title");
	}

	@Test(priority=3, enabled=false, description = "This Test case From Test level to Enter User details")
	/*@Severity(SeverityLevel.BLOCKER)
	@Description("This test cases is from Allure report level to Enter User details")
	@Story("This is from allure story level to Enter User details")
	*/
	public void verifyPage(String Companyname, String Firstname, String Lastname, String Phonenumber)
	{
		create.enterCompanyName(Companyname);
		create.enterFirstName(Firstname);
		create.enterLastName(Lastname);
		create.enterphno(Phonenumber);
		create.submit();
	}
	
	@Test(priority=3, enabled=true, description = "This Test case From Test level to Enter User details")
	/*@Severity(SeverityLevel.BLOCKER)
	@Description("This test cases is from Allure report level to Enter User details")
	@Story("This is from allure story level to Enter User details")
	*/
	public void verifyPage()
	{
		create.enterCompanyName(prop.getProperty("companyname"));
		create.enterFirstName(prop.getProperty("firstname"));
		create.enterLastName(prop.getProperty("lastname"));
		create.enterphno(prop.getProperty("phonenumber"));
		create.submit();
		//create.verifyFirstName();
	}

	@Test(priority=4, description = "This Test case From Test level to verify first name")
	/*
	@Severity(SeverityLevel.NORMAL)
	@Description("This test cases is from Allure report level to verify first name")
	@Story("This is from allure story level to verify first name")
	*/
	public void verifyfirstname()
	{
		String firstname = create.verifyFirstName();
		Assert.assertEquals(firstname.toLowerCase(), "manoj", "correct first name");
	}

	@Test(priority=5, description = "This Test case From Test level to verify page title")
	/*
	@Severity(SeverityLevel.MINOR)
	@Description("This test cases is from Allure report level to verify page title")
	@Story("This is from allure story level to verify page title")
	*/
	public void verifyleadtitle()
	{
		String viewlead = create.verifyPageTitle();
		Assert.assertTrue(viewlead.contains("View Lead"));
		Assert.assertEquals(viewlead, "View Lead | opentaps CRM", "Correct lead page");
	}

	@AfterTest(description = "Closing the browser")
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