package com.org.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Listeners;

import com.org.qa.util.WebEventListener;
import com.selenium.api.Design.Element;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TestBase implements Element
{

	public static WebDriver d;
	public static Properties prop;
	public static EventFiringWebDriver firedriver;
	public static WebEventListener eventlistener;

	public TestBase()
	{
		prop = new Properties();
		FileInputStream ip;
		try
		{
		ip = new FileInputStream("D:\\eclipse\\workspace\\Selenium\\src\\main\\java\\com\\org\\qa\\config\\config.properties");
			prop.load(ip);
		} 
		catch (FileNotFoundException e) 
		{	
			e.printStackTrace();
		}
		catch (IOException e)
		{	
			e.printStackTrace();
		}
	}

	public void initialize() throws MalformedURLException
	{
		
		
		String browser = prop.getProperty("browser");
		
		if(browser.equals("gchrome")) 
		{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		
		dc.setPlatform(Platform.WINDOWS);
		
		ChromeOptions co = new ChromeOptions();
		co.merge(dc);
		
		String baseurl = "http://192.168.43.221:4444/wd/hub";
		WebDriver d = new RemoteWebDriver(new URL(baseurl), co);
		}
		else if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.setHeadless(true);
			d = new ChromeDriver(option);
		}
		else if(browser.equals("ff"))
		{
			WebDriverManager.firefoxdriver().setup();
			d = new FirefoxDriver();
		}
		else if(browser.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			d = new InternetExplorerDriver();
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			d = new EdgeDriver();
		}
		
		firedriver = new EventFiringWebDriver(d);
		eventlistener = new WebEventListener();
		firedriver.register(eventlistener);
		d = firedriver;
		
		d.manage().window().maximize();
		d.manage().deleteAllCookies();
		d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		//d.get(prop.getProperty("url"));
	}
	
	public void clearAndType(WebElement ele, String data)
	{
		try {
			ele.clear();
			ele.sendKeys(data);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	}