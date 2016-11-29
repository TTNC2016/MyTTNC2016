package com.tfarm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tfarm.dao.BaseOperDao;
import com.tfarm.dto.Employee;

@Component("empService")
public class EmployeeService {
	@Autowired
	private BaseOperDao baseDao;

	public int add(Employee emp) {
		String sql = "insert into t_employee(femp_id,femp_username,femp_password,femp_realname,femp_birthday,femp_idcard,femp_telephone,femp_address,femp_pic,femp_email,femp_edu,femp_major,femp_school,femp_intime,femp_rolename,fdepart_id,create_time) values('"
				+ emp.getEmpId().trim()
				+ "','"
				+ emp.getEmpUsername().trim()
				+ "','"
				+ emp.getEmpPassword().trim()

				+ "','"
				+ emp.getEmpRealName().trim()
				+ "','"
				+ emp.getEmpBirthday()
				+ "','"
				+ emp.getEmpIdCard().trim()
				+ "','"
				+ emp.getEmpTelephone().trim()
				+ "','"
				+ emp.getEmpAddress().trim()
				+ "','"
				+ emp.getEmpPic().trim()
				+ "','"
				+ emp.getEmpEmail().trim()
				+ "','"
				+ emp.getEmpEdu()
				+ "','"
				+ emp.getEmpMajor()
				+ "','"
				+ emp.getEmpSchool().trim()
				+ "','"
				+ emp.getEmpInTime()
				+ "','"
				+ emp.getEmpRoleName().trim()
				+ "','"
				+ emp.getDepartId()
				+ "',now())";
		System.out.println(sql);
		return this.baseDao.update(sql);
	}

	public Map<String, Object> findById(String empId) {
		String sql = "select femp_id,femp_username,femp_password,femp_realname,femp_birthday,femp_idcard,femp_telephone,femp_address,femp_pic,femp_email,femp_edu,femp_major,femp_school,femp_intime,femp_rolename,emp.fdepart_id,fdepart_name from t_employee emp,t_department depart where emp.fdepart_id=depart.fdepart_id and emp.femp_id='"
				+ empId.trim() + "'";
		return this.baseDao.queryForMap(sql);
	}

	public int modify(Employee emp) {
		String sql = "update t_employee set femp_username='"
				+ emp.getEmpUsername().trim() + "',femp_password='"
				+ emp.getEmpPassword() + "',femp_realname='"
				+ emp.getEmpRealName().trim() + "',femp_birthday='"
				+ emp.getEmpBirthday() + "',femp_idcard='"
				+ emp.getEmpIdCard().trim() + "',femp_telephone='"
				+ emp.getEmpTelephone().trim() + "',femp_address='"
				+ emp.getEmpAddress().trim() + "',femp_pic='"
				+ emp.getEmpPic().trim() + "',femp_email='"
				+ emp.getEmpEmail().trim() + "',femp_edu='"
				+ emp.getEmpEdu().trim() + "',femp_major='"
				+ emp.getEmpMajor().trim() + "',femp_school='"
				+ emp.getEmpSchool().trim() + "',femp_intime='"
				+ emp.getEmpInTime() + "',femp_rolename='"
				+ emp.getEmpRoleName() + "',fdepart_id='" + emp.getDepartId()
				+ "',modify_time where femp_id='" + emp.getEmpId().trim() + "'";
		return this.baseDao.update(sql);
	}

	public List<Map<String, Object>> queryAll() {
		String sql = "select femp_id,femp_username,femp_password,femp_realname,femp_birthday,femp_idcard,femp_telephone,femp_address,femp_pic,femp_email,femp_edu,femp_major,femp_school,femp_intime,femp_rolename,emp.fdepart_id,fdepart_name from t_employee emp,t_department depart where emp.fdepart_id=depart.fdepart_id";
		return this.baseDao.queryForList(sql);
	}

	public int delete(String empId) {
		String sql = "delete  from t_employee where fowner_id='" + empId.trim()
				+ "'";
		return this.baseDao.update(sql);
	}

	public List<Map<String, Object>> empFindDepart() {

		String sql = "select fdepart_id,fdepart_name from t_department";
		return this.baseDao.queryForList(sql);
	}

}
