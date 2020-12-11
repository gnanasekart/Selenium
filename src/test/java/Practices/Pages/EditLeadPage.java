package Practices.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class EditLeadPage extends BaseProject {

	@Test
	public void editLead() throws InterruptedException {
		
		d.findElementByXPath("//a[text()='Leads']").click();
		d.findElementByXPath("//a[text()='Find Leads']").click();
		d.findElementByXPath("//label[text()='Lead ID:']//following::input[2]").sendKeys("manoj");
		d.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		d.findElementByXPath("(//table[@class='x-grid3-row-table']//a)[1]").click();
		
		if(d.getTitle().equals("View Lead | opentaps CRM"))
		{
			System.out.println("correct title");
		}
		d.findElementByXPath("//div[@class='frameSectionExtra']//a[text()='Edit']").click();
		d.findElementById("updateLeadForm_companyName").clear();
		d.findElementById("updateLeadForm_companyName").sendKeys("leaf");
		d.findElementByXPath("//input[@value='Update']").click();
		String cname = d.findElementById("viewLead_companyName_sp").getText();
		
		if (cname.trim().equals("leaf"))
		{
			System.out.println("correct name edited");
		}
		}
}
