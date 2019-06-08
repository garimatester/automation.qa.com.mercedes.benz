package com.mercedes.benz.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mercedes.benz.selenium.base.BaseSeleniumWebPageAction;



/**
 * @author garima
 * This Page Class should hold all the WebElement locators on collection/Payment page
 * https://shop.mercedes-benz.com/en-gb/collection/payment
 * And also the interactions on this page
 *
 * ---need to add more elements and actions
 *
 *
 */

public class PaymentPage extends BaseSeleniumWebPageAction {

	protected  WebDriverWait _wait;
	protected WebDriver driver;


   private static  By payPal=By.xpath("//strong[contains(text(),'PayPal')]") ;

	private static  By continueToVerification=By.xpath("//button[@class='wb-e-btn-1 dcp-co-func-footer__cta-primary ng-binding ng-scope']") ;

    private static WebElement element = null;


	public PaymentPage(final WebDriver paramdriver, final WebDriverWait wait) {
		super(paramdriver, wait);
		driver = paramdriver;
		_wait = wait;
	}



	 public static WebElement choose_payPal(WebDriver driver) throws InterruptedException{

		// final JavascriptExecutor jse = (JavascriptExecutor) driver;
	       // jse.executeScript( "window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
         explicitWait(payPal);
	    element = driver.findElement(payPal);
	    return element;

	    }


	 public static WebElement proceedPayment(WebDriver driver) throws InterruptedException{
	        explicitWait(continueToVerification);
		    element = driver.findElement(continueToVerification);
		    return element;

		    }





}
