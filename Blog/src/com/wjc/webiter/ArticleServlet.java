package com.wjc.webiter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wjc.dao.ArticleDao;
import com.wjc.dao.ArticleTypeDao;
import com.wjc.dao.RestoreDao;
import com.wjc.form.ArticleForm;
import com.wjc.form.ArticleTypeForm;
import com.wjc.form.RestoreForm;
import com.wjc.tool.Chinese;

public class ArticleServlet extends HttpServlet {

	private ArticleDao articleDao = null;

	private ArticleTypeDao articleTypeDao = null;

	private RestoreDao restoreDao = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int method = Integer.parseInt(request.getParameter("method"));
		if (method == 0) {
			this.addArticleType(request, response);
		}
		if (method == 1) {
			this.deleteArticleType(request, response);
		}
		if (method == 2) {
			this.addArticle(request, response);
		}
		if (method == 3) {
			this.deleteArticle(request, response);
		}
		if (method == 4) {
			this.updateArticle(request, response);
		}
		if (method == 5) {
			this.headAddNumberArticle(request, response);
		}
		if (method == 6) {
			this.deleteRestore(request, response);
		}
		if (method == 7) {
			this.HeadAddRestore(request, response);
		}
	}

	public void HeadAddRestore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		restoreDao = new RestoreDao();
		RestoreForm restoreForm = new RestoreForm();
		restoreForm.setArticleId(Integer.valueOf(request.getParameter("articleId")));
		restoreForm.setReAccount(request.getParameter("accountId"));
		restoreForm.setReTitle(Chinese.toChinese(request.getParameter("reTitle")));
		restoreForm.setReContent(Chinese.toChinese(request.getParameter("reContent")));
		if (restoreDao.operationRestore("���", restoreForm)) {
			out
					.print("<script language=javascript>alert('��ӻظ���Ϣ�ɹ��������²�ѯ��');window.location.href='head_ArticleForm.jsp?id="+request.getParameter("articleId")+"';</script>");
		} else {
			out
					.print("<script language=javascript>alert('��ӻظ���Ϣʧ�ܣ�');history.go(-1);</script>");
		}

	}

	public void deleteRestore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		restoreDao = new RestoreDao();
		RestoreForm restoreForm = new RestoreForm();
		restoreForm.setId(Integer.valueOf(request.getParameter("id")));
	
		if (this.restoreDao.operationRestore("ɾ��", restoreForm)) {
			out
					.print("<script language=javascript>alert('ɾ���ظ��ɹ��������²�ѯ��');window.location.href='back_RestoreSelect.jsp?id="
							+ request.getParameter("idd") + "';</script>");
		} else {
			out
					.print("<script language=javascript>alert('ɾ���ظ�ʧ�ܣ�');history.go(-1);</script>");
		}

	}

	// ���ӷ��ʴ���
	public void headAddNumberArticle(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArticleForm articleForm = new ArticleForm();
		articleDao = new ArticleDao();
		articleForm.setId(Integer.valueOf(request.getParameter("id")));
		articleDao.operationArticle("����", articleForm);
		request.setAttribute("form", articleDao.queryArticleForm(Integer
				.valueOf(request.getParameter("id"))));
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("head_ArticleForm.jsp");
		requestDispatcher.forward(request, response);
	}

	public void updateArticle(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		ArticleForm articleForm = new ArticleForm();
		articleForm.setId(Integer.valueOf(request.getParameter("id")));
		articleForm.setTypeId(Integer.valueOf(request.getParameter("typeId")));
		articleForm.setTitle(Chinese.toChinese(request.getParameter("title")));
		articleForm.setContent(Chinese.toChinese(request
				.getParameter("content")));
		articleDao = new ArticleDao();
		if (articleDao.operationArticle("�޸�", articleForm)) {
			out
					.print("<script language=javascript>alert('�޸����³ɹ��������²�ѯ��');window.location.href='back_ArticleSelect.jsp';</script>");
		} else {
			out
					.print("<script language=javascript>alert('�޸�����ʧ�ܣ�');history.go(-1);</script>");
		}
	}

	// ��̨ɾ������
	public void deleteArticle(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		ArticleForm articleForm = new ArticleForm();
		articleForm.setId(Integer.valueOf(request.getParameter("id")));
		articleDao = new ArticleDao();
		if (articleDao.operationArticle("ɾ��", articleForm)) {
			out
					.print("<script language=javascript>alert('ɾ�����³ɹ��������²�ѯ��');window.location.href='back_ArticleSelect.jsp';</script>");
		} else {
			out
					.print("<script language=javascript>alert('ɾ������ʧ�ܣ�');history.go(-1);</script>");
		}
	}

	// ��̨�������
	public void addArticle(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArticleForm articleForm = new ArticleForm();
		articleForm.setTypeId(Integer.valueOf(request.getParameter("typeId")));
		articleForm.setTitle(Chinese.toChinese(request.getParameter("title")));
		articleForm.setNumber(Integer.valueOf(request.getParameter("number")));
		articleForm.setContent(Chinese.toChinese(request
				.getParameter("content")));
		articleForm
				.setPhTime(Chinese.toChinese(request.getParameter("phTime")));
		articleDao = new ArticleDao();
		String result = "�������ʧ�ܣ�";
		if (articleDao.operationArticle("���", articleForm)) {
			result = "������ӳɹ���";
		}
		request.setAttribute("result", result);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("back_ArticleAdd.jsp");
		requestDispatcher.forward(request, response);
	}

	// ��̨ɾ���������
	public void deleteArticleType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		ArticleTypeForm ArticleTypeForm = new ArticleTypeForm();
		ArticleTypeForm.setId(Integer.valueOf(request.getParameter("id")));
		articleTypeDao = new ArticleTypeDao();
		if (articleTypeDao.operationArticleType("ɾ��", ArticleTypeForm)) {
			out
					.print("<script language=javascript>alert('ɾ���������ɹ��������²�ѯ��');window.location.href='back_ArticleTypeSelect.jsp';</script>");
		} else {
			out
					.print("<script language=javascript>alert('����Ҫ��������ڵ�����ɾ��,�ſ�ɾ�������');history.go(-1);</script>");
		}

	}

	// ��̨����������
	public void addArticleType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		ArticleTypeForm ArticleTypeForm = new ArticleTypeForm();
		ArticleTypeForm.setTypeName(Chinese.toChinese(request
				.getParameter("typeName")));
		ArticleTypeForm.setDescription(Chinese.toChinese(request
				.getParameter("description")));
		articleTypeDao = new ArticleTypeDao();
		if (articleTypeDao.operationArticleType("���", ArticleTypeForm)) {
			out
					.print("<script language=javascript>alert('����������ɹ��������²�ѯ��');window.location.href='back_ArticleTypeSelect.jsp';</script>");
		} else {
			out
					.print("<script language=javascript>alert('����������ʧ�ܣ�');history.go(-1);</script>");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
