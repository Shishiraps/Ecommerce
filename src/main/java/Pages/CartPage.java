package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Utils.Log;

public class CartPage 
{
	
	private WebDriver driver;
	
	
	@FindBy(css=".nav-cart-icon.nav-sprite")
	WebElement cartIcon;
	
	@FindBy(xpath="//input[@value='Proceed to checkout']")
	WebElement checkout;
	
	
	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(1000));
	
	
	public CartPage(WebDriver driver2)
	{
		this.driver=driver2;
		PageFactory.initElements(driver,this);
	}

	public void clickOnCartIcon()
	{
		wait.until(ExpectedConditions.visibilityOf(cartIcon));
		cartIcon.click();
		//Log.info("Clicked on cart icon");
		
	}
	
	
	public PaymentPage clickOncheckout() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(checkout));
		checkout.click();
		Thread.sleep(1000);
		//Log.info("clicked on checkout");
		return new PaymentPage(driver);
	}
	
	
	
	

}
