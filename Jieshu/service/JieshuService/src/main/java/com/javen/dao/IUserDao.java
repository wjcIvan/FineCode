package com.javen.dao;

import java.util.List;

import com.javen.model.User;

public interface IUserDao {

	void save(User user);
	
	void update(User user);
	
	void updateXY(int credit,int uid);

	User searchUid(String user);
	
	User searchUid2(int uid);
	
	List<User> searchAll();
	
	User login(String user,String pswd);
	
	void delete(int uid);
	
	
}