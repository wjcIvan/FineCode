package com.javen.service;

import java.util.ArrayList;

import com.javen.model.Book;

public interface IBookService {
	void update(int nowsid,int statu,int bid);

	ArrayList<Book> search(int nowsid);
	
	boolean isJie(int bid);
	
	ArrayList<Book> searchGJZ(String gjz);

}
