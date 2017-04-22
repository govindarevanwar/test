package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.common.Utility;
import com.orangehrm.common.WebDriverFactory;

public class HomePage {
//	WebDriver dr;

	Utility util = new Utility();
	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement AdminPagelink;
	
	
	@FindBy(partialLinkText="Welcome")
	WebElement VerifyLoginText;
	
	public HomePage()
	{
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}
	
	public void VerifyLoginText()
	{
		if(VerifyLoginText.getText().toLowerCase().contains("welcome"))
		{
			System.out.println("Login Successful");
		}
		else
		{
			System.out.println("Login Unsuccessful");
		}
			
		
	}
	public AdminPage navigateToAdminPage()
	{
		AdminPagelink.click();
		
		AdminPage ap= new AdminPage();
		if(ap.isPageLoaded())
		{
			return ap;
			
		}
		else
		{
			return null;
		}
	}
	public boolean isPageLoaded()
	{

		System.out.println("Home Page : Welcome button"+ VerifyLoginText);
		return util.waitForPageElement("id", "welcome");
	}
	
	
}
