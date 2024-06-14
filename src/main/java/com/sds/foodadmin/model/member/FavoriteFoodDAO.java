package com.sds.foodadmin.model.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sds.foodadmin.domain.FavoriteFood;
import com.sds.foodadmin.domain.Member;

@Mapper
public interface FavoriteFoodDAO {

	public int insert(FavoriteFood favoriteFood); // 등록

	public List selectAll();

	public FavoriteFood select(int favoriteFoodIdx);

	public Member selcteByid(String id);

	public void update(FavoriteFood favoriteFood);

}
