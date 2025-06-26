package tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;

public class InvalidLoginTest extends BaseTest
{

	@DataProvider(name="Logindata1")
	public Object[][] getdata1()
	{
		return new Object[][] {
			{"user1","password1"}
			
		};
	}
	
	@Test(dataProvider="Logindata1")
	public void testinvalidLogin(String username,String password)
	{
		LoginPage lp=new LoginPage(driver);
		lp.invalidCredentials(username, password);
		driver.quit();
	}
}
