package com.mercedes.benz.selenium.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mercedes.benz.selenium.base.BaseSeleniumWebPageAction;

/**
 * @author garima
 * This Page Class should hold all the WebElement locators on Collection/cart page
 * https://shop.mercedes-benz.com/en-gb/collection/cart
 * And also the interactions on this page
 *
 * ---need to add more elements and actions
 *
 *
 */
public class CartPage extends BaseSeleniumWebPageAction {

	protected  WebDriverWait _wait;
	protected WebDriver driver;
    private static  By continueToAddressAndDelivery=By.xpath("//button[contains(text(),'Continue to address and delivery')]") ;
    private static  By cartEntries=By.xpath("//div[@class='col-xs-12 co-grid-orderline-wrapper ng-scope']") ;
    private static  By nextPage=By.xpath("//input[@type='email']") ;




    private static WebElement element = null;
	private static List<WebElement> listelement;


	public CartPage(final WebDriver paramdriver, final WebDriverWait wait) {
		super(paramdriver, wait);
		driver = paramdriver;
		_wait = wait;
	}



	 public static void  lnk_continueToAddressAndDelivery(WebDriver driver) throws InterruptedException{
        explicitWait(continueToAddressAndDelivery);
	    element = driver.findElement(continueToAddressAndDelivery);
	    element.click();
	    explicitWait(nextPage);



	    }




	 public static List<WebElement> cartItems(WebDriver driver) throws InterruptedException{
        explicitWait(cartEntries);
	    listelement = driver.findElements(cartEntries);
	    return listelement;

	    }





}
