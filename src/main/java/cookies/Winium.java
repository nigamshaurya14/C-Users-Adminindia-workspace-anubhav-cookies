package cookies;

import static org.testng.AssertJUnit.assertEquals;

import java.awt.AWTException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class Winium {

	public static void main(String[] args) throws AWTException, Exception {

		DesktopOptions options = new DesktopOptions();
		options.setApplicationPath("C:\\Windows\\notepad.exe");

		WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), options);

		Thread.sleep(1000);
		WebElement edit = driver.findElementByClassName("Edit");
		edit.sendKeys("Hello World");
		
		assertEquals("Hello World",edit.getText());
		

	}

	
}
