package PasswordVerify;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;

public class Password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//    public static boolean SameString(String s1,String s2) {
//    	if(s1.length()==s2.length()) {
//    		if(s1.toLowerCase().equals(s2.toLowerCase())) {
//    			return true;
//    		}else
//    			return false;
//    	}
//    	return false;
//    }
	 
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();
//		String pass = request.getParameter("password");
//		String conPassword = request.getParameter("conPassword");
//		
//		
//	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out = response.getWriter();		
		String Password = request.getParameter("password");
		//String conPassword = request.getParameter("conPassword");
		HashSet<String> hs = new HashSet<>();
		try {
			BufferedReader bf = new BufferedReader(new FileReader("/home/ruch9101/eclipse-workspace/dynamicweb/src/main/java/PasswordVerify/bannedPasswords.txt"));
			String line;
			while((line = bf.readLine())!= null) {
				hs.add(line);
			}
			//boolean result = SameString(pass,);
			if(Password == null) {
				out.print("The password is Empty");
			}
			if(hs.contains(Password)) {
				out.print("The password entry is banned.");
			}else {
				out.print("The password entry is valid.");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
	}

}
