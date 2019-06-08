package appModules;

import org.openqa.selenium.WebDriver;

import com.mercedes.benz.selenium.pages.ShippingPage;

public class Shipping_Action{


	/**
    *
    *@param Webdriver driver
    *
    *1.fill in all shipping details
    *2.click on link to Payment
    *
    *
    *
    */



	public static void Execute(WebDriver driver) throws InterruptedException{
		//Tunnel.placeOrderAsGuest(driver).click();
		ShippingPage.fillInvoiceAddress(driver);
		ShippingPage.lnk_PaymentType(driver);

	}



}
