<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:directive.page import="com.wjc.form.ArticleForm"/>
<jsp:directive.page import="com.wjc.form.RestoreForm"/>
<jsp:directive.page import="com.wjc.form.ConsumerForm"/>
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
<jsp:useBean id="pagination" class="com.wjc.tool.MyPagination" scope="session"></jsp:useBean>
<jsp:useBean id="consumerDao" class="com.wjc.dao.ConsumerDao" scope="request"></jsp:useBean>
<jsp:useBean id="restoreDao" class="com.wjc.dao.RestoreDao" scope="session"></jsp:useBean>
<jsp:useBean id="articleDao" class="com.wjc.dao.ArticleDao" scope="request"></jsp:useBean>
<%
ConsumerForm consumerForm=(ConsumerForm)session.getAttribute("form");
String id=request.getParameter("id");


ArticleForm articleForm=articleDao.queryArticleForm(Integer.valueOf(id));

String str=(String)request.getParameter("Page");
int Page=1;
List list=null;
if(str==null){
	list=restoreDao.queryRestore(articleForm.getId());
	int pagesize=3;      //ָ��ÿҳ��ʾ�ļ�¼��
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
    <td valign="top" background="images/head_07.jpg" width="407" height="846">


<%
out.println("<br><p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=images/icon.gif width=10 height=10>&nbsp;&nbsp;"+articleForm.getTitle()+"</p>");
%>
	
	  <table width="373" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#fece62">
        <tr>
          <td valign="top" bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;<%=articleForm.getContent() %></td>
        </tr>
      </table>
	  <table width="373"  border="0">
        <tr>
          <td align="right"><%=articleForm.getPhTime()%>&nbsp;&nbsp;|&nbsp;&nbsp;�Ķ���<%=articleForm.getNumber()%>��&nbsp;&nbsp;|&nbsp;&nbsp;�ظ���<%=restoreDao.queryRestore(articleForm.getId()).size()%>��</td>
        </tr>
      </table>
	  <table width="373" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="36" align="right"><div align="center"><a href="#" onclick="javascript:history.go(-1);"><img src="images/back.gif"></a></div></td>
        </tr>
      </table>  
	  
	  
	  
	  
	  <%	  if(pagination.getRecordSize()>0){
for(int i=0;i<list.size();i++){
RestoreForm restoreForm=(RestoreForm)list.get(i);
 %>
	  <table width="345"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#fece62">
        <tr>
          <td width="47" bgcolor="#FFFFFF">��Ŀ��</td>
          <td width="285" bgcolor="#FFFFFF"><%=restoreForm.getReTitle() %></td>
        </tr>
        <tr>
          <td bgcolor="#FFFFFF">���ݣ�</td>
          <td bgcolor="#FFFFFF"><%=restoreForm.getReContent() %></td>
        </tr>
        <tr>
          <td colspan="2" bgcolor="#FFFFFF"><div align="right">�ظ��ˣ�<%=consumerDao.getConsumerForm(Integer.valueOf(restoreForm.getReAccount()))%></div></td>
        </tr>
      </table>
	  <%} 
	  

	  out.print(pagination.printCtrl(Page,id));}%>
	  
	  
	  
	  
	  
	  
	   <form name="form" method="post" action="ArticleServlet?method=7"  onSubmit="return addRestore()">
	  <table width="261"  border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#000000">
        <tr>
          <td width="88" bgcolor="#FFFFFF">�ظ����⣺
         </td>
          <td width="183" bgcolor="#FFFFFF"><input name="reTitle" type="text" class="inputinput" size="26"></td>
        </tr>
        <tr>
          <td height="139" bgcolor="#FFFFFF">�ظ����ݣ�</td>
          <td bgcolor="#FFFFFF"><textarea name="reContent" rows="10" class="inputinput"></textarea></td>
        </tr>
        <tr>
          <td bgcolor="#FFFFFF">��&nbsp;��&nbsp;�ˣ�</td>
          <td bgcolor="#FFFFFF"><input name="articleId" type="hidden" size="26" value="<%=articleForm.getId()%>"><input name="accountId" type="hidden" size="26" value="<%=consumerForm.getId()%>"><%=consumerForm.getName()%></td>
        </tr>
      </table>
	   <table width="284"  border="0" align="center">
         <tr>
           <td>
             <div align="center">
  <input type="image" class="inputinputinput" src="images/save.gif">
&nbsp;&nbsp;
   <a href="#" onClick="javascript:form.reset()"><img src="images/reset.gif"></a></div></td>
         </tr>
       </table>
	   </form>


  </td>
    <td width="10"><img src="images/head_08.jpg" width="13" height="846"></td>
    <td width="184" valign="top"><jsp:include page="head_right.jsp" flush="true" />
	  
	  
	  
    </td>
    <td width="122"><img src="images/head_10.jpg" width="122" height="846"></td>
  </tr>
</table>
<!--��ҳβ����-->
<jsp:include page="head_down.jsp" flush="true" />




</body>
</html>
