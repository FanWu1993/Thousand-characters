<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<html>
<head>
  <style type="text/css">
  body{
	background:url(images/bg.jpg);
	padding-top:30px;
	background-image:url(image/20070404_e2b32f571b0219ff527cSxWFTlAaAQVr.jpg);
	background-repeat:no-repeat;
	background-position:center;
	background-attachment:fixed;


}
</style>
  </head>
  
  <body>
  <%@ include file="head.jsp"%>
  <%
   //�ӳ������ӻ�ȡ����ֵ
   String s=request.getParameter("choice");
   //���û�л�ȡ������Ĭ��Ϊ��1��
   if (s==null)
		s="1";
   int choice=Integer.parseInt(s);
   switch(choice){
	case 1:	%> 
		 <%@ include file="index.html"%>
		 <%		break;
	case 10:	%> 
		 <%@ include file="addMessage.jsp"%>
		 <%		break;
	case 11:	%> 
		 <%@ include file="register.jsp"%>
		 <%		break;
   }
%>
  <%@ include file="foot.jsp"%>
  </body>
</html>
