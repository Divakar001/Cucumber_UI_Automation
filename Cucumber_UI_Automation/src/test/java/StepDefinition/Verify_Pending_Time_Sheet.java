package StepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Page_Objects.HomePage;
import Page_Objects.TimeSheetPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import utilities.CommonUtils;
import webdriverManager.DriverManager;

public class Verify_Pending_Time_Sheet {
	
	private static final Logger LOGGER = LogManager.getLogger(Verify_Pending_Time_Sheet.class);

@Given("the user is on the homepage")
public void the_user_is_on_the_homepage() {
	try {
	String URl=DriverManager.getDriver().getCurrentUrl();
	if(URl.contains("dashboard")) {
		System.out.println("Login Successfully");
		LOGGER.info("Login Successfully");
		System.out.println("the user is on the homepage");
	}}
	catch(Exception e) {
		LOGGER.error(e);
		//CommonUtils.getInstance().takesScreenshot();
		
	
}}

@Given("the user clicks on the time option from the menu")
public void the_user_clicks_on_the_time_option_from_the_menu() {
	try {

	HomePage.getInstance().ClickTime();
	System.out.println("the user clicks on the time option from the menu");
	LOGGER.info("the user clicks on the time option from the menu");
    
}
      catch(Exception e) {
	  LOGGER.error(e);
	//  CommonUtils.getInstance().takesScreenshot();
	
}}
@Given("the user enters the name as {string}")
public void the_user_enters_the_name_as(String PersonNametosearch) {
	try {
		
	TimeSheetPage.getInstance().enterEmployeeName(PersonNametosearch);
	System.out.println("the user enters the name as {string}");
	LOGGER.info("the user enters the name as {string}");
}



    catch(Exception e) {
	LOGGER.error(e);
	//CommonUtils.getInstance().takesScreenshot();
}}

@Given("clicks on the view button")
public void clicks_on_the_view_button() {
	try {
    //Thread.sleep(3000);
	TimeSheetPage.getInstance().ButtonViewClick();
	System.out.println("clicks on the view button");
	LOGGER.info("clicks on the view button");
	
	}
	
	catch(Exception e) {
    LOGGER.error(e);
   // CommonUtils.getInstance().takesScreenshot();
    
}}

@Then("the user should see the message as {string}")
public void the_user_should_see_the_message_as(String WarningexpectedName) {
	
	try {
		//Thread.sleep(3000);
	String WarningActualMessage= TimeSheetPage.getInstance().getWarningMessages();
	
	if(WarningexpectedName.equalsIgnoreCase(WarningActualMessage)) {
		
		System.out.println("this Code also Working Fine");
		LOGGER.info("this Code also Working Fine");
	}}
	
catch(Exception e) {
	LOGGER.error(e);
	//CommonUtils.getInstance().takesScreenshot();
	//Assert.fail();
	org.junit.Assert.fail(e.getMessage());

}}}
