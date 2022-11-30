package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Users;
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
		HashMap<String,String[]> userCredentials = new HashMap<String, String[]>();//Creating HashMap 
		
		try {
			Connection resCon=  connect.getPostGresConnection();
			Statement st = resCon.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * from users"); 
	        while (rs.next()) {
	        	//retrieving all the users from the table
	        	userCredentials.put(rs.getString("username"),new String[] {rs.getString("password"),rs.getString("role_id")});  
	        	//userCredentials.put(rs.getString("username"),rs.getString("password"));  

	        	
	        }
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Success");
		

		if (userCredentials.containsKey(username)) {
			//check if user name is present
			
			String[] userValue = userCredentials.get(username); //userValue[0]=pswd, userValue[1]=role_id
			
			//check password
			if( password.equals(userValue[0])) {
				
				//check role id; 1=admin; 2=user
				if(userValue[1].equals("2"))
				{
					//user login
					System.out.println("entered user setup");
					request.setAttribute("name", username);
					UserSql.DbConnection(request);
					request.getRequestDispatcher("home.jsp").forward(request, response);
					
				}
				else if (userValue[1].equals("1")) {
					
					System.out.println("entered admin setup");
					request.setAttribute("name", username);
					
					UserSql.DbConnection(request);
					
					ArrayList<Users> list=(ArrayList<Users>)request.getAttribute("data");
					Iterator<Users> itr=list.iterator(); 
					String role=null;
				    while(itr.hasNext()){  
				     Users u=itr.next();
				     if(u.getRole_id()==1) {
				    	 role ="admin"; 
				     }
				     else if (u.getRole_id()==2) {
				    	 role ="user"; 
					}
				     System.out.print("\n"+u.getUser_id()+" "+u.getUsername()+" "+u.getPassword()+" "+u.getEmail()+" "+role);  
				    }
				    for (Users users : list) {
						System.out.println("check: "+users.toString());
					}
				    request.setAttribute("userData", list);
					request.getRequestDispatcher("adminHome.jsp").forward(request, response);
				
			
				}
				
	
				
			}
			//adminlogin
			//if case insesnsitive use myStr1.equalsIgnoreCase(myStr2))
//			else if(username.equalsIgnoreCase(adminName) && password.equals(adminPwd)) {
//				request.setAttribute("name", adminName);
//				request.getRequestDispatcher("adminHome.jsp").forward(request, response);
//			}

			//error
			else {
				System.out.println("entered error setup");
				response.sendRedirect("error.jsp");
			}

		}
		//error
		else {
			System.out.println("entered error setup");
			response.sendRedirect("error.jsp");
		}
		

	response.getWriter().close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		final String username = request.getParameter("username");
//		final String password = request.getParameter("password");
//		
//		ArrayList list=(ArrayList)request.getAttribute("data");
//		Iterator itr=list.iterator();  
//	    while(itr.hasNext()){  
//	     Users u=(Users)itr.next();  
//	     System.out.print("<br>"+u.getUser_id()+" "+u.getUsername()+" "+u.getPassword());  
//	    }  
	}
}
