package com.orangehrm.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	WebDriverWait wt;
	// Explicit wait use for Ajax or when page is changing dynamically
	public void waitForElement(WebElement element)
	{
		wt = new WebDriverWait(WebDriverFactory.getDriver(), 10);
//		wt.until(ExpectedConditions.visibilityOf(element));
	}
	
	//preferred way by Vaibhav
	public boolean waitForPageElement(String locator, String locatorDescription)
	{
		int retrycount=0;
		while (retrycount<20)
		{
			try
			{
		switch (locator) {
		case "id":
			WebDriverFactory.getDriver().findElement(By.id(locatorDescription));
			
			return true;			
			
		case "xpath":
			WebDriverFactory.getDriver().findElement(By.xpath(locatorDescription));
			return true;
			
		}
			}catch(Exception e)
			{
				try {
					Thread.sleep(1000);
					retrycount++;
					
					System.out.println("Element "+ locatorDescription+" not Found By"+ locator +"in Sec"+ retrycount );
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
					
	}
		return false;
	}
}
