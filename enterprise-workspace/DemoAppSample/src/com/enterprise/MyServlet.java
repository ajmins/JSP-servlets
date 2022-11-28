package com.enterprise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
	
		PrintWriter ouPrintWriter =  res.getWriter();
		ouPrintWriter.print("Hi ");
		
		//Servlet context: initial value setup
		
//		ServletContext ctxContext = getServletContext();
//		String str = ctxContext.getInitParameter("name");
//		ouPrintWriter.println(str);
//		ouPrintWriter.print("This is my phone ");
//		String str1 = ctxContext.getInitParameter("phone");
//		ouPrintWriter.println(str1);
		
		//Servlet configuration: initial value setup
		ServletConfig cgConfig = getServletConfig();
		String str = cgConfig.getInitParameter("name");
		ouPrintWriter.println(str);
		String str1 = cgConfig.getInitParameter("phone");
		ouPrintWriter.print("This is "+ str1 +" phone "); //here null
		
		//ouPrintWriter.println(str1);
		
	}
	
}
