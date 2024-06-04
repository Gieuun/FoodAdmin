package com.sds.foodadmin.model.food;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.sds.foodadmin.domain.FoodDB;

@Mapper
public interface FoodDBDAO {
	public void insertFoodDB(FoodDB foodDB);
	public List selectAll(FoodDB foodDB);
	public void updateFoodDB(FoodDB foodDB);
	

}
