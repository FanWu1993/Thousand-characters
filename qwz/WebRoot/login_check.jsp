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
        ResultSet rs=sql.executeQuery("select * from user_info where username='"+name+"'and password='"+password+"' and mark='普通用户'");
        if(rs.next()){//如果查询到正确的用户名密码则rs.next()返回真值
	     session.setAttribute("login_name",name);//成功登录的用户添加到session对象
	     response.sendRedirect("main.jsp");//登录成功后转向main.jsp页面
	  }
        else{
             out.print("<script>alert('您的用户名或者密码有误，请重新输入或者注册');history.go(-1)</script>");
            }
             con.close();
      }catch(SQLException e1){}
%>
</body>
</html>
