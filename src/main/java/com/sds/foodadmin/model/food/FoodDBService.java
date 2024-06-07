package com.sds.foodadmin.model.food;

import java.util.List;

import com.sds.foodadmin.domain.FoodDB;

public interface FoodDBService {

	public String getData();
	
	public List<FoodDB> createFoodList(String jsonString);

	public void insertFoodDB(List<FoodDB> foodDBList);

	public FoodDB select(FoodDB foodDB);

	public List selectAll();

	public void deleteFoodDB();

}
