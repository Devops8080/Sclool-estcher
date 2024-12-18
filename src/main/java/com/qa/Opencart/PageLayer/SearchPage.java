package com.qa.Opencart.PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Opencart.Utils.ElementUtil;

public class SearchPage {
	public WebDriver driver;
	public ElementUtil eleutil;
	
	private By productCount = By.cssSelector("div h4");
	
	
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		eleutil= new ElementUtil(driver);
	}
	
	// method for finding no of products
	
	public int ProductCount()
	{
	  int productList=	eleutil.getElements(productCount).size(); // then store it in variable productList
	  return productList;
	}
	// Click on a product
    public ProductInfoPage ClickOnProduct(String productName)
    {
    	By productnameLocator= By.linkText(productName);
    	eleutil.doClick(productnameLocator);
    	return  new ProductInfoPage(driver);
    }
     
}
