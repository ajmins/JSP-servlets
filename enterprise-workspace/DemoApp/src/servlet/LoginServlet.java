package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserSql;
import dao.connect;

/**
 * Servlet implementation class Login
 */

public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		System.out.println("username: "+username);
		System.out.println("password: "+password);
		HashMap<String,String> userCredentials=new HashMap<String,String>();//Creating HashMap    
		try {
			Connection resCon=  connect.getPostGresConnection();
			Statement st = resCon.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * from users"); 
	        while (rs.next()) {
	        	userCredentials.put(rs.getString("username"),rs.getString("password"));  

	        	System.out.println("name:"+rs.getString("username"));
	        	System.out.println("pwd:"+rs.getString("password"));
	        }
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Success");
		
//		final String name = "testuser";
//		final String pwd = "123456789";
//		final String adminName = "admin";
//		final String adminPwd = "admin123";
		if (userCredentials.containsKey(username)) {
			System.out.println("new_username: "+username);
			String userPswd = userCredentials.get(username);
		
		//user login
		if( password.equals(userPswd)) {
			//response.sendRedirect("traineeHome.jsp");
			System.out.println("entered user setup");
			request.setAttribute("name", username);
			UserSql.DbConnection();
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		//adminlogin
		//if case insesnsitive use myStr1.equalsIgnoreCase(myStr2))
//		else if(username.equalsIgnoreCase(adminName) && password.equals(adminPwd)) {
//			request.setAttribute("name", adminName);
//			request.getRequestDispatcher("adminHome.jsp").forward(request, response);
//		}
		//error
		else {
			System.out.println("entered error setup");
			response.sendRedirect("error.jsp");
		}
		}
		
		else {
			System.out.println("error setup");
			response.sendRedirect("error.jsp");
		}
	response.getWriter().close();
	}
}
