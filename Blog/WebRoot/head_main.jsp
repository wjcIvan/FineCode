<%@ page contentType="text/html; charset=gb2312" language="java"
	import="java.sql.*" errorPage=""%>
<jsp:directive.page import="com.wjc.form.ArticleTypeForm" />
<jsp:directive.page import="com.wjc.form.ArticleForm" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="CSS/style.css" type="text/css" rel="stylesheet">
<title>jiahceng's blog</title>
<%@ page language="java" import="java.util.*"%>
<style type="text/css">
<!--
body {
	background-image: url(images/bg_01.gif);
}

.style6 {
	color: #77642c
}

.style7 {
	color: #7f5809
}
-->
</style>
</head>
<jsp:useBean id="articleTypeDao" scope="request" class="com.wjc.dao.ArticleTypeDao"></jsp:useBean>
<jsp:useBean id="articleDao" scope="request" class="com.wjc.dao.ArticleDao"></jsp:useBean>
<jsp:useBean id="restoreDao" scope="request" class="com.wjc.dao.RestoreDao"></jsp:useBean>
<%
	Integer typeId = null;
	List articleList = articleDao.queryArticle(typeId);
	int articleNumber = articleList.size();
	if (articleNumber > 5) {
		articleNumber = 5;
	}
%>
<body>
	<!--��ҳͷ����-->
	<jsp:include page="head_top.jsp" flush="true" />
	<table width="800" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td width="74"><img src="images/head_06.jpg" width="74"
				height="846">
			</td>
			<td height="846" valign="top" background="images/head_07.jpg">
				<!--��¼�û�����--> <br> <jsp:include page="head_Consumer.jsp"
					flush="true" />&nbsp;
				<table width="390" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td align="center">
							<%
								List list = articleTypeDao.queryArticleType();
								for (int i = 0; i < list.size(); i++) {
									ArticleTypeForm articleTypeForm = (ArticleTypeForm) list.get(i);
							%> <a
							href="head_ArticleList.jsp?typeId=<%=articleTypeForm.getId()%>">
								[<%=articleTypeForm.getTypeName()%>]</a>&nbsp; <%
 	}
 %>
						</td>
					</tr>
				</table> <%
 	for (int articleI = 0; articleI < articleNumber; articleI++) {
 		ArticleForm articleForm = (ArticleForm) articleList
 				.get(articleI);
 		String articleContent = articleForm.getContent();
 		if (articleContent.length() > 100) {
 			articleContent = articleContent.substring(0, 100) + "...";
 		}
 %>
				<table width="380" border="0" align="center">
					<tr>
						<td width="377" height="22"><font color="BE9110"><b><%=articleForm.getTitle()%></b>
						</font>
						</td>
					</tr>
					<tr>
						<td valign="top"><span class="style7"><%=articleContent%></span>
						</td>
					</tr>
					<tr>
						<td height="17" class="head-02"><a
							href="head_ArticleForm.jsp?id=<%=articleForm.getId()%>"
							class="head-02">�Ķ�ȫ��&gt;&gt;</a>
						</td>
					</tr>
					<tr>
						<td height="17" align="right"><%=articleForm.getPhTime()%>&nbsp;|&nbsp;�Ķ���<%=articleForm.getNumber()%>��&nbsp;|&nbsp;�ظ���<%=restoreDao.queryRestore(articleForm.getId()).size()%>��</td>
					</tr>
				</table>
				<div align="right" class="style6">
					<hr>
				</div> <%
 	}
 %>
			</td>
			<td width="10" background="images/head_07.jpg"><img
				src="images/head_08.jpg" width="13" height="846">
			</td>
			<td width="184" valign="top">
				<!--�Ҳ��������--> <jsp:include page="head_right.jsp" flush="true" /></td>
			<td width="122"><img src="images/head_10.jpg" width="122"
				height="846">
			</td>
		</tr>
	</table>
	<!--��ҳβ����-->
	<jsp:include page="head_down.jsp" flush="true" />
</body>
</html>
