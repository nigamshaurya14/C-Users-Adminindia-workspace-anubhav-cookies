package cookies;

//import java.awt.event.ActionEvent;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public abstract class xhr  implements ServletRequest {
	
	

	private HttpServletRequest request;

	   public void setRequest(HttpServletRequest request) {
	      this.request = request;
	   }

	   public HttpServletRequest getRequest() {
	      return this.request;
	   }

	   public void execute() throws Exception{
	      boolean ajax = "XMLHttpRequest".equals(
	                      getRequest().getHeader("X-Requested-With"));
	      if (ajax)
	         System.out.println("This is an AJAX request");
	      else 
	    	  System.out.println("This is an ordinary request");
		//return true;

	     // return SUCCESS;
	   }  


}
