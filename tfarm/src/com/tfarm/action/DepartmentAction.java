package com.tfarm.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.tfarm.dto.Department;
import com.tfarm.service.DepartmentService;

public class DepartmentAction extends ActionSupport {
	private Department depart;
	private String departId;
	private String[] one;

	@Resource
	private DepartmentService departService;

	public Department getDepart() {
		return depart;
	}

	public void setDepart(Department depart) {
		this.depart = depart;
	}

	public String getDepartId() {
		return departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
	}

	public String[] getOne() {
		return one;
	}

	public void setOne(String[] one) {
		this.one = one;
	}

	@Action(value = "/departAddAction", results = {
			@Result(name = SUCCESS, type = "redirectAction", location = "/departFindAll.action"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String add() {
		int flag = this.departService.add(depart);
		if (flag == 1) {

			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Action(value = "/departFindAll", results = {
			@Result(name = SUCCESS, location = "/department/list.jsp"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String queryAll() {
		List<Map<String, Object>> list = this.departService.queryAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return SUCCESS;
	}

	@Action(value = "/departDeleteOne", results = {
			@Result(name = SUCCESS, type = "redirectAction", location = "/departFindAll.action"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String deleteOne() {
		int flag = this.departService.delete(departId);
		if (flag == 1) {

			return SUCCESS;
		} else {
			return ERROR;
		}

	}

	@Action(value = "/departUpdateAction", results = {
			@Result(name = SUCCESS, type = "redirectAction", location = "/departFindAll.action"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String update() {
		int flag = this.departService.modify(depart);
		if (flag == 1) {

			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Action(value = "/departFindById", results = {
			@Result(name = SUCCESS, location = "/department/modify.jsp"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String findById() {
		Map<String, Object> depart = this.departService.findById(departId);
		ServletActionContext.getRequest().setAttribute("map", depart);
		return SUCCESS;
	}
}
