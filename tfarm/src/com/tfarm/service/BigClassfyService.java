package com.tfarm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tfarm.dao.BaseOperDao;
import com.tfarm.dto.BigClassfy;

@Component("bclassfyService")
public class BigClassfyService {
	@Autowired
	private BaseOperDao baseDao;

	public int add(BigClassfy bclassfy) {
		String sql = "insert into t_bigclassfy(fbclass_id,fbclass_name,create_time) values('"
				+ bclassfy.getBclassId().trim() + "','"

				+ bclassfy.getBclassName().trim() + "',now());";
		return this.baseDao.update(sql);
	}

	public Map<String, Object> findById(String bclassId) {
		String sql = "select fbclass_id,fbclass_name,create_time from t_bigclassfy where fbclass_id='"
				+ bclassId.trim() + "'";
		System.out.println(sql);
		return this.baseDao.queryForMap(sql);
	}

	public int modify(BigClassfy bclassfy) {
		String sql = "update t_bigclassfy set fbclass_name='"
				+ bclassfy.getBclassName().trim()
				+ "',modify_time=now() where fbclass_id='"
				+ bclassfy.getBclassId().trim() + "'";
		System.out.println(sql);
		return this.baseDao.update(sql);
	}

	public List<Map<String, Object>> queryAll() {
		String sql = "select fbclass_id,fbclass_name,create_time from t_bigclassfy";
		return this.baseDao.queryForList(sql);
	}

	public int delete(String bclassId) {
		String sql = "delete  from t_bigclassfy where fbclass_id='"
				+ bclassId.trim() + "'";
		return this.baseDao.update(sql);
	}

	public int deleteAll(String[] ones) {
		String sql = "delete  from t_bigclassfy where fbclass_id=?";
		return this.baseDao.update(sql, ones);
	}

}
