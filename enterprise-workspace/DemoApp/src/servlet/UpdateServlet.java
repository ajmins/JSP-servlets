package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UsersTable;
import dao.UserSql;

/*
 * Update Servlet is used for updating user details, can be used by both user and admin.
 * User can use this to edit their own details, Admin can use to edit other user's details
 */
public class UpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserSql uSql =new UserSql();
		UsersTable u = new UsersTable();
		int result=0;
		
		u.setUsername((String) request.getParameter("username"));
		u.setEmail((String) request.getParameter("email"));
		u.setPassword((String) request.getParameter("password"));
				
		try {
			result=uSql.updateData(u);
			if(result==0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("adminHome.jsp");
				rd.forward(request, response);
			}
			else {
				PrintWriter out=response.getWriter();
				out.println("Update Success");
				response.sendRedirect("login.jsp");
			}
		}
		catch(SQLException ex)
		{
			System.out.println("Update failed");
			ex.printStackTrace();
		}
		System.out.println("Update exited");
	}
}
