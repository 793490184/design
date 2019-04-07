package com.restaurant.controller;

import com.restaurant.entity.Food;
import com.restaurant.servie.StoremanService;
import com.restaurant.utils.BaseExecution;
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
	public BaseExecution insert(String name, String date, Integer security, String foodType, int number, String measure, Integer usedFlag) {
		Food food = new Food(name, date, security, foodType, number, measure, usedFlag);
		System.out.println(name);
		storemanService.insert(food);
		BaseExecution baseExecution = new BaseExecution(200, "ok", "插入食材成功");
		return baseExecution;
	}

	@RequestMapping("/remove.do")
	@ResponseBody
	public BaseExecution remove(int id) {
		storemanService.remove(id);
		BaseExecution baseExecution = new BaseExecution(200, "ok", "移除食材成功");
		return baseExecution;
	}

	@RequestMapping("/used.do")
	@ResponseBody
	public BaseExecution used(int id) {
		storemanService.used(id);
		BaseExecution baseExecution = new BaseExecution(200, "ok", "食材已经用尽");
		return baseExecution;
	}

	@RequestMapping("/update.do")
	@ResponseBody
	public BaseExecution update(Integer id, String name, String date, int security, String foodType, Integer number, String measure) {
		Food food = new Food(id, name, date, security, foodType, number, measure, 0);
		storemanService.update(food);
		BaseExecution baseExecution = new BaseExecution(200, "ok", "食物更新成功");
		return baseExecution;
	}

	@RequestMapping("/select.do")
	@ResponseBody
	public BaseExecution select(int start, int end) {
		List<Food> foods = storemanService.select(start, end);
		BaseExecution baseExecution = new BaseExecution(200, "ok", foods);
		return baseExecution;
	}

	@RequestMapping("/total.do")
	@ResponseBody
	public BaseExecution total(String startTime, String endTime, int start, int end) {
		List<Food> foods = storemanService.total(startTime, endTime, start, end);
		BaseExecution baseExecution = new BaseExecution(200, "ok", foods);
		return baseExecution;
	}

	@RequestMapping("/sum_of_foods")
	@ResponseBody
	public BaseExecution sumOfFoods() {
		int number = storemanService.sumOfFoods();
		BaseExecution baseExecution = new BaseExecution(200, "ok", number);
		return baseExecution;
	}

}
