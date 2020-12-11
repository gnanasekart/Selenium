package PracticesDemo;
import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RemoteWebDrivers {
@Test
	public void main() throws MalformedURLException 
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		
		ChromeOptions co = new ChromeOptions();
		co.merge(dc);
		
		String baseurl = "http://localhost:4444";
		WebDriver d = new RemoteWebDriver(new URL(baseurl), co);
		
		d.get("https://www.google.co.in");
		System.out.println(d.getTitle());
	}

}
