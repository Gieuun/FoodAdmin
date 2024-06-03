package com.sds.foodadmin.model.member;

import org.apache.ibatis.annotations.Mapper;

import com.sds.foodadmin.domain.Role;

@Mapper
public interface RoleDAO {
	
	public Role selectByName(String role_name);
	
}
