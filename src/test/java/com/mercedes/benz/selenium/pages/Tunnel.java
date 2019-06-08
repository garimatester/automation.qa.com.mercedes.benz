package com.mercedes.benz.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mercedes.benz.selenium.base.BaseSeleniumWebPageAction;



/**
 * @author garima
 * This Page Class should hold all the WebElement locators on collection/tunnel page
 * https://shop.mercedes-benz.com/en-gb/collection/tunnel
 * And also the interactions on this page
 *
 * ---need to add more elements and actions
 *
 *
 */

public class Tunnel extends BaseSeleniumWebPageAction {

	protected  WebDriverWait _wait;
	protected WebDriver driver;
	private static  By email=By.xpath("//input[@type='email']") ;
	private static  By buttonPlaceOrderAsGuest=By.xpath("//button[contains(text(),'Place order as guest')]") ;
	private static WebElement element;






	public Tunnel(final WebDriver paramdriver, final WebDriverWait wait) {
		super(paramdriver, wait);
		driver = paramdriver;
		_wait = wait;
	}




	public static WebElement placeOrderAsGuest(WebDriver driver) throws InterruptedException {
		//Thread.sleep(500);
		explicitWait(email);
		driver.findElement(email).sendKeys(testData.getParam("email"));
		//Scroll to bottom
		final JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(
                "window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");

		element=  driver.findElement(buttonPlaceOrderAsGuest);

		//Thread.sleep(3000);
		return element;




	}










}
