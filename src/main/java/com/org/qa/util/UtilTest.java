package com.org.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.org.qa.base.TestBase;

public class UtilTest extends TestBase 
{

	public static long PAGE_LOAD_TIMEOUT=20 ;
	public static long IMPLICIT_WAIT = 10;
	public static String EXCEL_NAME = "leaddetails";
	public static long EXPLICIT_WAIT = 20;
	
	//sekar change
	public static void takeScreenshotAtEndOfTest1() throws IOException {
		File scrFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	public void switchToFrameName(String fname)
	{
		d.switchTo().frame(fname);
	}

	public void switchToFrameIndex(String findex)
	{
		d.switchTo().frame(findex);
	}
	
	public static Object[][] testData(String sheetname) throws IOException
	{
		XSSFWorkbook wbook = new XSSFWorkbook("./Data/"+EXCEL_NAME+".xlsx");
		XSSFSheet sheet = wbook.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=1; i<=sheet.getLastRowNum(); i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0; j<=sheet.getRow(0).getLastCellNum(); j++)
			{	
				XSSFCell cell = row.getCell(j);
				String cellvalue = cell.getStringCellValue();
				data[i-1][j] = cellvalue;
			}
		}
		wbook.close();
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	public static void takeScreenshotAtEndOfTests() throws IOException {
		File scrFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
