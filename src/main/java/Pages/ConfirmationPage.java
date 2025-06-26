package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Utils.Log;

public class ConfirmationPage
{
	
	private WebDriver driver;
	
	@FindBy(xpath="//h4[.='Order placed, thank you!']")
	WebElement confirmationText;
	
	public ConfirmationPage(WebDriver driver2)
	{
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}
	
	public void validateConfirmation()
	{
		Assert.assertEquals(confirmationText.getText(), "Order placed, thank you!");
		System.out.println(confirmationText.getText());
		//Log.info("Successfully placed order");
	}

}
