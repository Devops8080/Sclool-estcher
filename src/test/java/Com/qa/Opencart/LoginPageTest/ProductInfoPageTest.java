package Com.qa.Opencart.LoginPageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Com.qa.Opencart.BaseTest.BasePageTest;

public class ProductInfoPageTest extends BasePageTest {
	
	//productInfoPage SetUp
	@BeforeClass
	public void productInfoPageSetUp()
	{
		account = login.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(enabled =true)
	public void verifyProductHeader()
	{
		search = account.DoSearch("Macbook");
		productInfo = search.ClickOnProduct("MacBook Air");
			//productInfo.productHeader();//it will give Header text
		Assert.assertEquals(productInfo.productHeader(), "MacBook Air");
	}
	
	//Validate product meta data
	@Test
	
	public void verifyProductMetaData()
	{
		search = account.DoSearch("Macbook");
		productInfo = search.ClickOnProduct("MacBook Air");
		System.out.println(productInfo.getProductMetaData());
		Assert.assertEquals("Brand", "Apple");
		Assert.assertEquals("Availability", "In Stock");
		Assert.assertEquals("Product Code", "Product 17");
		Assert.assertEquals("Reward Points", "700");
		
		
	}

}
