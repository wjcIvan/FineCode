package com.javen.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.javen.dao.IShujiaDao;
import com.javen.model.Shujia;
import com.javen.service.IShujiaService;

@Service("shujiaService")
public class ShujiaServiceImpl implements IShujiaService {
	@Resource
	private IShujiaDao shujiaDao;

	public void save(Shujia item) {
		shujiaDao.save(item);

	}

	public void update(Shujia item) {
		shujiaDao.update(item);

	}

	public ArrayList<Shujia> search() {
		// TODO Auto-generated method stub
		return shujiaDao.search();
	}

	public void delete(int mid) {
		shujiaDao.delete(mid);
	}

	public Shujia searchsid(int sid) {
		// TODO Auto-generated method stub
		return shujiaDao.searchsid(sid);
	}

}
