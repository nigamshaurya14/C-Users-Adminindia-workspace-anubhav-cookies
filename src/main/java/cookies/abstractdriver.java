package cookies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.Before;

public class abstractdriver {
	public static WebDriver driver;
	
	public WebDriver getDriver() {
		
		if(driver == null){
			String driverPath = "C:\\Users\\Adminindia\\Downloads\\geckodriver-v0.19.0-win64";
			System.out.println("launching firefox browser"); 
			System.setProperty("webdriver.gecko.driver", driverPath+"\\geckodriver.exe");
			driver = new FirefoxDriver();
	}
	
	return driver;
	}	
}
