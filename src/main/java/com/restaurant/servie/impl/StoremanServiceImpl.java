package com.restaurant.servie.impl;

import com.restaurant.dao.FoodMapper;
import com.restaurant.entity.Food;
import com.restaurant.servie.StoremanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StoremanServiceImpl implements StoremanService {

	@Resource
	private FoodMapper foodMapper;

	@Override
	public void insert(Food food) {
		foodMapper.insert(food);
	}

	@Override
	public void remove(int id) {
		foodMapper.remove(id);
	}

	@Override
	public void used(int id) {
		foodMapper.used(id);
	}

	@Override
	public void use(Food food) {
		foodMapper.use(food);
	}

	@Override
	public void update(Food food) {
		foodMapper.update(food);
	}

	@Override
	public int getFoodNumber(String type) {
		int number = foodMapper.getFoodNumber(type);
		return number;
	}

	@Override
	public List<Food> select(String foodType, int start, int end) {
		List<Food> foods = foodMapper.select(foodType, start, end);
		return foods;
	}

	@Override
	public List<Food> total(String startTime, String endTime, int start, int end) {
		List<Food> foods = foodMapper.total(startTime, endTime, start, end);
		return foods;
	}

	@Override
	public Integer sumOfFoods() {
		Integer number = foodMapper.sumOfFoods();
		return number;
	}
}
