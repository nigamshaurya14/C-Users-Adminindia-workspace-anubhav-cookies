package cookies;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//import com.google.common.collect.Table.Cell;
public class broken_link_guru {
	

	
	    
	    private static WebDriver driver = null;

	    public static void main(String[] args) throws Throwable {
	       
	        
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
	        driver. findElement(By.id("username")).sendKeys("Snigam_IT Manager");
	        driver.findElement(By.id("password")).sendKeys("password");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/fieldset/button")).click();
	        Thread.sleep(5000);
	       broken_link_guru objExcelFile = new broken_link_guru();
	       // String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";
	        //objExcelFile.readExcel(filePath,"backend_links_validation_output.xlsx","valid_links");
	       
	       //objExcelFile.cleanSheet(valid_links);
	       List<String> url=new ArrayList<String>();
	        List<WebElement> links = driver.findElements(By.xpath("//a[contains(@href,'admin') and (not(contains(@href,'logout')))]"));
	        links.addAll(driver.findElements(By.tagName("img")));
	        int i= links.size();
	        System.out.println("Total Links found : "+i);
	        
	        
	     
	    
	       
	        
	        for(WebElement link:links)
	        {
	        	url.add(link.getAttribute("href"));
	        	
	        }
	        
	     
	        for(String ur:url)
	        {
	        	
	        	
	        		
	        	
	        	
	            
	        
	             if(ur == null || ur.isEmpty()){
	System.out.println("URL is either not configured for anchor tag or it is empty");
	Thread.sleep(3000);
	objExcelFile.writeExcel(filePath,"skipped_links",ur);
	                continue;
	            }
	            
	             if(!ur.startsWith(homePage)){
	            	
	                System.out.println("URL belongs to another domain, skipping it.");
	            	Thread.sleep(3000);

	                objExcelFile.writeExcel(filePath,"skipped_links",ur);
	                continue;
	            }
	            
	            try {
	                huc = (HttpURLConnection)(new URL(ur).openConnection());
	                
	                huc.setRequestMethod("HEAD");
	                
	                huc.connect();
	                
	                respCode = huc.getResponseCode();
	                
	                if(respCode != 200){
	                	
	                    System.out.println(ur+" is a broken link");
	                    objExcelFile.writeExcel(filePath,"broken_links",ur);
	                    

	                }
	                /*else{
	                	 String Actualtitle = driver.getTitle();
	                	 
	                	 
	      	           if (Actualtitle.contentEquals(expectedTitle)){
	      	               System.out.println(ur+ " is a broken link");
	      	             objExcelFile.writeExcel(filePath,"broken_links",ur);
	      	           }*/ else {
	      	        	
	      	        		
	      	        			
	      	        		 
	      	        		
	      	        		try{
	      	        			
	      	        		driver.get(ur);
	      	        		System.out.println(ur);
	      	        		Thread.sleep(5000);
	      	        			
	      	        			
	      	        			//Boolean b=driver.findElement(By.xpath("//h4[text()=' Error 404! Page not found.']")).isDisplayed();
	      	        			//Boolean c=driver.findElement(By.xpath("//strong[text()='Oops something went wrong!']")).isDisplayed();
	                    		//System.out.println(b);
	                            if(driver.findElement(By.xpath("//h4[text()=' Error 404! Page not found.']")).isDisplayed()){
	                            	System.out.println(ur+ " is broken link with 404 error");
	                                objExcelFile.writeExcel(filePath,"broken_links",ur);
	                              
	                          	 }
	      	        		 
	      	        		
	      	        		  if(driver.findElement(By.xpath("//strong[text()='Oops something went wrong!']")).isDisplayed())
	      	        	   {
	      	        	 System.out.println(ur+ " is a 500 error  broken link");
	      	             objExcelFile.writeExcel(filePath,"broken_links",ur);
	      	        	 }
	      	        	   else{
	      	        		 String Actualtitle;
	     					
	 						Actualtitle = driver.getTitle();
	 					
	                 	 System.out.println(Actualtitle);
	      	        		 if (Actualtitle.contentEquals(expectedTitle)){
	      	               System.out.println(url+ " is a broken link");
	        	             objExcelFile.writeExcel(filePath,"broken_links",ur);
	        	           } else {
	        	               System.out.println(url+ " is a valid link");
	        	               System.out.println(respCode);
	        	              
	        	             objExcelFile.writeExcel(filePath,"valid_links",ur);
	        	           }  
	      	        		// System.out.println(ur+ " is a valid link");
		      	        		
		      	             //objExcelFile.writeExcel(filePath,"valid_links",ur);
	      	        	   }
	      	        	  } catch (Exception e) {
	      	        		System.out.println(ur+ " is a valid link");
	      	        		//continue;
		      	            objExcelFile.writeExcel(filePath,"valid_links",ur);
	      	        	  }
	      	        		
	      	        	 
	      	        	   
	      	              /* System.out.println(url+ " is a valid link");
	      	             objExcelFile.writeExcel(filePath,"valid_links",url);*/
	      	           }
	                    //System.out.println(url+" is a valid link");
	                }
	                    
	             catch (MalformedURLException e) {
	                
	                e.printStackTrace();
	            } catch (IOException e) {
	                
	                e.printStackTrace();
	            }
	        }
	        
	        //String fileSuffix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	        
	       

	    }
	        
	    
	    public  void writeExcel(String filePath, String sheetName, String ur) throws IOException{

          

            File file =    new File(filePath);

         

            FileInputStream inputStream = new FileInputStream(file);

            Workbook workbook = null;

          
      

            workbook = new XSSFWorkbook(inputStream);


        

            Sheet sheet = workbook.getSheet(sheetName);

          

            int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

          

            Row row = sheet.getRow(0);

           

            Row newRow = sheet.createRow(rowCount+1);

           

            for(int j = 0; j < row.getLastCellNum(); j++){

               

                Cell cell = (Cell) newRow.createCell(j);
              
               ((org.apache.poi.ss.usermodel.Cell)cell).setCellValue(ur);

            }

          

            inputStream.close();

            

            FileOutputStream outputStream = new FileOutputStream(file);

           

            workbook.write(outputStream);

          
            outputStream.close();
          //  workbook.close();
            

            }  
	    
	    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

	        

	        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	      

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	           

	                File DestFile=new File(fileWithPath);

	              

	                FileUtils.copyFile(SrcFile, DestFile);

	            

	    }
	   
}
