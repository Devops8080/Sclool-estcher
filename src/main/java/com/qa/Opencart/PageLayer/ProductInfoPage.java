package com.qa.Opencart.PageLayer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Opencart.Utils.ElementUtil;

public class ProductInfoPage {
	private static final Object Key = null;
	private static final Object Value = null;
	public WebDriver driver;
	public ElementUtil eleutil;
	//private By productInfo = By.partialLinkText("Samsung Galaxy Tab 10.1");
	private By productImages= By.cssSelector("ul.thumbnails li img");
	private By productHeader= By.cssSelector("div h1");
	private By productMetaData = By.xpath("//div[@id='content']//ul[@class='list-unstyled'][1]//li"); //4
	
	HashMap<String, String> map = new HashMap<String, String>();
	public ProductInfoPage(WebDriver driver) 
	{
		this.driver= driver;
		eleutil= new ElementUtil(driver);
	}
	
		
	// Imagecount
    public int ProductImageCount()
    {
    	int imageCount= eleutil.getElements(productImages).size();// we store the size of the image in int
    	return imageCount;
    }
    // Product Header method// Which method did you use to validate meta data
    public String productHeader()
    {
    	String text = eleutil.getElement(productHeader).getText();
    	System.out.println(text);
    	return text;
    }
     //method for productMetaData
    public HashMap<String, String> getProductMetaData()
    {
    	List<WebElement> productMetaDataList = eleutil.getElements(productMetaData);
    	// for each loop instead of for loop becuase it is easier
    	for(WebElement e: productMetaDataList)
    	{
    		String meta = e.getText();
    		String[] metaData= meta.split(":"); // this split method will seperate the values and it will give string array format
    		String Key = metaData[0]; //Brand
    		String Value = metaData[1]; // Apple
    	    map.put(Key, Value);
    	}
    	return map;
    }
 
}
