<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<jsp:directive.page import="com.wjc.form.DiscussForm"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="CSS/style.css" type="text/css"  rel="stylesheet">
<title>jiahceng's blog</title>
<%@ page language="java" import="java.util.*" %>
<style type="text/css">
<!--
body {
	background-image: url(images/bg_01.gif);
}
.style1 {
	color: #663403;
	font-weight: bold;
}
.style2 {color: #663403}
.style3 {color: #9a6400}
.style4 {
	color: #cc7800;
	font-size: 10pt;
}
.style5 {color: #663401}
-->
</style></head>
<jsp:useBean id="discussDao" class="com.wjc.dao.DiscussDao" scope="page"></jsp:useBean>
<%
DiscussForm discussForm=discussDao.queryDiscuss(Integer.valueOf(request.getParameter("id")));


%>
<body>
<!--��ҳͷ����-->
<jsp:include page="head_top.jsp" flush="true" />

<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="74"><img src="images/head_06.jpg" width="74" height="846"></td>
    <td height="846" valign="top" background="images/head_07.jpg" width="407">
<%
out.println("<br><p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=images/icon.gif width=10 height=10>&nbsp;&nbsp;"+discussForm.getDiscussTitle()+"</p>");
%>
<table width="373" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="21" align="right"><%=discussForm.getDiscussTime() %></td>
  </tr>
</table>	
	  <table width="373" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#fece62">
        <tr>
          <td valign="top" bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;<%=discussForm.getDiscussContent()%></td>
        </tr>
      </table>
	  <table width="373" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="48" align="right"><div align="center"><a href="#" onclick="javascript:history.go(-1);"><img src="images/back.gif"></a></div></td>
        </tr>
      </table></td>
    <td width="10"><img src="images/head_08.jpg" width="13" height="846"></td>
    <td width="184" valign="top">
	 
	 
	 
	 
	  	<jsp:include page="head_right.jsp" flush="true" />
	  
	  
	  
    </td>
    <td width="122"><img src="images/head_10.jpg" width="122" height="846"></td>
  </tr>
</table>
<!--��ҳβ����-->
<jsp:include page="head_down.jsp" flush="true" />




</body>
</html>
