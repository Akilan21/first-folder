package org.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hotelsearch extends Method{
	
	public Hotelsearch() {
		PageFactory.initElements(driver, this);
			}
	
	@FindBy(xpath="//select[@name='location']")
	private WebElement location;
	
	@FindBy(xpath="//select[@name='hotels']")
	private WebElement hotel;
	
	@FindBy(id="room_type")
	private WebElement roomtype;
	
	@FindBy(id="room_nos")
	private WebElement noofromm;
	
	@FindBy(xpath="//input[@name='datepick_in']")
	private WebElement checkin;
	
	@FindBy(xpath="//input[@name='datepick_out']")
	private WebElement chechout;
	
	@FindBy(id="adult_room")
	private WebElement adult;
	
	@FindBy(id="child_room")
	private WebElement children;
	
	@FindBy(id="Submit")
	private WebElement search;
	
	public WebElement getChechout() {
		return chechout;
	}

	public WebElement getAdult() {
		return adult;
	}

	public WebElement getChildren() {
		return children;
	}

	public WebElement getSearch() {
		return search;
	}
	public WebElement getNoofromm() {
		return noofromm;
	}

	public WebElement getCheckin() {
		return checkin;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public WebElement getRoomtype() {
		return roomtype;
	}
	
}
