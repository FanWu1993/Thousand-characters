<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'head.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style type="text/css">
<!--
.STYLE3 {
	font-family: "����";
	color: #FFFFFF;
	font-weight: bold;
}
.aaa {
	background-image: url(image/11.JPG);
	background-repeat: no-repeat;
}
.STYLE5 {font-family: "����"}
-->

    </style>
</head>
  
  <body>
  <br>
  <form name="form2" method="post" action="./servlet/addMessage">
  <table width="900" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#666666">
    <!--DWLayoutTable-->
    <tr>
      <td width="9" height="25">&nbsp;</td>
      <td valign="middle" class="STYLE3"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td width="2%">&nbsp;</td>
              <td width="98%" valign="top" background="Images/index_09.gif">
			  <%String name=(String)session.getAttribute("name");
			  if (name==null || name==""){%>
			  <table width="100%"  border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td colspan="2">�û���
                    <input name="name" type="text" class="txt_grey" id="name" size="16">                  
                    ����
                    <input name="PWD" type="password" class="txt_grey" id="PWD" size="16" onKeydown="if(event.keyCode==13) form1.submit();">
                    <input name="Button" type="button" class="btn_grey" value="ע��" onClick="window.location.href='index.jsp?choice=11'">
                    <input name="Submit" type="submit" id="Submit" value="��¼"></td>
                </tr>
              </table>
			  <%}else{%>
                <table width="100%"  border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="24" align="center" class="word_white">[<%=name%>]���ã���ӭ���٣�
                      <input name="Submit32" type="button" class="btn_grey" value="�˳���¼" onClick="window.location.href='logout.jsp';"></td>
                  </tr>
                </table>
				<%}%>			  </td>
            </tr>
          </table></td>
      <td width="29" valign="top"><img src="image/das.JPG" width="29" height="29"></td>
      <td width="71">&nbsp;</td>
    </tr>
  </table>
  <div align="center">
    <table width="900" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="aaa">
      <!--DWLayoutTable-->
      <tr>
        <td colspan="2" rowspan="2"><img src="image/վ��LOGO.gif" width="109" height="150"></td>
        <td height="20" colspan="3" align="center" valign="middle" bgcolor="#CCCCCC" class="asd"><div align="left"><span class="STYLE5">������Ѷ��</span></div></td>
        <td width="254" valign="middle" bgcolor="#CCCCCC" class="asd"><script>
var marqueeContent=new Array();   //��������
                  	
marqueeContent[0]='<a>+ �����ǹ�������</a>';
marqueeContent[1]='<a>+ �����ǲ�������</a>';
marqueeContent[2]='<a>+ �����ǹ�������</a>';
marqueeContent[3]='<a>+ �����ǲ��Ա���</a>';
marqueeContent[4]='<a>+ ���Բ��Բ���!</a>';

var marqueeInterval=new Array();  //����һЩ���ö���Ҫ�����õ��ı���
var marqueeId=0;
var marqueeDelay=3000;
var marqueeHeight=18;
function initMarquee() {
 var str=marqueeContent[0];
 document.write('<div id=marqueeBox style="overflow:hidden;height:'+marqueeHeight+'px" onmouseover="clearInterval(marqueeInterval[0])" onmouseout="marqueeInterval[0]=setInterval(\'startMarquee()\',marqueeDelay)"><div>'+str+'</div></div>');
 marqueeId++;
 marqueeInterval[0]=setInterval("startMarquee()",marqueeDelay);
 }
function startMarquee() {
 var str=marqueeContent[marqueeId];
  marqueeId++;
 if(marqueeId>=marqueeContent.length) marqueeId=0;
 if(marqueeBox.childNodes.length==1) {
  var nextLine=document.createElement('DIV');
  nextLine.innerHTML=str;
  marqueeBox.appendChild(nextLine);
  }
 else {
  marqueeBox.childNodes[0].innerHTML=str;
  marqueeBox.appendChild(marqueeBox.childNodes[0]);
  marqueeBox.scrollTop=0;
  }
 clearInterval(marqueeInterval[1]);
 marqueeInterval[1]=setInterval("scrollMarquee()",10);
 }
function scrollMarquee() {
 marqueeBox.scrollTop++;
 if(marqueeBox.scrollTop%marqueeHeight==marqueeHeight){
  clearInterval(marqueeInterval[1]);
  }
 }
initMarquee();
        </script>        </td>
      </tr>
      <tr>
        <td width="25%" height="80%"><div align="center" class="STYLE5">
          <h1><a href="index.jsp?choice=1">��ҳ</a></h1>
        </div></td>
        <td width="25%" height="80%"><div align="center" class="STYLE5">
          <h1><a href="index.jsp?choice=2">����</a></h1>
        </div></td>
        <td width="25%" height="80%"><div align="center" class="STYLE5">
          <h1><a href="index.jsp?choice=3">���ֳ�ʶ</a></h1>
        </div></td>
        <td width="25%" height="80%"><div align="center" class="STYLE5">
          <h1><a href="index.jsp?choice=4">������Ʒ</a></h1>
        </div></td>
      </tr>
	   <td width="108"></tr>
    </table>
    <table width="900" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC" class="asd">
      <!--DWLayoutTable-->
      <tr>
    </tr>
    </table>
  </div>
  </body>
</html>
