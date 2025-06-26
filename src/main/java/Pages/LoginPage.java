package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utils.Log;

public class LoginPage {
	
	private WebDriver driver;
	
	
	@FindBy(id="ap_email")
	WebElement username;
	
	@FindBy(css=".a-button-input")
	WebElement continue_button;
	
	@FindBy(css="#ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement signin;
	
	@FindBy(xpath="//div[contains(text(),'Wrong or Invalid email address or mobile phone number. Please correct and try again.')]")
	WebElement invalidText;

	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
	
	public LoginPage(WebDriver driver2)
	{
		this.driver=driver2;
		PageFactory.initElements(driver,this);
	}
	
	public void enterUsername(String uname)
	{
		username.sendKeys(uname);
	}
	public void clickOnContinue()
	{
		continue_button.click();
	}
	public void enterPassword(String pword)
	{
		password.sendKeys(pword);
	}
	public HomePage clickOnSignin()
	{
		signin.click();
		//Log.info("Logged in as user and successfully signed in");
		return new HomePage(driver);
	}
	public void invalidCredentials(String uname,String pword)
	{
		username.sendKeys(uname);
		continue_button.click();
		wait.until(ExpectedConditions.visibilityOf(invalidText));
		Assert.assertEquals(invalidText.getText(),"Wrong or Invalid email address or mobile phone number. Please correct and try again.");
	}

}
