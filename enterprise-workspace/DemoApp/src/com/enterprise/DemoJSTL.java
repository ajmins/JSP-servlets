package com.enterprise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DemoServlet")
public class DemoJSTL extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException { //two objects; request and response
	
//		String name = "Ajmi";
//		
//		//to pass this value to jsp file
//		request.setAttribute("label", name);
//		RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
//		//System.out.println(request.getAttribute("label"));
//		rd.forward(request, response);
		
		
//		//Passing some objects of Student class
//		Student student = new Student(1, "Dia");
//		request.setAttribute("s", student); //s=label
//		RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
//		rd.forward(request, response);
		
		//Passing list of students to jsp
		List<Student> studList = Arrays.asList(new Student(1, "Ajmi"),new Student(2, "Diya"),new Student(3, "Megha"));
		request.setAttribute("students", studList);
		RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
		rd.forward(request, response);
		
		
		
	}
}
