package com.tfarm.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.tfarm.dto.SmallClassfy;
import com.tfarm.service.SmallClassfyService;

public class SmallClassfyAction extends ActionSupport {
	private SmallClassfy sclassfy;
	private String sclassId;
	private String[] one;

	@Resource
	private SmallClassfyService sclassService;

	public SmallClassfy getSclassfy() {
		return sclassfy;
	}

	public void setSclassfy(SmallClassfy sclassfy) {
		this.sclassfy = sclassfy;
	}

	public String getSclassId() {
		return sclassId;
	}

	public void setSclassId(String sclassId) {
		this.sclassId = sclassId;
	}

	public String[] getOne() {
		return one;
	}

	public void setOne(String[] one) {
		this.one = one;
	}

	@Action(value = "/sclassfindBigClassAction", results = {
			@Result(name = SUCCESS, location = "/smallclassfy/add.jsp"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String queryBigClassfy() {
		List<Map<String, Object>> list = this.sclassService.queryBigClassfy();
		System.out.println(list);
		ServletActionContext.getRequest().setAttribute("list", list);
		return SUCCESS;
	}

	@Action(value = "/sclassAddAction", results = {
			@Result(name = SUCCESS, type = "redirectAction", location = "/sclassfyAll.action"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String add() {
		int flag = this.sclassService.add(sclassfy);
		if (flag == 1) {

			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Action(value = "/sclassfyAll", results = {
			@Result(name = SUCCESS, location = "/smallclassfy/list.jsp"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String queryAll() {
		List<Map<String, Object>> list = this.sclassService.queryAll();
		System.out.println(list);
		ServletActionContext.getRequest().setAttribute("list", list);
		return SUCCESS;
	}

	@Action(value = "/sclassfydeleteOne", results = {
			@Result(name = SUCCESS, type = "redirectAction", location = "/sclassfyAll.action"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String deleteOne() {
		int flag = this.sclassService.delete(sclassId);
		if (flag == 1) {

			return SUCCESS;
		} else {
			return ERROR;
		}

	}

	@Action(value = "/sclassfydeleteAll", results = {
			@Result(name = SUCCESS, type = "redirectAction", location = "/sclassfyAll.action"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String deleteAll() {
		int flag = this.sclassService.deleteAll(one);
		if (flag == 1) {

			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Action(value = "/sclassfyUpdateAction", results = {
			@Result(name = SUCCESS, type = "redirectAction", location = "/sclassfyAll.action"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String update() {
		int flag = this.sclassService.modify(sclassfy);
		if (flag == 1) {

			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Action(value = "/sclassfyfindbyid", results = {
			@Result(name = SUCCESS, location = "/smallclassfy/modify.jsp"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String findById() {
		Map<String, Object> blcassfy = this.sclassService.findById(sclassId);
		List<Map<String, Object>> list = this.sclassService.queryBigClassfy();
		ServletActionContext.getRequest().setAttribute("list", list);
		ServletActionContext.getRequest().setAttribute("map", blcassfy);
		return SUCCESS;
	}
}
