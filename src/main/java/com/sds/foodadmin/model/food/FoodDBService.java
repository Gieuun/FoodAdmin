package com.sds.foodadmin.model.food;

import java.util.List;

import com.sds.foodadmin.domain.FoodDB;

public interface FoodDBService {
	public void insertFoodDB();
	public int selectCount();
	public List selectAll();
	public void deleteFoodDB();
	
	

}
