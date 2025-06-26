package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utils.Log;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fs%3Fk%3Dhigh%2Bchair%2Bwith%2Bwheels%26crid%3DSEWOTOJF27KI%26sprefix%3D%252Caps%252C227%26ref%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		//Log.info("Navigating to URL");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
		//Log.info("Closing the session");
	}

}
