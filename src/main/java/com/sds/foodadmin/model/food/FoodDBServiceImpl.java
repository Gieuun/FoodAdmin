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
	public List selectHighProtein() {
		return foodDBDAO.selectHighProtein();
	}

	@Override
	public List selectLowSugar() {
		return foodDBDAO.selectLowSugar();
	}

	@Override
	public List selectLowSodium() {
		// TODO Auto-generated method stub
		return foodDBDAO.selectLowSodium();
	}

	@Override
	public List selectRandomHundred() {
		return foodDBDAO.selectRandomHundred();
	}

}