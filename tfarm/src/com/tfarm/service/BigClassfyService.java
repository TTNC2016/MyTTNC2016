package com.tfarm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tfarm.dao.BaseOperDao;
import com.tfarm.dto.BigClassfy;

@Component("bClassfyService")
public class BigClassfyService {
	@Autowired
	private BaseOperDao baseDao;

	public int add(BigClassfy bclassfy) {
		String sql = "insert into t_bigclassfy(fbclass_id,fbclass_name,create_time) values('"
				+ bclassfy.getBclassId() + "','"

				+ bclassfy.getBclassName() + "',now());";
		System.out.println(sql);
		return this.baseDao.update(sql);
	}

	public List<Map<String, Object>> queryAll() {
		String sql = "select bclass_id,bclass_name from t_bigclassfy";
		return this.baseDao.queryForList(sql);
	}

}
