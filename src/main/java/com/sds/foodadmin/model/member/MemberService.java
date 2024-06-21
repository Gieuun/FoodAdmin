package com.sds.foodadmin.model.member;

import java.util.List;

import com.sds.foodadmin.domain.Member;

public interface MemberService {

    public List<Member> selectAll();
}
