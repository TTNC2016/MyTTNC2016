package com.tfarm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.tfarm.dao.BaseOperDao;
import com.tfarm.dto.Owner;
import com.tfarm.dto.SmallClassfy;

public class OwnerService {

	@Autowired
	private BaseOperDao baseDao;

	public int add(Owner owner) {
		String sql = "insert into t_owner(fowner_id,fowner_name,fowner_telephone,fowner_adress,create_time) values('"
				+ owner.getOwnId().trim()
				+ "','"
				+ owner.getOwnerName().trim()
				+ "','"
				+ owner.getOwnerTelephone().trim()
				+ "','"
				+ owner.getOwnerAdress().trim() + "',now())";
		System.out.println(sql);
		return this.baseDao.update(sql);
	}

	public Map<String, Object> findById(String ownerId) {
		String sql = "select fowner_id,fowner_name,fowner_telephone,fowner_adress,create_time from t_owner where fowner_id='"
				+ ownerId.trim() + "'";
		return this.baseDao.queryForMap(sql);
	}

	public int modify(Owner owner) {
		String sql = "update t_owner set fowner_name='"
				+ owner.getOwnerName().trim() + "',fowner_adress='"
				+ owner.getOwnerAdress() + "',fowner_telephone='"
				+ owner.getOwnerTelephone().trim()
				+ "',modify_time=now() where fowner_id='"
				+ owner.getOwnId().trim() + "'";
		System.out.println(sql);
		return this.baseDao.update(sql);
	}

	public List<Map<String, Object>> queryAll() {
		String sql = "select fowner_id,fowner_name.fowner_telephone,fowner_adress,create_time from t_owner";
		return this.baseDao.queryForList(sql);
	}

	public int delete(String ownerId) {
		String sql = "delete  from t_owner where fowner_id='" + ownerId.trim()
				+ "'";
		return this.baseDao.update(sql);
	}

}