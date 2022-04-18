package Page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utilities.CommonUtils;

public class DirectoryPage {

	
	/*
	@FindBy(id ="searchDirectory_job_title")
	public static WebElement JobTitle_Dropdown;
	
	
	@FindBy(id ="searchBtn")
	public static WebElement SearchButton;
	
	
	@FindBy(xpath ="//*[@id=\'resultTable\']/tbody/tr[2]/td[2]/ul/li[1]/b")
	public static WebElement Name;
	
	*/
	
	private static DirectoryPage DirectoryPageInstance;
         private DirectoryPage() {
		
	}
	
	public static DirectoryPage getInstance()
	{
	if
	(DirectoryPageInstance==null) {
	DirectoryPageInstance = new DirectoryPage();
	
	} 
	return DirectoryPageInstance;
}
	
	
	
	
	
	@FindBy(id ="searchDirectory_job_title")
	private WebElement JobTitle_Dropdown;
	
	
	public WebElement getJobTitle_Dropdown() {
		return JobTitle_Dropdown;
	}
/*

	public WebElement getSearchButton() {
		return SearchButton;
	}


	public WebElement getName() {
		return Name;
	}

*/
	@FindBy(id ="searchBtn")
	private WebElement SearchButton;
	
	
	@FindBy(xpath ="//*[@id=\'resultTable\']/tbody/tr[2]/td[2]/ul/li[1]/b")
	private WebElement Name;
	
	
	
	
	//Action performs 
	
	
	public void SelectJobTitle(String JOB_TITLE) {
		CommonUtils.getInstance().HighlightElements(JobTitle_Dropdown);
		Select selectJob= new Select(JobTitle_Dropdown);
        selectJob.selectByVisibleText(JOB_TITLE);		
				
		
	} 
	
	public void SearchButtonclick() {
		CommonUtils.getInstance().HighlightElements(SearchButton);
		SearchButton.click();
		
	}
	public String getPersonName() {
		CommonUtils.getInstance().HighlightElements(Name);
		return Name.getText();
		
	}
	
	
}
