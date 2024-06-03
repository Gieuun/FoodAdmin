package com.sds.foodadmin.domain;

import lombok.Data;

@Data
public class FoodRecommendResult {
	public int foodRecommendResIdx;
	public FoodDB foodDB;
	public Member member;

}
