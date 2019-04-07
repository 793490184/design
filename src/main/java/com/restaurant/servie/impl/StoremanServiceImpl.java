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
	public void update(Food food) {
		foodMapper.update(food);
	}

	@Override
	public List<Food> select(int start, int end) {
		List<Food> foods = foodMapper.select(start, end);
		return foods;
	}

	@Override
	public List<Food> total(String startTime, String endTime, int start, int end) {
		List<Food> foods = foodMapper.total(startTime, endTime, start, end);
		return foods;
	}
}
