<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<jsp:directive.page import="com.wjc.form.ArticleTypeForm"/>
<jsp:directive.page import="com.wjc.form.ArticleForm"/>
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
-->
</style></head>
<jsp:useBean id="articleTypeDao" scope="request" class="com.wjc.dao.ArticleTypeDao"></jsp:useBean>
<jsp:useBean id="articleDao" scope="request" class="com.wjc.dao.ArticleDao"></jsp:useBean>

<body>
<!--网页头部分-->
<jsp:include page="head_top.jsp" flush="true" />



<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="74"><img src="images/head_06.jpg" width="74" height="846"></td>
    <td height="846" valign="top" background="images/head_07.jpg">
	<!--登录用户部分-->
		<br>
		
		




<table width="390" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#F7D069">
  <tr>
    <td height="25" align="center" bgcolor="#FFFFFF">

    
      <div align="left"><strong>Welcome：</strong></div></td>
  </tr>
  <tr>
    <td height="55" valign="top" bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;Welcome to my little blog!Just enjoy what I want to show you!</td>
  </tr>
  <tr>
    <td height="25" align="center" bgcolor="#FFFFFF"><div align="left"><strong>something about my blog：</strong></div></td>
  </tr>
  <tr>
    <td height="61" valign="top" bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;It just a blog,just..</td>
  </tr>
  <tr>
    <td height="25" align="center" bgcolor="#FFFFFF"><div align="left"><strong>My email:</strong></div></td>
  </tr>
  <tr>
    <td height="35" align="center" bgcolor="#FFFFFF"><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;2065014322@qq.com</div></td>
  </tr>
  <tr>
    <td height="25" align="center" bgcolor="#FFFFFF"><div align="left"><strong>My phone:</strong></div></td>
  </tr>
  <tr>
    <td height="32" align="center" bgcolor="#FFFFFF"><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;323231</div></td>
  </tr>
</table>






















</td>
    <td width="10" background="images/head_07.jpg"><img src="images/head_08.jpg" width="13" height="846"></td>
    <td width="184" valign="top">
	
	
	
	
	  	<!--右侧操作部分-->
	  <jsp:include page="head_right.jsp" flush="true" />
	  
	  
	  
    </td>
    <td width="122"><img src="images/head_10.jpg" width="122" height="846"></td>
  </tr>
</table>
<!--网页尾部分-->
<jsp:include page="head_down.jsp" flush="true" />




</body>
</html>
