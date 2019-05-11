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
		orderedPublicMenuMapper.removeOrderedPublic(menuId, account, type, useTime);
	}

	@Override
	public List<OrderedMenu> selectOrderedPublicByCustomer(String account, String type, String useTime) {
		List<OrderedMenu> orderedMenuList = orderedPublicMenuMapper.selectOrderedPublicByCustomer(account, type, useTime);
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
	public List<OrderedMenu> selectOrderedPrivateByCustomer(String account, String type, String useTime) {
		List<OrderedMenu> orderedMenuList = orderedPrivateMenuMapper.selectOrderedPrivateByCustomer(account, type, useTime);
		return orderedMenuList;
	}

	@Override
	public int selectOrderedByCustomer(String type, String account) {
		return 0;
	}
}
