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
    out.println("<head><title>ѡ��ͼ��</title></head>");
    out.println("<body>");
    HttpSession session=request.getSession(true);  //��ȡ�ͻ��ĻỰ����
    String item =new String(request.getParameter("item").getBytes("ISO-8859-1"));      //��ȡ�ͻ�ѡ���ͼ�����ơ�
    String mount=new String(request.getParameter("mount").getBytes("ISO-8859-1"));   //��ȡ�ͻ������������
    String unit =new String(request.getParameter("unit").getBytes("ISO-8859-1"));     //��ȡѡ��ĸ��ʽ��
    String str="ͼ������: "+item+"<BR>"+"  ����:"+mount+"<BR>"+"  ���ʽ:"+unit;
    session.setAttribute(item,str);  //���ͻ��Ĺ�����Ϣ����ͻ���session�����С�
    out.println(" ��Ĺ��ﳵ�е�ͼ����: ");
    Enumeration Enumeration = session.getAttributeNames();
    while(Enumeration.hasMoreElements())
       { String name=(String)Enumeration.nextElement();
          out.println("<BR>"+(String)session.getAttribute(name));
       }
          out.println("<br>");
          out.println("<a href=../select.jsp>����ѡ��</a>");
          out.println("<a href=../remove.jsp>ѡ��ɾ��</a>");
          out.println("</body></html>");
  }
  public void destroy() {
  }
}
