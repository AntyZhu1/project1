package com.anthony.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import com.anthony.dao.ManagerDAO;
import com.anthony.dao.ManagerDAOFactory;
import com.anthony.employee.PastReimbursement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DenyServlet extends HttpServlet{
	
	private static final Logger logger = LogManager.getLogger(DenyServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ManagerDAO manDao = ManagerDAOFactory.getManagerDao();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("navbar.html").include(request, response);
		

		List<PastReimbursement> pastTransactions = manDao.viewPastReimbursements();
		
		String id_string = request.getParameter("send-id");
		
		int id = Integer.parseInt(id_string);

		manDao.denyReimbursement(id);
		
		ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setThreshold(Level.INFO);
        consoleAppender.setLayout(new PatternLayout("%d{DATE} | Reimbursement Denied " + "\n"));
        consoleAppender.activateOptions();
        LogManager.getRootLogger().addAppender(consoleAppender);

        logger.debug("Hello this is a debug message");
        logger.info("%d{DATE} | Reimbursement Denied " + "\n");
		
		response.sendRedirect("manage_reimbursements");

	}
}
