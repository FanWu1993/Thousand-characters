<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.sql.*"%>
<html>
<head>
<title>察看留言</title>
<jsp:useBean id="con" class="com.DBconn" scope="request" />
<body>
<table width="732" height="*" border="1" align="center" cellpadding="1" cellspacing="0" bordercolordark="#ffffff"  bordercolor="#ffffff" bordercolorlight="#0066ff">
  <tr bgcolor="#CCCCFF">
    <td height="22" colspan="5" align="center"><a href="index.jsp?choice=10">增加留言</a></td>
  </tr>
  <%
	String sqli=" SELECT * FROM mas ORDER BY id DESC";
	ResultSet rs=con.executeQuery(sqli);
	String color="";
	String strpages=(String)request.getParameter("pages");
	int pages=0;
	if(strpages==null){
	      pages=0;
	}else{
              pages=Integer.parseInt(strpages);
	}
	rs.last();
	int sqan=4,i=0,fcount=0;
	int count=rs.getRow();
	int countpage=count/sqan;
	if(count%sqan>0) countpage=countpage+1;
	if(pages<0) pages=0;
	if(pages>countpage-1) pages=countpage-1;
	fcount=pages*sqan+1;
	int fpage=(count-fcount)/sqan+1;
	rs.absolute(fcount);
	rs.previous();
	while(rs.next()){
          int id=rs.getInt("id");
          String username=rs.getString("people");
          String time=rs.getString("time");
          String topic=rs.getString("topic");
          String email=rs.getString("Email");
          String masinfo=rs.getString("thing");
          if(masinfo==null) masinfo="";
          if(color==""){
                        color="#ffffff";
			}else{
                              color="";
			}
%>
  <tr bgcolor="<%=color%>">
    <td align="center" width="86" height="22"><div align="left">留言人：</div></td>
    <td align="center" width="158"><%=username%>&nbsp;</td>
    <td height="22"  colspan="2" align="left">留言主题：</td>
    <td width="298" height="22" align="center"><%=topic%>&nbsp;</td>
  </tr>
  <tr bgcolor="<%=color%>">
    <td width="86" height="22" align="center"><div align="left">日期：</div></td>
    <td width="158" height="22" align="center"><%=time%></td>
    <td height="22" colspan="3" rowspan="3" align="left" valign="top"><%=masinfo%>&nbsp;</td>
  </tr>
  <tr bgcolor="<%=color%>">
    <td height="22" align="center"><div align="left">Email：</div></td>
    <td height="22" align="center"><%=email%>&nbsp;</td>
  </tr>
  <tr bgcolor="<%=color%>">
    <td height="22" align="center"><div align="left">处理：</div></td>
    <td height="22" align="center"><a href="servlet/delMessage?id=<%=id%>" >删除留言</a></td>
    <%
	   i++;if(i==sqan) break;
        }
	try{
		con.close();
	}catch(Exception e){
	}
%>
  </tr>
  <tr align="right" bgcolor="#CCCCFF">
    <td height="22" colspan="5">第<%=(pages+1)%>/<%=countpage%>页&nbsp;&nbsp;<a href="message.jsp?pages=<%=(pages-1)%>">上一页</a>&nbsp;&nbsp;<a href="message.jsp?pages=<%=(pages+1)%>">下一页</a></td>
  </tr>
</table>
</body>
</html>
