package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.common.Utility;
import com.orangehrm.common.WebDriverFactory;

public class AddUserPage {
	WebDriver dr;
	Utility util = new Utility();
	@FindBy(id="systemUser_employeeName_empName")
	WebElement EmployeeName;
	@FindBy(id="systemUser_userName")
	WebElement UserName;
	@FindBy(id="systemUser_password")
	WebElement Password;
	@FindBy(id="systemUser_confirmPassword")
	WebElement ConfirmPassword;
	
	@FindBy(id="btnSave")
	WebElement SaveButton;
	
	public AddUserPage()
	{
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}
	
	public void AddUser()
	{
		EmployeeName.sendKeys("testuser");
		UserName.sendKeys("testuser");
		Password.sendKeys("testuser");
		ConfirmPassword.sendKeys("testuser");
		
		SaveButton.click();
		
	}

	public boolean isPageLoaded() {

		System.out.println("Add User Page : Save Button="+SaveButton);
		return util.waitForPageElement("id", "btnSave");
	}
	

}
