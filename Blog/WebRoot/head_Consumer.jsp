<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>jiahceng's blog</title>
</head>
<%@page import="com.wjc.form.ConsumerForm"%>

<%
ConsumerForm consumerFormPT=(ConsumerForm)session.getAttribute("form");
%>


<body>



		<%if(consumerFormPT.getManageLevel().equals("��ͨ")){%>


		
		  <table width="366" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#F1BD36">
          <tr bgcolor="#FFFFFF">
            <td width="171" height="20">�û�����<%=consumerFormPT.getAccount()%></td>
            <td width="195" height="20">������<%=consumerFormPT.getName()%></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td height="20">�Ա�<%=consumerFormPT.getSex()%></td>
            <td height="20">QQ���룺<%=consumerFormPT.getQQNumber()%></td>
          </tr>
          <tr bgcolor="#FFFFFF">
            <td height="20">��ҳ��<%=consumerFormPT.getMainPage()%></td>
            <td height="20">��Ȥ��<%=consumerFormPT.getInterest()%></td>
          </tr>
		      <tr bgcolor="#FFFFFF">
            <td height="20">���䣺<%=consumerFormPT.getEMail()%></td>
            <td height="20" bgcolor="#F1BD36"><a href="head_consumerUpdate.jsp">�����û���Ϣ</a></td>
	        </tr>
          </table>
	<%} %>


</body>
</html>
