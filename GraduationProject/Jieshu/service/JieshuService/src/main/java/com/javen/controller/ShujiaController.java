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
import com.javen.model.Shujia;
import com.javen.service.IShujiaService;
import com.javen.service.IBookService;

@Controller
@RequestMapping("/shujia")
public class ShujiaController {
	private static Logger log = LoggerFactory.getLogger(ShujiaController.class);
	@Resource
	private IShujiaService shujiaService;

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String searchAll(HttpServletRequest request) {
		JSONObject object = new JSONObject();
		List<Shujia> m = shujiaService.search();
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

	@RequestMapping(value = "/searchsid", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String searchsid(HttpServletRequest request) {
		JSONObject object = new JSONObject();
		int sid = Integer.parseInt(request.getParameter("sid"));
		Shujia m = shujiaService.searchsid(sid);
		if (m == null) {
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

}
