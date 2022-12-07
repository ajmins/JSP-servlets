package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Users;
import dao.UserSql;

/**
 * This class is used for updating details of a user from admin side login
 * For updation, we need to obtain the user_id and pass this id via URL and obtain details of that particular user, then this controller will call another controller UpdateServlet
 */
public class EditServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Users u = new Users();
		String[] data=null;
		String id =request.getParameter("userId");
		try {
			data = UserSql.singleUserIDView(u,id);
			request.setAttribute("username", data[1]);
			request.setAttribute("email", data[3]);
			request.setAttribute("password", data[2]);
			RequestDispatcher rd1 = request.getRequestDispatcher("edit.jsp");
			rd1.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Updation failed");
			e.printStackTrace();
		}

		
		
	}
}
