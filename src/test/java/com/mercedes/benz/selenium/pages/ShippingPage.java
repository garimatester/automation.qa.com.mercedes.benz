package com.mercedes.benz.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mercedes.benz.selenium.base.BaseSeleniumWebPageAction;



/**
 * @author garima
 * This Page Class should hold all the WebElement locators on collection/shipping page
 * https://shop.mercedes-benz.com/en-gb/collection/shipping
 * And also the interactions on this page
 *
 * ---need to add more elements and actions
 *
 *
 */



public class ShippingPage extends BaseSeleniumWebPageAction {

	protected  WebDriverWait _wait;
	protected WebDriver driver;
	private static  By radioSalutation=By.xpath("//label[contains(text(),'Ms')]") ;
	private static  By firstName=By.id("co_payment_address-firstName") ;
	private static  By lastName=By.id("co_payment_address-lastName") ;
	private static  By number=By.id("co_payment_address-line2") ;
	private static  By street=By.id("co_payment_address-line1") ;
	private static  By town=By.id("co_payment_address-town") ;
	private static  By postalCode=By.id("co_payment_address-postalCode") ;
	private static  By buttonContinueToPaymentType=By.xpath("//button[contains(text(),'Continue to payment type')]") ;
	private static  By nextPage=By.xpath("//strong[contains(text(),'PayPal')]") ;




	public ShippingPage(final WebDriver paramdriver, final WebDriverWait wait) {
		super(paramdriver, wait);
		driver = paramdriver;
		_wait = wait;
	}


   public static void fillInvoiceAddress(WebDriver driver) throws InterruptedException{
		explicitWait(radioSalutation);
		driver.findElement(radioSalutation).click();
		driver.findElement(firstName).sendKeys(testData.getParam("firstName"));
		driver.findElement(lastName).sendKeys(testData.getParam("lastName"));
		driver.findElement(number).sendKeys(testData.getParam("number"));
		driver.findElement(street).sendKeys(testData.getParam("street"));
		driver.findElement(town).sendKeys(testData.getParam("town"));
		driver.findElement(postalCode).sendKeys(testData.getParam("postalCode"));

   }


   public static void lnk_PaymentType(WebDriver driver) throws InterruptedException {
	   Thread.sleep(3000);
	   System.out.println("continue to payment page");
	   //explicitWait(buttonContinueToPaymentType);

      driver.findElement(buttonContinueToPaymentType).click();

	   Thread.sleep(5000);



      explicitWait(nextPage);
   }





}
