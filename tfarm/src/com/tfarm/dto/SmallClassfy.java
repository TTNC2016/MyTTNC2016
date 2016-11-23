package com.tfarm.dto;

/**
 * Title:SmallClassfy Description: Company:
 * 
 * @author lanli
 * @date 2016-11-23 下午3:21:40
 */
public class SmallClassfy {

	/**
	 * 小分類編號
	 */
	private String sclassfyId;

	/**
	 * 小分類名稱
	 */
	private String sclassfyName;

	/**
	 * 大分類編號
	 */
	private String bclassId;
	
	/**
	 * 備用字段
	 */
	private String fsclassBak;

	public String getSclassfyId() {
		return sclassfyId;
	}

	public void setSclassfyId(String sclassfyId) {
		this.sclassfyId = sclassfyId;
	}

	public String getSclassfyName() {
		return sclassfyName;
	}

	public void setSclassfyName(String sclassfyName) {
		this.sclassfyName = sclassfyName;
	}

	public String getBclassId() {
		return bclassId;
	}

	public void setBclassId(String bclassId) {
		this.bclassId = bclassId;
	}

	public String getFsclassBak() {
		return fsclassBak;
	}

	public void setFsclassBak(String fsclassBak) {
		this.fsclassBak = fsclassBak;
	}

}
