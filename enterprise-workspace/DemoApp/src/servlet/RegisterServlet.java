package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Users;
import dao.UserSql;

public class RegisterServlet extends HttpServlet {
 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserSql uSql =new UserSql();
		Users u = new Users();
		int result = 0;
//		int returnLastInsertId =UserSql.DbConnection(request);
	
		u.setUsername(request.getParameter("username"));
		u.setEmail(request.getParameter("email"));
		u.setPassword(request.getParameter("password"));
		String roleNumber =request.getParameter("role");
		
		u.setRole_id(Integer.parseInt(roleNumber));
	    System.out.print("\n"+u.getUser_id()+" "+u.getUsername()+" "+u.getPassword()+" "+u.getEmail()+" "+u.getRole_id());  

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
	}
}
