package com.anthony.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			
			
			
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
