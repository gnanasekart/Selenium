package Practices.Pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;

import bsh.util.Util;

public class javaScriptExecutorDemo 
{
	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.driver.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver86.exe");
		WebDriver d = new ChromeDriver();
		d.get("http://leaftaps.com/opentaps/control/main");
		d.manage().window().maximize();
		d.manage().deleteAllCookies();
		d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement button = d.findElement(By.className("decorativeSubmit"));
		//highlight element
		flash(button, d);

		//takescreen shot
		File file = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./Selenium/screenshots/jsss.jpg"));

		drawborder(button, d);
		//clickelementbyJs(button, d);
		pageRefresh(d);
		System.out.println(returntitle(d));
		
		System.out.println(getinnerbody(d));
		scrolling(d);
		

		//getAlert(d, "Hello! alert msg");
		d.close();
	}


	public static void flash(WebElement element, WebDriver driver) 
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor  = element.getCssValue("backgroundColor");
		for (int i = 0; i <  10; i++) 
		{
			changeColor("rgb(0,200,0)", element,driver);//1
			changeColor(bgcolor, element,driver);//2
		}
	}
	public static void changeColor(String color, WebElement element, WebDriver driver) 
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);

		try {
			Thread.sleep(20);
		}  catch (InterruptedException e) {
		}
	}

	public static void drawborder(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);    	
	}

	public static void getAlert(WebDriver driver, String msg)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("alert('"+msg+"')");
	}

	public static void clickelementbyJs(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click()", element);
	}

	public static void pageRefresh(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}

	public static String returntitle(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	public static String getinnerbody(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String text = js.executeScript("return document.documentElement.innerText;").toString();
		return text;
	}
	
	public static void scrolling(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("windows.scrollTo(0, document.body.scrollheight)");
		}
}