package com.orangehrm.test;

import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;

public class AddUserTest extends AbstractTest {
	
	@Test 
	public void addNewUser(){
		
//		WebDriverFactory.getDriver().get("http://192.168.0.103/orangehrm-3.3.1/symfony/web/index.php/auth/login");
		
		 LoginPage lp = new LoginPage();
		 lp.login("govindarevanwar", "govinda!")
		 	.navigateToAdminPage()
		 		.NavigateToAddUser()
		 			.AddUser();
		 
/*
		 HomePage hp = new HomePage();
		 hp.VerifyLoginText();
		 hp.NavigateToAdminPage();
		 
		 AdminPage ap = new AdminPage();
		 ap.NavigateToAddUser();
		 
		 AddUserPage aup = new AddUserPage();
		 aup.AddUser();
*/		 
		 		
	}
	
	

}
