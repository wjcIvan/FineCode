package com.imooc.employee.action;

import java.util.List;

import com.imooc.employee.domain.Department;
import com.imooc.employee.domain.Employee;
import com.imooc.employee.domain.PageBean;
import com.imooc.employee.service.DepartmentService;
import com.imooc.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	private static final long serialVersionUID = 1L;
	
	private Employee employee = new Employee();
	
	@Override
	public Employee getModel() {
		return employee;
	}
	
	
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	
	
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}


	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	private int currPage = 1;

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public String login(){
		
		System.out.println("login......");
		
		Employee existEmployee =  employeeService.login(employee);
		if(existEmployee == null){
			this.addActionError("用户名或密码错误!");
			return INPUT;
		}else{
			
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
		
		
		
	}
	
	
	public String findAll(){
		PageBean<Employee> pageBean= employeeService.finByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	public String saveUI(){
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	
	public String save(){
		employeeService.save(employee);
		return "saveSuccess";
	}
	
	public String edit(){
		
		employee = employeeService.findById(employee.getEid());
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	
	public String update(){
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	public String delete(){
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
}
