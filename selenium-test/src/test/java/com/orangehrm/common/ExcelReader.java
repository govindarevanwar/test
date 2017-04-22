package com.orangehrm.common;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelReader {
	
	public static String[][] getExcelTable(String filePath, String SheetName) 
	{
		try{
//		FileInputStream stream = new FileInputStream("F:/REST-API-Automation/OrangeHRM/src/com/orangehrm/test/LoginTest.xls");
			FileInputStream stream = new FileInputStream(filePath);
		HSSFWorkbook wb = new HSSFWorkbook(stream);
		HSSFSheet sh = wb.getSheet(SheetName);
		System.out.println("Filepath = " +filePath);
		System.out.println("Sheet Name = " +SheetName);
		int usedRowCount = sh.getLastRowNum();
		int usedColCount = sh.getRow(0).getLastCellNum();
		
		String [][] strArr= new String[usedRowCount+1][usedColCount];

		System.out.println("used Row count = "+usedRowCount);
		System.out.println("Used Column count =" +usedColCount);
		HSSFRow row;
		HSSFCell cell;
		
		 
		for (int i = 0; i<=usedRowCount; i++)
		{
			for (int j = 0; j<usedColCount; j++)
			{
				
				row = sh.getRow(i);
				cell = row.getCell(j);
				
				switch(cell.getCellType())
				{
				
				case HSSFCell.CELL_TYPE_FORMULA:
					strArr[i][j] = cell.getCellFormula();
					break;
					
				case HSSFCell.CELL_TYPE_NUMERIC:
					strArr[i][j]= ""+ cell.getNumericCellValue();
                    break;

                case HSSFCell.CELL_TYPE_STRING:
                	strArr[i][j] = ""
                         + cell.getStringCellValue();
                    break;

                case HSSFCell.CELL_TYPE_BLANK:
                	strArr[i][j]= "[BLANK]";
                   break;

                case HSSFCell.CELL_TYPE_ERROR:
                	strArr[i][j] = ""+cell.getErrorCellValue();
                 break;
             default:
	
				}
				
				
//				strArr[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
	        			}
		}
		
		wb.close();
		return strArr;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

}
