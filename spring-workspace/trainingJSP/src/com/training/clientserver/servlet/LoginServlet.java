package com.training.clientserver.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.clientserver.dao.ConnectionUtil;
import com.training.clientserver.dao.DBUtil;
import com.training.clientserver.dto.Login;
import com.training.clientserver.utils.Constants;

/**
 * Servlet implementation class Login
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private DBUtil dbUtil =  new DBUtil(); 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		System.out.println("username: "+username);
		System.out.println("password: "+password);
		Login login = null;
			try {
				login = dbUtil.getUser(username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(login == null) {
			response.sendRedirect("error.jsp");
		}else if(Constants.USER_TYPE_ADMIN.equals(login.getUserType())){
			response.sendRedirect("adminHome.jsp");
		}else if(Constants.USER_TYPE_TRAINER.equals(login.getUserType())){
			request.setAttribute("login", login);
			RequestDispatcher rDispatcher=request.getRequestDispatcher("/UserHome");
			rDispatcher.forward(request, response);
		}else if(Constants.USER_TYPE_TRAINEE.equals(login.getUserType())){
			response.sendRedirect("traineeHome.jsp");
		}
		
		response.getWriter().close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
