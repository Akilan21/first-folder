package junit_task;

import org.junit.Test;
import org.openqa.selenium.WebElement;


public class Adactivehome extends Method {


private WebElement username;


private WebElement password;


private WebElement login;

@Test
public WebElement getUsername() {
	return username;
}

public WebElement getPassword() {
	return password;
}

public WebElement getLogin() {
	return login;
}

}
