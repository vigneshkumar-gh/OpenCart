package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	FileInputStream fi;
	FileOutputStream fo;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	String path;
	
	ExcelUtility(String path){
		this.path = path;
	}
	
	public int noOfRows(String sheetName) throws IOException {
		fi = new FileInputStream(path);
		workbook= new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rows;
	}
	
	public int noOfCells(String sheetName, int rowNum) throws IOException {
		fi = new FileInputStream(path);
		workbook= new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cells = row.getLastCellNum();
		workbook.close();
		fi.close();
		return cells;
	}
	
	public void modifyCellData(String sheetName, int rowNum, int columnNum, String data) throws IOException {
		fo = new FileOutputStream(path);
		workbook= new XSSFWorkbook();
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(columnNum);
		cell.setCellValue(data);
		
		workbook.write(fo);
		workbook.close();
		fo.close();
	}
	public String getCellData(String sheetName, int rowNum, int columnNum) throws IOException {
		fi = new FileInputStream(path);
		workbook= new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(columnNum);
		String data;
		try {
			data = cell.getStringCellValue(); 		// exception if cell has integers
		}
		catch(Exception e) {
			data = "";
		}
		return data;
	}
	
	public void setCellData(String sheetName, int rowNum, int columnNum, String data) throws IOException {
		
		File file = new File(path);
		if(!file.exists()) {							//checks file exists
			workbook = new XSSFWorkbook();
			fo = new FileOutputStream(path);
			workbook.write(fo);
		}
		
		if(workbook.getSheetIndex(sheetName) < 0) {
			sheet = workbook.createSheet(sheetName);	// checks sheet exists
		}
		if(sheet.getRow(rowNum) == null) {
			row = sheet.createRow(rowNum);				// checks row exists
		}
		cell = row.getCell(columnNum);
		cell.setCellValue(data);
		fo = new FileOutputStream(path);
		workbook= new XSSFWorkbook();
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell.setCellValue(data);
		workbook.write(fo);
		workbook.close();
		fo.close();
	}
		
		

}
