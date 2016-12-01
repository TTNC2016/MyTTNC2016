package com.tfarm.dto;

/**
 * Title:Owner Description: Company:
 * 
 * @author lanli
 * @date 2016-11-23 下午4:49:47
 */
public class Owner {
	/**
	 * @description 擁有者編號
	 */
	private String ownerId;

	/**
	 * @description 擁有者姓名
	 */
	private String ownerName;
	/**
	 * @description 擁有者手機號碼
	 */
	private String ownerTelephone;
	/**
	 * @description 擁有者地址
	 */
	
	private String ownerAddress;
	/**
	 * 性别
	 */
	private  String ownerSex;
	/**
	 * @description 備用
	 */
	private String ownerBak;


	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerTelephone() {
		return ownerTelephone;
	}

	public void setOwnerTelephone(String ownerTelephone) {
		this.ownerTelephone = ownerTelephone;
	}



	public String getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	public String getOwnerBak() {
		return ownerBak;
	}

	public void setOwnerBak(String ownerBak) {
		this.ownerBak = ownerBak;
	}

	public String getOwnerSex() {
		return ownerSex;
	}

	public void setOwnerSex(String ownerSex) {
		this.ownerSex = ownerSex;
	}
	
	

}
