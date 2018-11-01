package cookies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;



public class Sikuli {

	
		
	@Test
		public void method() throws Exception{
			Screen screen=new Screen();
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Adminindia\\Downloads\\geckodriver-v0.19.0-win64\\geckodriver.exe");
			WebDriver driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://fineuploader.com/demos");
			
			System.out.println("launching firefox browser");
			//driver.findElement(By.xpath("id('fine-uploader-gallery')/div[1]/div[3]")).click();
			driver.findElement(By.xpath("//*[@id=\"fine-uploader-manual-trigger\"]/div/div[3]/div")).click();
			Thread.sleep(3000);
			Runtime.getRuntime().exec("Autoit\\upload.exe");
			Pattern img1= new Pattern("Images\\shaurya.jpg");
			Thread.sleep(1000);
			screen.wait(img1, 5);
			screen.click(img1, 5);
			System.out.println("Test Passed");
		}
	}


