package com.tfarm.dto;

import java.sql.Timestamp;

/**
 * Title:BigClassfy Description: Company:
 * 
 * @author lanli
 * @date 2016-11-23 下午3:28:42
 */
public class BigClassfy {

	/**
	 * @description 大分类编号
	 */
	private String bclassId;

	/**
	 * @description 大分类名称
	 */
	private String bclassName;

	/**
	 * @description 备用字段
	 */
	private String bclassBak;

	private Timestamp createTime;

	private Timestamp modifyTime;

	public String getBclassId() {
		return this.bclassId;
	}

	public void setBclassId(String bclassId) {
		this.bclassId = bclassId;
	}

	public String getBclassName() {
		return bclassName;
	}

	public void setBclassName(String bclassName) {
		this.bclassName = bclassName;
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

	public String getBclassBak() {
		return bclassBak;
	}

	public void setBclassBak(String bclassBak) {
		this.bclassBak = bclassBak;
	}

}
