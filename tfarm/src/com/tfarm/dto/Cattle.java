package com.tfarm.dto;

/**
* Title:Cattle
* Description:
* Company: 
* @author lanli
* @date 2016-11-23 下午4:33:36*/
public class Cattle {
	/**
	 * @description  编号
	 */
	private String catId;
	/**
	 * @description 名称
	 */
	private String catName;
	/**
	 * @description 库存
	 */
	private String catTotal;
	/**
	 * @description 销量
	 */
	private String catSellNum;
	/**
	 * @description 价格
	 */
	private String catPrice;
	/**
	 * @description 抢购id
	 */
	private String resId;
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getCatTotal() {
		return catTotal;
	}
	public void setCatTotal(String catTotal) {
		this.catTotal = catTotal;
	}
	public String getCatSellNum() {
		return catSellNum;
	}
	public void setCatSellNum(String catSellNum) {
		this.catSellNum = catSellNum;
	}
	public String getCatPrice() {
		return catPrice;
	}
	public void setCatPrice(String catPrice) {
		this.catPrice = catPrice;
	}
	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}

}
