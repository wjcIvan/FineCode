<%@ page contentType="text/html; charset=gb2312" language="java"
	import="java.sql.*" errorPage=""%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>jiahceng's blog</title>
<link href="CSS/style.css" type="text/css" rel="stylesheet">
<script src="JS/validate.js" language="javascript"
	type="text/javascript"></script>
<style type="text/css">
<!--
body {
	background-image: url(images/bg_01.gif);
}
-->
</style>
</head>
<body onselectstart="return false">
	<table width="800" height="496" border="0" align="center"
		cellpadding="0" cellspacing="0" background="images/login.jpg">
		<tr>
			<td valign="top"><table width="658" border="0">
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td width="92" height="358">&nbsp;</td>
						<td width="550" valign="bottom">
							<form name="form1" method="post"
								action="ConsumerServlet?method=0&sign=0"
								onSubmit="return userCheck()">
								<table width="291" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="66" height="30">�û�����</td>
										<td width="225"><input name="account" type="text"
											class="inputinput" id="account" size="30"></td>
									</tr>
									<tr>
										<td height="30">��&nbsp;&nbsp;�룺</td>
										<td><input name="password" type="password"
											class="inputinput" id="password" size="30">
										</td>
									</tr>
									<tr>
										<td height="30" colspan="2" align="center"><input
											type="image" class="inputinputinput" src="images/land.gif">
											&nbsp;&nbsp; <a href="#" onClick="javascript:form1.reset()"><img
												src="images/reset.gif"> </a> &nbsp;&nbsp; <a
											href="consumer/accountAdd.jsp"><img
												src="images/register.gif"> </a></td>
									</tr>
								</table>
							</form></td>
					</tr>
				</table></td>
		</tr>
	</table>

</body>
</html>
