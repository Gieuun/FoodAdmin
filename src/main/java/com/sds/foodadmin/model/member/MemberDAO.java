package com.sds.foodadmin.model.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sds.foodadmin.domain.Member;

@Mapper
public interface MemberDAO {
	
	public int insert(Member member); 			// 등록
	public Member selectByid(String id); 		// id에 해당하는 회원정보 가져오기
	
}
