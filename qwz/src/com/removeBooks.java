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
    out.println("<head><title>ɾ��ͼ��</title></head>");
    out.println("<body");
    HttpSession session=request.getSession(true);  //��ȡ�ͻ��ĻỰ����
       String item =new String(request.getParameter("item").getBytes("ISO-8859-1"));      //��ȡҪɾ����ͼ�����ơ�
              session.removeAttribute(item);       //ɾ����Ʒ��
        //�����ﳵ�е���Ʒ��ʾ���ͻ���
       out.println("<H3>�����ڹ��ﳵ�е���Ʒ��:</H3> ");
            Enumeration Enumeration = session.getAttributeNames();
             while(Enumeration.hasMoreElements())
               { String name=(String)Enumeration.nextElement();
                 out.println("<BR>"+(String)session.getAttribute(name));
               }
             out.println("<br>");
             out.println("<a href=../select.jsp>ѡ����Ʒ</a>");
             out.println("<a href=../remove.jsp>����ɾ��</a>");
    out.println("</body></html>");
  }
  //Clean up resources
  public void destroy() {
  }
}
