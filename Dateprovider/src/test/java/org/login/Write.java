package org.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Write extends Method{
	public Write() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="order_no")
	private WebElement orderno;
	
	private WebElement Billadd;

	public WebElement getOrderno() {
		return orderno;
	}

	public WebElement getBilladd() {
		return Billadd;
	}
}
