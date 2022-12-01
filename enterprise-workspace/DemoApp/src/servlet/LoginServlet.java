package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	        	System.out.println(rs.getString("password"));
	        	
	        }
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Successfull");
		

		if (userCredentials.containsKey(username)) {
			//check if user name is present
			System.out.println("user is on");
			String[] userValue = userCredentials.get(username); //userValue[0]=pswd, userValue[1]=role_id
			
			System.out.println(userValue[1]);
			
			//check password
			if( password.equals(userValue[0])) {
				
				//check role id; 1=admin; 2=user
				if(userValue[1].equals("2"))
				{
					//user login
					System.out.println("entered user setup");
					request.setAttribute("name", username);
					UserSql.DbConnection(request);
					System.out.println("entered after connection");
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
				System.out.println("password is incorrect");
				response.sendRedirect("error.jsp");
			}

		}
		//error
		else {
			System.out.println("user is not found");
			response.sendRedirect("error.jsp");
		}
		

	response.getWriter().close();
	}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		final String username = request.getParameter("username");
//		final String password = request.getParameter("password");
//		
//		ArrayList list=(ArrayList)request.getAttribute("data");
//		Iterator itr=list.iterator();  
//	    while(itr.hasNext()){  
//	     Users u=(Users)itr.next();  
//	     System.out.print("<br>"+u.getUser_id()+" "+u.getUsername()+" "+u.getPassword());  
//	    }  
//	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		
		Users u = new Users();
		 UserSql usql=new UserSql();
		 String[] data=null;
		 HttpSession session=request.getSession();
		 u.setUsername(request.getParameter("username"));
		 u.setPassword(request.getParameter("password"));
		 
		 try
		 {
		 if(usql.userLogin(u))
		 {
			 data=usql.singleView(u);
			 
			 u.setUsername(data[1]);
			
			 session.setAttribute("username",u.getUsername());
			
			 session.setAttribute("password", u.getPassword());
			 
			 String checkData = "Select * from users where username=username";
			 con = connect.getPostGresConnection();

			ps = con.prepareStatement(checkData);
			 System.out.println("roleid:"+checkData);
			 
			 RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			 rd.forward(request, response);
		 }
		 else {
			 response.sendRedirect("login.jsp");
			 session.setAttribute("ErrorMessage","Login Failed");
		 }
	}catch(SQLException|ClassNotFoundException ex)
		 {
			ex.printStackTrace();
		 }
		 }
}
