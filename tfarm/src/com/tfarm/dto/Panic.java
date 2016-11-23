package com.tfarm.dto;

import java.util.Date;

/**
 * Title:Panic Description: Company:
 * 
 * @author lanli
 * @date 2016-11-23 下午4:43:31
 */
public class Panic {
	/**
	 * @description 抢购编号
	 */
	private String panId;
	/**
	 * @description 抢购产品主表编号
	 */
	private String proId;
	/**
	 * @description 开始时间
	 */
	private Date startTime;

	public String getPanId() {
		return panId;
	}

	public void setPanId(String panId) {
		this.panId = panId;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

}
