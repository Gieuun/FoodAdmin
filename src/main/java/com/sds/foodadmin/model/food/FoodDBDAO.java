package com.sds.foodadmin.model.food;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.sds.foodadmin.domain.FoodDB;

@Mapper
public interface FoodDBDAO {
	public void insertFoodDB(FoodDB foodDB);
	public int selectCount();
	public List selectAll();
	public void updateFoodDB(FoodDB foodDB);
	public void deleteFoodDB();	

}
