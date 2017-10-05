package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class events {
	
	@FindBy(id = "contact_name")
	private WebElement Contact_name;
	
	@FindBy(id = "contact_email")
	private WebElement contact_email;
	
	@FindBy(name = "company_name")
	private WebElement company_name;
	
	@FindBy(name = "locatoin")
	private WebElement location;
	
	@FindBy(id = "phone")
	private WebElement phone;
	
	@FindBy(id = "event_date")
	private WebElement event_date;
	
	@FindBy(id = "event_time")
	private WebElement event_time;
	
	@FindBy(id = "event_type")
	private WebElement event_type;
	
	@FindBy(id = "event_products")
	private WebElement event_products;
	
	@FindBy(xpath = "//*[@id='events_form']/button")
	private WebElement submit;
	
	public events(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
}
