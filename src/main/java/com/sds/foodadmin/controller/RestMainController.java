package com.sds.foodadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sds.foodadmin.common.VisitorCounter;

@RestController
public class RestMainController {

    @Autowired
    private VisitorCounter visitorCounter;

    @GetMapping("/api/visitorCount")
    public int getVisitorCount() {
	return visitorCounter.countVisitors();
    }

}
