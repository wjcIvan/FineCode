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
<jsp:useBean id="pagination" class="com.wjc.tool.MyPagination" scope="session"></jsp:useBean>
<jsp:useBean id="discussDao" class="com.wjc.dao.DiscussDao" scope="page"></jsp:useBean>
<%
String str=(String)request.getParameter("Page");
int Page=1;
List list=null;
if(str==null){
	list=discussDao.queryDiscuss();
	int pagesize=22;      //ָ��ÿҳ��ʾ�ļ�¼��
	list=pagination.getInitPage(list,Page,pagesize);     //��ʼ����ҳ��Ϣ
}else{
	Page=pagination.getPage(str);
	list=pagination.getAppointPage(Page);     //��ȡָ��ҳ������
}




%>
<body>
<!--��ҳͷ����-->
<jsp:include page="head_top.jsp" flush="true" />

<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="74"><img src="images/head_06.jpg" width="74" height="846"></td>
    <td height="846" valign="top" background="images/head_07.jpg" width="407">
<%
out.println("<br><p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=images/icon.gif width=10 height=10>&nbsp;&nbsp;��ѯ���й�����Ϣ</p>");
%>
<table width="387" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="FECE62">
  <tr>
    <td width="112" height="30"><div align="center">��Ŀ</div></td>
    <td width="161"><div align="center">����ʱ��</div></td>
    <td width="96"><div align="center">����</div></td>
  </tr>
  
  <%for(int i=0;i<list.size();i++){
  DiscussForm discussForm=(DiscussForm)list.get(i);
      String title=discussForm.getDiscussTitle();
            if(title.length()>6){
            title=title.substring(0,6)+"......";
             }
   %>
  <tr bgcolor="#FFFFFF">
    <td height="30"><div align="center"><%=title%></div></td>
    <td><div align="center"><%=discussForm.getDiscussTime()%></div></td>
    <td><div align="center"><a href="head_disussForm.jsp?id=<%=discussForm.getId()%>">��ϸ��ѯ</a></div></td>
  </tr>
  <%} %>
</table>

	 <%=pagination.printCtrl(Page) %>


</td>
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
