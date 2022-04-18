package webdriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import StepDefinition.Common_Step_Definition;
import constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	
	private static final Logger LOGGER= LogManager.getLogger(DriverManager.class);
	private static WebDriver driver=null;
//	public static WebDriver getDriver() {
//		return driver;
//	}
	public static void launchBrowser() {
		try {
			
			switch(Constants.Browser)
			{
			case "chrome":
				WebDriverManager.chromedriver().setup();
			//System.setProperty(Constants.Chrome_driver, Constants.Chrome_driver_Location);
			LOGGER.info("Launching "+Constants.Browser);
			driver= new ChromeDriver();
			
			break;
			
			
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
			//System.setProperty(Constants.Firefox_driver,  Constants.Firefox_driver_Location);
			LOGGER.info("Launching "+Constants.Browser);
			
			driver= new FirefoxDriver();
			break;
			
			case "ie":
				WebDriverManager.iedriver().setup();
            //System.setProperty(Constants.IE_driver, Constants.IE_driver_Location);
            LOGGER.info("Launching "+Constants.Browser);
			
			driver= new InternetExplorerDriver();
			break;
			
			default:
				WebDriverManager.chromedriver().setup();
			//System.setProperty(Constants.Chrome_driver, Constants.Chrome_driver_Location);
			LOGGER.info("Launching "+Constants.Browser);
			driver= new ChromeDriver();
			
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
}
