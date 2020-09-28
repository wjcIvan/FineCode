package com.javen.dao;

import java.util.ArrayList;

import com.javen.model.Shujia;
public interface IShujiaDao {
	
	void save(Shujia item);
	
	void update(Shujia item);

	ArrayList<Shujia> search();
	Shujia searchsid(int sid);
	
	void delete(int sid);

}
