package pageobjects;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.http.HttpClient;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cookies.abstractdriver;

public class signin extends abstractdriver {

	@FindBy(xpath="//a[contains(text(),'log In')]")
	public WebElement login_button;
	
	@FindBy(xpath="//input[@id='email']")
    public WebElement username;
	
	@FindBy(xpath="//form[@id='login-form']//input[@placeholder='Password']")
    public WebElement password;
	
	@FindBy(xpath = "//div[contains(text(),'Please enter an email address.')]")
	public WebElement alert_email;
	
	@FindBy(xpath="//div[contains(text(),'The password field is required.')]")
	public WebElement alert_password;
	
	@FindBy(xpath="//button[@id='login-btn']")
    public WebElement submit_login;
	
	@FindBy(xpath="//a[contains(text(),'Hi, Shaurya')]")
	public WebElement login_text;
	
	@FindBy(xpath="//*[@id='sign-in-email']")
	public WebElement username_hover;
	
	@FindBy(xpath="//*[@id='sign-in-password']")
	public WebElement password_hover;
	
	@FindBy(xpath="//button[@id='sign-in-form-submit']")
	public WebElement submit_hover;
	
	@FindBy(xpath="//a[contains(text(),'Log Out')]")
	public WebElement logout;
	
	private int invalidImageCount;
	
WebDriver driver = getDriver();
	
	public signin(WebDriver driver) {
		//super(driver);
		PageFactory.initElements(driver, this);

	}
	
	public void validateInvalidImages(WebDriver driver) throws InterruptedException {
		try {
			invalidImageCount = 0;
			List<WebElement> imagesList = driver.findElements(By.tagName("img"));
			System.out.println("Total no. of images are " + imagesList.size());
			for (WebElement imgElement : imagesList) {
				if (imgElement != null) {
					verifyimageActive(imgElement);
				}
			}
			System.out.println("Total no. of invalid images are "	+ invalidImageCount);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public void verifyimageActive(WebElement imgElement) {
		try {
			org.apache.http.client.HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			if (response.getStatusLine().getStatusCode() != 200)
				invalidImageCount++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
