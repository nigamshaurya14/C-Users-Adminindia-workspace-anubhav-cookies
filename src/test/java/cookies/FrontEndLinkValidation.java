package cookies;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrontEndLinkValidation {
	 
    private static WebDriver driver = null;

    public static void main(String[] args) throws Throwable {
       
        
        String homePage = "https://insomniacookies.com";
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        String expectedErrorTitle="Whoops! There was an error.";
        String filePath="C:\\Users\\Adminindia\\workspace\\anubhav\\redesigned cookies\\src\\main\\backend_links_validation_output.xlsx";
        String driverPath = "C:\\Users\\Adminindia\\Downloads\\geckodriver-v0.19.0-win64";
		System.out.println("launching firefox browser"); 
		System.setProperty("webdriver.gecko.driver", driverPath+"\\geckodriver.exe");
		driver = new FirefoxDriver();
       
        driver.manage().window().maximize();
        
        driver.get(homePage);
      
        Thread.sleep(2000);
       
       broken_link_guru objExcelFile = new broken_link_guru();
      
       
        List<WebElement> links = driver.findElements(By.tagName("a"));
        links.addAll(driver.findElements(By.tagName("img")));
        
        Iterator<WebElement> it = links.iterator();
        
        
        while(it.hasNext()){
        	
        		
        		
            url = it.next().getAttribute("href");
            
            System.out.println(url);

            
        
             if(url == null || url.isEmpty()){
System.out.println("URL is either not configured for anchor tag or it is empty");
Thread.sleep(3000);
objExcelFile.writeExcel(filePath,"skipped_links",url);
                continue;
            }
            
             if(!url.startsWith(homePage)){
            	
                System.out.println("URL belongs to another domain, skipping it.");
            	Thread.sleep(3000);

                objExcelFile.writeExcel(filePath,"skipped_links",url);
                continue;
            }
            
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                
                huc.setRequestMethod("HEAD");
                
                huc.connect();
                
                respCode = huc.getResponseCode();
                
                if(respCode != 200){
                    System.out.println(url+" is a broken link with "+respCode+" Error");
                    


                    objExcelFile.writeExcel(filePath,"broken_links",url);

                }
                else{
                
                	 String Actualtitle = driver.getTitle();
      	           if (Actualtitle.contentEquals(expectedErrorTitle)){
      	               System.out.println(url+ " is a broken link");
      	             objExcelFile.writeExcel(filePath,"broken_links",url);
      	          
      	           } 
      	           
      	          
                	
      	           else {
      	        	
      	        			
      	        	 System.out.println(url+ " is a valid link");
      	             objExcelFile.writeExcel(filePath,"valid_links",url);
      	             }
      	           }
                	}
            
      	         catch (IOException e) {
              
                e.printStackTrace();
            }
        }
        
        
      
        
        File inputFile=new File("C:\\Users\\Adminindia\\workspace\\anubhav\\redesigned cookies\\src\\main\\backend_links_validation_output.xlsx");
		FileInputStream fis=new FileInputStream(inputFile);
		XSSFWorkbook inputWorkbook=new XSSFWorkbook(fis);
		int inputSheetCount=inputWorkbook.getNumberOfSheets();
		System.out.println("Input sheetCount: "+inputSheetCount);
		
		// Locate path and file of output excel.
		 Date date = new Date() ;
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy____HH_mm_ss") ;
		    File outputFile = new File("C:\\Users\\Adminindia\\workspace\\anubhav\\redesigned cookies\\src\\main\\backend_links"+dateFormat.format(date) + ".xlsx") ;
		
		FileOutputStream fos=new FileOutputStream(outputFile);
		
		//Creating workbook for output excel file.
		XSSFWorkbook outputWorkbook=new XSSFWorkbook();
		
		//Creating sheets with the same name as appearing in input file.
		for(int i=0;i<inputSheetCount;i++) 
                { 
                  XSSFSheet inputSheet=inputWorkbook.getSheetAt(i); 
                  String inputSheetName=inputWorkbook.getSheetName(i); 
                  XSSFSheet outputSheet=outputWorkbook.createSheet(inputSheetName); 

                 // Create and call method to copy the sheet and content in new workbook. 
                 copySheet(inputSheet,outputSheet); 
                }

               //  Write all the sheets in the new Workbook(testData_Copy.xlsx) using FileOutStream Object
               outputWorkbook.write(fos); 
              // At the end of the Program close the FileOutputStream object. 
               fos.close(); 
          }

           public static void copySheet(XSSFSheet inputSheet,XSSFSheet outputSheet) 
           { 
              int rowCount=inputSheet.getLastRowNum(); 
              System.out.println(rowCount+" rows in inputsheet "+inputSheet.getSheetName()); 
               
                int currentRowIndex=0; if(rowCount>0)
		{
			Iterator rowIterator=inputSheet.iterator();
			while(rowIterator.hasNext())
			{
				int currentCellIndex=0;
				Iterator cellIterator=((Row) rowIterator.next()).cellIterator();
				while(cellIterator.hasNext())
				{
				//  Creating new Row, Cell and Input value in the newly created sheet. 
					String cellData=cellIterator.next().toString();
					if(currentCellIndex==0)
						outputSheet.createRow(currentRowIndex).createCell(currentCellIndex).setCellValue(cellData);
					else
						outputSheet.getRow(currentRowIndex).createCell(currentCellIndex).setCellValue(cellData);
					
					currentCellIndex++;
				}
				currentRowIndex++;
			}
			System.out.println((currentRowIndex-1)+" rows added to outputsheet "+outputSheet.getSheetName());
			System.out.println();
		}
	
    
	}
        

	    

    
    
    public  void writeExcel(String filePath, String sheetName,String url) throws IOException{

      
        File file =    new File(filePath);

        

        FileInputStream inputStream = new FileInputStream(file);

        Workbook Workbook = null;

      
     

        Workbook = new XSSFWorkbook(inputStream);


     
        Sheet sheet = Workbook.getSheet(sheetName);

        

        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

      
        Row row = sheet.getRow(0);

      
        Row newRow = sheet.createRow(rowCount+1);

      

        for(int j = 0; j < row.getLastCellNum(); j++){

          

            Cell cell = (Cell) newRow.createCell(j);
          
           ((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(url);

        }

        inputStream.close();

     

        FileOutputStream outputStream = new FileOutputStream(file);

      
        Workbook.write(outputStream);

       

        outputStream.close();
      
        

        }
    
   
}



