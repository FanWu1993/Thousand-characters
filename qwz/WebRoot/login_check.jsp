<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>

<html>
<body>

<%
   String name=request.getParameter("name");
   if(name!=null){
   name=new String(name.getBytes("ISO-8859-1"));
   }
   String password=request.getParameter("password");
   if(password!=null)
   password=new String(password.getBytes("ISO-8859-1"));
   try{
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   } catch(ClassNotFoundException e){}
   try {
        Connection con = DriverManager.getConnection("jdbc:odbc:banji","sa","123456");
        Statement sql=con.createStatement();
        ResultSet rs=sql.executeQuery("select * from user_info where username='"+name+"'and password='"+password+"' and mark='��ͨ�û�'");
        if(rs.next()){//�����ѯ����ȷ���û���������rs.next()������ֵ
	     session.setAttribute("login_name",name);//�ɹ���¼���û���ӵ�session����
	     response.sendRedirect("main.jsp");//��¼�ɹ���ת��main.jspҳ��
	  }
        else{
             out.print("<script>alert('�����û����������������������������ע��');history.go(-1)</script>");
            }
             con.close();
      }catch(SQLException e1){}
%>
</body>
</html>
