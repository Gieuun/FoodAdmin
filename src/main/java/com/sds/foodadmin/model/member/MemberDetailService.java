package com.sds.foodadmin.model.member;

import com.sds.foodadmin.domain.Member;
import com.sds.foodadmin.domain.MemberDetail;

public interface MemberDetailService {

	public void insert(MemberDetail memberDetail);		 // 가입
	public Member selectByIdx(int member_idx);				// idx 해당하는 회원정보가져오기
}