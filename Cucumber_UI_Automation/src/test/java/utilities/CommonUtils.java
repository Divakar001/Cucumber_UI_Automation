package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Page_Objects.DirectoryPage;
import Page_Objects.HomePage;
import Page_Objects.LoginPage;
import Page_Objects.TimeSheetPage;
import StepDefinition.Common_Step_Definition;
import constants.Constants;
import webdriverManager.DriverManager;
import org.apache.logging.log4j.Logger;


public class CommonUtils {

	
	private static final Logger LOGGER= LogManager.getLogger(CommonUtils.class);
	private static CommonUtils CommonUtilsInstance=null;
	
	private CommonUtils() {
		
	}
	public static CommonUtils getInstance() {
		
		if(CommonUtilsInstance == null){
			CommonUtilsInstance = new CommonUtils();
        }
        return CommonUtilsInstance;
    }
	
	
	
	public void loadProperties() {
		Properties properties =new Properties();
		try{
			
			properties.load(getClass().getResourceAsStream("/config.properties"));
			//load(getClass().getResourceAsStream("/config.properties"));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
//	public static void loadProperties() throws IOException {
//		FileReader reader=null;
//		try{
//		 reader= new FileReader("config.properties");
//		}
//		catch(FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	
//		
//		Properties properties =new Properties();
//		
//		
//		try{
//			properties.load(reader);
//			}
//			catch(IOException e) {
//				e.printStackTrace();
//			}
		
	
		Constants.App_URL =properties.getProperty("App_URL");
		Constants.Browser =properties.getProperty("Browser");
		Constants.Username =properties.getProperty("Username");
		Constants.Password =properties.getProperty("Password");
		Constants.Chrome_driver_Location=properties.getProperty("Chrome_driver_Location");
		Constants.Firefox_driver_Location=properties.getProperty("Firefox_driver_Location");
		Constants.IE_driver_Location = properties.getProperty("IE_driver_Location");	
		
	}
	
	


	public void initWebElements() {

		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());	
		PageFactory.initElements(DriverManager.getDriver(), HomePage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), DirectoryPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), TimeSheetPage.getInstance());
	}



public void takesScreenshot() {
	
	File screenshot=((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			
	
	try {
		FileUtils.copyFile(screenshot, new File(Common_Step_Definition.GetScenarioName()+".png" ));
	}
	catch(IOException e) {
		System.out.println(e.getMessage());
		
	}
	

	
	
}
//Highlighting the Elements
	public void HighlightElements(WebElement element) {
		
		JavascriptExecutor exec= (JavascriptExecutor) DriverManager.getDriver();
		exec.executeScript("arguments[0].setAttribute('style','border: 3px solid red');", element);
		
	}

	
	
	public void SelectFromDropDown(WebElement DropDown, String Value, String HowTo) {

		Select select=new Select(DropDown);

		switch(HowTo) { 
		case "index":
			select.selectByIndex(Integer.parseInt(Value));
			break;
		case "value":
			select.selectByValue(Value);
			break;
		case "text":
			select.selectByVisibleText(Value);
			break;
		default:
			LOGGER.info("Please Provide a valid selection in the feature file. Valid Selections are: text, value, index");
			break;
		}



	}}
