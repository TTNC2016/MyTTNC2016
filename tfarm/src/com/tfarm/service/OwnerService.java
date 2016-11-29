package com.tfarm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tfarm.dao.BaseOperDao;
import com.tfarm.dto.Owner;

@Component("ownerService")
public class OwnerService {

	@Autowired
	private BaseOperDao baseDao;

	public int add(Owner owner) {
		String sql = "insert into t_owner(fowner_id,fowner_name,fowner_telephone,fowner_sex,fowner_address,create_time) values('"
				+ owner.getOwnerId().trim()
				+ "','"
				+ owner.getOwnerName().trim()
				+ "','"
				+ owner.getOwnerTelephone().trim()
				+ "','"
				+ owner.getOwnerSex().trim()
				+ "','"
				+ owner.getOwnerAddress().trim() + "',now())";
		System.out.println(sql);
		return this.baseDao.update(sql);
	}

	public Map<String, Object> findById(String ownerId) {
		String sql = "select fowner_id,fowner_name,fowner_telephone,fowner_sex,fowner_address,create_time from t_owner where fowner_id='"
				+ ownerId.trim() + "'";
		return this.baseDao.queryForMap(sql);
	}

	public int modify(Owner owner) {
		String sql = "update t_owner set fowner_name='"
				+ owner.getOwnerName().trim() + "',fowner_address='"
				+ owner.getOwnerAddress() + "',fowner_telephone='"
				+ owner.getOwnerTelephone().trim() + "',fowner_sex='"
				+ owner.getOwnerSex() + "',modify_time=now() where fowner_id='"
				+ owner.getOwnerId().trim() + "'";
		return this.baseDao.update(sql);
	}

	public List<Map<String, Object>> queryAll() {
		String sql = "select fowner_id,fowner_name,fowner_telephone,fowner_sex,fowner_address,create_time from t_owner";
		return this.baseDao.queryForList(sql);
	}

	public int delete(String ownerId) {
		String sql = "delete  from t_owner where fowner_id='" + ownerId.trim()
				+ "'";
		return this.baseDao.update(sql);
	}

}