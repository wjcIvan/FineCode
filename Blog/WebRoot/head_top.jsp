<%@ page contentType="text/html; charset=gb2312" language="java"
	import="java.sql.*" errorPage=""%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>jiahceng's blog</title>
<style type="text/css">
<!--
.style1 {
	color: #c97802
}

.style2 {
	color: #976600
}
-->
</style>
</head>



<%
	//�жϷ�����form�Ƿ����
	if (session.getAttribute("form") == null) {
		out.print("<script language=javascript>alert('���Ѿ���������Ͽ��������µ�¼��');window.location.href='index.jsp';</script>");
	}
	//��ҳ������
	Integer number = 1;
	if (application.getAttribute("number") != null) {
		number = (Integer) application.getAttribute("number");
		number++;
	}
	application.setAttribute("number", number);
	//������Ϣ
	com.wjc.dao.ConsumerDao consumerDao = new com.wjc.dao.ConsumerDao();
	com.wjc.form.ConsumerForm consumerForm1 = (com.wjc.form.ConsumerForm) session
	.getAttribute("form");
	java.util.List consumerlist = consumerDao.getConsumerList("�߼�");
	//����������Ӧ��
%>


<script language="javascript" src="JS/validate.js"></script>
<body>



	<!--ҳ��ͷ����1-->
	<!--ҳ��ͷ����2-->
	<!--ҳ��ͷ����3-->
	<table width="100" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><img src="images/head_03.jpg" width="800">
			</td>
		</tr>
	</table>
	<!--ҳ��ͷ����4-->
	<table width="800" height="71" border="0" align="center" cellpadding="0" cellspacing="0" background="images/head_04.jpg">
		<tr>
			<td width="31">&nbsp;</td>
			<td width="640"><table width="619" border="0" align="center" cellpadding="0" cellspacing="0">
					<%
						for (int host = 0; host < consumerlist.size(); host++) {
																com.wjc.form.ConsumerForm consumerHostForm = (com.wjc.form.ConsumerForm) consumerlist
																		.get(host);
					%>
					<tr>
						<td height="20"><span class="style1">������Ϣ&nbsp;��<a
								href="dealwith.jsp?sign=2">���µ�¼</a>��</span>
						</td>
						<td colspan="2">
							<%
								if (consumerForm1.getManageLevel().equals("�߼�")) {
							%>
							<div align="right">
								<span class="style2">��</span><a href="backMainPage.jsp"
									class="in">�����̨</a><span class="style2">��</span>
							</div> <%
 	}
 %>
						</td>
					</tr>
					<tr>
						<td height="20"><span class="style3 style2">������<%=consumerHostForm.getName()%></span>
						</td>
						<td width="212"><span class="style3 style2">�Ա�<%=consumerHostForm.getSex()%></span>
						</td>
						<td width="195"><span class="style3 style2">��Ȥ��<%=consumerHostForm.getInterest()%></span>
						</td>
					</tr>
					<tr>
						<td height="20"><span class="style3 style2">QQ���룺<%=consumerHostForm.getQQNumber()%></span>
						</td>
						<td><span class="style3 style2">E-Mail��<%=consumerHostForm.getEMail()%></span>
						</td>
						<td><span class="style3 style2">��ҳ��<%=consumerHostForm.getMainPage()%></span>
						</td>
					</tr>
					<%
						}
					%>
				</table>
			</td>
			<td width="129">&nbsp;</td>
		</tr>
	</table>
	<!--ҳ��ͷ����5-->
	<table width="800" height="26" border="0" align="center"
		cellpadding="0" cellspacing="0" background="images/head_05.jpg">
		<tr>
			<td width="37">&nbsp;</td>
			<td width="626"><marquee direction="left" scrollAmount="1"
					scrollDelay="1" class="tdtd">
					<span class="style4 style1">����jiacheng��һ���򵥵ĸ��˲�����վ</span>
				</marquee></td>
			<td width="137">&nbsp;</td>
		</tr>
	</table>















</body>
</html>
