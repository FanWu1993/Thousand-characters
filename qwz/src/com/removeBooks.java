package com;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class removeBooks extends HttpServlet {
  private static final String CONTENT_TYPE = "text/html; charset=GBK";
  //Initialize global variables
  public void init() throws ServletException {
  }
  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType(CONTENT_TYPE);
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>删除图书</title></head>");
    out.println("<body");
    HttpSession session=request.getSession(true);  //获取客户的会话对象
       String item =new String(request.getParameter("item").getBytes("ISO-8859-1"));      //获取要删除的图书名称。
              session.removeAttribute(item);       //删除商品。
        //将购物车中的商品显示给客户：
       out.println("<H3>你现在购物车中的商品有:</H3> ");
            Enumeration Enumeration = session.getAttributeNames();
             while(Enumeration.hasMoreElements())
               { String name=(String)Enumeration.nextElement();
                 out.println("<BR>"+(String)session.getAttribute(name));
               }
             out.println("<br>");
             out.println("<a href=../select.jsp>选择商品</a>");
             out.println("<a href=../remove.jsp>继续删除</a>");
    out.println("</body></html>");
  }
  //Clean up resources
  public void destroy() {
  }
}
