package com.orangehrm.test;

import javax.xml.ws.WebFault;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.orangehrm.common.WebDriverFactory;

public class FrameTest {

//	@Test
	public void frameHandling()
	{
//		WebDriverFactory.getDriver().navigate().to("http://192.168.0.105:8080/selenium-test/Inner.html");
		WebDriverFactory.getDriver().navigate().to("file:///F:/REST-API-Automation/frames/a.html");	
		
		
//		WebDriverFactory.getDriver().switchTo().frame(0);
//		WebDriverFactory.getDriver().switchTo().frame(WebDriverFactory.getDriver().findElement(By.id("2")));
		//WebDriverFactory.getDriver().switchTo().frame(WebDriverFactory.getDriver().findElement(By.xpath("/html/frameset/frame")));
		System.out.println(WebDriverFactory.getDriver().findElement(By.xpath("/html/body/div")).getText());
		
		
	}
	
//	@Test
	public void singleFrame()
	{
		WebDriverFactory.getDriver().navigate().to("file:///F:/REST-API-Automation/frames/Inner.html");
		WebDriverFactory.getDriver().switchTo().frame(WebDriverFactory.getDriver().findElement(By.id("2")));
		//WebDriverFactory.getDriver().switchTo().frame(WebDriverFactory.getDriver().findElement(By.xpath("/html/frameset/frame")));
		System.out.println(WebDriverFactory.getDriver().findElement(By.xpath("/html/body/div")).getText());
		
	}
	
//	@Test
	public void frameInFrame()
	{
		WebDriverFactory.getDriver().navigate().to("file:///F:/REST-API-Automation/frames/im.html");
		
		//Switch to Frame by providing find WebElement located by ID
		WebDriverFactory.getDriver().switchTo().frame(WebDriverFactory.getDriver().findElement(By.id("1")));
		
		WebDriverFactory.getDriver().switchTo().frame(0);
		
		System.out.println(WebDriverFactory.getDriver().findElement(By.xpath("/html/body/div")).getText());
		
	}
	@Test
	public void multipleFrames()
	{
		WebDriverFactory.getDriver().navigate().to("file:///F:/REST-API-Automation/frames/frames.html");
		
		WebDriverFactory.getDriver().switchTo().frame(0);
		System.out.println(WebDriverFactory.getDriver().findElement(By.xpath("/html/body/div")).getText());
		
		WebDriverFactory.getDriver().switchTo().defaultContent();
		
		WebDriverFactory.getDriver().switchTo().frame(WebDriverFactory.getDriver().findElement(By.xpath("/html/frameset/frame[2]")));
		
		System.out.println(WebDriverFactory.getDriver().findElement(By.xpath("/html/body/div")).getText());
		
		WebDriverFactory.getDriver().switchTo().defaultContent();
		
		WebDriverFactory.getDriver().switchTo().frame(2);
		System.out.println(WebDriverFactory.getDriver().findElement(By.xpath("/html/body/div")).getText());
		
		
	}
}
