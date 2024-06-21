package com.sds.foodadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sds.foodadmin.common.DashBoardCounter;

@RestController
public class RestMainController {

    @Autowired
    private DashBoardCounter dashBoardCounter;

    @GetMapping("/api/visitorCount")
    public int getVisitorCount() {
	return dashBoardCounter.countVisitors();
    }

    @GetMapping("/api/countMember")
    public int getCountMember() {
	return dashBoardCounter.countMembers();
    }

}
