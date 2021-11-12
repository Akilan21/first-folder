package Workbook;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelread1 {
	public static void main(String[] args) throws IOException
	{
//		File f = new File("D:\\excel\\akil.xlsx");
//		FileInputStream stream = new FileInputStream(f);
//		Workbook w = new XSSFWorkbook();
//		Sheet sheet = w.getSheet("abcd");
//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(0);
//		String stringCellValue = cell.getStringCellValue();
//		System.out.println(stringCellValue);
		
		File f = new File("D:\\excel\\akil.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet("abcd");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		String stringCellValue = cell.getStringCellValue();
		System.out.println(stringCellValue);
		
	}

}
