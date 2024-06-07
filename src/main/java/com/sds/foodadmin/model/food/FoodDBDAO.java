package com.sds.foodadmin.model.food;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.sds.foodadmin.domain.FoodDB;

@Mapper
public interface FoodDBDAO {

	public int insertFoodDB(List<FoodDB> foodDBList);

	public FoodDB select(FoodDB foodDB);

	public List<FoodDB> selectAll();

	public void deleteFoodDB();

}
