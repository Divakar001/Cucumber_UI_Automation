package StepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Page_Objects.LoginPage;
import constants.Constants;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.CommonUtils;
import webdriverManager.DriverManager;

public class Common_Step_Definition {

	
	//Launch the browser
	
	private static String scenarioName=null;
	
	public static String GetScenarioName() {
		return scenarioName;
		
	}
	
	
	

	//for logger
	private static final Logger LOGGER= LogManager.getLogger(Common_Step_Definition.class);
	@Before
	public void beforeScenario(Scenario scenario) {
		
		LOGGER.info("Execution Started");
		try {
			scenarioName=scenario.getName();
			//CommonUtils.loadProperties();
			LOGGER.info("instantiation the commonutils");
			
			
			LOGGER.info("Loading the Properties file");
			CommonUtils.getInstance().loadProperties();
		
			LOGGER.info("Checking the driver=null or not");
			if(DriverManager.getDriver()==null){
				LOGGER.info("Driver is null, instantiating it!");
				DriverManager.launchBrowser();
				CommonUtils.getInstance().initWebElements();
				login();
				
		}
		}
			
		catch(Exception e) {
			e.printStackTrace();
			
			CommonUtils.getInstance().takesScreenshot();
		}
	
	}
	private void login() {
		

		DriverManager.getDriver().get(Constants.App_URL);
		
		
	//Calling Login Page
		
		//LoginPage LoginPageObject = new LoginPage();
		//LoginPage.getInstance().getUsername().sendKeys(Constants.Username);
		LoginPage.getInstance().enterUserName(Constants.Username);
	
		LoginPage.getInstance().enterPassword(Constants.Password);
		
		LoginPage.getInstance().ClickLoginButton();
		
		

	}
	@AfterStep
	public void attachScreenshot(Scenario scenario)  {

		if(scenario.isFailed()) {
			byte[] screenshotTaken= ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotTaken, "image/png", "errorScreen");



		}


	}

	/*
	public void launchBrowser() {
		try {
			
			switch(Constants.Browser)
			{
			case "chrome":
			System.setProperty(Constants.Chrome_driver, Constants.Chrome_driver_Location);
			LOGGER.info("Launching "+Constants.Browser);
			driver= new ChromeDriver();
			
			break;
			
			
			case "firefox":
			System.setProperty(Constants.Firefox_driver,  Constants.Firefox_driver_Location);
			LOGGER.info("Launching "+Constants.Browser);
			
			driver= new FirefoxDriver();
			break;
			
			case "ie":
            System.setProperty(Constants.IE_driver, Constants.IE_driver_Location);
            LOGGER.info("Launching "+Constants.Browser);
			
			driver= new InternetExplorerDriver();
			break;
			
			default:
			System.setProperty(Constants.Chrome_driver, Constants.Chrome_driver_Location);
			LOGGER.info("Launching "+Constants.Browser);
			driver= new ChromeDriver();
			
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
}
