package com.mercedes.benz.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mercedes.benz.selenium.base.BaseSeleniumWebPageAction;

/**
 * @author garima
 * This Page Class should hold all the WebElement locators on collection/summary page
 * https://shop.mercedes-benz.com/en-gb/collection/summary
 * And also the interactions on this page
 *
 * ---need to add more elements and actions
 *
 *
 */

public class SummaryPage extends BaseSeleniumWebPageAction {

	protected  WebDriverWait _wait;
	protected WebDriver driver;
	private static  By invoiceAddress=By.xpath("//div[@class='dcp-co-order-data-panel__content ng-binding']") ;
	private static WebElement element;






	public SummaryPage(final WebDriver paramdriver, final WebDriverWait wait) {
		super(paramdriver, wait);
		driver = paramdriver;
		_wait = wait;
	}







}
