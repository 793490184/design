package com.restaurant.servie.impl;

import com.restaurant.dao.OrderedPrivateMenuMapper;
import com.restaurant.dao.OrderedPublicMenuMapper;
import com.restaurant.entity.OrderedMenu;
import com.restaurant.servie.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Resource
	private OrderedPublicMenuMapper orderedPublicMenuMapper;
	@Resource
	private OrderedPrivateMenuMapper orderedPrivateMenuMapper;

	@Override
	public void selectOrderedAsPublic(int menuId, String account, String type, String useTime, int number) {
		orderedPublicMenuMapper.selectOrderedAsPublic(menuId, account, type, useTime, number);
	}

	@Override
	public void removeOrderedPublic(int menuId, String account, String type, String useTime) {
		System.out.println(menuId + account + type + useTime);
		orderedPublicMenuMapper.removeOrderedPublic(menuId, account, type, useTime);
	}

	@Override
	public List<OrderedMenu> selectOrderedPublicByCustomer(String account, String useTime, int start, int end) {
		List<OrderedMenu> orderedMenuList = orderedPublicMenuMapper.selectOrderedPublicByCustomer(account, useTime, start, end);
		return orderedMenuList;
	}

	@Override
	public void selectOrderedAsPrivate(int menuId, String account, String type, String useTime, int number) {
		orderedPrivateMenuMapper.selectOrderedAsPrivate(menuId, account, type, useTime, number);
	}

	@Override
	public void removeOrderedPrivate(int menuId, String account, String type, String useTime) {
		orderedPrivateMenuMapper.removeOrderedPrivate(menuId, account, type, useTime);
	}

	@Override
	public List<OrderedMenu> selectOrderedPrivateByCustomer(String account, String useTime, int start, int end) {
		List<OrderedMenu> orderedMenuList = orderedPrivateMenuMapper.selectOrderedPrivateByCustomer(account, useTime, start, end);
		return orderedMenuList;
	}

	@Override
	public void customerMark(Integer menuId, String useTime, String place, String account, Integer grade) {
		if (place.equals("public")) {
			orderedPublicMenuMapper.customerMark(menuId, useTime, account, grade);
			double avg = orderedPublicMenuMapper.getAvgMark(menuId);
			orderedPublicMenuMapper.updateMenuMark(menuId, avg);
		} else if (place.equals("private")) {
			orderedPrivateMenuMapper.customerMark(menuId, useTime, account, grade);
			double avg = orderedPrivateMenuMapper.getAvgMark(menuId);
			orderedPrivateMenuMapper.updateMenuMark(menuId, avg);
		}
	}


}
