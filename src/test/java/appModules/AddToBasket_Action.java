package appModules;
import org.openqa.selenium.WebDriver;

import com.mercedes.benz.selenium.pages.PdPPage;


public class AddToBasket_Action {


	public static void Execute(WebDriver driver) throws InterruptedException{
		PdPPage.lnk_AddToBasket(driver).click();
		PdPPage.lnk_ContinueToBasket(driver).click();

		//CartPage.lnk_continueToAddressAndDelivery(driver).click();
	}







}
