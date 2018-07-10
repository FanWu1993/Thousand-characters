package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app63.DBconn;


public class delMessage extends HttpServlet {
 
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	 
		
		DBconn con = new DBconn();
		int id = Integer.parseInt((String) request.getParameter("id"));
		String sqld = " DELETE FROM mas WHERE id=" + id;
		con.executeDelete(sqld);
		response.sendRedirect("../message.jsp");
  
	}
  
}
