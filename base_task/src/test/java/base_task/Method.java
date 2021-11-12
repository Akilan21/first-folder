package base_task;

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

public class Method {
	
	WebDriver driver;

	public void Browser(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		
		}

	public WebElement locator (String loctype, String path) {
		if(loctype.equals("xpath")) {
			WebElement Q = driver.findElement(By.xpath(path));
			return Q;
			}
		else if(loctype.equals("name")){
			WebElement W = driver.findElement(By.name(path));
			return W;
		}
		else {
			WebElement I = driver.findElement(By.id(path));
			return I;	
			}}
	
	public void  sendText(WebElement element , String text) {
		element.sendKeys(text);
	}
	
	public String excelread(String path, String sheetname, int rowindex, int cellindex) throws IOException {
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
		}}
	
	
}
