package com.sds.foodadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	@GetMapping("/")
	public String getMain() {
		log.debug("메인요청함");

		return "index";
	}

	@GetMapping("/foodapi")
	public String getApiUpdate() {
		log.debug("음식리스트");
		return "food/list";
	}

}
