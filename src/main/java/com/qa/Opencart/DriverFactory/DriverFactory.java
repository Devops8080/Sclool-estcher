package com.qa.Opencart.DriverFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.Opencart.Utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
  // Public - access modifier
	// this class can be used anywhere in the the same project
	//Initialise driver method
	public WebDriver driver;
	public Properties prop;
	public OptionsManager op;
	//public javaScriptUtil;
	public static String highlight;
	public ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	// we call methods by using using objects reference variable
	public WebDriver InitDriver(Properties prop)
	{ op= new OptionsManager(prop);
	   highlight=prop.getProperty("highlight");
	
		// browser is coming from config file
		String browsername = prop.getProperty("browser");
		System.out.println ("the browser is :"+ browsername);
		// chrome//chrome
		if (browsername.trim().equalsIgnoreCase("chrome"))
		{
			// chrome driver
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			// Object
			//driver= new ChromeDriver(op.getChromeOptions());
			tldriver.set(new ChromeDriver(op.getChromeOptions())); //op is options...refer to OptionManager class
			
		}
		
		else if (browsername.trim().equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			//top costing
			tldriver.set(new FirefoxDriver(op.getFirefoxOptions()));
		}
		
		else if (browsername.trim().equalsIgnoreCase("safari"))
		{
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			
		}
		
		else if (browsername.trim().equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		else
		{
			System.out.println("enter the correct browser name:");
		}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("url"));
			return driver;
		}
	/**
	 * create a method for getting properties from config file
	 * Properties class methods is predefine class// by using properties class we can get all data from config file.
	 * FileInput is from config file
	 * prop.load is a method to get data(values) from  config file
	 * (ip) we loaded file or data in ip and if any exception comes it helps to catch it using try catch method.
	 */
	public Properties initProperties()
	{
		prop = new Properties();// Object creation
		
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\Nelly\\eclipse-workspace\\NellyAndLakshmiProject\\src\\test\\resources\\ConfigFile");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return prop; // property file
	}
	
	}
	
	

