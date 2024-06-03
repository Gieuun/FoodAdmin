package com.sds.foodadmin.model.food;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.foodadmin.domain.FoodDB;

@Service
public class FoodDBServiceImpl implements FoodDBService {

	@Autowired
	private FoodDBDAO foodDBDAO;

	@Override
	public void insertFoodDB(FoodDB foodDB) {
		foodDBDAO.insertFoodDB(foodDB);
		
	}

	@Override
	public List selectAll(FoodDB foodDB) {
		
		return foodDBDAO.selectAll(foodDB);
	}

	@Override
	public void updateFoodDB(FoodDB foodDB) {
		foodDBDAO.updateFoodDB(foodDB);
		
	}

	
}
