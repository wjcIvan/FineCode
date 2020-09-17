package com.imooc.employee.service;

import com.imooc.employee.domain.Employee;
import com.imooc.employee.domain.PageBean;


public interface EmployeeService {
	
	Employee login(Employee employee);

	PageBean<Employee> finByPage(int currPage);

	void save(Employee employee);

	Employee findById(int eid);

	void update(Employee employee);

	void delete(Employee employee);



}
