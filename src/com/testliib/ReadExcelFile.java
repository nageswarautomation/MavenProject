package com.testliib;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	XSSFWorkbook wb;
	XSSFSheet sheet;
public ReadExcelFile(String excelPath) {
	try {
		File src=new File(excelPath);
		FileInputStream fis=new FileInputStream(src);
		wb=new XSSFWorkbook();
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	
	
}

//public int getRowCount(String sheetName) {
//	// TODO Auto-generated method stub
//	XSSFSheet sh=wb.getSheet(sheetName);
//	return 0;
//}
//public String getCellData(String sheetName, String row, int rowNum) {
//	// TODO Auto-generated method stub
//	String data=sheet.getSheetName();
//	return data;
//}

public int getRowCount(int sheetIndex) {
	// TODO Auto-generated method stub
	int row = wb.getSheetAt(sheetIndex).getLastRowNum();
	row=row+1;
	return row;
	
}

public Object getData(int sheetNumber, int row, int coloumn) {
	// TODO Auto-generated method stub
	sheet=wb.getSheetAt(sheetNumber);
	String data=sheet.getRow(row).getCell(coloumn).getStringCellValue();
	return data;
}

}
