package com.orangehrm.test;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.orangehrm.common.ExcelReader;


public class AbstractTest {
//	protected WebDriver dr;
	
	@DataProvider(name = "excelData")
	public String[][] getDataProvider(Method m)
	
	{
//	return DataProviderFactory.getDataTable();

//		System.out.println(m.getName());
//		System.out.println(m.getDeclaringClass().getResource(m.getDeclaringClass().getSimpleName()+".class"));
		
		System.out.println(getTestMethodName(m));
		System.out.println(getClassName(m));
		
		String methodName = getTestMethodName(m);
		String filePath = getClassName(m);
				
		return ExcelReader.getExcelTable(filePath, methodName);
	}

	private String getTestMethodName(Method m)
	{
		String mname = m.getName();
		
		return mname;
		
	}
	
	private String getClassName(Method m)
	{
		Class<?> cls = m.getDeclaringClass();
		
		String className = cls.getResource(cls.getSimpleName()+".class").getPath();
		className = className.replaceFirst(".class", ".xls");
		className=className.substring(1, className.length()).replace("/", "\\");
		
		return className;
		
	}
	
}
