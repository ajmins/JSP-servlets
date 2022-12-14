package com.enterprise;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sq")
public class SqServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		//1. Request dispatcher
//		int k = (int) req.getAttribute("k");
//		k = k * k;
//		PrintWriter outPrintWriter = res.getWriter();
//		//outPrintWriter.println("Hello to Sq");
//		
//		outPrintWriter.println("Result: "+ k);
		
		//2.SendRedirect 
		
		//## Sesssion Management -  URL rewriting 
//		int k = Integer.parseInt(req.getParameter("k")) ;
//		k = k * k;
//		PrintWriter outPrintWriter = res.getWriter();
//		outPrintWriter.println("Result: "+ k);
//		
//		System.out.println("sq called");
		
		//## Sesssion Management -  Sessions
//		HttpSession session =  req.getSession();
//		
//		//we can remove the session value bu using
//		//session.removeAttribute("k");
//		//then we will not get output
//		
//		int k = (int) session.getAttribute("k");
//		
//		k = k * k;
//		PrintWriter outPrintWriter = res.getWriter();
//		outPrintWriter.println("Result: "+ k);
//		
//		System.out.println("sq called");
		
		
		//## Sesssion Management -  Cookies
		//we need to get all cookies from fst servlet
		//req.getCookies(); //client sends all the cookies and we need to decide what we wants
		
		int k = 0;
		
		Cookie cookies[] = req.getCookies();
		for (Cookie c : cookies) {
			if(c.getName().equals("k"))
				k = Integer.parseInt(c.getValue());
		}
		
		
		k = k * k;
		
		PrintWriter outPrintWriter = res.getWriter();
		outPrintWriter.println("Result: "+ k);
		
		System.out.println("sq called");
		
	}
}
