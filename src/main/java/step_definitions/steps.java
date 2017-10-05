package step_definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cookies.abstractdriver;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class steps extends abstractdriver {

	WebDriver driver = getDriver();
	
	@Given("^I went to gmail\\.com$")
	public void i_went_to_gmail_com() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http:\\gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    //throw new PendingException();
	}

	@When("^I entered username and password$")
	public void i_entered_username_and_password() throws Throwable {
	   driver.findElement(By.id("email")).sendKeys("nigamshaurya14");
	   
	}

	@Then("^I should get logged in successfully$")
	public void i_should_get_logged_in_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("logged in");
	    throw new PendingException();
	}


}
