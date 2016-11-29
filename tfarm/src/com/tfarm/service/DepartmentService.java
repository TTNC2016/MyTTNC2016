package com.tfarm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tfarm.dao.BaseOperDao;
import com.tfarm.dto.Department;

@Component("departService")
public class DepartmentService {
	@Autowired
	private BaseOperDao baseDao;

	public int add(Department depart) {
		String sql = "insert into t_department(fdepart_id,fdepart_name) values('"
				+ depart.getDepartId().trim()
				+ "','"
				+ depart.getDepartName().trim() + "')";
		return this.baseDao.update(sql);
	}

	public Map<String, Object> findById(String departId) {
		String sql = "select fdepart_id,fdepart_name from t_department where fdepart_id='"
				+ departId.trim() + "'";
		return this.baseDao.queryForMap(sql);
	}

	public int modify(Department depart) {
		String sql = "update t_department set fdepart_name='"
				+ depart.getDepartName().trim() + "' where fdepart_id='"
				+ depart.getDepartId().trim() + "'";
		return this.baseDao.update(sql);
	}

	public List<Map<String, Object>> queryAll() {
		String sql = "select fdepart_id,fdepart_name from t_department";
		return this.baseDao.queryForList(sql);
	}

	public int delete(String ownerId) {
		String sql = "delete  from t_department where fdepart_id='"
				+ ownerId.trim() + "'";
		return this.baseDao.update(sql);
	}
}
