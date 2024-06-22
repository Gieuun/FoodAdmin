package com.sds.foodadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sds.foodadmin.domain.Member;
import com.sds.foodadmin.model.member.MemberService;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/memberList")
    public ModelAndView getMemberList() {
	List<Member> memberList = memberService.selectAll();
	ModelAndView mav = new ModelAndView("/member/list");
	mav.addObject("memberList", memberList);
	return mav;
    }

}
