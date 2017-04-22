package com.orangehrm.common;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {

	// Commented private static webdriver due to testng parallel execution. and its replaced by threadlocal
//	private static  WebDriver dr;
	public static ThreadLocal<WebDriver> tdl = new ThreadLocal<WebDriver>();
	
	public static void SetDriver()
	{
//		dr = new FirefoxDriver();
		DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setBrowserName(System.getenv("browserName"));
		cap.setBrowserName("chrome");
//		tdl.set(new FirefoxDriver());
		
		try {
			//tdl.set(new RemoteWebDriver(new URL(System.getenv("hubURL")), cap));
			System.out.println("************ Creating instace");
			tdl.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("!!!!!!!!!!! Unable to create driver object");
			e.printStackTrace();
		}
		tdl.get().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverFactory.getDriver().get("http://192.168.0.108/orangehrm-3.3.1");
		WebDriverFactory.getDriver().manage().window().maximize();
				
	}
	
	public static WebDriver getDriver()
	{
//		return dr;
		return tdl.get();
	}
}
