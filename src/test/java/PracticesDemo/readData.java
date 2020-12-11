package PracticesDemo;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
public class readData {
	public static String EXCEL_NAME = "leaddetails";
	public static String sheetname = "Createlead";
	 
		public static Object[][] testData() throws IOException{
			FileInputStream file = new FileInputStream("D:\\eclipse\\workspace\\Selenium\\Data\\lead.xlsx");
			XSSFWorkbook book = new XSSFWorkbook(file);
			XSSFSheet sheet = book.getSheetAt(1);
			int rowcount = sheet.getLastRowNum();
			int colcount = sheet.getRow(0).getLastCellNum();
			System.out.println("row count: "+rowcount+" column count: "+colcount);
			Object[][] data = new Object[rowcount][colcount];
			for(int i=1; i<=sheet.getLastRowNum(); i++){
				for(int j=0; j<=sheet.getRow(0).getLastCellNum(); j++){	
					data[i-1][j]= sheet.getRow(i).getCell(j).toString();
				}			}
			book.close();
			return data;
		}
		public static void main(String[] args) throws IOException
		{
			testData();
		}	}

