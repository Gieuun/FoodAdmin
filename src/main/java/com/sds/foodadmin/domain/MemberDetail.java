package com.sds.foodadmin.domain;

import lombok.Data;

@Data
public class MemberDetail {
	private int memberDetailIdx;
	private String gender;
	private int age;
	private long height;
	private long weight;
	private Member member; // 회원정보 객체 가짐

	private FavoriteFood FavoriteFood; // 비선호 음식 객체 가짐

}
