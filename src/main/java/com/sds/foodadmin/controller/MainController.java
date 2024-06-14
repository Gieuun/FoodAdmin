package com.sds.foodadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sds.foodadmin.domain.FoodDB;
import com.sds.foodadmin.model.food.FoodDBService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {

    @Autowired
    private FoodDBService foodDBService;

    @GetMapping("/")
    public String getMain() {
	log.debug("메인요청함");

	return "index";
    }

    @GetMapping("/foodList")
    public ModelAndView getFoodList() {
	List<FoodDB> foodList = foodDBService.selectAll();
	ModelAndView mav = new ModelAndView("food/list");
	mav.addObject("foodList", foodList);

	return mav;
    }

}
