package com.qa.Opencart.PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Opencart.Utils.ElementUtil;

public class RegisterPage {
	public WebDriver driver;
	public ElementUtil eleutil;
	
	private By firstName = By.name("firstname");
	private By lastName = By.name("lastname");
	private By email = By.name("email");
	private By telephone = By.name("telephone");	
	private By password = By.name("password");	
	private By passwordConfirm = By.name("confirm");
	private By subscribeYes = By.xpath("//label[normalize-space()='Yes']//input[@type='radio']");
	private By subscribeNo = By.xpath("//label[normalize-space()='No']//input[@type='radio']");
	private By checkbox = By.xpath("//input[@type='checkbox']");
	private By continueButton = By.xpath("//input[@type='submit']");
	private By successMessage = By.cssSelector("div h1");
	private By logoutLink = By.linkText("Logout");
	private By RegisterLink = By.linkText("Register");
				
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		 eleutil = new ElementUtil(driver);
	}
	// Page action
 public void RegisterUser(String FirstName, String LastName, String Email, String Telephone, String Password, String Subscribe)
 {
	  eleutil.doSendKeys(firstName, FirstName);
	  eleutil.doSendKeys(lastName, LastName);
	  eleutil.doSendKeys(email, Email);
	  eleutil.doSendKeys(telephone, Telephone);
	  eleutil.doSendKeys(password, Password);
	  eleutil.doSendKeys(passwordConfirm, Password);
	  
	  if(Subscribe.equalsIgnoreCase("Yes"))
	  {
		  eleutil.doClick(subscribeYes);
	  }
	  else
	  {
		  eleutil.doClick(subscribeNo);
	  }
	  eleutil.doClick(checkbox);
	  eleutil.doClick(continueButton);
	  
 }
 public boolean navigateToRegisterLink()
 {
	 String message = "Your Account Has Been Created!";
	  String text = eleutil.getElement(successMessage).getText();
	  if(text.contains(message))
    {
	 eleutil.doClick(logoutLink);
	 eleutil.doClick(RegisterLink); 
	 return true;
    }
	  
	 return false;
		 
 }
}
