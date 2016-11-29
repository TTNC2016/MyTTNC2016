package com.tfarm.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.tfarm.dto.BigClassfy;
import com.tfarm.service.BigClassfyService;

public class BigClassfyAction extends ActionSupport {
	private BigClassfy bclassfy;
	private String bclassId;
	private String[] one;

	public String getBclassId() {
		return bclassId;
	}

	public void setBclassId(String bclassId) {
		this.bclassId = bclassId;
	}

	public String[] getOne() {
		return one;
	}

	public void setOne(String[] one) {
		this.one = one;
	}

	public void setBclassfy(BigClassfy bclassfy) {
		this.bclassfy = bclassfy;
	}

	public BigClassfy getBclassfy() {
		return bclassfy;
	}

	@Resource
	private BigClassfyService bclassService;

	@Action(value = "/bclassAddAction", results = {
			@Result(name = SUCCESS, type = "redirectAction", location = "/bclassfyAll.action"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String add() {
		int flag = this.bclassService.add(bclassfy);
		if (flag == 1) {

			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Action(value = "/bclassfyAll", results = {
			@Result(name = SUCCESS, location = "/bigclassfy/list.jsp"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String queryAll() {
		List<Map<String, Object>> list = this.bclassService.queryAll();
		System.out.println(list);
		ServletActionContext.getRequest().setAttribute("list", list);
		return SUCCESS;
	}

	@Action(value = "/deleteOne", results = {
			@Result(name = SUCCESS, type = "redirectAction", location = "/bclassfyAll.action"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String deleteOne() {
		System.out.println(bclassId);
		int flag = this.bclassService.delete(bclassId);
		if (flag == 1) {

			return SUCCESS;
		} else {
			return ERROR;
		}

	}

	@Action(value = "/deleteAll", results = {
			@Result(name = SUCCESS, type = "redirectAction", location = "/bclassfyAll.action"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String deleteAll() {
		int flag = this.bclassService.deleteAll(one);
		if (flag == 1) {

			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Action(value = "/bclassUpdateAction", results = {
			@Result(name = SUCCESS, type = "redirectAction", location = "/bclassfyAll.action"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String update() {
		int flag = this.bclassService.modify(bclassfy);
		if (flag == 1) {

			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Action(value = "/findbyid", results = {
			@Result(name = SUCCESS, location = "/bigclassfy/modify.jsp"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String findById() {
		Map<String, Object> blcassfy = this.bclassService.findById(bclassId);
		System.out.println(blcassfy);
		ServletActionContext.getRequest().setAttribute("map", blcassfy);
		return SUCCESS;
	}
}
