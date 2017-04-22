package com.orangehrm.test;


import org.testng.annotations.Test;

import com.orangehrm.common.WebDriverFactory;
import com.orangehrm.pages.LoginPage;

public class LoginTest extends AbstractTest{

	
	String URL = "http://192.168.0.103/orangehrm-3.3.1";
	
//	String URL = "http://opensource.demo.orangehrmlive.com";

//	@Test(dataProvider="excelData")
	public void verifySuccessfulLogin(String UserName, String Password)
	{
		
		LoginPage lp = new LoginPage();
		lp.login(UserName, Password)
			.VerifyLoginText();

//		HomePage hp = new HomePage();
//		hp.VerifyLoginText();
		
		
	}
	@Test
	public void externalLinkTest()
	{
	
		LoginPage lp = new LoginPage();
		
		lp.navigateToFacebookPage();
//		System.out.println(WebDriverFactory.getDriver().getTitle());
		lp.navigateToLinkedInPage();
//		System.out.println(WebDriverFactory.getDriver().getTitle());
		lp.navigateToTwitterPage();
//		System.out.println(WebDriverFactory.getDriver().getTitle());
		lp.navigateToYoutubePage();
//		System.out.println(WebDriverFactory.getDriver().getTitle());
		String parentWinHandel = WebDriverFactory.getDriver().getWindowHandle();
		System.out.println(parentWinHandel);
		Object[] allWinHandles = WebDriverFactory.getDriver().getWindowHandles().toArray();
		
		
		for(Object window :allWinHandles)
		{
			System.out.println("Winbdow Handel To string "+window.toString());
//			System.out.println("Winbdow Handel TypeCast string "+(String)window);
			WebDriverFactory.getDriver().switchTo().window((String) window);
			
			System.out.println(WebDriverFactory.getDriver().getTitle());
			
			
			if(!parentWinHandel.equals(window))
			{
				WebDriverFactory.getDriver().close();
			}
			
		
		}
	}
	public void verifyInvalidLoginError(String UserName, String Password, String ErrorMsg)
	{
		LoginPage lp = new LoginPage();
		lp.login(UserName, Password);
		
		
	}
		
}
