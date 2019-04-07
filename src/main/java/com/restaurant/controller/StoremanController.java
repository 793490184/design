package com.restaurant.controller;

import com.restaurant.entity.Food;
import com.restaurant.servie.StoremanService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Component
@RequestMapping("/storeman")
public class StoremanController {

	@Resource
	StoremanService storemanService;

	@RequestMapping("/insert.do")
	@ResponseBody
	public void insert(Food food) {
		storemanService.insert(food);
	}

	@RequestMapping("/remove.do")
	@ResponseBody
	public void remove(int id) {

	}

	@RequestMapping("/used.do")
	@ResponseBody
	public void used(int id) {

	}

	@RequestMapping("/update.do")
	@ResponseBody
	public void update(Food food) {

	}

	@RequestMapping("/select.do")
	@ResponseBody
	public List<Food> select(int start, int end) {
		return null;
	}

	@RequestMapping("/total.do")
	@ResponseBody
	public List<Food> total(String startTime, String endTime, int start, int end) {
		return null;
	}

}
