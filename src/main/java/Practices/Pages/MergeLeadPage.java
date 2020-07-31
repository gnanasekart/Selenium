package Practices.Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MergeLeadPage extends BaseProject {
@Test
	public void mergeLead() throws InterruptedException {
	
		d.findElementByXPath("//div[@class='x-panel-header']//following::a[1]").click();
		d.findElementByXPath("//a[text()=\"Merge Leads\"]").click();
		
		Actions action = new Actions(d);
		action.click(d.findElementByXPath("//span[text()='From Lead']//following::a[1]")).perform();
		
		Set<String> wh = d.getWindowHandles();
		List<String> whs = new ArrayList<>();
		whs.addAll(wh);
		d.switchTo().window(whs.get(1));
		System.out.println(d.getTitle());
		
		d.findElementByXPath("//label[text()='Lead ID:']/following::input[1]").sendKeys("100");
		d.findElementByXPath("//button[text()= 'Find Leads']").click();
		
		Thread.sleep(2000);
		String mergefrom = d.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a").getText();
		String mergeto = d.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a").getText();
		d.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a").click();
		
		d.switchTo().window(whs.get(0));
		System.out.println(d.getTitle());
		
		d.findElementByXPath("(//input[@class='XdijitInputField dijitInputFieldValidationNormal'])[2]").sendKeys(mergeto);
		d.findElementByXPath("//a[@class='buttonDangerous']").click();
		
		d.switchTo().alert().accept();
		d.switchTo().defaultContent();
		
		d.findElementByXPath("//a[text()='Find Leads']").click();
		d.findElementByXPath("//label[text()='Lead ID:']/following::input[1]").sendKeys(mergefrom);
		d.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		String result = d.findElementByXPath("//div[text()='No records to display']").getText();
		if(result.equalsIgnoreCase("No records to display"))
				{
			System.out.println("correct result");
				}
		else
		{
			System.out.println("incorrect result");
		}
		
		
//		if(d.findElementByXPath("//div[text()='No records to display']").isDisplayed())
//		{
//			System.out.println("correct result");
//		}
	}
}
