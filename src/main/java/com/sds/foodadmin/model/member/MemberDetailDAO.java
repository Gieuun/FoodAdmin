package com.sds.foodadmin.model.member;

import org.apache.ibatis.annotations.Mapper;

import com.sds.foodadmin.domain.Member;
import com.sds.foodadmin.domain.MemberDetail;

@Mapper
public interface MemberDetailDAO {
	
	public int  insert(MemberDetail memberDetail);		 // 등록
	public Member selectByIdx(int member_idx);				//member_idx 해당하는 회원정보 가져오기
}