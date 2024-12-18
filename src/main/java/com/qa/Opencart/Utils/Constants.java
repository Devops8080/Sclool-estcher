package com.qa.Opencart.Utils;

import java.util.ArrayList;

public class Constants {
	
	//methods and variables should be static final
	// application level
	public final static String logintitle ="Account Login";
	public final static String Url = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
	public static ArrayList<String> AccountHeaderExpectedValues()
	{
		ArrayList<String> accountList = new ArrayList<String>();
		accountList.add("My Account");
		accountList.add("My Orders");
		accountList.add("My Affiliate Account");
		accountList.add("Newsletter");
		
		  return accountList;
	}
 
}
