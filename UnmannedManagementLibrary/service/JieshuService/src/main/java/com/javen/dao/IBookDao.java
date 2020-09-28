package com.javen.dao;

import java.util.ArrayList;


import com.javen.model.Book;
public interface IBookDao {
	
	
	
	void update(int nowsid,int statu,int bid);
	
	Book isJie(int bid);

	ArrayList<Book> search(int nowsid);
	
	ArrayList<Book> searchGJZ(String gjz);

}
