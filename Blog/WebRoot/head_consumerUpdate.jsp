<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
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
<%
	com.wjc.form.ConsumerForm consumerForm=(com.wjc.form.ConsumerForm)session.getAttribute("form");
%>


<body>
<!--��ҳͷ����-->
<jsp:include page="head_top.jsp" flush="true" />



<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="74"><img src="images/head_06.jpg" width="74" height="846"></td>
    <td height="846" valign="top" background="images/head_07.jpg">
	<!--��¼�û�����-->
		<br>
		<jsp:include page="head_Consumer.jsp" flush="true" />&nbsp;
		
		<br>
		  <%out.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=images/icon.gif width=10 height=10>&nbsp;&nbsp;�����û���Ϣ</p>");%>
		  <form name="form" method="post" action="ConsumerServlet?method=6&id=<%=consumerForm.getId() %>" onSubmit="return hostUpdate()">
		  
            <table width="325" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#FECE62">
              <tr>
                <td width="93" height="30"><div align="center">�û�����</div></td>
                <td width="219" bgcolor="#FFFFFF"><div align="center"><input name="account" type="text" class="inputinput" size="40" value="<%=consumerForm.getAccount()%>" readonly="readonly" onclick="alert('���ı�������Ϊֻ�����û������޸�')"></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">���룺</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><input name="password" type="password" class="inputinput"  size="40" value="<%=consumerForm.getPassword()%>"></div></td>
              </tr>
			   <tr>
                <td height="30"><div align="center">�ظ����룺</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><input name="repeatPassword" type="password" class="inputinput"  value="<%=consumerForm.getPassword()%>"  size="40">
                </div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">������</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><input name="name" type="text" class="inputinput"  size="40" value="<%=consumerForm.getName()%>"></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">�Ա�</div></td>
                <td bgcolor="#FFFFFF"><div align="center">
				<input name="sex" type="radio" class="inputinputinput" value="��" <%if(consumerForm.getSex().trim().equals("��")){%>checked<%}%> >
        ��
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input name="sex" type="radio" class="inputinputinput" value="Ů" <%if(consumerForm.getSex().trim().equals("Ů")){%>checked<%}%> > 
        Ů
		</div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">QQ���룺</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><input name="QQnumber" type="text" class="inputinput"  size="40" value="<%=consumerForm.getQQNumber()%>"></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">��ҳ��</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><input name="mainPage" type="text" class="inputinput"  size="40" value="<%=consumerForm.getMainPage()%>"></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">��Ȥ���ã�</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><input name="interest" type="text" class="inputinput"  size="40" value="<%=consumerForm.getInterest()%>"></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">�������䣺</div></td>
                <td bgcolor="#FFFFFF"><div align="center"><input name="eMail" type="text" class="inputinput" size="40" value="<%=consumerForm.getEMail()%>"></div></td>
              </tr>
            </table>
            <div align="center"><br>
              <input type="image" class="inputinputinput" src="images/save.gif">
&nbsp;&nbsp;
   <a href="#" onClick="javascript:form.reset()"><img src="images/reset.gif"></a>
            </div>
		  </form>
			
		
		</td>
    <td width="10" background="images/head_07.jpg"><img src="images/head_08.jpg" width="13" height="846"></td>
    <td width="184" valign="top">
	
	
	
	
	  	<!--�Ҳ��������-->
	  <jsp:include page="head_right.jsp" flush="true" />
	  
	  
	  
	  </td>
    <td width="122"><img src="images/head_10.jpg" width="122" height="846"></td>
  </tr>
</table>
<!--��ҳβ����-->
<jsp:include page="head_down.jsp" flush="true" />




</body>
</html>
