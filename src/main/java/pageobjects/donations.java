package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class donations {

	@FindBy(id="cookie-donation-contact-info")
	private WebElement donor_contact_name;
	
	@FindBy(id="cookie-donation-company-name")
	private WebElement donor_company_name;
	
	@FindBy(id="cookie-donation-store")
	private WebElement donor_store_name;
	
	
	
}
