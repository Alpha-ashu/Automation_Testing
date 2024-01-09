package Selenium_Test_Cases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Selenium_Utilities.Read_Config;

public class Selenium_Base_Class {
	Read_Config RC = new Read_Config();

	public String BaseURL = RC.getApplicationURL();
	public String Username = RC.getUsername();
	public String Password = RC.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters ("browser")
	@BeforeClass
	public void setup(String br) 
	{
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("WebDriver.chrome.driver", RC.getChromepath());
			driver = new ChromeDriver();
		} else if (br.equals("Firefox")) 
		{
			System.setProperty("WebDriver.gecko.driver", RC.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		else if (br.equals("ie")) 
		{
			System.setProperty("WebDriver.ie.driver", RC.getIEpath());
			driver = new InternetExplorerDriver();
			}
		driver.get(BaseURL);
		
	}
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}

}
