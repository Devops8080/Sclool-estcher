package Com.qa.Opencart.LoginPageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Opencart.PageLayer.ProductInfoPage;
import com.qa.Opencart.Utils.Constants;

import Com.qa.Opencart.BaseTest.BasePageTest;

public class AccountPageTest extends BasePageTest {
	// Unit test cases
	// Setup Account page// login username and password
	// with TestNG you can do parallel testing and you can integrate it with Docker
	@BeforeClass
	public void AccountPageSetUp()
	{
	 //account = login.doLogin("nnem@yahoo.com", "nnem123@");// build pattern i.e building a relationship between loginpage and account page
		account = login.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	
	
	@Test//(priority=1)
	public void verifyMyAccountLinkDisplay()
	{
		// using accountpage  as reference variable b/c these my acoount reference methods are returning in account page only and thatis why we using account page referece varaible
		Assert.assertTrue(account.myAccountLinkDisplay());
	}
	// if you don't want this test run make it(@Test(enable=false))
	@Test (priority=2)                       //(enabled=false)
	public void verifyEditAccountLinkDisplayed()
	{
		Assert.assertTrue(account.editAccountLink());
	}
	
	@Test(priority=3)
	public void verifyPasswordLinkDisplay()
	{
		Assert.assertTrue(account.passwordLink());
	}
	 
	@Test(priority=4)
	public void verifySearchBarDisplay()
	{
		Assert.assertTrue(account.searchBarDisplayed());
	}
	@Test(priority=5)
	public void verifyAccountHeaders()
	{
		//actual value vs expected vaule
		Assert.assertEquals(account.AccountHeadersList(),Constants.AccountHeaderExpectedValues());
	}
	
	// DataProvider is used to avoid changing hardcoded code
	// data driven testing
	@DataProvider
	public Object[][] getSearchData()
	{
		return new Object[][]{
			{"Apple", 1},
			{"Macbook", 3},
			{"imac", 1}
			
			
			
				};
	}
	
	@Test(priority=6, dataProvider="getSearchData")
	public void verifyProductCount(String searchKey, int productCount)
	{
		search= account.DoSearch(searchKey);
	    Assert.assertEquals(search.ProductCount(), productCount);
		
	}
	
	/**
	 * Macbook, MacBook, 5
	 * Macbook, MacBook Air, 4
	 * Macbook, MacBook Pro, 4
	 * Apple, Apple Cinema 30", 6
	 * Samsung, Samsung SyncMaster 941BW, 1
	 * Samsung, Samsung SyncMaster 941BW, 7
	 */

@DataProvider
 public Object[][] getProductTestData()
 {
	return new Object[][] 
			{
		       {"Macbook", "MacBook", 5},
		       {"Macbook", "MacBook Air", 4},
		       {"Macbook", "MacBook Pro", 4},
		       {"Apple", "Apple Cinema 30\"", 6},
		       {"Samsung", "Samsung SyncMaster 941BW", 1},
		       {"Samsung", "Samsung Galaxy Tab 10.1", 7}
			};
 }

// Validate product image count
@Test(priority=7, dataProvider= "getProductTestData")
public void verifyProductData(String searchKey, String productName, int ImageCount)
{
	search= account.DoSearch(searchKey);// build pattern that is linking one page to another page
	productInfo= search.ClickOnProduct(productName); // if you click on product name it will land on product page
	Assert.assertEquals(productInfo.ProductImageCount(), ImageCount);
	
}

}
