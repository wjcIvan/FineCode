package com.wjc.webiter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wjc.dao.VoteDao;
import com.wjc.form.VoteForm;
import com.wjc.tool.Chinese;

public class VoteServlet extends HttpServlet {

	private VoteDao voteDao = null;

	private int method;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.method = Integer.parseInt(request.getParameter("method"));
		if (method == 0) {
			this.addVote(request, response);
		}
		if (method == 1) {
			this.deleteVote(request, response);
		}
	}



	// ��̨-ɾ��ͶƱ����
	public void deleteVote(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		VoteForm voteForm = new VoteForm();
		voteDao = new VoteDao();
		voteForm.setId(Integer.valueOf(request.getParameter("id")));
		if (voteDao.operationVote("ɾ��", voteForm)) {
			out
					.print("<script language=javascript>alert('ɾ����ͶƱ���ݳɹ��������½��в�ѯ��');window.location.href='back_VoteSelect.jsp';</script>");
		} else {
			out
					.print("<script language=javascript>alert('ɾ����ͶƱ����ʧ�ܣ�');history.go(-1);</script>");
		}
	}

	// ��̨�����ͶƱ����
	public void addVote(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VoteForm voteForm = new VoteForm();
		voteDao = new VoteDao();
		voteForm.setVoteName(Chinese
				.toChinese(request.getParameter("voteName")));
		voteForm.setVoteNumber(0);
		String result = "���ͶƱ����ʧ��!";
		if (voteDao.operationVote("���", voteForm)) {
			result = "���ͶƱ���ݳɹ�!";
		}
		request.setAttribute("result", result);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("back_VoteAdd.jsp");
		requestDispatcher.forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
