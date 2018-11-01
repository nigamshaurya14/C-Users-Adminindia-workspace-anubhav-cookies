package cookies;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class delete_from_excel {
	public static void main(String[] args) throws IOException {
	//delete_from_excel dt =new delete_from_excel();
	 String filePath="C:\\Users\\Adminindia\\workspace\\anubhav\\cookies\\src\\main\\backend_links_validation_output.xlsx";
			
			
			
			
				
			
	 delete_from_excel.delete_data(filePath,"valid_links");
	}
	
	
	public  static void delete_data(String filePath,String sheetName) throws IOException{
		
		 File file =    new File(filePath);
		 System.out.println(filePath);

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);

        Workbook guru99Workbook = null;

      
       //If it is xlsx file then create object of XSSFWorkbook class

        guru99Workbook = new XSSFWorkbook(inputStream);
        System.out.println(sheetName);

      //Read excel sheet by sheet name    

        Sheet sheet = guru99Workbook.getSheet(sheetName);
        System.out.println(sheetName);
        //Get the current count of rows in excel file

        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        System.out.println(rowCount);
        
        for (int index = 1; index <= rowCount; index++) {
        	System.out.println(index);
       	 sheet.removeRow( sheet.getRow(index));
        }
        
        System.out.println("data deleted");
	}

	
}

