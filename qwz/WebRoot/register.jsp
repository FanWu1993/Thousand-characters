<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<% java.util.Date date=new java.util.Date(); %>
<script>
function RgTest(){
	var username=document.getElementById("username").value;
	var password=document.getElementById("password").value;
	var Repwd=document.getElementById("Repassword").value;
	var relname=document.getElementById("realname").value;
	if(username=="")
		alert("�������û���");
	else if(username.length>10)
		alert("�û����ĳ��Ȳ��ܳ���10���ַ�");
	else if(password=="")
		alert("����������");
	else if(password.length<6||password.length>10)
		alert("���볤��Ӧ��6-10֮��");
	else if(password!=Repwd)
		alert("������������벻һ��");
	else if(relname=="")
		alert("��������ʵ����");
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
      <td colspan="2"><div align="center"><strong>=== ǧ����---&gt;&gt;ע�� ===</strong></div></td>
    </tr>
    <tr>
      <td width="31%">�û�����</td>
      <td width="69%"><input name="username" type="text" id="username" size="20" /></td>
    </tr>
    <tr>
      <td>�ܡ���:</td>
      <td><input name="password" type="password" id="password" size="20"></td>
    </tr>
    <tr>
      <td>ȷ�����룺</td>
      <td><label>
        <input name="Repassword" type="password" id="Repassword" size="20">
      </label></td>
    </tr>
    <tr>
      <td>��ʵ������</td>
      <td><label>
      <input name="realname" type="text" id="realname" size="20" />
      </label></td>
    </tr>
    
    <tr>
      <td colspan="2"> <div align="center">
          <input type="button" onClick="RgTest()" value="ע��">����
           <input type="reset" name="Submit2" value="������д" />
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
   String mark="��ͨ�û�";
   
    	
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
        out.print("<script>alert('��������û������Ѿ����ڣ������������µ��û���')</script>");
        session.setAttribute("register_false","�����û����Ѿ�����");
      }
      else{
          String condition="insert into user_info values('"+username+"','"+password+"','"+RealName+"','"+IssueDate+"','"+mark+"')";
          sql.executeUpdate(condition);
          session.setAttribute("register_sucsess","��ע��ɹ�");
          out.print("<script>alert('��ע��ɹ���');</script>");
          out.print("<center><a href='index.jsp'>"+"���¼��"+"</a></center>");
          con.close();
      }
 %>
 <%
  }catch(SQLException e1){}
 %>