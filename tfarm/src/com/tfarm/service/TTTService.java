package com.tfarm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tfarm.dao.BaseOperDao;

@Component("tService")
public class TTTService
{
	@Autowired
	private BaseOperDao baseDao;

	public List<Map<String, Object>> getTest()
	{

		String sql = "select * from t_product limit 10";
		return this.baseDao.queryForList(sql);
	}
}
