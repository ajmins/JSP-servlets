package com.training.clientserver.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		System.out.println("username: "+username);
		System.out.println("password: "+password);
		final String name = "testuser";
		final String pwd = "123456789";
		final String adminName = "admin";
		final String adminPwd = "admin123";
		System.out.println("name: "+name);
		System.out.println("pwd: "+pwd);
		
	//user login
	if(username.equals(name) && password.equals(pwd)) {
		//response.sendRedirect("traineeHome.jsp");
		request.setAttribute("name", username);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	//adminlogin
	//if case insesnsitive use myStr1.equalsIgnoreCase(myStr2))
	else if(username.equalsIgnoreCase(adminName) && password.equals(adminPwd)) {
		request.setAttribute("name", adminName);
		request.getRequestDispatcher("adminHome.jsp").forward(request, response);
	}
	//error
	else {
		response.sendRedirect("error.jsp");
	}
	response.getWriter().close();
	}
}
