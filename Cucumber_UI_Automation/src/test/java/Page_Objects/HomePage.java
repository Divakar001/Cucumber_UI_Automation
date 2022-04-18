package Page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.CommonUtils;

public class HomePage {

	/*

	@FindBy(linkText ="Directory")
	public static WebElement Directory;
	
	*/
	
	private static HomePage HomePageInstance;
	private HomePage() {
		
	}
	public static HomePage getInstance() {
		
		if(HomePageInstance == null){
			HomePageInstance = new HomePage();
        }
        return HomePageInstance;
    }
	
	
	@FindBy(linkText="Time")
	private WebElement Time;
	
	public WebElement GetClickTime() {
		return Time;
	}
	
	public void ClickTime() {
		Time.click();
	}
	
	
	@FindBy(linkText ="Directory")
	private WebElement Directory;

	public WebElement getDirectory() {
		CommonUtils.getInstance().HighlightElements(Directory);
		return Directory;
	}
	
	public void ClickDirectory() {
		CommonUtils.getInstance().HighlightElements(Directory);
		Directory.click();
	}
	
}
