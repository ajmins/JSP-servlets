package com.training.clientserver.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.clientserver.dao.ConnectionUtil;
import com.training.clientserver.dao.DBUtil;
import com.training.clientserver.dto.Login;
import com.training.clientserver.dto.Trainee;

/**
 * Servlet implementation class TrainingServlet
 */
public class UserHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBUtil dbUtil = new DBUtil();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Login login = (Login) request.getAttribute("login");
		if(login != null) {
			try {
				List<Trainee> list = dbUtil.getTraineesForTrainer(ConnectionUtil.getConnection(),
						login.getPerson().getPersonId());
				request.setAttribute("list", list);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		response.sendRedirect("trainerHome.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
