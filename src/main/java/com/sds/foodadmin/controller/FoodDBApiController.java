package com.sds.foodadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	// 쿼리작동에 문제가 있는 상황

	// Api 에서 제공하는 리스트를 끌어오자
	@GetMapping("food/update")
	public String getApiList() {
		
		List<FoodDB> dataList = foodDBService.selectAll();
		int count = dataList.size();
		
		if(count!=0) {
			foodDBService.deleteFoodDB();
		}
		
		//데이터 가져오기
		String data = foodDBService.getData();		
		log.debug("콘트롤러로 날라오나?============"+data);
		
		// 데이터로 FoodDB 객체 만듬
		List<FoodDB> foodList = foodDBService.createFoodList(data);
		
		//FoodDB 객체 데이터베이스에 넣는다
		foodDBService.insertFoodDB(foodList);
		
		return "food/list";
	}

}
