package com.javen.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.javen.model.User;
import com.javen.service.IUserService;
import com.javen.util.Base64Coder;

@RestController
@RequestMapping("/user")
// /user/**
public class UserController {
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	@Resource
	private IUserService userService;

	// /user/test?id=1

	@RequestMapping(value = "/register", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String register(HttpServletRequest request) {
		JSONObject object = new JSONObject();
		String user = request.getParameter("user");
		if (userService.isCreate(user)) {
			object.put("code", "fail");
			object.put("msg", "账号已注册");
		} else {
			String pswd = request.getParameter("pswd");
			String sex = request.getParameter("sex");
			String name = request.getParameter("name");
			String icon = request.getParameter("icon");
			User u = new User(-1, user, pswd, sex, name, icon);
			u.setCredit(0);
			userService.save(u);
			object.put("code", "success");
			object.put("msg", "注册成功");
			log.debug(object.toString());
		}

		return object.toString();
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String login(HttpServletRequest request) {
		JSONObject object = new JSONObject();
		String user = request.getParameter("user");
		String pswd = request.getParameter("pswd");
		User u = userService.login(user, pswd);
		if (u == null) {
			object.put("code", "fail");
			object.put("msg", "账号或密码输入有误");
		} else {

			object.put("code", "success");
			object.put("msg", "登录成功");
			object.put("data", u);
		}
		log.debug(object.toString());

		return object.toString();
	}

	@RequestMapping(value = "/update", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String update(HttpServletRequest request) {
		JSONObject object = new JSONObject();
		String json = request.getParameter("json");
		User u = new Gson().fromJson(json, User.class);
		userService.update(u);
		object.put("code", "success");
		object.put("msg", "编辑成功");
		log.debug(object.toString());

		return object.toString();
	}

	@RequestMapping(value = "/updateXY", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String updateXY(HttpServletRequest request) {
		JSONObject object = new JSONObject();
		int uid = Integer.parseInt(request.getParameter("uid"));
		int credit = Integer.parseInt(request.getParameter("credit"));
		userService.updateXY(credit, uid);
		object.put("code", "success");
		object.put("msg", "编辑成功");
		log.debug(object.toString());

		return object.toString();
	}

	@RequestMapping(value = "/webupdate", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String webupdate(HttpServletRequest request) {
		JSONObject object = new JSONObject();
		int uid = Integer.parseInt(request.getParameter("uid"));
		String user = request.getParameter("user");
		String pswd = request.getParameter("pswd");
		String sex = request.getParameter("sex");
		String name = request.getParameter("name");
		String icon = request.getParameter("icon");
		User u = new User(uid, user, pswd, sex, name, icon);
		userService.update(u);
		object.put("code", "success");
		object.put("msg", "编辑成功");
		log.debug(object.toString());

		return object.toString();
	}

	@RequestMapping(value = "/searchAll", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String searchAll(HttpServletRequest request) {
		JSONObject object = new JSONObject();
		List<User> u = userService.searchAll();
		if (u == null) {
			object.put("code", "fail");
			object.put("msg", "暂无用户");
		} else {
			object.put("code", 0);
			object.put("msg", "查询成功");
			object.put("data", u);
			object.put("count", u.size());
		}
		log.debug(object.toString());

		return object.toString();
	}

	

	@RequestMapping(value = "/delete", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String delete(HttpServletRequest request) {
		JSONObject object = new JSONObject();
		int uid = Integer.parseInt(request.getParameter("uid"));
		userService.delete(uid);
		object.put("code", "success");
		object.put("msg", "删除成功");
		log.debug(object.toString());
		return object.toString();
	}

}