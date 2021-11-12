package org.login;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider extends Method{
	
	@Test(dataProvider="adactin")
	private static void test(String username, String password, String s, String h, String r,String n, String c,String o,String d,
			String C, String F,String L, String bill,String cr, String ty, String mon, String yer, String cvv) throws IOException {
		Browser("https://adactinhotelapp.com/");
		Adactinhome a = new Adactinhome();
	 WebElement username2 = a.getUsername();
	 sendText(username2, username);
	 WebElement password2 = a.getPassword();
	 sendText(password2, password);
	 WebElement login = a.getLogin();
	 buttonclick(login);
	
	
	Hotelsearch b = new Hotelsearch();
	WebElement location = b.getLocation();
	selectByIndex(location, Integer.parseInt(s));
	WebElement hotel = b.getHotel();
	int parseInt2 = Integer.parseInt(h);
	selectByIndex(hotel, parseInt2);
	WebElement roomtype = b.getRoomtype();
	selectByIndex(roomtype, Integer.parseInt(r));
	WebElement noofromm = b.getNoofromm();
	selectByIndex(noofromm, Integer.parseInt(n));
	WebElement checkin = b.getCheckin();
	clear(checkin);
	sendText(checkin, c);
	WebElement chechout = b.getChechout();
	clear(chechout);
	sendText(chechout, o);
	WebElement adult = b.getAdult();
	selectByIndex(adult, Integer.parseInt(d));
	WebElement children = b.getChildren();
	selectByIndex(children, Integer.parseInt(C));
	WebElement search = b.getSearch();
	buttonclick(search);
	
	Selecthotel B = new Selecthotel();
	WebElement select = B.getSelect();
	buttonclick(select);
	WebElement search2 = B.getSearch();
	buttonclick(search2);
	
	Payment e = new Payment();
	WebElement firstname = e.getFirstname();
	sendText(firstname, F);
	WebElement lastname = e.getLastname();
	sendText(lastname, L);
	WebElement addresh = e.getAddresh();
	sendText(addresh, bill);
	WebElement cardno = e.getCardno();
	sendText(cardno, cr);
	WebElement cardtype = e.getCardtype();
	selectByIndex(cardtype, Integer.parseInt(ty));
	WebElement month = e.getMonth();
	selectByIndex(month, Integer.parseInt(mon));
	WebElement year = e.getYear();
	selectByIndex(year, Integer.parseInt(yer));
	WebElement cvv2 = e.getCvv();
	sendText(cvv2, cvv);
	WebElement booknow = e.getBooknow();
	buttonclick(booknow);
	
	
	Write w = new Write();
	WebElement orderno = w.getOrderno();
	String attribute = orderno.getAttribute("value");
	System.out.println(attribute);
	
	}
	
	@DataProvider(name="adactin")
	private Object [] [] data() throws IOException {
		return new Object [] [] {
			{excelread(0, 0),excelread(0, 1),excelread(0, 2),excelread(0, 3),excelread(1, 0),excelread(1, 1),excelread(1, 2),
				excelread(1, 3),excelread(1, 4),excelread(1, 5),excelread(1,6),excelread(1, 7),excelread(1, 8),excelread(1, 9),
					excelread(1, 10),excelread(1, 11),excelread(1, 12),excelread(1, 13)}
		};
		}}
			
			
			
			
			
		