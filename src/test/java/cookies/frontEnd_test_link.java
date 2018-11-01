package cookies;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class frontEnd_test_link {
	 private static WebDriver driver = null;
	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub String homePage = "https://20.stage.insomniacookies.com/admin";
		 String homePage = "https://15.stage.insomniacookies.com";
	       
        String url = "https://15.stage.insomniacookies.com/asd";
        HttpURLConnection huc = null;
       // int respCode =200 ;
        String expectedTitle="Whoops! There was an error.";
        String filePath="C:\\Users\\Adminindia\\workspace\\anubhav\\redesignedcookies\\src\\main\\backend_links_validation_output.xlsx";
       // String fileWithPath="C:\\Users\\Adminindia\\workspace\\anubhav\\cookies\\src\\screenshots\\test.png";
        String driverPath = "C:\\Users\\Adminindia\\Downloads\\geckodriver-v0.19.0-win64";
		System.out.println("launching firefox browser"); 
		System.setProperty("webdriver.gecko.driver", driverPath+"\\geckodriver.exe");
		driver = new FirefoxDriver();
       
        driver.manage().window().maximize();
        
        driver.get(url);
       /* driver. findElement(By.id("username")).sendKeys("Snigam_IT Manager");
        driver.findElement(By.id("password")).sendKeys("Password");*/
       /* Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/fieldset/button")).click();*/
        Thread.sleep(5000);
       broken_link_guru objExcelFile = new broken_link_guru();
       // String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";
        //objExcelFile.readExcel(filePath,"backend_links_validation_output.xlsx","valid_links");
       
       //objExcelFile.cleanSheet(valid_links);
       
           //url = ((WebElement) driver).getAttribute("href");
            
            System.out.println(url);
            
          
        
            if(url == null || url.isEmpty()){
System.out.println("URL is either not configured for anchor tag or it is empty");
objExcelFile.writeExcel(filePath,"skipped_links",url);
               // continue;
            }
            
            else   if(!url.startsWith(homePage)){
            	
                System.out.println("URL belongs to another domain, skipping it.");
                objExcelFile.writeExcel(filePath,"skipped_links",url);
               // continue;
            }
            else{
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                
                huc.setRequestMethod("HEAD");
                
                huc.connect();
                
                int respCode = huc.getResponseCode();
                
                if(respCode != 200){
                    System.out.println(url+" is a broken link");
                    String Actualtitle = driver.getTitle();
                    System.out.println("url : " +Actualtitle);
                    System.out.println("server response code : "+respCode);
    	              
                    //Write the file using file name, sheet name and the data to be filled

                    objExcelFile.writeExcel(filePath,"broken_links",url);
                    //broken_link_guru.takeSnapShot(driver, fileWithPath);

                }
                else{
                	
                	
                	
                	try{
                		driver.navigate().to(url); 
                		System.out.println("server response code : "+respCode);
                		//WebElement we=driver.findElement(By.xpath("//strong[text()='Oops something went wrong!']"));
                		//JavascriptExecutor js = (JavascriptExecutor) driver;
                		//js.executeScript("arguments[0].click()", we);
                		Thread.sleep(3000);
  	        			//Boolean b=;

                		//Boolean c=;
                		//System.out.println(b);
                  if(driver.findElement(By.xpath("//h4[text()=' Error 404! Page not found.']")).isDisplayed()){
                	 System.out.println(url+ " is a broken link");
                	 }
                  else if(driver.findElement(By.xpath("//strong[text()='Oops something went wrong!']")).isDisplayed())
 	        	   {
 	        	 System.out.println(url+ " is a 500 error  broken link");
 	             objExcelFile.writeExcel(filePath,"broken_links",url);
 	        	 }
                	
                	else{
                	 String Actualtitle;
					
						Actualtitle = driver.getTitle();
					
                	 System.out.println(Actualtitle);
      	           if (Actualtitle.contentEquals(expectedTitle)){
      	               System.out.println(url+ " is a broken link");
      	             objExcelFile.writeExcel(filePath,"broken_links",url);
      	           } else {
      	               System.out.println(url+ " is a valid link");
      	               System.out.println(respCode);
      	              
      	             objExcelFile.writeExcel(filePath,"valid_links",url);
      	           }
                	}  //System.out.println(url+" is a valid link");
                }catch(Exception e){
            		e.printStackTrace();
            		System.out.println("Element Not Found");
            	       
            	}
                	}
                    
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }/* catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }*/
        }
        
        //String fileSuffix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        
     

    }
    
    
    public  void writeExcel(String filePath, String sheetName,String url) throws IOException{

        //Create an object of File class to open xlsx file

        File file =    new File(filePath);

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);

        Workbook guru99Workbook = null;

      
       //If it is xlsx file then create object of XSSFWorkbook class

        guru99Workbook = new XSSFWorkbook(inputStream);


      //Read excel sheet by sheet name    

        Sheet sheet = guru99Workbook.getSheet(sheetName);

        //Get the current count of rows in excel file

        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

        //Get the first row from the sheet

        Row row = sheet.getRow(0);

        //Create a new row and append it at last of sheet

        Row newRow = sheet.createRow(rowCount+1);

        //Create a loop over the cell of newly created Row

        for(int j = 0; j < row.getLastCellNum(); j++){

            //Fill data in row

            Cell cell = (Cell) newRow.createCell(j);
          
           ((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(url);

        }

        //Close input stream

        inputStream.close();

        //Create an object of FileOutputStream class to create write data in excel file

        FileOutputStream outputStream = new FileOutputStream(file);

        //write data in the excel file

        guru99Workbook.write(outputStream);

        //close output stream

        outputStream.close();
      // guru99Workbook.close();
        

        }
    /*public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);

            

    }*/
   

}	


