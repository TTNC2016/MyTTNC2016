package com.tfarm.dto;

import java.sql.Timestamp;

/**
 * Title: Department Description: 部门信息
 * 
 * @author lanli
 * @date 2016-11-29 下午1:46:31
 */
public class Department {
	/**
	 * 部门编号
	 */
	private String departId;
	/**
	 * 部门名称
	 */
	private String departName;
	/**
	 * 添加时间
	 */
	private Timestamp createTime;
	/**
	 * 最后一次修改时间
	 */
	private Timestamp modifyTime;

	public String getDepartId() {
		return departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

}
