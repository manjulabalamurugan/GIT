package testngAssigment;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] Excel(String fileName) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook("./data/"+fileName+".xlsx");
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
			//System.out.println(rowCount);
		short cellCount = sheet.getRow(1).getLastCellNum();
			//System.out.println(cellCount);
		
		String[][] data = new String[rowCount][cellCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(value+" ");
				data[i-1][j] = value;
			}
			System.out.println();
		}
		
		//workbook.close();
		return data;
	}

}
