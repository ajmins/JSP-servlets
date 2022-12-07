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

public class EditServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Admin Edit entered");
		UserSql uSql =new UserSql();
		Users u = new Users();
		int result=0;
		String[] data=null;
		HttpSession session=request.getSession();
		
		String id =request.getParameter("userId");
		System.out.println("idToEdit: "+id); 
		try {
			data = UserSql.singleUserIDView(u,id);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		for (String string : data) {
			System.out.println("data: "+string.toString());
		}
		request.setAttribute("username", data[1]);
		request.setAttribute("email", data[3]);
		request.setAttribute("password", data[2]);
		RequestDispatcher rd1 = request.getRequestDispatcher("edit.jsp");
		rd1.forward(request, response);
		
//		u.setUsername((String) data[1]);
//		u.setEmail((String) data[3]);
//		u.setPassword((String) data[2]);
//		System.out.println(request.getParameter("username") +" : "+ request.getParameter("email")+" : "+ request.getParameter("password"));
//	
//
//		
//
//		try {
//			result=uSql.editData(id,u);
//			if(result==0)
//			{
//				RequestDispatcher rd = request.getRequestDispatcher("adminHome.jsp");
//				rd.forward(request, response);
//			}
//			else {
//				PrintWriter out=response.getWriter();
//				out.println("Edit Success");
//				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
//				rd.forward(request, response);
//			}
//
//		} 
//		catch(SQLException ex)
//		{
//			System.out.println("Edit failed");
//			ex.printStackTrace();
//			
//		}
		
	}
}
