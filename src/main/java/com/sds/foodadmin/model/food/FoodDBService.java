package com.sds.foodadmin.model.food;

import java.util.List;

import com.sds.foodadmin.domain.FoodDB;

public interface FoodDBService {
	public void insertFoodDB(FoodDB foodDB);

	public List selectHighProtein();

	public List selectLowSugar();

	public List selectLowSodium();

	public List selectRandomHundred();

}
