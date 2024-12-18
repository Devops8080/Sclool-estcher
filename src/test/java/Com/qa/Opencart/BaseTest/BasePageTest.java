package Com.qa.Opencart.BaseTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.Opencart.DriverFactory.DriverFactory;
import com.qa.Opencart.PageLayer.AccountPage;
import com.qa.Opencart.PageLayer.LoginPage;
import com.qa.Opencart.PageLayer.ProductInfoPage;
import com.qa.Opencart.PageLayer.RegisterPage;
import com.qa.Opencart.PageLayer.SearchPage;

public class BasePageTest {// parent class (inheritance is called extent)
	
	// SetUp method and TearDown method 
	
//SetUp Method: TestNG Methods 
	// 1. Before suit include smoke test, sanity and regression
	// 2. Before Test, 3. Before Class, and  4. Before method
	
	//@Test// run// Assertion	
	// TearDown: 1. Before Method, 2. Before Class, 3. Before Test, 4. Before Suite
	public WebDriver driver;
	public Properties prop;
	DriverFactory df1;
	
	public LoginPage login;
	public AccountPage account;
	public SearchPage search;
	public ProductInfoPage productInfo;
	public RegisterPage Register;
	
	
	@BeforeTest
	public void SetUp() 
	{
		df1= new DriverFactory();
		prop = df1.initProperties();
		driver = df1.InitDriver(prop);
		login = new LoginPage(driver);
		
		//How to create an object. Account class name is firest AccountPage, the 2nd AccountPage is an object. 
	 //account = new AccountPage(driver);	// classic way of creating an object// to optimize your code 
	}
	
	@AfterTest
	public void TearDown()
	{
		//driver.quit();// closing all the browsers
	}

}
