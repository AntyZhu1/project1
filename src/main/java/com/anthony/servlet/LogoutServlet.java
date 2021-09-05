package com.anthony.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{

	private static final Logger logger = LogManager.getLogger(LoginServlet.class);
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			
//			FileAppender f = new FileAppender();
//	        f.setName("Interaction Log");
//	        f.setFile("interaction.log");
//	        f.setThreshold(Level.INFO);
//
//	        f.setLayout(new PatternLayout("%d{DATE} | Logged Out " + "\n"));
//	        f.setAppend(true);
//	        f.activateOptions();
//	        LogManager.getRootLogger().addAppender(f);
//	        logger.info("%d{DATE} | Logged Out "+ "\n");
			
			ConsoleAppender consoleAppender = new ConsoleAppender();
	        consoleAppender.setThreshold(Level.INFO);
	        consoleAppender.setLayout(new PatternLayout("%d{DATE} | Logging Out " + "\n"));
	        consoleAppender.activateOptions();
	        LogManager.getRootLogger().addAppender(consoleAppender);

	        logger.debug("Hello this is a debug message");
	        logger.info("%d{DATE} | Logging Out " + "\n");
			
			
			session.invalidate();
			request.getRequestDispatcher("navbar.html").include(request, response);	
       
			
			out.print("<h1>You have logged out</h1>");
			out.close();

		}
		
		else {
			request.getRequestDispatcher("navbar.html").include(request, response);	

			request.getRequestDispatcher("login.html").include(request, response);
			out.print("<script> alert('You are not logged in') </script>");
			out.close();


		}

		
		out.close();
	}
}
