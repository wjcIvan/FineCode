<%@ page contentType="text/html; charset=gb2312" language="java"
	import="java.sql.*" errorPage=""%>
<%
	Integer sign = Integer.valueOf(request.getParameter("sign"));
	if (sign == 0) {
		if (request.getAttribute("information") != null) {
	String information = (String) request
	.getAttribute("information");
	out.print("<script language=javascript>alert('"
	+ information + "');history.go(-1);</script>");
		} else {
	session.setAttribute("form", request.getAttribute("form"));
	out
	.print("<script language=javascript>alert('�û���¼�ɹ���');window.location.href='head_main.jsp';</script>");
		}
	}
	if (sign == 1) {
		String result = (String) request.getAttribute("result");
		if (result.equals("success")) {
	session.setAttribute("form", request.getAttribute("form"));
	out
	.print("<script language=javascript>alert('�û�ע��ɹ���');window.location.href='head_main.jsp';</script>");
		}
		if (result.equals("fail")) {
	out
	.print("<script language=javascript>alert('�û�ע��ʧ�ܣ�');history.go(-1);</script>");
		}
	}

	if (sign == 2) {
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
	if (sign == 3) {
		com.wjc.form.VoteForm voteForm = new com.wjc.form.VoteForm();
		com.wjc.dao.VoteDao voteDao = new com.wjc.dao.VoteDao();
		String[] voteID = request.getParameterValues("voteID");
		if (voteID == null) {
	out
	.print("<script language=javascript>alert('�����ͶƱ��');history.go(-1);</script>");
		} else {
	for (int i = 0; i < voteID.length; i++) {
		voteForm.setId(Integer.valueOf(voteID[i]));
		voteDao.operationVote("ͶƱ", voteForm);
		}
		application.setAttribute("vote","voteSuccess");
	out
	.print("<script language=javascript>alert('ͶƱ�ɹ��������²�ѯͶƱ�����');window.location.href='head_VoteQuery.jsp';</script>");
		}

	}

	if (sign == 4) {
	}
%>
