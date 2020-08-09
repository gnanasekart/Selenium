package PracticesDemo;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteWebDrivers {

	public static void main(String[] args) throws MalformedURLException 
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WIN10);
		
		ChromeOptions co = new ChromeOptions();
		co.merge(dc);
		
		String baseurl = "http://192.168.43.221:4444/wd/hub";
		WebDriver d = new RemoteWebDriver(new URL(baseurl), co);
		
		d.get("https://www.google.co.in");
		System.out.println(d.getTitle());
	}

}
