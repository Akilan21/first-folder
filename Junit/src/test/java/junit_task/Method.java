package junit_task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Method {
	static WebDriver driver;

	public static void Browser(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		}

	public static void  sendText(WebElement element , String value) {
		element.sendKeys(value);
	}
	
	public static void buttonclick(WebElement element) {
		element.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
