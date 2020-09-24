package com.wjc.webiter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.wjc.dao.PhotoDao;
import com.wjc.form.PhotoForm;

public class PhotoSerlvet extends HttpServlet {

	private int method;

	private PhotoDao photoDao = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.method = Integer.parseInt(request.getParameter("method"));
		if (method == 0) {
			this.addPhoto(request, response); // �ϴ�ͼƬ
		}
		if (method == 1) {
			this.deletePhoto(request, response); // ɾ��ͼƬ
		}

	}

	// ɾ��ͼƬ
	public void deletePhoto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		photoDao = new PhotoDao();
		Integer id = Integer.valueOf(request.getParameter("id"));
		String photoDir = request.getRealPath(photoDao.queryPhoto(id)
				.getPhotoAddress());
		java.io.File file = new java.io.File(photoDir);
		PhotoForm photoForm = new PhotoForm();
		photoForm.setId(id);
		if (photoDao.operationPhoto("ɾ��", photoForm)) {
			file.delete();
			out
					.print("<script language=javascript>alert('ɾ��ͼƬ�ɹ��������²�ѯ��');window.location.href='back_PhotoSelect.jsp';</script>");
		} else {
			out
					.print("<script language=javascript>alert('�޸��û���Ϣʧ�ܣ�');history.go(-1);</script>");
		}

	}

	public void addPhoto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		photoDao = new PhotoDao();
		PhotoForm photoForm = new PhotoForm();
		com.jspsmart.upload.SmartUpload su = new com.jspsmart.upload.SmartUpload();

		Integer maxID = 0;
		if (photoDao.MaxQueryID() != null) {
			maxID = photoDao.MaxQueryID();
		}
		String result = "�ϴ�����Ƭ��ʽ�ʹ�С������,�ϴ���Ƭʧ��!";
		String type = null;
		String imageType[] = { "JPG", "jpg", "gif", "bmp", "BMP" };
		String filedir = "file/";
		long maxsize = 2 * 1024 * 1024;
		try {
			su.initialize(this.getServletConfig(), request, response);
			su.setMaxFileSize(maxsize);
			su.upload(); // �ϴ��ļ�
			Files files = su.getFiles();
			for (int i = 0; i < files.getCount(); i++) { 
				File singlefile = files.getFile(i);
				type = singlefile.getFileExt();

				for (int ii = 0; ii < imageType.length; ii++) {
					if (imageType[ii].equals(type)) {
						if (!singlefile.isMissing()) { // ���ѡ�����ļ�
							String photoTime = su.getRequest().getParameter(
									"phtoTime");
							String photoDescription = su.getRequest()
									.getParameter("photoDescription");

							photoForm.setPhtoTime(photoTime);

							photoForm.setPhotoDescription(photoDescription);
							filedir = filedir + maxID + "."
									+ singlefile.getFileExt();
							photoForm.setPhotoAddress(filedir);
							if (photoDao.operationPhoto("���", photoForm)) {
								singlefile.saveAs(filedir, File.SAVEAS_VIRTUAL);
								result = "�ϴ���Ƭ�ɹ�!";
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("result", result);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("back_PhotoInsert.jsp");
		requestDispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
