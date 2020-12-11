package PracticesDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriver {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver86.exe");
		WebDriver d = new ChromeDriver();
		
	//	WebDriver d = new HtmlUnitDriver();
		d.manage().window().maximize();
		d.manage().deleteAllCookies();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		d.manage().timeouts().pageLoadTimeout(20, TimeUnit.MILLISECONDS);
		
		
		
		d.get("http://leaftaps.com/opentaps/control/main");	
		System.out.println("title : "+d.getTitle());
		d.findElement(By.id("username")).sendKeys("Demosalesmanager");
		d.findElement(By.id("password")).sendKeys("crmsfa");
		d.findElement(By.className("decorativeSubmit")).click();
		System.out.println("title : "+d.getTitle());

	}

}
