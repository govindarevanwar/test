package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.common.Utility;
import com.orangehrm.common.WebDriverFactory;

public class AdminPage {

	WebDriver dr;
	Utility util = new Utility();
	@FindBy(id="btnAdd")
	WebElement AddUser;
	
	public AdminPage()
	{
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}
//	dr.findElement(By.id("btnAdd")).click();
	public  AddUserPage NavigateToAddUser()
	{
		AddUser.click();
		AddUserPage aup = new  AddUserPage();
		if(aup.isPageLoaded())
		{
			return aup;
		}
		else
		{
			return null;
		}
		
	}
	
	public boolean isPageLoaded()
	{
		System.out.println("Admin Page : Add User "+ AddUser);
		return util.waitForPageElement("id", "btnAdd");
	}
}
