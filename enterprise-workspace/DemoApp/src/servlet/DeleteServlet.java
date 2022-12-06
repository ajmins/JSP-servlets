package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserSql;

public class DeleteServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Delete entered");
		UserSql uSql =new UserSql();
		int result=0;
		String[] data=null;
		HttpSession session=request.getSession();
		String id =request.getParameter("userId");
		System.out.println("idToDelete: "+id);
		try {
			result=uSql.deleteData(id);
		} 
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
	}
}
