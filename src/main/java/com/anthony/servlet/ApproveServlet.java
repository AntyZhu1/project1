package com.anthony.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.anthony.dao.ManagerDAO;
import com.anthony.dao.ManagerDAOFactory;
import com.anthony.employee.PastReimbursement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ApproveServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerDAO manDao = ManagerDAOFactory.getManagerDao();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("navbar.html").include(request, response);
		

		List<PastReimbursement> pastTransactions = manDao.viewPastReimbursements();
		
		String id_string = request.getParameter("send-id");
		
		int id = Integer.parseInt(id_string);

		manDao.approveReimbursement(id);
		
		response.sendRedirect("manage_reimbursements");

	}
}
