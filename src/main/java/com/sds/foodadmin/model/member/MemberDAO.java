package com.sds.foodadmin.model.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sds.foodadmin.domain.Member;

@Mapper
public interface MemberDAO {

    public List<Member> selectAll();

}
