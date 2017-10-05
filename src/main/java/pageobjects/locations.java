package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class locations {

	@FindBy(id = "entered_location")
	private WebElement entered_location;
	
	@FindBy(id = "input")
	private WebElement input;
	
	@FindBy(xpath="id('search-city-zip')")
	private WebElement search;
	
	
	
	
	public locations(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
}
