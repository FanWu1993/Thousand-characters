package com;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class addBook extends HttpServlet {
  private static final String CONTENT_TYPE = "text/html; charset=GBK";
  //Initialize global variables
  public void init() throws ServletException {
  }
  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType(CONTENT_TYPE);
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>选择图书</title></head>");
    out.println("<body>");
    HttpSession session=request.getSession(true);  //获取客户的会话对象
    String item =new String(request.getParameter("item").getBytes("ISO-8859-1"));      //获取客户选择的图书名称。
    String mount=new String(request.getParameter("mount").getBytes("ISO-8859-1"));   //获取客户购买的数量。
    String unit =new String(request.getParameter("unit").getBytes("ISO-8859-1"));     //获取选择的付款方式。
    String str="图书名字: "+item+"<BR>"+"  数量:"+mount+"<BR>"+"  付款方式:"+unit;
    session.setAttribute(item,str);  //将客户的购买信息存入客户的session对象中。
    out.println(" 你的购物车中的图书有: ");
    Enumeration Enumeration = session.getAttributeNames();
    while(Enumeration.hasMoreElements())
       { String name=(String)Enumeration.nextElement();
          out.println("<BR>"+(String)session.getAttribute(name));
       }
          out.println("<br>");
          out.println("<a href=../select.jsp>继续选择</a>");
          out.println("<a href=../remove.jsp>选择删除</a>");
          out.println("</body></html>");
  }
  public void destroy() {
  }
}
