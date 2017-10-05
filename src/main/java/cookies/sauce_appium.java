package cookies;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;

public class sauce_appium {

	public static final String USERNAME = "nigamshaurya14";
	  public static final String ACCESS_KEY = "95faa0d3-0e8a-4493-b4f0-a6b3948d9e80";
	  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	  
	 
			//String driverPath = "C:\\Users\\Adminindia\\Downloads\\geckodriver-v0.19.0-win64";  //for firefox driver
			//public WebDriver driver;
			
			
				
				  public static void main(String[] args) throws Exception {
				 
				    /*DesiredCapabilities capabilities = new DesiredCapabilities();
				    capabilities.setCapability("platformName", "Android");
				    capabilities.setCapability("deviceName", "Samsung Galaxy S4 Emulator");
				    capabilities.setCapability("platformVersion", "4.4");
				    */
				    DesiredCapabilities capabilities = DesiredCapabilities.android();
				    /*caps.setCapability("appiumVersion", "1.4.16");
				    caps.setCapability("deviceName","Android Emulator");
				    caps.setCapability("deviceType","phone");
				    caps.setCapability("deviceOrientation", "portrait");
				    caps.setCapability("browserName", "");
				    caps.setCapability("platformVersion","5.1");
				    caps.setCapability("platformName","Android");
				    caps.setCapability("app", "sauce-storage:abof.apk");*/
				    /*capabilities.setCapability("browserName", "");
				    capabilities.setCapability("deviceOrientation", "portrait");
				    capabilities.setCapability("appiumVersion", "1.5.3");*/
				    capabilities.setCapability("appiumVersion", "1.6.5");
				    capabilities.setCapability("deviceName","Google Nexus 7 HD GoogleAPI Emulator");
				    capabilities.setCapability("deviceOrientation", "portrait");
				    capabilities.setCapability("browserName", "chrome");
				    capabilities.setCapability("platformVersion","4.4");
				    capabilities.setCapability("platformName","Android");//capabilities.setCapability("automationName", "uiautomator2");
				    
				    capabilities.setCapability("app", "");
				    /*capabilities.setCapability("platformName", "Android");
					capabilities.setCapability("platformVersion", "4.4");
					capabilities.setCapability("deviceName", "Google Nexus 7 HD GoogleAPI Emulator");
					
					capabilities.setCapability("browserName", "chrome");*/
					capabilities.setCapability("appPackage", "com.android.settings");		
					capabilities.setCapability("appActivity", "com.android.settings.Settings"); 
					//capabilities.setCapability("appiumVersion", "1.5.3");
					
					/*capabilities.setCapability("platformName", "Android");
				    capabilities.setCapability("deviceName", "Samsung Galaxy S4 Emulator");
				    capabilities.setCapability("platformVersion", "4.4");
				    capabilities.setCapability("app", "http://saucelabs.com/example_files/ContactManager.apk");
				    capabilities.setCapability("browserName", "");
				    capabilities.setCapability("deviceOrientation", "portrait");
				    capabilities.setCapability("appiumVersion", "1.5.3");*/
				    
					AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL(URL), capabilities);
					// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 
				    //WebDriver driver = new RemoteWebDriver(new URL(URL), capabilities);
					System.out.println("Line # 31");
					driver.findElementByAndroidUIAutomator("UiSelector().text(\"Display\")").click();
					
				 
				    
				    System.out.println("Android app launched successfully");
				    /**
				     * Test Actions here...
				     */
				 
				    driver.quit();// driver.quit();
			  }
}
