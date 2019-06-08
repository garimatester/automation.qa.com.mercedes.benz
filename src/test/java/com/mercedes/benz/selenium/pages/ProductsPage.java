package com.mercedes.benz.selenium.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mercedes.benz.selenium.base.BaseSeleniumWebPageAction;





/**
 * @author garima
 * This Page Class should hold all the WebElement locators on collection/products/ page
 * https://shop.mercedes-benz.com/en-gb/collection/products/{chosen_product_category}
 * And also the interactions on this page
 *
 * ---need to add more elements and actions
 *
 *
 */

public class ProductsPage extends BaseSeleniumWebPageAction {




	protected  WebDriverWait _wait;
	protected WebDriver driver;
    private By linkProduct=By.xpath("//div[@class='utils-product-tile-image-inner']") ;



	public ProductsPage(final WebDriver paramdriver, final WebDriverWait wait) {
		super(paramdriver, wait);
		driver = paramdriver;
		_wait = wait;
	}






	public void Click_linkProduct(WebDriver driver) throws InterruptedException {
		//Thread.sleep(3000);
		explicitWait(linkProduct);

		List<WebElement> listProducts=driver.findElements(linkProduct);
		System.out.println("list size"+ listProducts.size());

		if(listProducts.size()>0) {
			WebElement firstProduct = listProducts.get(0);
			firstProduct.click();

		}

	}












}
