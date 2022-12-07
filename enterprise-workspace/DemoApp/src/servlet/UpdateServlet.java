package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Users;
import dao.UserSql;

public class UpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Update entered");
		UserSql uSql =new UserSql();
		Users u = new Users();
		int result=0;
		String[] data=null;
		HttpSession session=request.getSession();
		
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
