package cookies;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.support.ManagedArray;

import io.appium.java_client.TouchAction;

import io.appium.java_client.android.AndroidDriver;

public class sauce_appium {

	public static final String USERNAME = "snigam";
	public static final String ACCESS_KEY = "3fa87941-4469-4c8e-a4a4-5a82f3b026b2";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	public static void main(String[] args) throws Exception {

		DesiredCapabilities capabilities = DesiredCapabilities.android();

		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("appiumVersion", "1.6.5");

		capabilities.setCapability("deviceName", "Samsung Galaxy S7 Edge FHD GoogleAPI Emulator");
		capabilities.setCapability("deviceOrientation", "portrait");
		capabilities.setCapability("browserName", "chrome");

		capabilities.setCapability("platformVersion", "7.1");
		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("app", "");

		capabilities.setCapability("appPackage", "com.android.settings");
		capabilities.setCapability("appActivity", "com.android.settings.Settings");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL(URL), capabilities);

		System.out.println("Line # 31");

		driver.findElementByAndroidUIAutomator("UiSelector().text(\"More\")").click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"OFF\")").click();

		if (driver.findElementByAndroidUIAutomator("new UiSelector().text(\"ON\")").isDisplayed()) {
			System.out.println("TestCase Passed!");
		} else {
			System.out.println("TestCase Failed!");

		}
		driver.quit();
	}
}
