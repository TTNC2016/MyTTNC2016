package com.tfarm.dto;

import java.sql.Timestamp;

public class Employee {
	/**
	 * 员工编号
	 */
	private String empId;
	/**
	 * 员工账号名
	 */
	private String empUsername;
	/**
	 * 员工登陆密码
	 */
	private String empPassword;
	/**
	 * 员工真实姓名
	 */
	private String empRealName;
	/**
	 * 员工出生日期
	 */
	private Timestamp empBirthday;
	/**
	 * 身份证号码
	 */
	private String empIdCard;
	/**
	 * 手机号码
	 */
	private String empTelephone;
	/**
	 * 家庭住址
	 */
	private String empAddress;
	/**
	 * 个人照片
	 */
	private String empPic;
	/**
	 * 邮件地址
	 */
	private String empEmail;
	/**
	 * 教育程度
	 */
	private String empEdu;
	/**
	 * 专业
	 */
	private String empMajor;
	/**
	 * 毕业学校
	 */
	private String empSchool;
	/**
	 * 入职时间
	 */
	private Timestamp empInTime;
	/**
	 * 角色名称
	 */
	private String empRoleName;
	/**
	 * 所在部门编号
	 */
	private String departId;
	/**
	 * 记录添加时间
	 */
	private Timestamp createTime;
	/**
	 * 记录修改时间
	 */
	private Timestamp modifyTime;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpUsername() {
		return empUsername;
	}

	public void setEmpUsername(String empUsername) {
		this.empUsername = empUsername;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpRealName() {
		return empRealName;
	}

	public void setEmpRealName(String empRealName) {
		this.empRealName = empRealName;
	}

	public Timestamp getEmpBirthday() {
		return empBirthday;
	}

	public void setEmpBirthday(Timestamp empBirthday) {
		this.empBirthday = empBirthday;
	}

	public String getEmpIdCard() {
		return empIdCard;
	}

	public void setEmpIdCard(String empIdCard) {
		this.empIdCard = empIdCard;
	}

	public String getEmpTelephone() {
		return empTelephone;
	}

	public void setEmpTelephone(String empTelephone) {
		this.empTelephone = empTelephone;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpPic() {
		return empPic;
	}

	public void setEmpPic(String empPic) {
		this.empPic = empPic;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpEdu() {
		return empEdu;
	}

	public void setEmpEdu(String empEdu) {
		this.empEdu = empEdu;
	}

	public String getEmpMajor() {
		return empMajor;
	}

	public void setEmpMajor(String empMajor) {
		this.empMajor = empMajor;
	}

	public String getEmpSchool() {
		return empSchool;
	}

	public void setEmpSchool(String empSchool) {
		this.empSchool = empSchool;
	}

	public Timestamp getEmpInTime() {
		return empInTime;
	}

	public void setEmpInTime(Timestamp empInTime) {
		this.empInTime = empInTime;
	}

	public String getEmpRoleName() {
		return empRoleName;
	}

	public void setEmpRoleName(String empRoleName) {
		this.empRoleName = empRoleName;
	}

	public String getDepartId() {
		return departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
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

}
