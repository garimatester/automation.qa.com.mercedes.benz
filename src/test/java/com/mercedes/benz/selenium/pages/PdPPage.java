package com.mercedes.benz.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mercedes.benz.selenium.base.BaseSeleniumWebPageAction;


/**
 * @author garima
 * This Page Class should hold all the WebElement locators on collection/pdp/ page
 * https://shop.mercedes-benz.com/en-gb/collection/pdp/{chosen_product_details}
 * And also the interactions on this page
 *
 * ---need to add more elements and actions
 *
 *
 */


public class PdPPage extends BaseSeleniumWebPageAction {

	protected  WebDriverWait _wait;
	protected WebDriver driver;
    private static  By addToBasketButton=By.xpath("//button[@class='wb-e-btn-1 dcp-pdp-buy-box-add-to-basket__cta ng-binding ng-scope dcp-pdp-buy-box-add-to-basket__cta--one-variant']") ;
    private static  By continueToBasket=By.xpath("//button[@class='wb-e-btn-1 dcp-modal__cta dcp-modal__cta--primary ng-binding']") ;





    private static WebElement element = null;


	public PdPPage(final WebDriver paramdriver, final WebDriverWait wait) {
		super(paramdriver, wait);
		driver = paramdriver;
		_wait = wait;
	}



	 public static WebElement lnk_AddToBasket(WebDriver driver) throws InterruptedException{
	  final JavascriptExecutor jse = (JavascriptExecutor) driver;
      jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");

      explicitWait(addToBasketButton);
      element = driver.findElement(addToBasketButton);
      return element;

	    }


	 public static WebElement lnk_ContinueToBasket(WebDriver driver) throws InterruptedException{

	      explicitWait(continueToBasket);

		    element = driver.findElement(continueToBasket);



		    return element;

		    }






}
