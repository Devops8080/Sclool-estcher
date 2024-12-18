package com.qa.Opencart.PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Opencart.Utils.ElementUtil;

public class LoginPage {
	
	
	
	
	//Constructor
	// By creating object and by using object reference variable we can call methods
	
	public WebDriver driver; 
	// By using object reference variable, we can call all methods from one class to another class
	public ElementUtil eleutil;// creating object of Util and importing it from ElementUtil class
	
	//Encapsulation//null
	private By mailid = By.name("email");
	private By pass = By.id("input-password");
	private By loginButton = By.xpath("//input[@type='submit']");
	private By forgottenPasswordLink = By.partialLinkText("Forgotten Password");
	private By RegisterLink = By.linkText("Register");
	
	// Constructor Creation
	public LoginPage (WebDriver driver) 
	{
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}
	// page actions
	// Page title
	public String getLoginPageTitle() 
	{
		
		return driver.getTitle(); // page title//Account login
	}
	 //Current url
	public String getUrl() 
	{
		String URL=driver.getCurrentUrl();
		return URL;
	}
	//verify passwordlink is displayed
	public boolean forgotPasswordLinkDisplay() 
	{
		boolean forgotlink =eleutil.doElementIsDisplayed(forgottenPasswordLink);
				//driver.findElement(forgottenPasswordLink).isDisplayed();
		return forgotlink;
	}
	
	// DoClick
	public RegisterPage DoClickRegisterLink()
	{
		eleutil.doClick(RegisterLink);
		return new RegisterPage(driver);
	
	}
	//login with username and password
	public AccountPage doLogin(String username, String password)
	{
	  //driver.findElement(mailid).sendKeys("nnem@yahoo.com");
	  eleutil.doSendKeys(mailid, username);
	  //driver.findElement(pass).sendKeys("nnem123@");
	  eleutil.doSendKeys(pass, password);
	  //driver.findElement(loginButton).click();
	  eleutil.doClick(loginButton);
	  return new AccountPage(driver);// object // page chain model
	  //TDD approach(Test Driven Development appraoch): Write some code and implement the code based on the requirement
		
	}
	
	

}
 