package com;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Check extends HttpServlet {
  private static final String CONTENT_TYPE = "text/html; charset=GBK";
  //Initialize global variables
  public void init() throws ServletException {
  }
  //Process the HTTP Get request
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType(CONTENT_TYPE);
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>验证码验证</title></head>");
    out.println("<body bgcolor=\"#ffffff\">");
    HttpSession session=request.getSession(true);
    String rand = (String)session.getAttribute("rand");
     String input = request.getParameter("rand");
     if (rand.equals(input)) {
       out.println("您输入值与认证码相同，认证成功！");
     }
      else {
        out.println("您输入值与认证码不同，认证失败！");
       }
    out.println("</body></html>");
  }
  public void destroy() {
  }
}