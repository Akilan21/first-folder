package org.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Method {
	static WebDriver driver;

	public static void Browser(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		}

	public static WebElement locator (String loctype, String value) {
		if(loctype.equals("xpath")) {
			WebElement Q = driver.findElement(By.xpath(value));
			return Q;
			}
		else if(loctype.equals("name")){
			WebElement W = driver.findElement(By.name(value));
			return W;
		}
		else {
			WebElement I = driver.findElement(By.id(value));
			return I;	
			}
				}
	public static void  sendText(WebElement element , String value) {
		element.sendKeys(value);
	}
	
	public static void buttonclick(WebElement element) {
		element.click();
	}
	
	public static String excelread(int rowindex, int cellindex) throws IOException {
		File f = new File("D:\\excel\\Book1.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet("akil");
		Row row = sheet.getRow(rowindex);
		Cell cell = row.getCell(cellindex);
		int cellType = cell.getCellType();
				
		if(cellType==1) {
		String stringCellValue = cell.getStringCellValue();
		return stringCellValue;
				}
				
		else if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
			String format = s.format(dateCellValue);
			return format;
			}
		else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long)numericCellValue;
			String valueOf = String.valueOf(l);
			return valueOf;
		}
	}
	public static void selectByIndex(WebElement element, int value) {
		Select s = new Select(element);
		s.selectByIndex(value);	
		}
	public static void clear(WebElement element) {
		element.clear();
}
	
	public static void excelWrite(int rowindex,int cellindex,String value) throws IOException {
		File f1 = new File("D:\\excel\\Book1.xlsx");
		FileOutputStream stream1 = new FileOutputStream(f1);
		Workbook w = new XSSFWorkbook();
		Sheet createSheet1 = w.createSheet("sheet");
		Row createRow1 = createSheet1.createRow(rowindex);
		Cell createCell1 = createRow1.createCell(cellindex);
		createCell1.setCellValue(value);
		w.write(stream1);
		}


/*public static void getattribute (WebElement element, String value) {
	element.getAttribute(value);}
	*/
}











