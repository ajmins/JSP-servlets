package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UsersTable;
import dao.Connect;
import dao.UserSql;


/**
 * Servlet implementation class Login using Post method
 * Login as normal user and as admin is possible based on user role_id
 */

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		
		 UsersTable u = new UsersTable();
		 UserSql usql=new UserSql();
		 String[] data=null;
		 HttpSession session=request.getSession();
		 u.setUsername(request.getParameter("username"));
		 u.setPassword(request.getParameter("password"));
		 con = Connect.getPostGresConnection(request, response);
		 System.out.println("Login entered");
		 try
		 {
		 if(usql.userLogin(u))
		 {
			 
				data=UserSql.singleView(u);
				u.setUsername(data[1]);
				String name =data[1];
				UserSql.DbConnection(request);
				ArrayList<UsersTable> list=(ArrayList<UsersTable>)request.getAttribute("data");
				 
				session.setAttribute("username",u.getUsername());
				session.setAttribute("password", u.getPassword());
				
				 
				String checkData = "Select * from userstable where username=?";
			
				ps = con.prepareStatement(checkData,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ps.setString(1, name);
				rs = ps.executeQuery();
				rs.last();
				int role = rs.getInt(5);
				
			 if(role == 1) { //admin
				request.setAttribute("name", name);
				request.setAttribute("userData", list);
				request.getRequestDispatcher("adminHome.jsp").forward(request, response);
			 }
			 
			 else if (role ==2) { //normal user
				request.setAttribute("name", name);
				String[] listUser=UserSql.singleView(u);
				List<String> listUsers = Arrays.asList(listUser);
				request.setAttribute("listUser", listUsers);
				RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
			}			
		 }
		 else {
			 System.out.println("entered error setup");
			 response.sendRedirect("error.jsp");
			 session.setAttribute("ErrorMessage","Login Failed");
		 }
	}catch(SQLException|ClassNotFoundException ex)
		 {
			ex.printStackTrace();
		 }
		 System.out.println("Login exited");
		 }
	
}
