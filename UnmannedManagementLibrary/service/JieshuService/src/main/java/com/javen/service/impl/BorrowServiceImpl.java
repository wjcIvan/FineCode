package com.javen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.javen.dao.IBorrowDao;
import com.javen.model.Borrow;
import com.javen.service.IBorrowService;

@Service("borrowService")
public class BorrowServiceImpl implements IBorrowService {

	@Resource
	private IBorrowDao borrowDao;

	public void save(Borrow item) {
		borrowDao.save(item);

	}

	public void updateStatu(int brid, int statu) {
		borrowDao.updateStatu(brid, statu);
		
	}

	public List search(int statu) {
		// TODO Auto-generated method stub
		return borrowDao.search(statu);
	}

	public void delete(int brid) {
		// TODO Auto-generated method stub
		borrowDao.delete(brid);
	}

	public List searchUid(int statu, int uid) {
		// TODO Auto-generated method stub
		return borrowDao.searchUid(statu, uid);
	}

	

}
