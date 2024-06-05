package com.sds.foodadmin.domain;

import lombok.Data;

@Data
public class FoodDB { // 식품영양성분DB 오픈API에서 가져오는 데이터를 담을 객체
	public int foodIdx; // 넘버링
	public String foodname; // 음식이름 : DESC_KOR
	public float kcal; // 열량 : NUTR_CONT1
	public float carbohydrate; // 탄수화물 : NUTR_CONT2
	public float protein; // 단백질(g) : NUTR_CONT3
	public float fat; // 지방(g) : NUTR_CONT4
	public float sugar; // 당류(g) : NUTR_CONT5
	public float sodium; // 나트륨(mg) : NUTR_CONT6

}
