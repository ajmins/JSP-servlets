package com.enterprise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.ldap.Rdn;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//when extends, AddServlet class becomes a servlet
public class AddServlet extends HttpServlet {

	//service method name is used, and no other name is used
	//servlet is a server component and it do services
	
	//a method
//	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException { //two objects; request and response
//		//getparameter will send string so we need to convert to integer
//		int i = Integer.parseInt(req.getParameter("num1")); 
//		int j = Integer.parseInt(req.getParameter("num2"));
//		
//		int k = i + j;
//		//to display in console
//		//System.out.println("result: "+k);
//		//to display in web page
//		//res.getWriter().println("Result: "+k);
//		//we can also use..
//		PrintWriter out = res.getWriter();
//		out.println("Result: "+k);
//		
//	}
	
	//another method specifically for get and post
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException { //two objects; request and response
		int i = Integer.parseInt(req.getParameter("num1")); 
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k = i + j;
		
		k=k*k;
		/*
		PrintWriter out = res.getWriter();
		out.println("Result: "+k);
		*/
		
		//to call another servlet from a servlet
		//2 methods; Req Dispatcher and Redirect
		//1. Request dispatcher
		
		//to pass k value to the new servlet
		req.setAttribute("k", k);
		
		
		RequestDispatcher rsDispatcher  =  req.getRequestDispatcher("sq");
		rsDispatcher.forward(req, res);
		
	}
	
}
