package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;

public class CREATELEADGetDataFromExcel {

	public static String[][] excelRead(String filename)throws IOException {
		//static String[][] excelRead()
		//Set up the excel document path 
		XSSFWorkbook workbook = new XSSFWorkbook("./data/"+filename+".xlsx");
		//Set up the worksheet
		//XSSFSheet sheet = workbook.getSheetAt(1);
		   //or
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		//Get into the row
		XSSFRow row = sheet.getRow(1);
		//Get into the cell
		XSSFCell cell = row.getCell(0);
		
		//To find No of rows in a Worksheet
		int noOfRows = sheet.getLastRowNum();
		System.out.println(noOfRows);
		
		//To find No of cells in a Worksheet
		short lastCellNum = sheet.getRow(1).getLastCellNum();
		System.out.println(lastCellNum);
		
		//declare 2D Array
		String[][] data=  new String[noOfRows][lastCellNum];
		
		for (int i = 1; i < noOfRows; i++) {
			for (int j = 0; j < lastCellNum; j++) {
				String text = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(text);
				data[i-1][j] = text;
			}
		}
		workbook.close();
		return data;
	}

}
