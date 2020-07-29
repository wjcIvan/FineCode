package com.javen.service;  

import java.util.List;

import com.javen.model.User;
  
  
public interface IUserService {  
	
	public void save(User user);
	
	void update(User user);
	
	boolean isCreate(String user);
	
	User login(String user,String pswd);
	
	
	User search(int uid);
	
	List<User> searchAll();
	
	void delete(int uid);
	
	void updateXY(int credit,int uid);
}  