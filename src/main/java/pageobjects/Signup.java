package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cookies.abstractdriver;

public class Signup extends abstractdriver {

	@FindBy(xpath = "//div[@class='growl-message']")
	public  WebElement popup;
	
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	public WebElement alert;

	@FindBy(xpath = "//button[@id='submit-login-btn']")
	public WebElement submit_login;

	@FindBy(xpath = "//input[@id='new-first-name']")
	public WebElement first_name;

	@FindBy(xpath = "//input[@id='new-last-name']")
	public WebElement last_name;

	@FindBy(xpath = "//input[@id='email-register']")
	public WebElement emailid;

	
	@FindBy(xpath = " //input[@id='password-register']")
	public WebElement new_password;

	@FindBy(xpath = "//input[@id='password-confirm']")
	public WebElement new_user_confirm_password;

	@FindBy(xpath = "//button[@id='submit-register-form']")
	public WebElement create_account;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
    public WebElement forgot_password;
	
	@FindBy(xpath = "//h3[@class='text-dark']")
	public WebElement forgot_password_page;
	
	WebDriver driver = getDriver();

	public Signup(WebDriver driver) {
		// super(driver);
		PageFactory.initElements(driver, this);
	}

	public void signin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

}
