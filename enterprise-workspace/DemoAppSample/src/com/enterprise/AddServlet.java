package com.enterprise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.ldap.Rdn;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/add")
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
		
		//set background colour
		PrintWriter out = res.getWriter();
		out.println("<html><body bgcolor='cyan'>");
		
		
		//PrintWriter out = res.getWriter();
		out.println("Result: "+k);
		
		
		
		//to call another servlet from a servlet
		//2 methods; Req Dispatcher and Redirect
		//1. Request dispatcher
		
		//to pass k value to the new servlet
//		req.setAttribute("k", k);
//		
//		
//		RequestDispatcher rsDispatcher  =  req.getRequestDispatcher("sq");
//		rsDispatcher.forward(req, res);
		
		
//		//2. SendRedirect
//		res.sendRedirect("sq?k="+k); //session management : 1.URL Rewriting
//		
//		//another methods are: 2. Cookies, and 3. Sessions
		
//		
//		//Sessions 
//		HttpSession session = req.getSession();
//		session.setAttribute("k", k);
//		
//		res.sendRedirect("sq");
		
		

		
		//Cookies
		
//		Cookie cookie =  new Cookie("k", k +""); //integer + "" = string
//		res.addCookie(cookie);		
//
//		res.sendRedirect("sq");
//		
		
		
		
	}
	
}
