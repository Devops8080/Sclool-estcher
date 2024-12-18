package com.qa.Opencart.PageLayer;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Opencart.Utils.ElementUtil;

public class AccountPage {
	
	public WebDriver driver;
	public ElementUtil eleutil;
	
	
	private By myAccountLink = By.linkText("My Account");
	private By editAccountLink = By.linkText("Edit Account");
	private By passwordLink = By.linkText("Password");
	private By searchBar = By.name("search");
	private By accountHeaders = By.cssSelector("div#content h2");
	private By searchbar = By.xpath("//input[@name='search']");
	private By searchIcon = By.xpath("//span//button[@type='button']");
	
	//Constructor
	public AccountPage(WebDriver driver) 
	
	{
		this.driver=driver;
		eleutil = new ElementUtil(driver);
	}
	
	//locators, page actions: methods
	//1. verify MyAccount link is displayed
	public boolean myAccountLinkDisplay()
	{
	 return	eleutil.doElementIsDisplayed(myAccountLink);
			 //driver.findElement(myAccountLink).isDisplayed();
	}
	
	 //2. verify EditAccount link is displayed
	public boolean editAccountLink()
	{
	  return eleutil.doElementIsDisplayed(editAccountLink);
			  //driver.findElement(editAccountLink).isDisplayed();
	}
	
	//3. verify  Password link is displayed
	public boolean passwordLink() 
	{
		return eleutil.doElementIsDisplayed(passwordLink);
				//driver.findElement(passwordLink).isDisplayed();
	}
	//4. verify SearchBar is displayed
	public boolean searchBarDisplayed()
	{
		return eleutil.doElementIsDisplayed(searchBar);
	}
	
	//5. verify Account Headers are correct or not
	public ArrayList<String> AccountHeadersList() 
	{
		
		//Collection: ArrayList
	 List<WebElement> AccountHeadersList = driver.findElements(accountHeaders);
	 ArrayList<String> ArrayAccountList = new ArrayList<String>();// collection concept // Dynamic Arraylist
	 
	 for(WebElement e: AccountHeadersList)//1, 2, 3,4 // this is for loop
	 {
		 String text = e.getText();
		 //System.out.println(text); // my Account, my Order, my Affliate, my Newsletter
		 
		 ArrayAccountList.add(text);// to store or add each value in arraylist
		 
		 }
	 return ArrayAccountList;
	}
	// This is method overloading, it could be by name, by price etc
	 public SearchPage DoSearch(String searchKey)//imac. Apple, macbook
	 {
		 eleutil.getElement(searchbar).clear(); // It will clear data from search bar
		 eleutil.getElement(searchbar).sendKeys(searchKey);// imac
		 eleutil.clickWhenReady(10, searchIcon);
		return new SearchPage(driver);// Test driven Development approach
	 }
	

}
