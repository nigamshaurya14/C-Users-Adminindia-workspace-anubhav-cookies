package cookies;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class totalLinksBackEnd {
    private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
        
        String homePage = "https://9.stage.insomniacookies.com/admin";
        //String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        String expectedTitle="Whoops! There was an error.";
        String filePath="C:\\Users\\Adminindia\\workspace\\anubhav\\cookies\\src\\main\\backend_links_validation_output.xlsx";
       // String fileWithPath="C:\\Users\\Adminindia\\workspace\\anubhav\\cookies\\src\\screenshots\\test.png";
        String driverPath = "C:\\Users\\Adminindia\\Downloads\\geckodriver-v0.19.0-win64";
		System.out.println("launching firefox browser"); 
		System.setProperty("webdriver.gecko.driver", driverPath+"\\geckodriver.exe");
		driver = new FirefoxDriver();
       
        driver.manage().window().maximize();
        
        driver.get(homePage);
        driver. findElement(By.id("username")).sendKeys("Snigam");
        driver.findElement(By.id("password")).sendKeys("Password");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/fieldset/button")).click();
        Thread.sleep(5000);
       broken_link_guru objExcelFile = new broken_link_guru();
       // String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";
        //objExcelFile.readExcel(filePath,"backend_links_validation_output.xlsx","valid_links");
       
       //objExcelFile.cleanSheet(valid_links);
       List<String> url=new ArrayList<String>();
       
        List<WebElement> links  =  driver.findElements(By.xpath("//a[contains(@href,'admin') and (not(contains(@href,'logout')))]"));
        Thread.sleep(30000);
        // //i[not(contains(@class,'fa fa-sign-out'))]/ ..
        //links.addAll(driver.findElements(By.tagName("img")));
       // Set<WebElement> linksSet = new HashSet<WebElement>(links);
       // links.clear();
       // links.addAll(linksSet);
       // Thread.sleep(5000);
        //links=links.stream().distinct().collect(Collectors.toList());
        //Collections.reverse((List<?>) linksSet);
        int i= links.size();
        System.out.println(i);
        
        
       // Iterator<WebElement> it = links.iterator();
        
       //while(it.hasNext())
        for(WebElement link:links)
        {
        	url.add(link.getAttribute("href"));
        }
        
        for(String ur:url)
        {
        	
        	
        		driver.get(ur);
        		//url = it.next().getAttribute("href");
        		System.out.println(ur);
        	
        	
        		//continue;
        		}
        }
}
        

	


