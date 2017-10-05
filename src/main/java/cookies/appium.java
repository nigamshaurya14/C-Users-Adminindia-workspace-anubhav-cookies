package cookies;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class appium {



	@Test
	public void setUp() throws MalformedURLException, InterruptedException  {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("platformVersion", "6.0");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.android.settings");		
		capabilities.setCapability("appActivity", "com.android.settings.Settings"); 
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Thread.sleep(10000);
		System.out.println("Line # 31");
		driver.findElementByAndroidUIAutomator("UiSelector().text(\"Display\")").click();
		
		
		
		System.out.println("Line # 36");
	
	}

	/*@Test
	public void testCal() throws Exception {
		WebElement two = driver.findElementByAndroidUIAutomator("UiSelector().text(\"Display\")").click();
		two.click();
		System.out.println("test executed");

	}
*/
}
