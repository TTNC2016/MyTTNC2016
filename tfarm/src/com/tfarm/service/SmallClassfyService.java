package com.tfarm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tfarm.dao.BaseOperDao;
import com.tfarm.dto.SmallClassfy;

@Component("sclassfyService")
public class SmallClassfyService {
	@Autowired
	private BaseOperDao baseDao;

	public int add(SmallClassfy sclassfy) {
		String sql = "insert into t_smallclassfy(fsclass_id,fsclass_name,fbclass_id,create_time) values('"
				+ sclassfy.getSclassfyId().trim()
				+ "','"

				+ sclassfy.getSclassfyName().trim()
				+ "','"
				+ sclassfy.getBclassId().trim() + "',now());";

		System.out.println(sql);
		return this.baseDao.update(sql);
	}

	public Map<String, Object> findById(String sclassfyId) {
		String sql = "select fsclass_id,fsclass_name,small.fbclass_id,fbclass_name,small.create_time from t_smallclassfy small,t_bigclassfy big where small.fbclass_id=big.fbclass_id and fsclass_id='"
				+ sclassfyId.trim() + "'";
		return this.baseDao.queryForMap(sql);
	}

	public int modify(SmallClassfy sclassfy) {
		String sql = "update t_smallclassfy set fsclass_name='"
				+ sclassfy.getSclassfyName().trim() + "',fbclass_id='"
				+ sclassfy.getBclassId().trim()
				+ "',modify_time=now() where fsclass_id='"
				+ sclassfy.getSclassfyId().trim() + "'";
		System.out.println(sql);
		return this.baseDao.update(sql);
	}

	public List<Map<String, Object>> queryAll() {
		String sql = "select fsclass_id,fsclass_name,small.fbclass_id,fbclass_name,small.create_time from t_smallclassfy small,t_bigclassfy big where small.fbclass_id=big.fbclass_id ";
		return this.baseDao.queryForList(sql);
	}

	public int delete(String sclassId) {
		String sql = "delete  from t_smallclassfy where fsclass_id='"
				+ sclassId.trim() + "'";
		return this.baseDao.update(sql);
	}

	public int deleteAll(String[] ones) {
		String sql = "delete  from t_smallclassfy where fsclass_id=?";
		return this.baseDao.update(sql, ones);
	}

	public List<Map<String, Object>> queryBigClassfy() {
		String sql = "select fbclass_id,fbclass_name from t_bigclassfy";
		return this.baseDao.queryForList(sql);
	}
}
