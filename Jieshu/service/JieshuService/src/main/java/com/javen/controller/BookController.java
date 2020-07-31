package com.javen.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.javen.model.Book;
import com.javen.service.IBookService;

@Controller
@RequestMapping("/book")
public class BookController {
	private static Logger log = LoggerFactory.getLogger(BookController.class);
	@Resource
	private IBookService bookService;

	@RequestMapping(value = "/update", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String update(HttpServletRequest request) {
		JSONObject object = new JSONObject();
		int nowsid = Integer.parseInt(request.getParameter("nowsid"));
		int statu = Integer.parseInt(request.getParameter("statu"));
		int bid = Integer.parseInt(request.getParameter("bid"));
		bookService.update(nowsid, statu, bid);
		;
		object.put("code", "success");
		object.put("msg", "编辑成功");
		log.debug(object.toString());

		return object.toString();
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String searchAll(HttpServletRequest request) {
		int nowsid = Integer.parseInt(request.getParameter("nowsid"));
		JSONObject object = new JSONObject();
		List<Book> m = bookService.search(nowsid);
		if (m.size() == 0) {
			object.put("code", "fail");
			object.put("msg", "暂无数据");
		} else {

			object.put("code", "success");
			object.put("msg", "查询成功");
			object.put("data", m);
		}
		log.debug(object.toString());
		return object.toString();
	}
	@RequestMapping(value = "/searchGJZ", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String searchGJZ(HttpServletRequest request) {
		String gjz = request.getParameter("gjz");
		JSONObject object = new JSONObject();
		List<Book> m = bookService.searchGJZ(gjz);
		if (m.size() == 0) {
			object.put("code", "fail");
			object.put("msg", "暂无数据");
		} else {
			
			object.put("code", "success");
			object.put("msg", "查询成功");
			object.put("data", m);
		}
		log.debug(object.toString());
		return object.toString();
	}

	@RequestMapping(value = "/isjie", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String isjie(HttpServletRequest request) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		JSONObject object = new JSONObject();
		if (!bookService.isJie(bid)) {
			object.put("code", "fail");
			object.put("msg", "已被借");
		} else {

			object.put("code", "success");
			object.put("msg", "查询成功");
		}
		log.debug(object.toString());
		return object.toString();
	}

	
	
}
