package appModules;

import org.openqa.selenium.WebDriver;

import com.mercedes.benz.selenium.pages.PaymentPage;

public class PayMent_Action {


	/**
    *
    *@param Webdriver driver
    *1.Choose Payment Method as Paypal
    *2.Proceed to Verification and order Page
    *
    *
    *
    *
    */

	public static void Execute(WebDriver driver) throws InterruptedException{
		PaymentPage.choose_payPal(driver).click();
		PaymentPage.proceedPayment(driver).click();
	}



}
