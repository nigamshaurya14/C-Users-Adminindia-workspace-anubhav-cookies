package cookies;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class file_with_time_stamp {

	public static void main(String[] args) throws IOException {
		
		 Date date = new Date() ;
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy____HH_mm_ss") ;
		    File file = new File("C:\\Users\\Adminindia\\workspace\\anubhav\\cookies\\src\\main\\resources"+dateFormat.format(date) + ".csv") ;
		    try(BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
		        out.write("Writing to file");
		        
		        System.out.println("the file is created successfully");
		    } catch (IOException e) {
		       
		        e.printStackTrace();
		    }
		    
		    File file2 = new File("C:\\Users\\Adminindia\\Desktop\\test_file.xlsx") ;

		    InputStream in = new FileInputStream(file2);
		    OutputStream out = new FileOutputStream(file, true);

		    byte[] buf = new byte[1024];
		    int len;
		    while ((len = in.read(buf)) > 0){
		      out.write(buf, 0, len);
		    }
		    in.close();
		    out.close();
	}
	

}
