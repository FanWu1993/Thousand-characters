package com;

import javax.servlet.*;
import javax.servlet.http.*;

import app63.DBconn;
import app63.StrConvert;

import java.io.*;
import java.util.*;

public class addMessage extends HttpServlet {
  
	// Process the HTTP Get request
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		DBconn con = new DBconn();
		StrConvert chstr = new StrConvert();
		String username = (String) request.getParameter("people");
		String email = (String) request.getParameter("email");
		String topic = (String) request.getParameter("topic");
		String masinfo = (String) request.getParameter("thing");
		String nowtime = String.valueOf(new Date().toLocaleString());
		if (username != null || email != null || topic != null) {
			username = chstr.chStr(username);
			email = chstr.chStr(email);
			topic = chstr.chStr(topic);
			masinfo = chstr.chStr(masinfo);
		}
		String sqli = " INSERT INTO mas(people,topic,time,email,thing) VALUES('"
			+ username + "','" + topic + "','" + nowtime + "','" + email
			+ "','" + masinfo + "')";
		int temp = -10;
		con.executeInsert(sqli);
		response.sendRedirect("../message.jsp");
	}
}
