package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cookies.abstractdriver;


public class Order extends abstractdriver {

	@FindBy(xpath = "//a[@id='order-button']")
	public WebElement order_button;
	
	@FindBy(xpath = "//input[@id='addresstext']")
	public WebElement address_box;
	
	@FindBy(xpath = "//div[@class='btn-store-override btn-store-delivery']")
	public WebElement delivery_button;
	
	@FindBy(css = "div.main-content.push-wrap:nth-child(4) section.container.mt-2.find-store:nth-child(2) section.row.my-2:nth-child(2) div.col-sm div.row div.col-lg-12:nth-child(1) div.row:nth-child(2) div.col-12 div.row.mx-auto.my-auto:nth-child(3) div.carousel.w-100.carousel-fade div.carousel-inner.w-100 div.carousel-item.item.row.active:nth-child(1) div.col-md-6.col-lg-4.mt-xs-2.mt-md-0.location-div.active:nth-child(1) div.location.card.border.active div.card-footer.datepicker form:nth-child(2) div.form-group:nth-child(2) div.input-group:nth-child(2) > select.delivery-timepicker-dropdown.custom-select")
	public WebElement time;
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public WebElement Continue;
	
	@FindBy(xpath = "//div[@id='deals']//div[@class='row']//div[2]//div[1]//div[1]//img[1]")
	public WebElement sixpack;
	
	@FindBy(xpath = "//button[contains(text(),'Pick For Me')]")
	public WebElement pick_for_me;
	
	@FindBy(xpath = "//button[@class='cart-button btn btn-primary']")
	public WebElement cart_button;
	
	@FindBy(xpath = "//button[contains(text(),'Checkout')]")
	public WebElement checkout_button;
	
	@FindBy(xpath = "//input[@id='recipient-name']")
	public WebElement recipient_name;
	
	@FindBy(xpath = "//input[@id='recipient-phone']")
	public WebElement recipient_phone;
	
	@FindBy(xpath = "//textarea[@id='instructions']")
	public WebElement instructions;
	
	@FindBy(xpath = "//input[@id='customer-name']")
	public WebElement customer_name;
	
	@FindBy(xpath = "//input[@id='customer-phone']")
	public WebElement customer_phone;
	
	@FindBy(xpath = "//input[@id='customer-email']")
	public WebElement customer_email;
	
	@FindBy(xpath = "//a[@id='pills-credit-tab']")
	public WebElement credit_card;
	
	
	@FindBy(xpath = "//input[@id='cc-number']")
	public WebElement cc_num;
	
	@FindBy(xpath = "//input[@id='cc-exp']")
	public WebElement cc_exp;
	
	@FindBy(xpath = "//button[@id='submit-order-btn']")
	public WebElement place_order;
	
	@FindBy(xpath = "//h1[contains(text(),'THANKS!')]")
	public WebElement thanks;
	
	@FindBy(xpath = "//a[contains(text(),'#')]")
	public WebElement tracking_no;

	@FindBy(xpath = "//h4[contains(text(),'Insomnia Cookies - ')]")
	public WebElement store_name;
	
	@FindBy(xpath = "//b[@class='text-primary']")
	public WebElement product_ordered;
	
	@FindBy(xpath = "//a[@class='btn btn-primary btn-block my-2']")
	public WebElement track_order;
	
	@FindBy(xpath = "//h4[contains(text(),'Baking...')]")
	public WebElement tracker_delivery;
	
	@FindBy(xpath = "/html/body/div[2]/nav/form/div/span/div/div/div[1]")
	public WebElement address_suggestion;
	
	@FindBy(xpath = "//div[@id='deals']//div[@class='row']//div[5]//div[1]//div[1]//img[1]")
	public WebElement the_insomniac;
	
	@FindBy(xpath = "//a[@id='pills-cash-tab']")
	public WebElement cash;
	
	@FindBy(xpath = "//a[@id='pills-schoolcash-tab']")
	public WebElement school_cash;
	
	@FindBy(xpath = "//input[@id='school-cash']")
	public WebElement school_cash_details;
	
	@FindBy(xpath = "//*[@id='deals']/div/div/div/div[4]/div/div[1]/img")
	public WebElement major_rager;
	
	@FindBy(xpath = "//a[@id='pills-giftcard-tab']")
	public WebElement gift_card;
	
	@FindBy(xpath = "//input[@id='giftcard-number']")
	public WebElement gift_card_no;

    @FindBy(xpath = "//div[@class='col-6 mt-0 mt-sm-1']//div[@class='btn-store-override btn-store-pickup']")
    public WebElement pickup;
    
    @FindBy(xpath = "//span[contains(text(),'Ready for pickup')]")
    public WebElement pickup_verify;
	
	/*@FindAllBy(className="form-control search-input tt-input")
	public List<WebElement> autocomplete_Address;*/
	
	
WebDriver driver = getDriver();
	
	public Order(WebDriver driver) {
		//super(driver);
		PageFactory.initElements(driver, this);

	}
}
