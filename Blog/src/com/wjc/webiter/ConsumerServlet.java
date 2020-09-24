package com.wjc.webiter;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.wjc.dao.ConsumerDao;
import com.wjc.form.ConsumerForm;
import com.wjc.tool.Chinese;

public class ConsumerServlet extends HttpServlet {
	private ConsumerDao consumerDao = null;
	private int method;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		method = Integer.parseInt(request.getParameter("method"));
		if (method == 0) {
			checkConsumer(request, response); // �û���¼����
		}
		if (method == 1) {
			registerConsumer(request, response);// �û�ע�����
		}
		if (method == 2) {
			queryConsumerForm(request, response);// ��̨�����У���һ���û����в�ѯ
		}
		if (method == 3) {
			deleteConsumerForm(request, response);// ��̨�����У����û�����ɾ������
		}
		if (method == 4) {
			queryConsumerHostForm(request, response); // ��̨�����У��Բ����Ĳ�ѯ����
		}
		if (method == 5) {
			updateConsumerHostForm(request, response); // ��̨�����У��Բ�����Ϣ���޸Ĳ���
		}
		if (method == 6) {
			front_updateConsumerForm(request, response); // ǰ̨�����У��û��Ե�¼�ý����޸�
		}

	}

	// ǰ̨�����У��û��Ե�¼�ý����޸�
	public void front_updateConsumerForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		ConsumerForm form = new ConsumerForm();
		consumerDao = new ConsumerDao();
		form.setAccount(Chinese.toChinese(request.getParameter("account")));
		form.setPassword(Chinese.toChinese(request.getParameter("password")));
		form.setName(Chinese.toChinese(request.getParameter("name")));
		form.setSex(Chinese.toChinese(request.getParameter("sex")));
		form.setQQNumber(request.getParameter("QQnumber"));
		form.setMainPage(request.getParameter("mainPage"));
		form.setInterest(Chinese.toChinese(request.getParameter("interest")));
		form.setId(Integer.valueOf(request.getParameter("id")));
		form.setEMail(request.getParameter("eMail"));
		if (consumerDao.front_updateConsumerForm(form)) {
			out
					.print("<script language=javascript>alert('�޸��û��ɹ��������µ�¼��');window.location.href='dealwith.jsp?sign=2';</script>");
		} else {
			out
					.print("<script language=javascript>alert('�޸��û���Ϣʧ�ܣ�');history.go(-1);</script>");
		}

	}

	// ��̨�����У��Բ�����Ϣ���޸Ĳ���
	public void updateConsumerHostForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		ConsumerForm form = new ConsumerForm();
		consumerDao = new ConsumerDao();
		form.setAccount(Chinese.toChinese(request.getParameter("account")));
		form.setPassword(Chinese.toChinese(request.getParameter("password")));
		form.setName(Chinese.toChinese(request.getParameter("name")));
		form.setSex(Chinese.toChinese(request.getParameter("sex")));
		form.setQQNumber(request.getParameter("QQnumber"));
		form.setMainPage(request.getParameter("mainPage"));
		form.setInterest(Chinese.toChinese(request.getParameter("interest")));
		form.setEMail(request.getParameter("eMail"));
		form.setManageLevel("�߼�");
		String result = "�޸Ĳ�����Ϣʧ�ܣ�";

		if (consumerDao.updateConsumerForm(form)) {
			result = "�޸Ĳ�����Ϣ�ɹ���";
		}

		request.setAttribute("result", result);
		request.setAttribute("form", consumerDao.getConsumerForm(form
				.getAccount()));

		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("back_consumerSelectHostForm.jsp");
		requestDispatcher.forward(request, response);
	}

	// ��̨�����У����û�����ɾ������
	public void deleteConsumerForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		String account = Chinese.toChinese(request.getParameter("account"));
		consumerDao = new ConsumerDao();
		PrintWriter out = response.getWriter();
		if (consumerDao.deleteConsumerForm(account)) {
			out
					.print("<script language=javascript>alert('ɾ�����û��ɹ��������½��в�ѯ��');window.location.href='back_consumerSelect.jsp';</script>");
		} else {
			out
					.print("<script language=javascript>alert('ɾ���û���Ϣʧ�ܣ�');history.go(-1);</script>");
		}
	
	}

	// ��̨�����У��Բ����Ĳ�ѯ����
	public void queryConsumerHostForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		consumerDao = new ConsumerDao();
		request.setAttribute("form", consumerDao.getConsumerForm("Ivan"));
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("back_consumerSelectHostForm.jsp");
		requestDispatcher.forward(request, response);

	}

	// ��̨�����У���һ���û����в�ѯ
	public void queryConsumerForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		consumerDao = new ConsumerDao();
		String account = Chinese.toChinese(request.getParameter("account"));
		request.setAttribute("form", consumerDao.getConsumerForm(account));
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("back_consumerSelectForm.jsp");
		requestDispatcher.forward(request, response);
	}

	// �û�ע�����
	public void registerConsumer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		ConsumerForm form = new ConsumerForm();
		consumerDao = new ConsumerDao();
		form.setAccount(Chinese.toChinese(request.getParameter("account")));
		form.setPassword(Chinese.toChinese(request.getParameter("password")));
		form.setName(Chinese.toChinese(request.getParameter("name")));
		form.setSex(Chinese.toChinese(request.getParameter("sex")));
		form.setQQNumber(request.getParameter("QQnumber"));
		form.setMainPage(request.getParameter("mainPage"));
		form.setInterest(Chinese.toChinese(request.getParameter("interest")));
		form.setEMail(request.getParameter("eMail"));
		form.setManageLevel("��ͨ");
		String result = "fail";
		if (consumerDao.getConsumerForm(form.getAccount()) == null) {
			if (consumerDao.addConsumerForm(form)) {
				request.setAttribute("form", consumerDao.getConsumerForm(form
						.getAccount()));
				result = "success";
			}
		}
		request.setAttribute("result", result);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("dealwith.jsp");
		requestDispatcher.forward(request, response);
	}

	// �û���¼����
	public void checkConsumer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String account = request.getParameter("account");
		consumerDao = new ConsumerDao();
		ConsumerForm consumerForm = consumerDao.getConsumerForm(account);
		if (consumerForm == null) {
			request.setAttribute("information", "��������û��������ڣ����������룡");
		} else if (!consumerForm.getPassword().equals(
				request.getParameter("password"))) {
			request.setAttribute("information", "������ĵ�¼�����������������룡");
		} else {

			request.setAttribute("form", consumerForm);
		}
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("dealwith.jsp");
		requestDispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
