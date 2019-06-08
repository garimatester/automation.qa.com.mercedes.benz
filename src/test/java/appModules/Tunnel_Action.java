package appModules;

import org.openqa.selenium.WebDriver;

import com.mercedes.benz.selenium.pages.Tunnel;

public class Tunnel_Action{


	/**
    *
    *@param Webdriver driver
    *1.places order as guest
    *
    *
    *
    *
    */



	public static void Execute(WebDriver driver) throws InterruptedException{
		Tunnel.placeOrderAsGuest(driver).click();

	}



}
