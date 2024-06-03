package com.sds.foodadmin.model.member;

import org.apache.ibatis.annotations.Mapper;

import com.sds.foodadmin.domain.Sns;

@Mapper
public interface SnsDAO {
	
	public Sns selectByName(String sns_name);
}
