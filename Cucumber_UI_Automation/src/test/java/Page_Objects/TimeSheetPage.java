package Page_Objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.CommonUtils;

public class TimeSheetPage {
	
	private static TimeSheetPage TimeSheetPageInstance;
	private TimeSheetPage() {
		
	}
	public static TimeSheetPage getInstance() {
		
		if(TimeSheetPageInstance == null){
			TimeSheetPageInstance = new TimeSheetPage();
        }
        return TimeSheetPageInstance;
    }
	
	
	

	//Employee search Box
	@FindBy(id="employee")
	private WebElement EmployeNameTextBox;
	
	public WebElement getemployeeName() {
		return EmployeNameTextBox;
	}

	//action
		public void enterEmployeeName(String PersonNametosearch){
			CommonUtils.getInstance().HighlightElements(EmployeNameTextBox);
			EmployeNameTextBox.clear();
			EmployeNameTextBox.sendKeys(PersonNametosearch+Keys.ENTER);
			
			
			
			}
		
	//Employee buttonView	
		@FindBy(id="btnview")
		private WebElement btnView;
		
		/*
		public WebElement getBtnView() {
			return btnView;
		}
		*/
		public void ButtonViewClick(){
			CommonUtils.getInstance().HighlightElements(btnView);
			btnView.click();
			}
		
		
		//getting warning Message
		@FindBy(className="message warning")
		//@FindBy(xpath="//*[@id=\'content\']/div/div/div[1]")
		private WebElement WarningMessage;
		
		/*
		public WebElement getWarningMessage() {
			return WarningMessage;
		}
		*/
		public String getWarningMessages(){
			CommonUtils.getInstance().HighlightElements(WarningMessage);
			return WarningMessage.getText();
			}
		
}
