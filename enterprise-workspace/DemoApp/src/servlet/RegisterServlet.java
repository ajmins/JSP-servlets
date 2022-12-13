package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UsersTable;
import dao.UserSql;
/*
 * Register Servlet is used for Registering user. 
 * Access is allowed to admin user alone.
 */
public class RegisterServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Registration entered");
		UserSql uSql =new UserSql();
		UsersTable u = new UsersTable();
		int result = 0;
	
		u.setUsername(request.getParameter("username"));
		u.setEmail(request.getParameter("email"));
		u.setPassword(request.getParameter("password"));
		String roleNumber =request.getParameter("role");
		
		u.setRole_id(Integer.parseInt(roleNumber));

		try {
			if (uSql.checkUser(u)) {
				result = uSql.insertData(u);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (result != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
		System.out.println("Registration exited");
	}
}
