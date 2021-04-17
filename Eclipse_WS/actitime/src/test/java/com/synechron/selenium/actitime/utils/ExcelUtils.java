package com.synechron.selenium.actitime.utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	
	private static File file =null;
	private static Workbook wb = null;
	private static Sheet sh = null;
	private static Row row = null;
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		Workbook wb = getWorkBook();
		System.out.println("Total number of sheets " + wb.getNumberOfSheets());
		
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			System.out.println(wb.getSheetName(i));
			
		}
		
		sh = getMySheet("createcustomer");
		
		int rowCount = sh.getLastRowNum()+1;
		Row row;
		Cell cell1, cell2;
		for (int i = 0; i < rowCount; i++) 
		{
			row = sh.getRow(i);
			cell1 = row.getCell(0);
			cell2 = row.getCell(1);
			System.out.println(" | " + cell1 + " | " + cell2+ " | ");
		}
		
	}
	
	public static String getCellValue(String sheetName, int rowNum, int colNum) throws IOException
	{
		sh = getMySheet(sheetName);
		row = sh.getRow(rowNum);
		return row.getCell(colNum).toString();
		
	}
	public static int getRowCount(String sheetName) throws IOException {
		sh = getMySheet(sheetName);
		return sh.getLastRowNum()+1;
	}

	public static Sheet getMySheet(String sheetName) throws IOException {
		wb = getWorkBook();
		sh = wb.getSheet(sheetName);
		return sh;
	}

	public static Workbook getWorkBook() throws IOException {
		file = new File("data/actitime-testdata.xls");
		wb = WorkbookFactory.create(file);
		return wb;
	}

}
