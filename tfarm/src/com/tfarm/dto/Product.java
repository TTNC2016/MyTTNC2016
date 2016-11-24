package com.tfarm.dto;

import java.util.Date;

/**
* Title:Product
* Description:
* Company: 
* @author lanli
* @date 2016-11-23 下午4:20:06*/
public class Product {
	
	/**
	 * @description  产品编号
	 */
	private String proId;
	
	/**
	 * @description  产品名称
	 */
	private String proName;
	/**
	 * @description  产品重量
	 */
	private String proWeight;
	/**
	 * @description 产品库存
	 */
	private int proTotal;
	/**
	 * @description  产品销量
	 */
	private int proSellnum;
	/**
	 * @description 产地 
	 */
	private String proPlace;
	/**
	 * @description  保质期 按天
	 */
	private int proGuaranteeTime;
	/**
	 * @description 储存方式
	 */
	private String proStore;
	
	/**
	 * @description 销售单位
	 */
	private String proUnit;
	/**
	 * @description  包装规格
	 */
	private String proPackage;
	
	/**
	 * @description 食用建议
	 */
	private String proAdvise;
	/**
	 * @description  温馨提示
	 */
	private String proNote;
	/**
	 * @description 录入时间
	 */
	private Date proOntime;
	/**
	 * @description 预计可以销售时间
	 */
	private Date proSellTime;
	/**
	 * @description 产品详情
	 */
	private String proDetail;
	/**
	 * @description 是否首页现实
	 */
	private int proFlag;
	/**
	 * @description 上传人员
	 */
	private String empId;
	/**
	 * @description 产品拥有者
	 */
	private String ownerId;
	/**
	 * @description 小分类编号
	 */
	private String sClassId;
	/**
	 * @description  备用字段
	 */
	private String proBak;
	
	/**
	 * @description 备用字段
	 */
	private String proBak1;
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProWeight() {
		return proWeight;
	}
	public void setProWeight(String proWeight) {
		this.proWeight = proWeight;
	}
	public int getProTotal() {
		return proTotal;
	}
	public void setProTotal(int proTotal) {
		this.proTotal = proTotal;
	}
	public int getProSellnum() {
		return proSellnum;
	}
	public void setProSellnum(int proSellnum) {
		this.proSellnum = proSellnum;
	}
	public String getProPlace() {
		return proPlace;
	}
	public void setProPlace(String proPlace) {
		this.proPlace = proPlace;
	}
	public int getProGuaranteeTime() {
		return proGuaranteeTime;
	}
	public void setProGuaranteeTime(int proGuaranteeTime) {
		this.proGuaranteeTime = proGuaranteeTime;
	}
	public String getProStore() {
		return proStore;
	}
	public void setProStore(String proStore) {
		this.proStore = proStore;
	}
	public String getProUnit() {
		return proUnit;
	}
	public void setProUnit(String proUnit) {
		this.proUnit = proUnit;
	}
	public String getProPackage() {
		return proPackage;
	}
	public void setProPackage(String proPackage) {
		this.proPackage = proPackage;
	}
	public String getProAdvise() {
		return proAdvise;
	}
	public void setProAdvise(String proAdvise) {
		this.proAdvise = proAdvise;
	}
	public String getProNote() {
		return proNote;
	}
	public void setProNote(String proNote) {
		this.proNote = proNote;
	}
	public Date getProOntime() {
		return proOntime;
	}
	public void setProOntime(Date proOntime) {
		this.proOntime = proOntime;
	}
	public Date getProSellTime() {
		return proSellTime;
	}
	public void setProSellTime(Date proSellTime) {
		this.proSellTime = proSellTime;
	}
	public String getProDetail() {
		return proDetail;
	}
	public void setProDetail(String proDetail) {
		this.proDetail = proDetail;
	}
	public int getProFlag() {
		return proFlag;
	}
	public void setProFlag(int proFlag) {
		this.proFlag = proFlag;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getsClassId() {
		return sClassId;
	}
	public void setsClassId(String sClassId) {
		this.sClassId = sClassId;
	}
	public String getProBak() {
		return proBak;
	}
	public void setProBak(String proBak) {
		this.proBak = proBak;
	}
	public String getProBak1() {
		return proBak1;
	}
	public void setProBak1(String proBak1) {
		this.proBak1 = proBak1;
	}
	
	

}
