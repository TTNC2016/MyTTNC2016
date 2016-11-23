package com.tfarm.dto;

public class Sheep {
	/**
	 * @description  编号
	 */
	private String sheId;
	/**
	 * @description 名称
	 */
	private String sheName;
	/**
	 * @description 库存
	 */
	private String sheTotal;
	/**
	 * @description 销量
	 */
	private String sheSellNum;
	/**
	 * @description 价格
	 */
	private String shePrice;
	public String getSheId() {
		return sheId;
	}
	public void setSheId(String sheId) {
		this.sheId = sheId;
	}
	public String getSheName() {
		return sheName;
	}
	public void setSheName(String sheName) {
		this.sheName = sheName;
	}
	public String getSheTotal() {
		return sheTotal;
	}
	public void setSheTotal(String sheTotal) {
		this.sheTotal = sheTotal;
	}
	public String getSheSellNum() {
		return sheSellNum;
	}
	public void setSheSellNum(String sheSellNum) {
		this.sheSellNum = sheSellNum;
	}
	public String getShePrice() {
		return shePrice;
	}
	public void setShePrice(String shePrice) {
		this.shePrice = shePrice;
	}
	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	/**
	 * @description 抢购id
	 */
	private String resId;
}
