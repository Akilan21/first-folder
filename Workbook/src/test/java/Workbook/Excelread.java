package Workbook;

import java.io.File;
import java.io.FileInputStream;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Excelread {
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
	
		
	public static String excelread(String path, String sheetname, int rowindex, int cellindex) throws IOException {
		File f = new File(path);
		FileInputStream stream = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet(sheetname);
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
	public static void main(String[] args) throws IOException {
		Excelread a = new Excelread();
		a.Browser("https://adactinhotelapp.com/");
		String excelread = a.excelread("D:\\excel\\Book1.xlsx", "akil", 0, 0);
		WebElement locator = a.locator("xpath", "//input[@type='text']");
		a.sendText(locator, excelread);
		
	}










}
