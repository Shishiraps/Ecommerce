package tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Base.BaseTest;
import Pages.HomePage;
import Pages.CartPage;
import Pages.ConfirmationPage;
import Pages.LoginPage;
import Pages.PaymentPage;

public class ValidLoginTest extends BaseTest 
{
	
	@DataProvider(name="Logindata")
	public Object[][] getdata()
	{
		return new Object[][] {
			{"xxx@gmail.com","xxxx"}
			
		};
	}
	
	
	
	
	@Test(dataProvider="Logindata")
	public void testLogin(String Username,String Password) throws InterruptedException
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.enterUsername(Username);
		lp.clickOnContinue();
		lp.enterPassword(Password);
		HomePage hp=lp.clickOnSignin();
		hp.searchForItem();
		CartPage cp=hp.addToCart();
		cp.clickOnCartIcon();
		PaymentPage pp=cp.clickOncheckout();
		pp.clickOnPaymentOption();
		ConfirmationPage conp=pp.placeOrder();
		conp.validateConfirmation();
		driver.quit();
		
		
	}
	
	

}
