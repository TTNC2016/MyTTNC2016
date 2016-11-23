package com.tfarm.dto;

import java.util.Date;

/**
 * Title:Reserve Description: Company:
 * 
 * @author lanli
 * @date 2016-11-23 下午4:46:25
 */
public class Reserve {
	/**
	 * @description 預定編號
	 */

	private String resId;
	/**
	 * @description 預定產品主表編號
	 */
	private String proId;
	/**
	 * @description 預定開始時間
	 */
	private Date resStartTime;
	/**
	 * @description 預定結束時間
	 */
	private Date resEndTime;
	
	/**
	 * @description 預定類別
	 */
	private int resMode;

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public Date getResStartTime() {
		return resStartTime;
	}

	public void setResStartTime(Date resStartTime) {
		this.resStartTime = resStartTime;
	}

	public Date getResEndTime() {
		return resEndTime;
	}

	public void setResEndTime(Date resEndTime) {
		this.resEndTime = resEndTime;
	}

	public int getResMode() {
		return resMode;
	}

	public void setResMode(int resMode) {
		this.resMode = resMode;
	}

}
