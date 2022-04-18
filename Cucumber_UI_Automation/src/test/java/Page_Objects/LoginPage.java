package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonUtils;
import webdriverManager.DriverManager;

public class LoginPage {
	
	/*
	@FindBy(id="txtUsername")
	public static WebElement Username;

	@FindBy(id="txtPassword")
	public static WebElement Password;

	@FindBy(id="btnLogin")
	public static WebElement Login_Button;

	
	
	*/
	//implementing the Lazy Initialization - Singleton
	/*Default Code
	package com.journaldev.singleton;

	public class LazyInitializedSingleton {

	    private static LazyInitializedSingleton instance;
	    
	    private LazyInitializedSingleton(){}
	    
	    public static LazyInitializedSingleton getInstance(){
	        if(instance == null){
	            instance = new LazyInitializedSingleton();
	        }
	        return instance;
	    }
	}
	**/
	
	
	private static LoginPage LoginInstance;
	private LoginPage() {
		
	}
	public static LoginPage getInstance() {
		
		if(LoginInstance == null){
			LoginInstance = new LoginPage();
        }
        return LoginInstance;
    }
	//Using ByLocator
	By USERNAME=By.id("txtUsername");
	By PASSWORD=By.id("txtPassword");
	By Login_Button=By.id("btnLogin");
	WebDriver driver=  DriverManager.getDriver();
			
	
	//Using PageFactory
	/*
	@FindBy(id="txtUsername")
	private WebElement USERNAME;
	
	@FindBy(id="txtPassword")
	private WebElement PASSWORD;
	
	@FindBy(id="btnLogin")
	private WebElement Login_Button;
	*/

	/*
	public WebElement getUsername() {
		return USERNAME;
	}

	public WebElement getPassword() {
		return PASSWORD;
	}

	public WebElement getLogin_Button() {
		return Login_Button;
	}

*/
	//action
	//Explicit wait in Try catch block for to handle NoSuchElement exception
	public void enterUserName(String Username){

		try {
			CommonUtils.getInstance().HighlightElements(driver.findElement(USERNAME));
			//CommonUtils.getInstance().HighlightElements(USERNAME);

			driver.findElement(USERNAME).sendKeys(Username);
			//USERNAME.sendKeys(Username);
		}
		catch (NoSuchElementException e) {
			System.out.println("Element Not Found, trying explicit wait");
			
			try {
				WebDriverWait wait= new WebDriverWait(DriverManager.getDriver(), 15);
				wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME));
			} catch (Exception e2) {
				System.out.println("Element Not Found, Please give correct locator");
			}

		}}

	public void enterPassword(String Password){
		CommonUtils.getInstance().HighlightElements(driver.findElement(PASSWORD));
		//PASSWORD.sendKeys(Password);
		driver.findElement(PASSWORD).sendKeys(Password);

	}
	public void ClickLoginButton(){
		CommonUtils.getInstance().HighlightElements(driver.findElement(Login_Button));
		//Login_Button.click();
		driver.findElement(Login_Button).click();
	}
}
