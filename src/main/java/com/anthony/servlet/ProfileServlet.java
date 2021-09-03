package com.anthony.servlet;

import com.anthony.loadData.LoadAllData;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

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
import jakarta.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet{
	

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("navbar.html").include(request, response);
		
		HttpSession session = request.getSession(false);
		
		EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDao();
		
		if (session != null) {
			String role = (String)session.getAttribute("role");
			
			if (role.equals("employee")) {
				out.print("<br>"
						+ "<h1>Employee Reimbursement Menu </h1>"
						+ "				<hr class=\"my-4\">\r\n"
						+ "" );
				out.print("<h1>Your Past Transactions: </h1>");
				
				List<PastReimbursement> pastTransactions = dao.viewPastReimbursements(0);
				
				out.print("<div class='container'>");
			
				out.print("<table class='table table-bordered' id='table'>");
				
				out.print("<thead class='table-primary'>");
				
				out.print("<th>Transaction ID:</th>");
				out.print("<th>Employee ID:</th>");
				out.print("<th>Amount:</th>");
				out.print("<th>Date:</th>");
				out.print("<th>Type:</th>");
				out.print("<th>Description:</th>");
				out.print("<th>Status:</th>");
				out.print("</thead>");
				out.print("<tbody>");
				
				int row = 1;
				
				for (PastReimbursement temp : pastTransactions) {
					
					int reId = temp.getPast_re_id();
					
					int empId = temp.getPast_emp_id();
					
					double amount = temp.getPast_amount();
					
					String date = temp.getPast_date();
					
					String type = temp.getPast_type();
					
					String description = temp.getPast_desc();
					
					String status = temp.getPast_approve_status();
					
					if (row % 2 == 0) {
						out.print("<tr class='table-secondary; id= '" + reId + "'>");
					}
					else {
						out.print("<tr class ='" + status + "' id= '" + reId + "'>");
					}
					
					
					out.print("<td>" + reId + "</td>");
					out.print("<td>" + empId + "</td>");
					out.print("<td>$" + amount + "</td>");
					out.print("<td>" + date + "</td>");
					out.print("<td>" + type + "</td>");
					out.print("<td>" + description + "</td>");
					out.print("<td>" + status + "</td>");
					
					
					out.print("</tr>");
					
					
					row += 1;
					
				}
				

				out.print("</tbody>");
				out.print("</table>");
				out.print("</div>");	
				
				request.getRequestDispatcher("emp_profile.html").include(request, response);
				out.close();
				
			}
			
			else if (role.equals("manager")) {
				out.print("<br>"
						+ "<h1>Manager Reimbursement Menu </h1>" );
				request.getRequestDispatcher("man_profile.html").include(request, response);

			}

		}
		else {
			out.print("<h1>You're Not Logged In! </h1>");
			request.getRequestDispatcher("login.html");
		}
		out.close();
	}
	
}
