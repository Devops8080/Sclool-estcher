package com.qa.Opencart.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ExcelUtil {
	
	public WebDriver driver;
	public static final String TestExcelData= "C:\\Users\\Nelly\\eclipse-workspace\\NellyAndLakshmiProject\\src\\test\\resources\\AutomationProject.xlsx";
	public static Workbook book;
	public static Sheet sheet;
	public ExcelUtil(WebDriver driver)
	{
		this.driver = driver;
	}
	/**
	 * Create method for ExcelSheet
	 */
	
	public static Object [][] getTestData(String SheetName)
	{
		Object[][] data = null;
		try {
			FileInputStream input = new FileInputStream(TestExcelData);
			// It will create memory for Excel sheet			
			book = WorkbookFactory.create(input);
			 sheet = book.getSheet("Register");
			 data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
				// sheet.getLastRowNum()= 6	 
				//sheet.getRow(0).getLastCellNum()=(0,1)
			 for(int i=1; i<sheet.getLastRowNum();i++)
			 {
				 for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
				 {
					 data[i][j]=sheet.getRow(i+1).getCell(j).toString();
					 //data will be converted into String format
				 }
			 }
					 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	
	

}
