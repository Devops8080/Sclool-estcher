package Com.qa.Opencart.LoginPageTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Opencart.Utils.Constants;

import Com.qa.Opencart.BaseTest.BasePageTest;

 
public class LoginPageTest extends BasePageTest{ // using inheritance concept
	
	//LoginPageTest is a child
	//for each page we have SetUp method
	
	@Test(priority=1)
	public void verifyLoginPageTest() // using assertion and is TestNG method
	{
		// Unit tests
		 // Assertion: To verify actual value vs expected value
		Assert.assertEquals(login.getLoginPageTitle(), Constants.logintitle);
		
	}
	@Test(priority=2)
	public void verifyCurrentUrl()
	{
	   // Validate currentUrl()
		Assert.assertEquals(login.getUrl(),Constants.Url);
		
	}
	@Test(priority=3)	
	public void verifyForgotPasswordLinkDisplat()
   {
	 Assert.assertTrue(login.forgotPasswordLinkDisplay());
   }
	
}
