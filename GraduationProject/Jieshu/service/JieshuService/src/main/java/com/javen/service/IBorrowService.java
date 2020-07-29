package com.javen.service;

import java.util.List;

import com.javen.model.Borrow;

public interface IBorrowService {

	void save(Borrow item);
	
	List search(int statu);
	List searchUid(int statu,int uid);
	void updateStatu(int brid,int statu);
	
	void delete(int brid);
}
