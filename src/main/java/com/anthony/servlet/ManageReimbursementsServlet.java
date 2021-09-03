package com.anthony.servlet;

import com.anthony.dao.ManagerDAO;
import com.anthony.dao.ManagerDAOFactory;
import com.anthony.employee.PastReimbursement;
import com.anthony.loadData.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ManageReimbursementsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("navbar.html").include(request, response);
		
		ManagerDAO manDao = ManagerDAOFactory.getManagerDao();
		
     		
		out.println("<script>");
		
		//Filtering Table Function		
		out.println("function filterTable() {");
		
		out.println("let dropdown, table, rows, cells, status, filter;"
				+ "\n"
				+ "dropdown = document.getElementById(\"statusDropdown\");"
				+ "\n"
				+ "table = document.getElementById(\"table\");"
				+ "\n"
				+ "rows = table.getElementsByTagName(\"tr\");"
				+ "\n"
				+ "filter = dropdown.value;"
				+ "\n");
		
		out.println("for (let row of rows) { ");
		out.println("cells = row.getElementsByTagName(\"td\");");
		out.println("status = cells[6] || null;");
		out.println("if (filter === \"All\" || !status || (filter === status.textContent)) {");
		out.println("row.style.display = \"\";"
				+ "\n"	
				+ "}");
		out.println("else {\r\n"
				+ "      row.style.display = \"none\";\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}");
		
		// Sending reId to servlets using hidden field
		out.println("function sendId(id) {\r\n"
				+ "    document.getElementById(\"send-id\").value = id;\r\n"
				+ "    document.getElementById(\"demo\").innerHTML = document.getElementById(\"send-id\").value;\r\n"
				+ "}");
		
		out.println("</script>");
				
		List<PastReimbursement> pastTransactions = manDao.viewPastReimbursements();
		
		out.print("<br>");
		
		out.print("<div class='container'>");
		
		out.print("<select class=\"form-select\" id=\"statusDropdown\" oninput=\"filterTable()\">\r\n"
				+ "  <option>All</option>\r\n"
				+ "  <option>Pending</option>\r\n"
				+ "  <option>Approved</option>\r\n"
				+ "  <option>Rejected</option>\r\n"
				+ "</select>");
		
		out.print("<table class='table table-bordered' id='table'>");
		
		out.print("<thead class='table-primary'>");
		
		out.print("<th>Transaction ID:</th>");
		out.print("<th>Employee ID:</th>");
		out.print("<th>Amount:</th>");
		out.print("<th>Date:</th>");
		out.print("<th>Type:</th>");
		out.print("<th>Description:</th>");
		out.print("<th>Status:</th>");
		out.print("<th>Action:</th>");
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
			
			if(status.equals("Pending")) {
				out.println("<td>");
				
				out.println("<form method = \"post\" action = \"approve_reimbursement\">");
				
				out.println("<button type=\"submit\" class=\"btn btn-outline-secondary\" onclick='sendId(" + reId + ")'>Approve</button>");
				
				out.print("<input type='hidden' name='send-id' value='' id='send-id'>");

				out.println("</form>");
				
				out.println("<form method = \"post\" action = \"deny_reimbursement\">");

				out.println("<button type=\"submit\" class=\"btn btn-outline-secondary\" onclick='sendId(" + reId + ")'>Deny</button>");

				out.print("<input type='hidden' name='send-id' value='' id='send-id'>");

				out.println("</form>");

				out.println("</td>");

			}
			else {
				out.print("<td>" + temp.getPast_approve_status() + "</td>");
			}
				

			out.print("</tr>");
			
			
			row += 1;
			
		}
		

		out.print("</tbody>");
		out.print("</table>");
		out.print("</div>");	


		
		
		

		
	}

}
