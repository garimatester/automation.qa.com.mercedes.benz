package com.mercedes.benz.selenium.tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mercedes.benz.selenium.base.BaseSeleniumSetup;
import com.mercedes.benz.selenium.base.SeleniumToolException;
import com.mercedes.benz.selenium.pages.CartPage;
import com.mercedes.benz.selenium.pages.CollectionPage;
import com.mercedes.benz.selenium.pages.ProductsPage;

import appModules.AddToBasket_Action;
import appModules.ContinueToAddressandDelivery_Action;
import appModules.PayMent_Action;
import appModules.Shipping_Action;
import appModules.Tunnel_Action;
import listeners.CustomListener;


@Listeners(CustomListener.class)

public class E2EWorkFlowTest extends BaseSeleniumSetup {

    private ProductsPage productsPage;
	private CollectionPage collectionPage;



	/**
     *
     *@param testdatafile(E2ETestData.json)
     * @Override setup(testDataFile) from BaseSeleniumSetup
     * where it is:
     * Setup for driver depending upon browser passed in E2ETestData.json
     * driver opens url depending upon environments passed in E2ETestData.json
     *
     * executed before class
     *
     *
     */


	@Override
	@BeforeClass
    @Parameters({"testdatafile"})
   	public void setUp(@Optional("src/test/resources/E2ETestData.json")String testDataFile) throws  IOException, SeleniumToolException {
        super.setUp(testDataFile);
    }




	/**
     * workflow automated
     * 1.Adding one item to shopping basket from smartPhonesandTablets category
     * 2.Proceed on shopping basket workflow to address and delivery(as a guest user)
     * 3. Continue Your order and Select PayPal as payment method
     * 4.Continue to Page Verification And order placement.
     *  1.Close cookiesNotification on collections page
     *  2.Click link Collection & Accessories
     *  3. Click link Personal Accessories
     *  4. click Smart Phone And Tablets
     *  5.choose first Product
     *  6. Add it to basket
     *  7.Add Shipping Address and continue to Payment
     *  8. Choose Payment method as PayPal
     *  9. proceed to verification and Order Payment
     *
     *
     */





	@Test(priority=0)
    public void e2eWorkFlowTest() throws InterruptedException {

		SoftAssert s_assert= new SoftAssert();

		collectionPage=getCollectionPage(driver, wait);
    	productsPage=getProductsPage(driver, wait);
        log.info("Workflow start------ Adding A Product In a Cart");
    	log.info("cookiesNotification is being closed here on collections page");
    	collectionPage.closeCookies(driver);
    	log.info("on collections page clicking link Collection & Accessories ");
    	collectionPage.Click_linkCollectionAndAccessories(driver);
    	log.info("on collections page clicking link Personal Accessories ");
    	collectionPage.Click_linkPersonalAccessories(driver);
    	log.info("on collections page clicking link Smart Phone And Tablets  ");
    	collectionPage.Click_linkSmartPhoneAndTablets(driver);
    	log.info("on Products page clicking first listed Product ");
         productsPage.Click_linkProduct(driver);
         log.info("Adding the Product To Basket ");
         AddToBasket_Action.Execute(driver);

         log.info("Validate if cart has one product Entry atleast");
         s_assert.assertTrue(CartPage.cartItems(driver).size()==1, "check if cart has one item added") ;

         log.info("Continue To address and delivery");

          ContinueToAddressandDelivery_Action.Execute(driver);

          log.info("Continue as guest user");

          Tunnel_Action.Execute(driver);

          log.info("Check if on shipping page");

          s_assert.assertTrue(driver.getTitle().contains("Address & delivery"), "check if Address And Delivery Page is Open") ;

          log.info("Adding Shipping Address ");

          Shipping_Action.Execute(driver);

          log.info("Check if on Payment Page "+ driver.getTitle());

          s_assert.assertTrue(driver.getTitle().contains("Collection Site"), "check if payment Page is Open") ;


          log.info("Choosing Payment Method As Paypal and proceed ");

           PayMent_Action.Execute(driver);


           log.info("Check if on Summary or Verification and order Page "+ driver.getTitle());

           s_assert.assertTrue(driver.getTitle().contains("Collection Site "), "check if Summary Page is Open") ;








    }

















}
