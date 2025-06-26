package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utils.Log;

public class HomePage 
{
	
	private WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
	
	@FindBy(xpath="//span[contains(.,'Hello, Shishira')]")
	WebElement homepageValidation;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(xpath="//span[@class='a-declarative'] //div[contains(@class,'puis-card-container s-card-container')] //h2[@class='a-size-base-plus a-spacing-none a-color-base a-text-normal']")
	List<WebElement> Pens;
	
	public HomePage(WebDriver driver2)
	{
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void searchForItem() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(homepageValidation));
		searchBox.clear();
		searchBox.sendKeys("Cello Gripper-1 Ball Pen, Blue - Pack of 5");
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	
	public CartPage addToCart()
	{
		for(WebElement ele:Pens)
		{
			
			if(ele.getText().equalsIgnoreCase("Cello Gripper-1 Ball Pen, Blue - Pack of 5"))
				//Log.info("Item found");
				ele.findElement(By.xpath("//button[.='Add to cart']")).click();
		}
		//Log.info("Successfully added the item to cart");
		return new CartPage(driver);
	}
	

}
