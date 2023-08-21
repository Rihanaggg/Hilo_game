package fibonacci;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;


public class Fibonacci extends HttpServlet {
	private static final long serialVersionUID = 1L;     
         public  static int fib(int n){
        	      
        	        if (n <= 1)
        	            return n;        	 
        	        
        	        return fib(n - 1) + fib(n - 2);
        	    }       	 
        	    
         
	
		@Override
		  public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		    try {
		     
		      
		      PrintWriter out = resp.getWriter();
		      int num = Integer.parseInt(req.getParameter("n"));
		      for(int i=0;i<=num;i++) {
		    	  out.println(String.format("<p> %d!</p>",fib(i) ));
		      }
		      
		      
		    } catch (IOException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		  }
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    PrintWriter out = response.getWriter();
		    String nValue = request.getParameter("limitValue");

		    try {
		        int num = Integer.parseInt(nValue);
		        for (int i = 0; i <= num; i++) {
		            out.println(String.format("<p> %d</p>", fib(i)));
		        }
		    } catch (NumberFormatException e) {
		        out.println("Invalid input. Enter a valid integer value for 'n'.");
		    }
		}

	}

	

