package com.imooc.employee.action;

import com.imooc.employee.domain.Department;
import com.imooc.employee.domain.PageBean;
import com.imooc.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	
	private Department department = new Department();
	@Override
	public Department getModel() {
		
		return department;
	}
	
	private Integer currPage = 1;
	
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	public String findAll(){
		
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
		
	}
	
	public String saveUI(){
		return "saveUI";
	}
	
	public String save(){
		departmentService.save(department);
		return "saveSuccess";
	}
	
	public String edit(){
		
		department = departmentService.findById(department.getDid());
		return "editSuccess";
	}
	
	public String update(){
		
		departmentService.update(department);
		return "updateSuccess";
	}
	
	
	public String delete(){
		
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}

}
