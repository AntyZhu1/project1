package com.anthony.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.anthony.dao.EmployeeDAO;
import com.anthony.dao.EmployeeDAOFactory;
import com.anthony.dao.ManagerDAO;
import com.anthony.dao.ManagerDAOFactory;
import com.anthony.employee.Employee;
import com.anthony.loggedIn.LoggedIn;
import com.anthony.manager.Manager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.apache.log4j.*;

public class LoginServlet extends HttpServlet{
	
	private static final Logger logger = LogManager.getLogger(LoginServlet.class);
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
//		FileAppender f = new FileAppender();
//        f.setName("Interaction Log");
//        f.setFile("interaction.log");
//        f.setThreshold(Level.INFO);
//
//        f.setLayout(new PatternLayout("%d{DATE} | Session Started " + "\n"));
//        f.setAppend(true);
//        f.activateOptions();
//        LogManager.getRootLogger().addAppender(f);
//        logger.info("%d{DATE} | Session Started "+ "\n");
		
		ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setThreshold(Level.INFO);
        consoleAppender.setLayout(new PatternLayout("%d{DATE} | Logging In ... " + "\n"));
        consoleAppender.activateOptions();
        LogManager.getRootLogger().addAppender(consoleAppender);

        logger.debug("Hello this is a debug message");
        logger.info("%d{DATE} | Session is running " + "\n");
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//		
		String id_string = request.getParameter("emp_id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

		HttpSession s=request.getSession(); 
		
		EmployeeDAO empDao = EmployeeDAOFactory.getEmployeeDao();
		ManagerDAO manDao = ManagerDAOFactory.getManagerDao();
		
		
		if(username != null && password != null) {
			
			
			if (role.equals("Employee")) {
				
//	            f.setLayout(new PatternLayout("%d{DATE} | Logged in as" + username + "\n"));
//	            f.setAppend(true);
//	            f.activateOptions();
//	            LogManager.getRootLogger().addAppender(f);
//	            logger.info("%d{DATE} | Logged in as" + username + "\n");
				
		        logger.debug("%d{DATE} | Logged in as" + username + "\n");
		        logger.info("%d{DATE} | Logged in as" + username + "\n");
				
				int id = Integer.parseInt(id_string);
				
				Employee tempEmp = empDao.employeeLogin(id, username, password);
				
				if (username.equals(tempEmp.getEmp_username()) && password.equals(tempEmp.getEmp_password())) {					

					request.getRequestDispatcher("index.html").include(request, response);
					out.print("<h1> Employee: " + tempEmp.getEmp_username() + "</h1>");
					
								          
			        s.setAttribute("role", "employee");
			        s.setAttribute("id", id);
					response.sendRedirect("profile");
					
					out.close();

				}
				else if (username.equals(tempEmp.getEmp_username()) && !password.equals(tempEmp.getEmp_password())) {

					
					request.getRequestDispatcher("login.html").include(request, response);
					out.print("<h1> Error, incorrect password </h1>");
					
					out.close();
				}
				else if (!username.equals(tempEmp.getEmp_username()) && password.equals(tempEmp.getEmp_password())) {

					
					request.getRequestDispatcher("login.html").include(request, response);
					out.print("<h1> Error, incorrect username </h1>");
					
					out.close();
				}
				
		        // commit the transaction
		        
	

				
			}
			
			else if (role.equals("Manager")) {
				
				int id = Integer.parseInt(id_string);
				
//	            f.setLayout(new PatternLayout("%d{DATE} | Logged in as" + username + "\n"));
//	            f.setAppend(true);
//	            f.activateOptions();
//	            LogManager.getRootLogger().addAppender(f);
//	            logger.info("%d{DATE} | Logged in as" + username + "\n");
				
		        logger.debug("%d{DATE} | Logged in as" + username + "\n");
		        logger.info("%d{DATE} | Logged in as" + username + "\n");
				
				Manager tempMan = manDao.mangerLogin(id, username, password);
				
				if (username.equals(tempMan.getMan_username()) && password.equals(tempMan.getMan_password())) {

					
					request.getRequestDispatcher("index.html").include(request, response);
					out.print("<h1> Manager: " + tempMan.getMan_username() + "</h1>");
					
			         
					s.setAttribute("role", "manager");
					s.setAttribute("id", id);
					response.sendRedirect("profile");
					
					out.close();

				}
				else if (username.equals(tempMan.getMan_username()) && !password.equals(tempMan.getMan_password())) {

					
					request.getRequestDispatcher("login.html").include(request, response);
					out.print("<h1> Error, incorrect password </h1>");
					
					out.close();
				}
				else if (!username.equals(tempMan.getMan_username()) && password.equals(tempMan.getMan_password())) {

					
					request.getRequestDispatcher("login.html").include(request, response);
					out.print("<h1> Error, incorrect username </h1>");
					
					out.close();
				}
				
		        // commit the transaction

			}
			
			else {
				request.getRequestDispatcher("login.html").include(request, response);
				out.print("<h1>Error, please select a role </h1>");
			}
		
		
		}
		else {
			request.getRequestDispatcher("login.html").include(request, response);
			out.print("<h1>Error, Username and password cannot be empty </h1>");

			
		}
	


		
	}
}
