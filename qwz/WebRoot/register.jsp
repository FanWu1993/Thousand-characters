<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<% java.util.Date date=new java.util.Date(); %>
<script>
function RgTest(){
	var username=document.getElementById("username").value;
	var password=document.getElementById("password").value;
	var Repwd=document.getElementById("Repassword").value;
	var relname=document.getElementById("realname").value;
	if(username=="")
		alert("请输入用户名");
	else if(username.length>10)
		alert("用户名的长度不能超过10个字符");
	else if(password=="")
		alert("请输入密码");
	else if(password.length<6||password.length>10)
		alert("密码长度应在6-10之间");
	else if(password!=Repwd)
		alert("两次输入的密码不一致");
	else if(relname=="")
		alert("请输入真实姓名");
	else
		document.getElementById("fom").submit();
	
}
</script><style type="text/css">
<!--
body {
	background-color: #CCCCCC;
}
-->
</style>
<form name="form1" method="post" action="" id="fom">
  <table align="center" bgcolor="#999999"  class="table"  style="width:350px;">
    <tr>
      <td colspan="2"><div align="center"><strong>=== 千文字---&gt;&gt;注册 ===</strong></div></td>
    </tr>
    <tr>
      <td width="31%">用户名：</td>
      <td width="69%"><input name="username" type="text" id="username" size="20" /></td>
    </tr>
    <tr>
      <td>密　码:</td>
      <td><input name="password" type="password" id="password" size="20"></td>
    </tr>
    <tr>
      <td>确认密码：</td>
      <td><label>
        <input name="Repassword" type="password" id="Repassword" size="20">
      </label></td>
    </tr>
    <tr>
      <td>真实姓名：</td>
      <td><label>
      <input name="realname" type="text" id="realname" size="20" />
      </label></td>
    </tr>
    
    <tr>
      <td colspan="2"> <div align="center">
          <input type="button" onClick="RgTest()" value="注册">　　
           <input type="reset" name="Submit2" value="重新填写" />
      </div></td>
    </tr>
  </table>
</form>
<%
  String username=request.getParameter("username");
  if(username!=null)
  	username=new String(username.getBytes("ISO-8859-1"));
  String password=request.getParameter("password");
  if(password!=null)
  	password=new String(password.getBytes("ISO-8859-1"));
   String RealName=request.getParameter("realname");
  if(RealName!=null)
  	RealName=new String(RealName.getBytes("ISO-8859-1"));
   String IssueDate=date.getYear()+1900+"-"+date.getMonth()+"-"+date.getDay();
   String mark="普通用户";
   
    	
%>
  <%
   try{
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     }
   catch(ClassNotFoundException e){}
   try {
      Connection con = DriverManager.getConnection("jdbc:odbc:banji","sa","123456");
      Statement sql=con.createStatement();
      ResultSet rs=sql.executeQuery("select * from user_info where username='"+username+"'");
      if(rs.next()){
        if(username!=null&&password!=null)
        out.print("<script>alert('你输入的用户名字已经存在，请重新输入新的用户名')</script>");
        session.setAttribute("register_false","您的用户名已经存在");
      }
      else{
          String condition="insert into user_info values('"+username+"','"+password+"','"+RealName+"','"+IssueDate+"','"+mark+"')";
          sql.executeUpdate(condition);
          session.setAttribute("register_sucsess","您注册成功");
          out.print("<script>alert('你注册成功！');</script>");
          out.print("<center><a href='index.jsp'>"+"请登录！"+"</a></center>");
          con.close();
      }
 %>
 <%
  }catch(SQLException e1){}
 %>