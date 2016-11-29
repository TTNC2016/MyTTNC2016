package com.tfarm.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.tfarm.dto.Owner;
import com.tfarm.service.OwnerService;

public class OwnerAction extends ActionSupport {
	private Owner owner;
	private String ownerId;
	private String[] one;

	@Resource
	private OwnerService ownerService;

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String[] getOne() {
		return one;
	}

	public void setOne(String[] one) {
		this.one = one;
	}

	@Action(value = "/ownerAddAction", results = {
			@Result(name = SUCCESS, type = "redirectAction", location = "/ownerFindAll.action"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String add() {
		int flag = this.ownerService.add(owner);
		if (flag == 1) {

			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Action(value = "/ownerFindAll", results = {
			@Result(name = SUCCESS, location = "/owner/list.jsp"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String queryAll() {
		List<Map<String, Object>> list = this.ownerService.queryAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return SUCCESS;
	}

	@Action(value = "/ownerDeleteOne", results = {
			@Result(name = SUCCESS, type = "redirectAction", location = "/ownerFindAll.action"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String deleteOne() {
		int flag = this.ownerService.delete(ownerId);
		if (flag == 1) {

			return SUCCESS;
		} else {
			return ERROR;
		}

	}

	@Action(value = "/ownerUpdateAction", results = {
			@Result(name = SUCCESS, type = "redirectAction", location = "/ownerFindAll.action"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String update() {
		int flag = this.ownerService.modify(owner);
		if (flag == 1) {

			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Action(value = "/ownerFindbyid", results = {
			@Result(name = SUCCESS, location = "/owner/modify.jsp"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String findById() {
		Map<String, Object> owner = this.ownerService.findById(ownerId);
		ServletActionContext.getRequest().setAttribute("map", owner);
		return SUCCESS;
	}
}
