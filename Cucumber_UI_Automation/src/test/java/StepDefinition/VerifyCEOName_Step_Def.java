package StepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.Select;

import Page_Objects.DirectoryPage;
import Page_Objects.HomePage;
import Page_Objects.LoginPage;
import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.CommonUtils;
import webdriverManager.DriverManager;

public class VerifyCEOName_Step_Def {
	
	private static final Logger LOGGER = LogManager.getLogger(VerifyCEOName_Step_Def.class);
	
	@Given("the user is logged in successfully and is on home PAge")
	public void the_user_is_logged_in_successfully_and_is_on_home_p_age() throws InterruptedException {
		
		LOGGER.info("the user is logged in successfully and is on home PAge");
		System.out.println("the user is logged in successfully and is on home PAge");
		try {
			
			
			
		
		Thread.sleep(4000);
		String URl=DriverManager.getDriver().getCurrentUrl();
		if(URl.contains("dashboard")) {
			System.out.println("Login Successfully");
			
		}}
		
		catch(Exception e) {
			LOGGER.error(e);
			//CommonUtils.getInstance().takesScreenshot();
			
		
		}
		
		
		
	}
	    
	

	@When("the user clicks on the directory option from the menu bar")
	public void the_user_clicks_on_the_directory_option_from_the_menu_bar() throws InterruptedException {
		//System.out.println("the user clicks on the directory option from the menu bar");
		//HomePage HomePageObject = new HomePage();
		
		try {
			
		
		Thread.sleep(3000);
		HomePage.getInstance().ClickDirectory();
		System.out.println("the user clicks on the directory option from the menu bar");
		LOGGER.info("the user clicks on the directory option from the menu bar");
		
	}
	catch(Exception e) {
		LOGGER.error(e);
		//CommonUtils.getInstance().takesScreenshot();
	
	}
	}

	@When("the user selects the job title as {string} from the drop down using {string}")
	public void the_user_selects_the_job_title_as_from_the_drop_down(String Value, String HowTo) throws InterruptedException {
		//DirectoryPage DirectoryPageObject= new DirectoryPage();
		try {
		
		Thread.sleep(5000);
		CommonUtils.getInstance().SelectFromDropDown(DirectoryPage.getInstance().getJobTitle_Dropdown(), Value, HowTo);
		//DirectoryPage.getInstance().SelectJobTitle(JobTitle);
//	     Select select = new Select(DirectoryPage.getInstance().getJobTitle_Dropdown());
//	     select.selectByVisibleText(JobTitle);
	     System.out.println("the user selects the job title as {string} from the drop down using {string}");
	     LOGGER.info("the user selects the job title as {string} from the drop down using {string}");
		}
	     catch(Exception e) {
	 		LOGGER.error(e);
	 		//CommonUtils.getInstance().takesScreenshot();
	 	
	 	}
		
	   
	}

	@When("click the search button")
	public void click_the_search_button() throws InterruptedException {
		try {
		Thread.sleep(5000);
		//DirectoryPage DirectoryPageObject= new DirectoryPage();
		DirectoryPage.getInstance().SearchButtonclick();
		System.out.println("click the search button"); 
		LOGGER.info("click the search button");
	}
    catch(Exception e) {
		LOGGER.error(e);
		//CommonUtils.getInstance().takesScreenshot();
		
	}
	
	    
	}

	@Then("the user should see the CEO name as {string}")
	public void the_user_should_see_the_ceo_name_as(String expectedName) throws InterruptedException {
		//DirectoryPage DirectoryPageObject= new DirectoryPage();
		try {
		Thread.sleep(5000);
		String ActualName =DirectoryPage.getInstance().getPersonName();
		if(expectedName.equalsIgnoreCase(ActualName)) {
			
			System.out.println("Code Working Fine");
			LOGGER.info("click the search button");
		}
		}
		//System.out.println("the user should see the CEO name as {string}");
		catch(Exception e) {
			LOGGER.error(e);
			//CommonUtils.getInstance().takesScreenshot();
		
		}
		  
		
		
		

		}
}
