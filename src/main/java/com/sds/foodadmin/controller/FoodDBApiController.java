package com.sds.foodadmin.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sds.foodadmin.common.Pager;
import com.sds.foodadmin.domain.FoodDB;
import com.sds.foodadmin.model.food.FoodDBService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FoodDBApiController {

	@Autowired
	private FoodDBService foodDBService;

	@Autowired
	private Pager pager;
	
	//쿼리작동에 문제가 있는 상황

	// Api 에서 제공하는 리스트를 끌어오자
	@GetMapping("/apiupdate")
	public String getApiList(FoodDB foodDB, Model model) {
		//sql 안에서 행 개수를 체크
		

		if (count != 0) {					// 행이 1개라도 있으면
			foodDBService.deleteFoodDB();	// 테이블을 싹 날린다
		}
		foodDBService.insertFoodDB();		// 테이블에 데이터 넣는다
		foodDBService.selectAll();			// 생성된 데이터를 다 선택

		return "redirect:food/list";		// 리프레쉬 해준다
	}

}
