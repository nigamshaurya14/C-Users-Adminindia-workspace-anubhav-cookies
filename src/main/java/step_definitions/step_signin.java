package step_definitions;

import static org.testng.AssertJUnit.assertEquals;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import cookies.abstractdriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.Signup;
import pageobjects.signin;

public class step_signin extends abstractdriver {
	// public WebDriver driver;
	/*
	 * public step_signin() { driver = Hooks.driver; // TODO Auto-generated
	 * constructor stub }
	 */
	//ConfigFileReader configFileReader = new ConfigFileReader();
	 WebDriver driver = getDriver();
	// public Map<String, String> url;
	signin s = new signin(driver);
	Signup signup = new Signup(driver);

	/*@Given("^User opens the Website$")
	public void user_opens_the_Website() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		System.out.println(configFileReader.getApplicationUrl());
		Thread.sleep(3000);
	}*/

	@Given("^User opens the Website$")
	  public void user_opens_the_Website(DataTable table) throws Throwable {
	  List<List<String>> data = table.raw();
	  System.out.println(data.get(0).get(1));
	  driver.get(data.get(0).get(1));
	  
	  }
	 
	@Given("^Click on Log In link present in top right corner of the homepage$")
	public void click_on_Login_button_in_Header() throws Throwable {
		Thread.sleep(5000);
		s.login_button.click();
		
	}

	@When("^User enters valid Email and Password$")
	public void under_SIGN_IN_section_enter_valid_Email_and_Password(DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		s.username.sendKeys(data.get(0).get(1));
		Thread.sleep(3000);
		s.password.sendKeys(data.get(1).get(1));
		Thread.sleep(3000);
	}
	
	@When("^User enters the invalid Email and Password$")
	public void under_SIGN_IN_section_enter_invalid_Email_and_Password(DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		s.username.sendKeys(data.get(0).get(1));
		Thread.sleep(3000);
		s.password.sendKeys(data.get(1).get(1));
		Thread.sleep(3000);
	}

	@When("^Click on the Log In button$")
	public void click_on_Submit() throws Throwable {
		s.submit_login.click();
		Thread.sleep(10000);
	}
	
	@When("^User clicks Logout button$")
	public void click_logout() throws Throwable {
		s.logout.click();
		Thread.sleep(3000);
	}

	@Then("^User must get login in and UserName should be displayed in the header$")
	public void user_must_get_login_in_and_UserName_should_be_displayed_in_the_header() throws Throwable {
		String str = new String();
		str = s.login_text.getText();
		System.out.println(str);
		if (str.contains("Hi")) {
			System.out.println("Test Case Passed");
		} else {
			System.out.println("Test Case Failed");
		}

	}
	
	@Then("^Error popup should appear stating Email and password do not match$")
	public void error_popup_should_appear_stating_Email_and_password_do_not_match() throws Throwable {
		assertEquals("Email and password do not match.", signup.alert.getText());

	}
	
	@Then("^Alert should appear saying Please enter an email address$")
	public void alert_should_appear_saying_Please_enter_an_email_address() throws Throwable {
	    
		assertEquals("Please enter an email address.", s.alert_email.getText());
	}

	@Then("^The password field is required$")
	public void the_password_field_is_required() throws Throwable {
		assertEquals("The password field is required.", s.alert_password.getText());
	}

	

	@And("^User should logout successfully$")
	public void User_should_logout_successfully() throws Throwable {

		try{
		
		assertEquals("log In",s.login_button.getText());
		
		System.out.println("Logged out successfully");
		Thread.sleep(5000);
		}catch (NoSuchElementException e) {
			System.out.println("User is still Logged In");
		}
	}

	
}
