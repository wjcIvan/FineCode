package com.imooc.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.imooc.employee.dao.DepartmentDao;
import com.imooc.employee.domain.Department;
import com.imooc.employee.domain.PageBean;
import com.imooc.employee.service.DepartmentService;


@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	
	
	private DepartmentDao departmentDao;
	
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}



	@Override
	public PageBean<Department> findByPage(Integer currPage) {
		
		PageBean<Department> pageBean = new PageBean<Department>();
		pageBean.setCurrPage(currPage);
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		int begin = (currPage -1)* pageSize;
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		
		
		return pageBean;
	}


	@Override
	public void save(Department department) {
		
		departmentDao.save(department);
		
	}


	@Override
	public Department findById(int did) {
		
		
		return departmentDao.finById(did);
	}


	@Override
	public void update(Department department) {
		
		departmentDao.update(department);
		
	}


	@Override
	public void delete(Department department) {

		departmentDao.delete(department);
	}


	@Override
	public List<Department> findAll() {
		
		return departmentDao.findAll();
	}
	

}
