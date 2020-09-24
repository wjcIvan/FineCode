<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<jsp:directive.page import="java.util.List"/>
<jsp:directive.page import="com.wjc.form.ArticleForm"/>
<jsp:directive.page import="com.wjc.form.ArticleTypeForm"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link type="text/css" rel="stylesheet" href="CSS/style.css">
<script language="javascript" type="text/javascript" src="JS/validate.js"></script>
<title>jiahceng's blog</title>
<style type="text/css">
<!--
.style1 {color: #FFCD00}
.style2 {
	color: #a54400;
	font-weight: bold;
}
body {
	background-color: #F0F0F0;
}
.style4 {color: #666666}
-->
</style>
</head>
<jsp:useBean id="pagination" class="com.wjc.tool.MyPagination" scope="session"></jsp:useBean>
<jsp:useBean id="articleDao" class="com.wjc.dao.ArticleDao" scope="session"></jsp:useBean>
<jsp:useBean id="articleTypeDao" class="com.wjc.dao.ArticleTypeDao" scope="session"></jsp:useBean>
<jsp:useBean id="restoreDao" class="com.wjc.dao.RestoreDao" scope="session"></jsp:useBean>

<%
Integer typeId=null;
if(request.getParameter("typeId")!=null){
typeId=Integer.valueOf(request.getParameter("typeId"));
}
String str=(String)request.getParameter("Page");
int Page=1;
List list=null;
if(str==null){
	list=articleDao.queryArticle(typeId);
	int pagesize=9;      //ָ��ÿҳ��ʾ�ļ�¼��
	list=pagination.getInitPage(list,Page,pagesize);     //��ʼ����ҳ��Ϣ
}else{
	Page=pagination.getPage(str);
	list=pagination.getAppointPage(Page);     //��ȡָ��ҳ������
}



%>


<script type="text/javascript">
function deleteForm(id){
if(confirm("ȷ��Ҫɾ����������")){
window.location.href="ArticleServlet?method=3&id="+id;
}
}
</script>





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
		  
		              <%
if(pagination.getRecordSize()<=0){
	out.println("<p align=center><img src=images/icon.gif width=10 height=10>&nbsp;&nbsp;&nbsp;&nbsp;û�����²�ѯ������ˣ�</p>");
	%>
	<%	
}else{
  
		  
		  
		  out.print("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=images/icon.gif width=10 height=10>&nbsp;&nbsp;���²�ѯ</p>");%>
		  
    <table width="500" border="0">
      <tr>
        <td><div align="center">
		    <%
    List articleTypeList=articleTypeDao.queryArticleType();
    for(int i=0;i<articleTypeList.size();i++){
    ArticleTypeForm articleTypeForm=(ArticleTypeForm)articleTypeList.get(i);
    %>
   <a href="back_ArticleSelect.jsp?typeId=<%=articleTypeForm.getId()%>"> [<%=articleTypeForm.getTypeName()%>]</a>&nbsp;
    <%}%>
		
		</div></td>
      </tr>
    </table>
	         <br>             
    <table width="486" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#FECE62">
            <tr>
              <td width="81" height="20"><div align="center">������Ŀ</div></td>
              <td width="73"><div align="center">�������</div></td>
              <td width="142"><div align="center">����ʱ��</div></td>
              <td width="64"><div align="center">�ظ�����</div></td>
              <td width="98"><div align="center">����</div></td>
            </tr>
            
         <%for(int i=0;i<list.size();i++){ 
         ArticleForm articleForm=(ArticleForm)list.get(i);
         %>   
            <tr bgcolor="#FFFFFF">
              <td height="30"><div align="center">
			 <a href="back_RestoreSelect.jsp?id=<%=articleForm.getId()%>" title="���Բ鿴�ظ�����"> <%=articleForm.getTitle()%></a>
			  
			  </div></td>
              <td><div align="center"><%=articleTypeDao.queryArticleTypeName(articleForm.getTypeId())%></div></td>
              <td><div align="center"><%=articleForm.getPhTime()%></div></td>
              <td><div align="center"><%=restoreDao.queryRestore(articleForm.getId()).size()%></div></td>
              <td><div align="center"><A href="back_ArticleUpdate.jsp?id=<%=articleForm.getId()%>">�޸�</A>&nbsp;&nbsp;<a href="javascript:deleteForm('<%=articleForm.getId()%>')">ɾ��</a></div></td>
            </tr>
			<%} %>
          </table>
		  
		  
		 <%=pagination.printCtrl(Page) %>
<%} %>	 
		  
		  
		  
		  </td>
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
