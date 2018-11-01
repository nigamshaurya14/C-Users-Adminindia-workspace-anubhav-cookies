package cookies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import helper.ConfigFileReader;

public class abstractdriver {
	public static WebDriver driver;
	ConfigFileReader configFileReader= new ConfigFileReader();
	/*
	 * public abstractdriver(WebDriver driver){ abstractdriver.driver = driver;
	 */
	public WebDriver getDriver() {

		if (driver == null) {
			System.setProperty("webdriver.gecko.driver", configFileReader.getDriverPath());
			//String driverPath = "C:\\Users\\Adminindia\\Downloads\\geckodriver-v0.19.0-win64";
			System.out.println("launching firefox browser");
			//System.setProperty("webdriver.gecko.driver", driverPath + "\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
		}

		return driver;
	}
}
