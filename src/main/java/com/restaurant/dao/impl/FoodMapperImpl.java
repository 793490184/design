package com.restaurant.dao.impl;

import com.restaurant.dao.FoodMapper;
import com.restaurant.entity.Food;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FoodMapperImpl implements FoodMapper {
	@Override
	public void insert(Food food) {
		SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession().openSession();
		FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);
		foodMapper.insert(food);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void remove(int id) {
		SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession().openSession();
		FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);
		foodMapper.remove(id);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void used(int id) {
		SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession().openSession();
		FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);
		foodMapper.used(id);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void update(Food food) {
		SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession().openSession();
		FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);
		foodMapper.update(food);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public List<Food> select(int start, int end) {
		SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession().openSession();
		FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);
		List<Food> foods = foodMapper.select(start, end);
		sqlSession.close();
		return foods;
	}

	@Override
	public List<Food> total(String startTime, String endTime, int start, int end) {
		SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession().openSession();
		FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);
		List<Food> foods = foodMapper.total(startTime, endTime, start, end);
		sqlSession.close();
		return foods;
	}

	@Override
	public Integer sumOfFoods() {
		SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession().openSession();
		FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);
		int number = foodMapper.sumOfFoods();
		sqlSession.close();
		return number;
	}
}
