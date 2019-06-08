package com.mercedes.benz.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mercedes.benz.selenium.base.BaseSeleniumWebPageAction;


/**
 * @author garima
 * This Page Class should hold all the WebElement locators on collection page
 * https://shop.mercedes-benz.com/en-gb/collection
 * And also the interactions on this page
 *
 * ---need to add more elements and actions
 *
 *
 */

public class CollectionPage extends BaseSeleniumWebPageAction {

	protected  WebDriverWait _wait;
	protected WebDriver driver;
	private By linkCookiesNotificationClose= By.xpath("//a[contains(text(),'Close')]");
	private By linkCollectionAndAccessories=By.xpath("//a[contains(text(),'Collection & accessories')]");
	private By linkPersonalAccessories=By.xpath("//a[contains(text(),'Personal accessories')]");
    private By linkSmartPhoneAndTablets= By.xpath("//a[contains(text(),'Smartphone & tablet accessories')]");






	public CollectionPage(final WebDriver paramdriver, final WebDriverWait wait) {
		super(paramdriver, wait);
		driver = paramdriver;
		_wait = wait;
	}



   public void closeCookies(WebDriver driver) throws InterruptedException {

		explicitWait(linkCookiesNotificationClose);
		driver.findElement(linkCookiesNotificationClose).click();


     }

	public  void Click_linkCollectionAndAccessories(WebDriver driver) throws InterruptedException {
		explicitWait(linkCollectionAndAccessories);
        driver.findElement(linkCollectionAndAccessories).click();

	}


	public void Click_linkPersonalAccessories(WebDriver driver) throws InterruptedException {
		explicitWait(linkPersonalAccessories);
        driver.findElement(linkPersonalAccessories).click();

	}



	public void Click_linkSmartPhoneAndTablets(WebDriver driver) throws InterruptedException {
		explicitWait(linkSmartPhoneAndTablets);
        driver.findElement(linkSmartPhoneAndTablets).click();

	}















}
