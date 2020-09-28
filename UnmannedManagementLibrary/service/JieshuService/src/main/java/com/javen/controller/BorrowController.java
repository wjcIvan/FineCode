package com.javen.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.javen.model.Borrow;
import com.javen.service.IBorrowService;

@Controller
@RequestMapping("/borrow")
public class BorrowController {

	@Resource
	private IBorrowService borrowService;

	@RequestMapping(value = "/save", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String save(HttpServletRequest request) {
		JSONObject object = new JSONObject();
		int bid = Integer.parseInt(request.getParameter("bid"));
		int uid = Integer.parseInt(request.getParameter("uid"));
		int statu = Integer.parseInt(request.getParameter("statu"));
		String time = request.getParameter("time");
		Borrow m = new Borrow(-1, bid, uid, statu, time);
		borrowService.save(m);
		object.put("code", "success");
		object.put("msg", "借书成功");

		return object.toString();
	}

	

	@RequestMapping(value = "/updateStatu", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String updateStatu(HttpServletRequest request) {
		JSONObject object = new JSONObject();
		int brid = Integer.parseInt(request.getParameter("brid"));
		int statu = Integer.parseInt(request.getParameter("statu"));
		borrowService.updateStatu(brid, statu);;
		object.put("code", "success");
		object.put("msg", "操作成功");

		return object.toString();
	}
	
	@RequestMapping(value = "/search",  produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String search(HttpServletRequest request) {
		JSONObject object = new JSONObject();
		int statu = Integer.parseInt(request.getParameter("statu"));
		int uid = Integer.parseInt(request.getParameter("uid"));
		List m = borrowService.searchUid(statu,uid);
		if (m.size() == 0) {
			object.put("code", "fail");
			object.put("msg", "暂无数据");
		} else {
			
			object.put("code", "success");
			object.put("msg", "查询成功");
			object.put("data", m);
		}
		return object.toString().toLowerCase();
	}
	
	@RequestMapping(value = "/delete", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String delete(HttpServletRequest request) {
		JSONObject object = new JSONObject();
		int brid = Integer.parseInt(request.getParameter("brid"));
		borrowService.delete(brid);;
		object.put("code", "success");
		object.put("msg", "删除成功");

		return object.toString();
	}
	
	

	

}
