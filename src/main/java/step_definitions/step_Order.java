package step_definitions;

import static org.junit.Assert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cookies.abstractdriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.Order;

public class step_Order extends abstractdriver{
	
	 WebDriver driver = getDriver();
	 
	 Order order=new Order(driver);
	 WebDriverWait wait = new WebDriverWait(driver, 120);
	 
	 @Given("^user clicks on Order button$")
	 public void user_clicks_on_Order_button() throws Throwable {
	     order.order_button.click();
	     Thread.sleep(3000);
	 }

	 @When("^user enters the address$")
	 public void user_enters_the_address(DataTable table) throws Throwable {
		 List<List<String>> data = table.raw();
		  System.out.println(data.get(0).get(1));
		  order.address_box.sendKeys(data.get(0).get(1));
		  wait.until(ExpectedConditions.visibilityOf(order.pickup)); 
			 wait.until(ExpectedConditions.elementToBeClickable(order.pickup));
		  Thread.sleep(10000);
		 // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		 /* order.address_suggestion.click();
		 
		 		  Thread.sleep(3000);*/

	 }

	 @When("^user clicks on Delivery button$")
	 public void user_clicks_on_Delivery_button() throws Throwable {
	     order.delivery_button.click();
	 }

	 @When("^user select Date and Time from Calendar$")
	 public void user_select_Date_and_Time_from_Calendar() throws Throwable {
		 
	
		 //wait.until(ExpectedConditions.elementToBeSelected(order.time));
		 
	
		 
		 Thread.sleep(5000);
		 WebElement e= driver.findElement(By.cssSelector("div.main-content.push-wrap:nth-child(4) section.container.mt-2.find-store:nth-child(2) section.row.my-2:nth-child(2) div.col-sm div.row div.col-lg-12:nth-child(1) div.row:nth-child(2) div.col-12 div.row.mx-auto.my-auto:nth-child(3) div.carousel.w-100.carousel-fade div.carousel-inner.w-100 div.carousel-item.item.row.active:nth-child(1) div.col-md-6.col-lg-4.mt-xs-2.mt-md-0.location-div.active:nth-child(1) div.location.card.border.active div.card-footer.datepicker form:nth-child(2) div.form-group:nth-child(2) div.input-group:nth-child(2) > select.delivery-timepicker-dropdown.custom-select"));
	     Select time_dropdown= new Select(e);
	    // WebElement e= driver.findElement();
	     time_dropdown.selectByVisibleText("11:45 AM");
	     Thread.sleep(2000);
	 }

	 @When("^user clicks on Continue$")
	 public void user_clicks_on_Continue() throws Throwable {
	  
		 
		 wait.until(ExpectedConditions.visibilityOf(order.Continue));
		 Thread.sleep(5000);
		 Actions action= new Actions(driver);
		 action.doubleClick(order.Continue).build().perform();
		// order.Continue.click();
		 Thread.sleep(5000);
	 }

	 @When("^On Menu Page click on a Six Pack$")
	 public void on_Menu_Page_click_on_a_Six_Pack() throws Throwable {
	     
		 wait.until(ExpectedConditions.elementToBeClickable(order.sixpack));
		 order.sixpack.click();
		 Thread.sleep(3000);
		
	 }

	 @When("^user clicks on add product$")
	 public void user_clicks_on_add_product() throws Throwable {
		 wait.until(ExpectedConditions.elementToBeClickable(order.pick_for_me));
		 order.pick_for_me.click();
		 Thread.sleep(5000);
	 }

	 @When("^user goes to the cart$")
	 public void user_goes_to_the_cart() throws Throwable {
		 wait.until(ExpectedConditions.elementToBeClickable(order.cart_button));
	    order.cart_button.click();
	    Thread.sleep(2000);
	 }

	 @When("^user clicks on the checkout button$")
	 public void user_clicks_on_the_checkout_button() throws Throwable {
		 wait.until(ExpectedConditions.elementToBeClickable( order.checkout_button));
	    order.checkout_button.click();
	    Thread.sleep(3000);
	 }

	 @When("^user enters Valid Details under Delivery Info & your Info$")
	 public void user_enters_Valid_Details_under_Delivery_Info_your_Info(DataTable table) throws Throwable {

		 List<List<String>> data = table.raw();
		  System.out.println(data.get(0).get(1));
		  wait.until(ExpectedConditions.elementToBeClickable( order.recipient_name));
		  order.recipient_name.sendKeys(data.get(0).get(1));
		  wait.until(ExpectedConditions.elementToBeClickable( order.recipient_phone));
		  order.recipient_phone.sendKeys(data.get(1).get(1));
		  wait.until(ExpectedConditions.elementToBeClickable( order.customer_name));
		  order.customer_name.sendKeys(data.get(2).get(1));
		  wait.until(ExpectedConditions.elementToBeClickable( order.customer_phone));
		  order.customer_phone.sendKeys(data.get(3).get(1));
		  wait.until(ExpectedConditions.elementToBeClickable( order.customer_email));
		  order.customer_email.sendKeys(data.get(4).get(1));
		  
	     
	 }

	 @When("^user enter delivery message$")
	 public void user_enter_delivery_message(DataTable table) throws Throwable {
		 
		 List<List<String>> data = table.raw();
		 
	     order.instructions.sendKeys(data.get(0).get(1));
	 }

	 @When("^user selects Payment Method as Credit Card$")
	 public void user_selects_Payment_Method_as_Credit_Card() throws Throwable {
		 wait.until(ExpectedConditions.elementToBeClickable( order.credit_card));
	     order.credit_card.click();
	 }

	 @When("^user enters credit card details$")
	 public void user_enters_credit_card_details(DataTable table) throws Throwable {
		 List<List<String>> data = table.raw();
		 wait.until(ExpectedConditions.elementToBeClickable( order.cc_num));
		 order.cc_num.sendKeys(data.get(0).get(1));
		 wait.until(ExpectedConditions.elementToBeClickable( order.cc_exp));
		 order.cc_exp.sendKeys(data.get(1).get(1));
	 }

	 @When("^user clicks on Place Order$")
	 public void user_clicks_on_Place_Order() throws Throwable {
	    order.place_order.click();
	    
	   
	   driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
	 }

	 @Then("^Order confirmation page should appear displaying Order summary$")
	 public void order_confirmation_page_should_appear_displaying_Order_summary() throws Throwable {
	     
		 
		 assertEquals("THANKS!", order.thanks.getText());
	    
	     assertThat(order.tracking_no.getText(), CoreMatchers.containsString("#"));
	     
	     assertThat(order.store_name.getText(), CoreMatchers.containsString("Insomnia Cookies -"));
	     
	    // assertThat(order.product_ordered.getText(), CoreMatchers.containsString("The Sixpack"));
	     
	     //assertThat(order.tracking_no.getText()).startsWith("#");
	 }

@And("^On Menu Page click on The Insomniac$")
public void on_Menu_Page_click_on_the_Insomniac() throws Throwable {
	
	wait.until(ExpectedConditions.elementToBeClickable( order.the_insomniac));
	order.the_insomniac.click();
	
}

@And("^user selects Payment Method as cash$")
public void payment_through_cash() throws Throwable{
	try{
		wait.until(ExpectedConditions.elementToBeClickable( order.cash));	
	order.cash.click();
	Thread.sleep(3000);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
 @And("^user selects Payment Method as School cash$")
 public void school_cash() throws Throwable{
	 wait.until(ExpectedConditions.elementToBeClickable( order.school_cash));
	order.school_cash.click();
	
}
 @And("^user enters school cash number$")
 public void school_cash_details(DataTable table) throws Throwable{
	 
	 List<List<String>> data = table.raw();
	 wait.until(ExpectedConditions.elementToBeClickable( order.school_cash_details));
	 order.school_cash_details.sendKeys(data.get(0).get(1));
	 
 }
 
 @And("^user clicks on Pickup button$")
 public void pickup()throws Throwable{
	/* WebDriverWait wait = new WebDriverWait(driver, 60);
	 wait.until(ExpectedConditions.visibilityOf(order.pickup)); */
	 wait.until(ExpectedConditions.elementToBeClickable(order.pickup));
	 order.pickup.click();
	 
 }
 
 @And("^user enters into your Info$")
 public void pickup_button(DataTable table) throws Throwable {
	 List<List<String>> data = table.raw();
	 wait.until(ExpectedConditions.elementToBeClickable(order.customer_name));
	 order.customer_name.sendKeys(data.get(0).get(1));
	 wait.until(ExpectedConditions.elementToBeClickable(order.customer_phone));
	  order.customer_phone.sendKeys(data.get(1).get(1));
	  wait.until(ExpectedConditions.elementToBeClickable(order.customer_email));
	  order.customer_email.sendKeys(data.get(2).get(1));
	 
 }
 
 @And("^On Menu Page click on The Major Rager$")
 public void major_rager() throws Throwable{
	 wait.until(ExpectedConditions.elementToBeClickable(order.major_rager));
	 order.major_rager.click();
	
 }
 
 @And("^user selects Payment Method as Gift card$")
 public void gift_card() throws Throwable{
	 wait.until(ExpectedConditions.elementToBeClickable(order.gift_card));
	 order.gift_card.click();
	 
 }
 
 @And("^user enters Gift card number$")
 public void gift_card_details(DataTable table) throws Throwable{
	 
List<List<String>> data = table.raw();
wait.until(ExpectedConditions.elementToBeClickable(order.gift_card_no));
	 order.gift_card_no.sendKeys(data.get(0).get(1));
	 
 }
}


