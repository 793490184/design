package com.restaurant.servie;

import com.restaurant.entity.Food;

import java.util.List;

public interface StoremanService {
	public void insert(Food food);
	public void remove(int id);
	public void used(int id);
	public void update(Food food);
	public List<Food> select(int start, int end);
	public List<Food> total(String startTime, String endTime, int start, int end);
	public Integer sumOfFoods();
}
