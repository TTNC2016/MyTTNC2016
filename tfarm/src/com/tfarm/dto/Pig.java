package com.tfarm.dto;

public class Pig {
	/**
	 * @description  编号
	 */
	private String pigId;
	/**
	 * @description 名称
	 */
	private String pigName;
	/**
	 * @description 库存
	 */
	private String pigTotal;
	/**
	 * @description 销量
	 */
	private String pigSellNum;
	/**
	 * @description 价格
	 */
	private String pigPrice;
	/**
	 * @description 抢购id
	 */
	private String resId;
	public String getPigId() {
		return pigId;
	}
	public void setPigId(String pigId) {
		this.pigId = pigId;
	}
	public String getPigName() {
		return pigName;
	}
	public void setPigName(String pigName) {
		this.pigName = pigName;
	}
	public String getPigTotal() {
		return pigTotal;
	}
	public void setPigTotal(String pigTotal) {
		this.pigTotal = pigTotal;
	}
	public String getPigSellNum() {
		return pigSellNum;
	}
	public void setPigSellNum(String pigSellNum) {
		this.pigSellNum = pigSellNum;
	}
	public String getPigPrice() {
		return pigPrice;
	}
	public void setPigPrice(String pigPrice) {
		this.pigPrice = pigPrice;
	}
	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	
	
}
