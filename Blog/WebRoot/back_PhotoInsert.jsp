<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<jsp:directive.page import="java.util.List"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link type="text/css" rel="stylesheet" href="CSS/style.css">
<script language="javascript" type="text/javascript" src="JS/validate.js"></script>
<title>jiahceng's blog</title>
<style type="text/css">
<!--
body {
	background-color: #F0F0F0;
}
.style1 {
	color: #FF0000;
	font-weight: bold;
}
.style2 {
	color: #a54400;
	font-weight: bold;
}
-->
</style>
</head>



<jsp:useBean id="countTime" scope="page" class="com.wjc.tool.CountTime"></jsp:useBean>


<body>
<jsp:include page="back_Top.jsp" flush="true" />
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0" background="images/back1.gif">
  <tr>
    <td width="227" valign="top"><jsp:include page="back_Left.jsp" flush="true" /></td>
    <td width="573" valign="top"><table width="227" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td><img src="images/back_noword_03.jpg" width="573" height="25"></td>
      </tr>
    </table>
      <table width="573" border="0" cellpadding="0" cellspacing="0" background="images/back_noword_05.jpg">
        <tr>
          <td valign="top" align="center">		
		  
		  <%out.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=images/icon.gif width=10 height=10>&nbsp;&nbsp;��Ƭ�ϴ�</p>");%>
		  <form action="PhotoSerlvet?method=0" method="post"  name="form" onSubmit="return addPhoto()" enctype="multipart/form-data">
		  
            <table width="340" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#FECE62">
              <tr>
                <td width="72" height="30"><div align="center">�ϴ���ַ��</div></td>
                <td width="255" bgcolor="#FFFFFF">
                    <div align="left">
                      <input name="photoAddress" type="file" class="inputinput"  size="30">
                  </div></td></tr>
              <tr>
                <td height="30"><div align="center">��Ƭ������</div></td>
                <td bgcolor="#FFFFFF">
                    <div align="left">
                      <input name="photoDescription" type="text" class="inputinput"  size="30">
                  </div></td></tr>
              <tr>
                <td height="30"><div align="center">�ϴ�ʱ�䣺</div></td>
                <td bgcolor="#FFFFFF">
                  <div align="left">
                     <input name="phtoTime" type="text" class="inputinput" onclick="alert('���ı�������Ϊֻ�����û������޸�')" value="<%=countTime.currentlyTime() %>" size="30" readonly="readonly">
                  </div></td></tr>
            </table>
            <table width="494" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="494">
				<br>
				<div align="center" class="style1">ע�⣺ͼƬ�ĸ�ʽֻ��Ϊ����JPG��,��jpg��,��gif��,��bmp��,��BMP����ʽ</div></td>
              </tr>
            </table>
            <br>
 <input type="image" class="inputinputinput" src="images/save.gif">
&nbsp;&nbsp;
 <a href="#" onClick="javascript:form.reset()"><img src="images/reset.gif"></a>
            </form>
			
			<%if(request.getAttribute("result")!=null){
			out.print(request.getAttribute("result"));
			} %></td>
        </tr>
      </table>
      <table width="227" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td><img src="images/back_noword_18.jpg" width="573" height="21"></td>
        </tr>
      </table></td>
  </tr>
</table>
<jsp:include page="back_Down.jsp" flush="true" />
</body>
</html>
