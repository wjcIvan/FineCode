package com.javen.dao;

import java.util.List;

import com.javen.model.Borrow;

public interface IBorrowDao {

	void save(Borrow item);
	
	
	
	void updateStatu(int brid,int statu);
	
	List search(int statu);
	List searchUid(int statu,int uid);
	void delete(int brid);

}
