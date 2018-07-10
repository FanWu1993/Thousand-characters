<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.sql.*"%>
<html>
<head>
<title>留言</title>
<jsp:useBean id="add" class="com.DBconn" scope="page" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312"><style type="text/css">
<!--
body {
	background-color: #CCCCCC;
}
-->
</style></head>

<body>
<form action="./servlet/addMessage" method="post" name="form3" >

  <table width="365" height="276" border="0" align="center" cellspacing="0">
  <tr bgcolor="#AEB6DD">
    <td width="93" height="27" align="left"><span class="style2">留&nbsp;言&nbsp;人：</span></td>
 <td width="324" height="27" style="font-size:12px "><input name="people" type="text" id="name" size="20" maxlength="40" />
      </td>
  </tr>
  <tr bgcolor="#AEB6DD">
    <td width="93" height="27" align="left"><span class="style2">E-mail：</span></td>
    <td width="324" height="27"> <input name="email" type="text" size="20" maxlength="40"> </td>
  </tr>
  <tr bgcolor="#AEB6DD">
    <td width="93" height="27" align="left"><span class="style2">留言主题：</span></td>
    <td width="324" height="27"> <input name="topic" type="text" size="30" maxlength="50"> </td>
  </tr>
    <tr align="left" bgcolor="#AEB6DD">
    <td height="27" colspan="2"><span class="style2">留言信息：</span></td>
    </tr>
  <tr align="left" bgcolor="#AEB6DD">
    <td height="106" colspan="2" valign="top"><span class="style2">
      <textarea name="masinfo" cols="50" rows="6" wrap="PHYSICAL"></textarea>
    </span> </td>
   </tr>
      <tr align="center" bgcolor="#AEB6DD">
        <td height="34" colspan="2">
          <span class="style2">
          <input name="Submit3" type="submit" class="code" value="留言" >
          &nbsp;
          <input name="Submit2" type="reset" class="code" value="重置">
        </span></td>
    </tr>
</table>

</form>
</body>
</html>
