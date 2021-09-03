package com.anthony.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class TryLoginServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			
			out.print("<script> alert('You are already logged in') </script>");
			
						
			request.getRequestDispatcher("profile").include(request, response);
			
			out.close();

			
		}
		else {
			request.getRequestDispatcher("login_navbar.html").include(request, response);

			request.getRequestDispatcher("login.html").include(request, response);
			

		}

		
		out.close();
	}
	
	
}
