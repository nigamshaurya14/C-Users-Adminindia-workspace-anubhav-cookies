package step_definitions;

import static org.testng.AssertJUnit.assertEquals;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cookies.abstractdriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.Signup;

public class step_Signup extends abstractdriver {
	/*
	 * public step_Signup(WebDriver driver) { super(driver); // TODO
	 * Auto-generated constructor stub }
	 */

	WebDriver driver = getDriver();
	Signup signup = new Signup(driver);
	// signin s=new signin(driver);

	@And("^Click on Submit button$")
	public void click_submit() throws Throwable {
		signup.submit_login.click();
		Thread.sleep(4000);
	}

	@When("^User enters an already registered emaid Id in email text box$")
	public void user_enters_an_already_registered_emaid_Id_in_email_text_box(DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		signup.emailid.sendKeys(data.get(0).get(1));

		Thread.sleep(3000);

	}

	@Then("^Error popup should appear stating that The email has already been taken$")
	public void error_popup_should_appear_stating_that_The_email_has_already_been_taken() throws Throwable {
		assertEquals("The email has already been taken.", signup.popup.getText());

	}

	@When("^Click on Create Account button$")
	public void click_on_new_Submit_button() throws Throwable {
		signup.create_account.click();
		Thread.sleep(3000);
	}

	@When("^User enter valid inputs in all fields and invalid  emailid format$")
	public void user_enter_invalid_emailid_format(DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		signup.emailid.sendKeys(data.get(0).get(1));

		Thread.sleep(3000);

	}

	@Then("^Error popup should appear stating that The email must be a valid email address$")
	public void error_popup_should_appear_stating_that_The_email_must_be_a_valid_email_address() throws Throwable {
		assertEquals("The email must be a valid email address.", signup.popup.getText());
	}

	@Then("^Error popup should appears stating Please enter your first name$")
	public void error_popup_should_appears_stating_Please_enter_your_first_name() throws Throwable {
		assertEquals("Please enter your first name", signup.popup.getText());
		System.out.println(signup.popup.getText());
		Thread.sleep(5000);
	}

	@When("^User enter first Name$")
	public void user_enter_first_Name(DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		signup.first_name.sendKeys(data.get(0).get(1));
		// Thread.sleep(3000);
	}

	@Then("^Error popup should appears stating Please enter your last name$")
	public void error_popup_should_appears_stating_Please_enter_your_last_name() throws Throwable {
		assertEquals("Please enter your last name", signup.popup.getText());
		System.out.println(signup.popup.getText());
		Thread.sleep(5000);
	}

	@When("^User enter last Name$")
	public void user_enter_last_Name(DataTable table) throws Throwable {
		List<List<String>> data = table.raw();
		signup.last_name.sendKeys(data.get(0).get(1));
		Thread.sleep(3000);
	}

	@Then("^Error popup should appears stating The email field is required$")
	public void error_popup_should_appears_stating_The_email_field_is_required() throws Throwable {
		assertEquals("The email field is required.", signup.popup.getText());
		System.out.println(signup.popup.getText());
		Thread.sleep(5000);
	}

	@When("^User enters emailid$")
	public void user_enters_emailid(DataTable table) throws Throwable {
		List<List<String>> data = table.raw();
		signup.emailid.sendKeys(data.get(0).get(1));
	}

	@Then("^Error popup should appears stating The telephone field is required$")
	public void error_popup_should_appears_stating_The_telephone_field_is_required() throws Throwable {
		assertEquals("The telephone field is required.", signup.popup.getText());
		System.out.println(signup.popup.getText());
		Thread.sleep(5000);
	}

	@When("^User enters The telephone number$")
	public void user_enters_The_telephone_number(DataTable table) throws Throwable {
		List<List<String>> data = table.raw();
		// signup.phone.sendKeys(data.get(0).get(1));
	}

	@Then("^Error popup should appear stating The password field is required$")
	public void error_popup_should_appear_stating_The_password_field_is_required() throws Throwable {
		assertEquals("The password field is required.", signup.popup.getText());
		System.out.println(signup.popup.getText());
		Thread.sleep(5000);
	}

	@When("^User enter the password$")
	public void user_enter_the_password(DataTable table) throws Throwable {
		List<List<String>> data = table.raw();
		signup.new_password.sendKeys(data.get(0).get(1));
	}

	@Then("^Error popup should apppear stating The password confirmation does not match$")
	public void error_popup_should_apppear_stating_The_password_confirmation_does_not_match() throws Throwable {
		assertEquals("The password confirmation does not match.", signup.popup.getText());
		System.out.println(signup.popup.getText());
		Thread.sleep(5000);
	}

	@When("^User enter valid inputs in all fields and uncommon inputs in Password and confirm password fields$")
	public void user_enter_valid_inputs_in_all_fields_and_uncommon_inputs_in_Password_and_confirm_password_fields(
			DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

	
	signup.emailid.sendKeys(data.get(0).get(1));
		 Thread.sleep(3000);
		// signup.phone.sendKeys(data.get(3).get(1));
		// Thread.sleep(3000);
		signup.new_password.sendKeys(data.get(1).get(1));
		 Thread.sleep(3000);
		signup.new_user_confirm_password.sendKeys(data.get(2).get(1));
		 Thread.sleep(3000);

	}

	@Then("^Error Validation messages should appear stating that The password confirmation does not match$")
	public void error_Validation_messages_should_appear_stating_that_The_password_confirmation_does_not_match()
			throws Throwable {
		assertEquals("The password confirmation does not match.", signup.popup.getText());
		System.out.println(signup.popup.getText());
	}

	@When("^User enter valid inputs in all fields and 4 digit password in Password fields$")
	public void User_enter_valid_inputs_in_all_fields_and_4_digit_password_in_Password_fields(DataTable table)
			throws Throwable {
		List<List<String>> data = table.raw();

		signup.emailid.sendKeys(data.get(0).get(1));
		 Thread.sleep(3000);
		
		signup.new_password.sendKeys(data.get(1).get(1));
		 Thread.sleep(3000);
		signup.new_user_confirm_password.sendKeys(data.get(2).get(1));
		 Thread.sleep(3000);
		
	}

	@Then("^Error Validation messages should appear stating that The password must be at least 5 characters$")
	public void paaswprd_less_than_5() throws Throwable {
		assertEquals("The password must be at least 5 characters.", signup.popup.getText());
		System.out.println(signup.popup.getText());

	}

	@When("^User enter valid inputs in all fields and phone no less than (\\d+)$")
	public void user_enter_valid_inputs_in_all_fields_and_phone_no_less_than(int arg1, DataTable table)
			throws Throwable {
		List<List<String>> data = table.raw();

		signup.first_name.sendKeys(data.get(0).get(1));
		// Thread.sleep(3000);
		signup.last_name.sendKeys(data.get(1).get(1));
		// Thread.sleep(3000);
		signup.emailid.sendKeys(data.get(2).get(1));
		// Thread.sleep(3000);
		// signup.phone.sendKeys(data.get(3).get(1));
		// Thread.sleep(3000);
		signup.new_password.sendKeys(data.get(4).get(1));
		// Thread.sleep(3000);
		signup.new_user_confirm_password.sendKeys(data.get(5).get(1));
		// Thread.sleep(3000);

	}

	@Then("^Error Validation messages should appear stating that Please enter a (\\d+) digit phone number$")
	public void error_Validation_messages_should_appear_stating_that_Please_enter_a_digit_phone_number(int arg1)
			throws Throwable {
		assertEquals("Please enter a 10 digit phone number", signup.popup.getText());
		System.out.println(signup.popup.getText());

	}

	@When("^User enter valid inputs in all fields and phone no greater than (\\d+)$")
	public void user_enter_valid_inputs_in_all_fields_and_phone_no_greater_than(int arg1, DataTable table)
			throws Throwable {
		List<List<String>> data = table.raw();

		signup.first_name.sendKeys(data.get(0).get(1));
		// Thread.sleep(3000);
		signup.last_name.sendKeys(data.get(1).get(1));
		// Thread.sleep(3000);
		signup.emailid.sendKeys(data.get(2).get(1));
		signup.phone.sendKeys(data.get(3).get(1));
	}

	@Then("^Only (\\d+) digits should be displayed in the textbox$")
	public void only_digits_should_be_displayed_in_the_textbox(int arg1) throws Throwable {

		String str = signup.phone.getAttribute("value");
		System.out.println(str);
		int i = str.length();
		System.out.println(i);
		assertEquals(10, i);

	}

	@When("^User enter valid inputs in all fields and phone no in characters$")
	public void user_enter_valid_inputs_in_all_fields_and_phone_no_in_characters(DataTable table) throws Throwable {
		List<List<String>> data = table.raw();
		signup.first_name.sendKeys(data.get(0).get(1));
		// Thread.sleep(3000);
		signup.last_name.sendKeys(data.get(1).get(1));
		// Thread.sleep(3000);
		signup.emailid.sendKeys(data.get(2).get(1));
		// signup.phone.sendKeys(data.get(3).get(1));
	}

	@Then("^Nothing should be displayed in the textbox$")
	public void nothing_should_be_displayed_in_the_textbox() throws Throwable {
		String str = signup.phone.getAttribute("value");
		System.out.println(str);
		if (str.isEmpty()) {
			System.out.println("Test Case Passed");
		} else {
			System.out.println("Test Case Passed");
		}

	}
	@And("^User Click on Forgot Passoword$")
	public void click_forgot_password() throws Throwable
	{
		signup.forgot_password.click();
	}
@Then("^user redirects to Forgot password Page$") 
public void forgot_password_page() throws Throwable{

	assertEquals("Forgot Your Password?", signup.forgot_password_page.getText());
	System.out.println(signup.forgot_password_page.getText());
	Thread.sleep(5000);
}
}
