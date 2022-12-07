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
 * Profile is set for normal user. 
 */
public class ProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		
		Users u = new Users();
		String[] data = null;
		HttpSession session = request.getSession();

		u.setUsername((String) session.getAttribute("username"));
		u.setPassword((String) session.getAttribute("password"));
		
		
		try {
			data = UserSql.singleView(u);
			u.setUser_id(Integer.parseInt(data[0]));
			u.setUsername(data[1]);
			u.setPassword(data[2]);
			u.setEmail(data[3]);
			u.setRole_id(Integer.parseInt(data[4]));

			session = request.getSession();
			session.setAttribute("user_id", u.getUser_id());
			session.setAttribute("username",u.getUsername());
			session.setAttribute("password", u.getPassword());
			session.setAttribute("email", u.getEmail());
			session.setAttribute("role_id", u.getRole_id());
			
			RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("Profile exited");
	}
}
