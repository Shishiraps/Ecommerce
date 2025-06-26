package Pages;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Utils.Log;

public class PaymentPage 
{
	private WebDriver driver;
	
	@FindBy(id="nav-checkout-title-header-text")
	WebElement checkoutTitle;
	
	@FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[6]")
	WebElement cashOnDeliveryButton;
	
	@FindBy(xpath="//input[@aria-labelledby='checkout-primary-continue-button-id-announce']")
	WebElement useThisPaymentButton;
	
	@FindBy(id="placeOrder")
	WebElement placeOrder;
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
	
	public PaymentPage(WebDriver driver2)
	{
		this.driver=driver2;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnPaymentOption() throws InterruptedException
	{
		Assert.assertEquals(checkoutTitle.getText(), "Secure checkout");
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,5000)");
		Thread.sleep(3000);
		cashOnDeliveryButton.click();
		//Log.info("Selected the payment option");
	}
	
	public ConfirmationPage placeOrder() throws InterruptedException
	{
		useThisPaymentButton.click();
		Thread.sleep(2000);
		placeOrder.click();
		//Log.info("Successfully placed order");
		return new ConfirmationPage(driver);
	}
	
	
	
	
}
