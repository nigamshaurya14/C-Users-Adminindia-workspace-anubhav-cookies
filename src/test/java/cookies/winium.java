package cookies;

import java.awt.AWTException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class winium {
	public static void main(String[] args) throws AWTException, Exception {
		// TODO Auto-generated method stub

		DesktopOptions options=new DesktopOptions();
		options.setApplicationPath("C:\\Windows\\notepad.exe");
		
		WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),options);
		//Runtime.getRuntime().exec("Autoit\\Notepad.exe");
		Thread.sleep(1000);
		WebElement edit= driver.findElementByClassName("Edit");
		Thread.sleep(3000);
		edit.sendKeys("This is a demo for Winium with AutoIT");
		
		Thread.sleep(1000);
		driver.quit();
		
		
		Runtime.getRuntime().exec("Autoit\\Notepad_close.exe");
		}
}
