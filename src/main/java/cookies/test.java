package cookies;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class test {
	
	public static final String USERNAME = "nigamshaurya14";
	  public static final String ACCESS_KEY = "95faa0d3-0e8a-4493-b4f0-a6b3948d9e80";
	  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	  
	 
			String driverPath = "C:\\Users\\Adminindia\\Downloads\\geckodriver-v0.19.0-win64";
			//public WebDriver driver;
			
			
			public static void main(String[] args) throws Exception {
				 
			    DesiredCapabilities caps = DesiredCapabilities.chrome();
			    caps.setCapability("platform", "Windows 10");
			    caps.setCapability("version", "61.0");
			 
			    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
			 
			    /**
			     * Goes to Sauce Lab's guinea-pig page and prints title
			     */
			 
			    driver.get("https://google.com");
			    System.out.println("title of page is: " + driver.getTitle());
			 
			    driver.quit();
			  }
}
	



