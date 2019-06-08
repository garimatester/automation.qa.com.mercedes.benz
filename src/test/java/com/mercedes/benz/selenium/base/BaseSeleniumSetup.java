package com.mercedes.benz.selenium.base;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.mercedes.benz.selenium.driverbase.DriverManager;
import com.mercedes.benz.selenium.driverbase.DriverManagerFactory;
import com.mercedes.benz.selenium.pages.CollectionPage;
import com.mercedes.benz.selenium.pages.ProductsPage;





public class BaseSeleniumSetup extends DriverManagerFactory {

	public static  WebDriver driver;
	public  WebDriverWait wait;
	protected Logger log = LoggerFactory.getLogger(BaseSeleniumSetup.class);
	protected DriverManager driverManager;
    private String baseurl;






@Override
	//@BeforeClass
   @BeforeClass
	@Parameters({ "testdatafile" })
	protected void setUp(String testDataFile) throws  IOException, SeleniumToolException {

		log.info("starting base selenium setup");

		logPlusDivider();

		super.setUp(testDataFile);


		driverManager=DriverManagerFactory.getManager();

		driver=driverManager.getDriver();

		wait = new WebDriverWait(driver, 10, 100);


		log.info("testData is declared in Common.java");

		baseurl=testData.getUrlForEnvironment();

		openBaseUrl(baseurl);
	}



	@AfterMethod(alwaysRun = true)
	protected void tearDown() throws Exception {


		driverManager.quitDriver();
		driver = null;
	}



	/**
	 * @param baseUrl
	 * @return
	 * @throws SeleniumToolException
	 */
	public WebDriver openBaseUrl(final String baseUrl) throws SeleniumToolException {

		log.info("open base url");

		if (driver == null) {
			log.info("Driver not initialized");
			return null;
		}

		driver.get(baseUrl);

		if (driver.getClass().getName().contains("ChromeDriver")) {
			//setBrowserSize(browserWidth, browserHeight);
			//driver.manage().window().maximize();
		} else {
			driver.manage().window().maximize();
		}

		if (baseUrl.equals(driver.getCurrentUrl())) {
			log.info("Driver '" + driver.getClass().getName() + "' successfully opened url '" + baseUrl + "' with browser '" + testData.getBrowser() + "'");
		} else {

			if (driver.getCurrentUrl() != null) {
				log.warn("Driver '" + driver.getClass().getName() + "' opened url '" + driver.getCurrentUrl() + " instead of requested baseUrl " + baseUrl
						+ "' with browser '" + testData.getBrowser() + "'");
			} else {

				throw new SeleniumToolException(
						"Driver '" + driver.getClass().getName() + "' was unable to open url '" + baseUrl + "' with browser '" + testData.getBrowser() + "'");
			}
		}

		return driver;
	}


	/**
	 * change the size of the browser
	 *
	 * @param width - new width
	 * @param height - new height
	 */
	public void setBrowserSize(final int width, final int height) {
		driver.manage().window().setSize(new Dimension(width, height));
	}




	/**
	 * get the CollectionPage
	 *
	 * @param Drive
	 * @return CollectionPage
	 * @throws InterruptedException
	 */
	protected CollectionPage getCollectionPage(final WebDriver driver, final WebDriverWait wait) throws InterruptedException {
		return new CollectionPage(driver, wait);
	}




	/**
	 * get the ProductsPage
	 *
	 * @param Drive
	 * @return ProductsPage
	 * @throws InterruptedException
	 */
	protected ProductsPage getProductsPage(final WebDriver driver, final WebDriverWait wait) throws InterruptedException {
		return new ProductsPage(driver, wait);
	}





	/**
	 * invoked on every failed test to capture screenshots
	 * testClass must have @Listeners(CustomListener.class) to invoke
	 * @param none
	 * @return void
	 *
	 */


 public void failed(String testName){
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String userHome=System.getProperty("user.dir");
		File des=new File(userHome+"/screenShot/" +testName+".png");
		log.info("destination file "+des);


		try {
			FileUtils.copyFile(screenshotFile, des);
			log.info("screenshot Saved");
		}


		catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}

