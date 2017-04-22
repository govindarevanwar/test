package com.orangehrm.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.common.WebDriverFactory;

public class LoginPage {

	
	@FindBy(name="txtUsername")
	WebElement userName; //= dr.findElement(By.name("txtUsername"));
	
	@FindBy(id="txtPassword")
	WebElement password;// = dr.findElement(By.id("txtPassword"));
	
	@FindBy(name="Submit")
	WebElement login;// = dr.findElement(By.name("Submit"));
	
	@FindBy(id="spanMessage")
	WebElement errorMessage;
	
	@FindBy(xpath="//img[@alt='LinkedIn OrangeHRM group']")
	WebElement linkedInLink;
	
	@FindBy(xpath="//img[@alt='OrangeHRM on Facebook']")
	WebElement facebookLink;
	
	@FindBy(xpath="//img[@alt='OrangeHRM on twitter']")
	WebElement twitterLink;
	
	@FindBy(xpath="//img[@alt='OrangeHRM on youtube']")
	WebElement youTubeLink;
	
	public LoginPage()
	{
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}
	
	public HomePage login(String UserName, String Password)
	{
		
		//WebElement userName= dr.findElement(By.name("txtUsername"));
		userName.sendKeys(UserName);
		
		//WebElement password = dr.findElement(By.id("txtPassword"));
		password.sendKeys(Password);
		
		//WebElement login = dr.findElement(By.name("Submit"));
		login.click();
		
		HomePage hp = new HomePage();
		if (hp.isPageLoaded())
		{
			return hp;
			
		}
		else
		{
			return null;
		}	
	}
	
	public HomePage login()
	{
		

		userName.sendKeys("govindarevanwar");
		
		password.sendKeys("govindar!");
		
		login.click();
		
		HomePage hp = new HomePage();
		if (hp.isPageLoaded())
		{
			return hp;
		}
		else
		{
			return null;
		}
		

	}
	public void invalidLogin(String UserName, String Password)
	{
		userName.sendKeys(UserName);
		
		password.sendKeys(Password);
	
		login.click();
	}
	

	public void validateLoginErrorMsg(String errorMessage)
	{
		
	}
	
	public LoginPage navigateToLinkedInPage()
	{
		linkedInLink.click();
		return this;
	}
	

	public LoginPage navigateToFacebookPage()
	{
		facebookLink.click();
		return this;
	}
	
	public LoginPage navigateToTwitterPage()
	{
		twitterLink.click();
		return this;
	}
	
	public LoginPage navigateToYoutubePage()
	{
		youTubeLink.click();
		return this;
	}
}
