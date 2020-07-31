package com.org.qa.testdata;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class DataLibrary
{
	
	@Test
	public static Object[][] readExceldata() throws IOException
	{
		XSSFWorkbook wbook = new XSSFWorkbook("./Data/TC001.xlsx");
		XSSFSheet sheet = wbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowCount][colcount];
		for(int i=1; i<=rowCount; i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0; j<=rowCount; j++)
			{
				XSSFCell cell = row.getCell(j);
				String cellvalue = cell.getStringCellValue();
				data[i-1][j] = cellvalue;
			}
		}
		wbook.close();
		return data;
	}
}

