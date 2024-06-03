package com.sds.foodadmin.model.food;

import java.util.List;

import com.sds.foodadmin.domain.FoodDB;

public interface FoodDBService {
	public void insertFoodDB(FoodDB foodDB);
	public List selectAll(FoodDB foodDB);
	public void updateFoodDB(FoodDB foodDB);
	
	

}
