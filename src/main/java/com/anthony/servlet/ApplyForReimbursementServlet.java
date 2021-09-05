package com.anthony.servlet;

import com.anthony.loadData.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.anthony.dao.EmployeeDAO;
import com.anthony.dao.EmployeeDAOFactory;
import com.anthony.employee.PastReimbursement;
import com.anthony.employee.Reimbursement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class ApplyForReimbursementServlet extends HttpServlet{
	
	private static final Logger logger = LogManager.getLogger(ApproveServlet.class);

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//		
		String id_string = request.getParameter("emp_id");
		String amount_string = request.getParameter("amount");
		String type = request.getParameter("type");
		String description = request.getParameter("description");
		String date_string = request.getParameter("date");
		
		EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDao();
        
        int id = Integer.parseInt(id_string);
        
        int amount = Integer.parseInt(amount_string);
        
		ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setThreshold(Level.INFO);
        consoleAppender.setLayout(new PatternLayout("%d{DATE} | Reimbursement Applied For By Employee with ID: " + id + "\n"));
        consoleAppender.activateOptions();
        LogManager.getRootLogger().addAppender(consoleAppender);

        logger.debug("Hello this is a debug message");
        logger.info("%d{DATE} | Reimbursement Applied For By Employee with ID: " + id + "\n");
		
		request.getRequestDispatcher("navbar.html").include(request, response);	

		out.print("<h1>OK, the following request has been sent: </h1>");
		
		out.print("<table class='table table-bordered'>");
		
		out.print("<tr>");
		
		out.print("<th>ID:</th>");
		
		out.print("<td>" + id + "</td>");
		
		out.print("</tr>");
		
		out.print("<tr>");
		
		out.print("<th>Amount:</th>");
		
		out.print("<td>$" + amount + "</td>");
		
		out.print("</tr>");
		
		out.print("<tr>");
		
		out.print("<th>Reimbursement Date:</th>");
		
		out.print("<td>" + date_string + "</td>");
		
		out.print("</tr>");
		
		out.print("<tr>");
		
		out.print("<th>Reimbursement Type:</th>");
		
		out.print("<td>" + type + "</td>");
		
		out.print("</tr>");
		
		out.print("<tr>");
		
		out.print("<th>Description:</th>");
		
		if (description != "") {
			out.print("<td>" + description + "</td>");
		}
		
		else {
			out.print("</td>No Description</td>");
			description = "No Description";
		}
						
		out.print("</tr>");
		
		out.print("</table>");
		
		out.print("<form action=\"profile\">\r\n"
				+ "	<button class=\"btn btn-primary\" type=\"submit\">Return to Profile</button>\r\n"
				+ "</form>");
				
		dao.applyForReimbursement(id, type, amount, description, date_string);
				
		List<Reimbursement> pastReimbursements = dao.viewAllMyReimbursements();
		
		Reimbursement mostRecent = pastReimbursements.get(pastReimbursements.size() - 1);
		
		int recentReimbursementId = mostRecent.getRe_id();
		
		PastReimbursement reimbursementRecord = new PastReimbursement(recentReimbursementId, id, type, amount, description, date_string, "Pending");

		dao.addToPendingReimbursements(reimbursementRecord);
        
        out.close();

		
	}
}
