package org.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Selecthotel extends Method {
	public Selecthotel() {
		PageFactory.initElements(driver, this);
	}
    
	@FindBy(id="radiobutton_0")
	private WebElement select;
	
	@FindBy(id="continue")
	private WebElement search;


	public WebElement getSelect() {
		return select;
	}


	public WebElement getSearch() {
		return search;
	}
	

}
