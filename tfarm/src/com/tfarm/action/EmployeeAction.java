package com.tfarm.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.tfarm.dto.Employee;
import com.tfarm.service.EmployeeService;

public class EmployeeAction extends ActionSupport {
	private Employee emp;
	private String empId;
	private String[] one;

	@Resource
	private EmployeeService empService;

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String[] getOne() {
		return one;
	}

	public void setOne(String[] one) {
		this.one = one;
	}

	@Action(value = "/empAddAction", results = {
			@Result(name = SUCCESS, type = "redirectAction", location = "/empFindAll.action"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String add() {
		int flag = this.empService.add(emp);
		if (flag == 1) {

			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Action(value = "/empFindAll", results = {
			@Result(name = SUCCESS, location = "/employee/list.jsp"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String queryAll() {
		List<Map<String, Object>> list = this.empService.queryAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return SUCCESS;
	}

	@Action(value = "/empDeleteOne", results = {
			@Result(name = SUCCESS, type = "redirectAction", location = "/empFindAll.action"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String deleteOne() {
		int flag = this.empService.delete(empId);
		if (flag == 1) {

			return SUCCESS;
		} else {
			return ERROR;
		}

	}

	@Action(value = "/empUpdateAction", results = {
			@Result(name = SUCCESS, type = "redirectAction", location = "/empFindAll.action"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String update() {
		int flag = this.empService.modify(emp);
		if (flag == 1) {

			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Action(value = "/empFindById", results = {
			@Result(name = SUCCESS, location = "/employee/modify.jsp"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String findById() {
		Map<String, Object> emp = this.empService.findById(empId);
		ServletActionContext.getRequest().setAttribute("map", emp);
		List<Map<String, Object>> list = this.empService.empFindDepart();
		ServletActionContext.getRequest().setAttribute("list", list);
		return SUCCESS;
	}

	@Action(value = "/empFindDepart", results = {
			@Result(name = SUCCESS, location = "/employee/add.jsp"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String empFindDepart() {
		List<Map<String, Object>> list = this.empService.empFindDepart();
		ServletActionContext.getRequest().setAttribute("list", list);
		return SUCCESS;
	}
}
