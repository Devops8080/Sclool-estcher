package com.qa.Opencart.Utils;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	// we need to run our scripts in headless mode and Incognito
	
	public Properties prop;
	public ChromeOptions co;
	public FirefoxOptions fo;
	/**
	 * creating ChromeOptions
	 */
	
	public OptionsManager(Properties prop)
	{
		this.prop= prop;
	}
	public ChromeOptions getChromeOptions() 
	{co = new ChromeOptions();
	co.addArguments("remote-allow-origins=*");
		
		if(Boolean.parseBoolean(prop.getProperty("headless")))//true
		{
			co.addArguments("--headless");
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito")));
		{
			co.addArguments("--incognito");
		}
		return co;
	}
	
	public FirefoxOptions getFirefoxOptions()
	{ fo = new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless")))
				
		{
			fo.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incoginto"))) 
		{
			fo.addArguments("--incognitor");
		}
		return fo;
			
	   	
			
		
	}
	
	
	
	

}
