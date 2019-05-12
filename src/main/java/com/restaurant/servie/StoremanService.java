package com.restaurant.servie;

import com.restaurant.entity.Food;

import java.util.List;

public interface StoremanService {
	public void insert(Food food);
	public void remove(int id);
	public void used(int id);
	public void use(Food food);
	public void update(Food food);
	public int getFoodNumber(String type);
	public List<Food> select(String foodType, int start, int end);
	public List<Food> total(String startTime, String endTime, int start, int end);
	public Integer sumOfFoods();
}
