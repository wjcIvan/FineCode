package com.javen.service.impl;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;  
  



import org.springframework.stereotype.Service;

import com.javen.dao.IBookDao;
import com.javen.model.Book;
import com.javen.service.IBookService;
  
  
@Service("bookService")  
public class BookServiceImpl implements IBookService {  
    @Resource  
    private IBookDao bookDao;

	

	public ArrayList<Book> search(int nowsid) {
		// TODO Auto-generated method stub
		return bookDao.search(nowsid);
	}



	public void update(int nowsid, int statu, int bid) {
		bookDao.update(nowsid, statu, bid);
		
	}



	public boolean isJie(int bid) {
		Book bk = bookDao.isJie(bid);
		if(bk.getStatu() == 0) {
			return true;
		}
		return false;
	}



	public ArrayList<Book> searchGJZ(String gjz) {
		// TODO Auto-generated method stub
		return bookDao.searchGJZ(gjz);
	}

	

	

	

	
   
  
}  
