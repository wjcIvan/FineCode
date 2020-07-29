package com.javen.service;

import java.util.ArrayList;

import com.javen.model.Shujia;

public interface IShujiaService {
	void save(Shujia item);

	void update(Shujia item);

	ArrayList<Shujia> search();

	void delete(int sid);
	
	Shujia searchsid(int sid);

}
