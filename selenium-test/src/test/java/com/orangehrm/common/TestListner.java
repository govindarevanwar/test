package com.orangehrm.common;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

//public class TestListner implements ITestListener {
public class TestListner implements IInvokedMethodListener{

	@Override
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		
		WebDriverFactory.getDriver().quit();
	}

	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {

		WebDriverFactory.SetDriver();
		
	}
	


}


