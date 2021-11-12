package base_task;



import org.openqa.selenium.WebElement;



public class Adactin extends Method {
	public static void main(String[] args)  {
	Adactin a = new Adactin();
	a.Browser("https://adactinhotelapp.com");
	WebElement locator = a.locator("id", "username");
	
	}

}
