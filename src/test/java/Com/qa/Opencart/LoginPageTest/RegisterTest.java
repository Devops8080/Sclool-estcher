package Com.qa.Opencart.LoginPageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Opencart.Utils.ExcelUtil;

import Com.qa.Opencart.BaseTest.BasePageTest;

public class RegisterTest extends BasePageTest{
	
	
	// RegisterPage Set up
	@BeforeClass
	public void RegisterPageSetUp()
	{
		Register = login.DoClickRegisterLink(); // Buiuld pattern
	}
	@DataProvider
	public Object[][] getTestData()
	{
	  Object[][] regTestData =	ExcelUtil.getTestData("Register");
	  return regTestData;
	}
    @Test(dataProvider = "getTestData")
    public void verifyRegTest(String FirstName, String LastName, String Email, String Telephone, String Password,String Subscribe)
    {
      Register.RegisterUser(FirstName, LastName, Email, Telephone, Password, Subscribe);
      Assert.assertTrue(Register.navigateToRegisterLink());
    }
}
