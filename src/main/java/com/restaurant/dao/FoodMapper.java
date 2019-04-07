package com.restaurant.dao;

import com.restaurant.entity.Food;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FoodMapper {
	public void insert(Food food);
	public void remove(int id);
	public void used(int id);
	public void update(Food food);
	public List<Food> select(@Param("start") int start, @Param("end") int end);
	public List<Food> total(@Param("startTime") String startTime, @Param("endTime") String endTime,
							@Param("start") int start, @Param("end") int end);
	public Integer sumOfFoods();

}
