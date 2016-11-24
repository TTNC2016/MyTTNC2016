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
	private String ownId;

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
	private String ownerAdress;
	/**
	 * @description 備用
	 */
	private String ownerBak;

	public String getOwnId() {
		return ownId;
	}

	public void setOwnId(String ownId) {
		this.ownId = ownId;
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

	public String getOwnerAdress() {
		return ownerAdress;
	}

	public void setOwnerAdress(String ownerAdress) {
		this.ownerAdress = ownerAdress;
	}

	public String getOwnerBak() {
		return ownerBak;
	}

	public void setOwnerBak(String ownerBak) {
		this.ownerBak = ownerBak;
	}

}
