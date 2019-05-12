package com.restaurant.servie.impl;

import com.restaurant.dao.*;
import com.restaurant.entity.Menu;
import com.restaurant.entity.OrderedMenu;
import com.restaurant.entity.SortedMenu;
import com.restaurant.servie.CookerService;
import com.restaurant.utils.BaseExecution;
import com.restaurant.utils.BaseInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CookerServiceImpl implements CookerService {

	@Resource
	private MenuMapper menuMapper;
	@Resource
	private SortedPublicMenuMapper sortedPublicMenuMapper;
	@Resource
	private SortedPrivateMenuMapper sortedPrivateMenuMapper;
	@Resource
	private OrderedPublicMenuMapper orderedPublicMenuMapper;
	@Resource
	private OrderedPrivateMenuMapper orderedPrivateMenuMapper;

	@Override
	public int getMenuNumber(String place, String type) {
		if (place.equals("big")) {
			if (type.equals("all"))
				return menuMapper.selectMenuNumber();
			else
				return menuMapper.selectMenuNumberBySeason(type);
		} else if (place.equals("public")) {
			return menuMapper.selectMenuPublicNumber(type);
		} else if (place.equals("private")) {
			return menuMapper.selectMenuPrivateNumber(type);
		}
		return 0;
	}

	@Override
	public int addMenu(Menu menu) {
		if (menuMapper.isExists(menu.getName()) == 1) {
			return 0;
		}
		menuMapper.insertMenu(menu);
		return 1;
	}

	@Override
	public int removeMenu(int id, String name) {
//		if (menuMapper.isExists(name) == 0) {
//			return 0;
//		}
		menuMapper.deleteMenu(id);
		return 1;
	}

	@Override
	public void updateMenu(Menu menu) {
		menuMapper.updateMenu(menu);
	}

	@Override
	public Menu checkDetail(int id, String name) {
		if (menuMapper.isExists(name) == 0) {
			return null;
		}
		return menuMapper.checkDetail(id);
	}

	@Override
	public List<Menu> selectMenu(int start, int end) {
		List<Menu> menuList = menuMapper.selectMenu(start, end);
		return menuList;
	}

	@Override
	public List<Menu> selectMenuByName(String name, int start, int end) {
		List<Menu> menuList = menuMapper.selectMenuByName(name, start, end);
		return menuList;
	}

	@Override
	public List<Menu> selectMenuBySeason(String season, int start, int end) {
		List<Menu> menuList = menuMapper.selectMenuBySeason(season, start, end);
		return menuList;
	}

	@Override
	public List<Menu> selectMenuByType(String type, int start, int end) {
		List<Menu> menuList = menuMapper.selectMenuByType(type, start, end);
		return menuList;
	}

	@Override
	public int getPublicNumber() {
		int number = sortedPublicMenuMapper.getPublicNumber();
		return number;
	}

	@Override
	public void selectMenuAsPublic(int id) {
		sortedPublicMenuMapper.selectMenuAsPublic(id);
	}

	@Override
	public void removeMenuPublic(int id) {
		sortedPublicMenuMapper.removeMenuPublic(id);
	}

	@Override
	public List<SortedMenu> selectPublicMenus(int start, int end) {
		List<SortedMenu> sortedMenuList = sortedPublicMenuMapper.selectPublicMenus(start, end);
		return sortedMenuList;
	}

	@Override
	public List<SortedMenu> selectPublicMenuByType(String type, int start, int end) {
		String season = BaseInfo.getSeason();
		List<SortedMenu> sortedMenuList = sortedPublicMenuMapper.selectPublicMenuByType(season, type, start, end);
		return sortedMenuList;
	}

	@Override
	public List<SortedMenu> selectPublicSortedMenu(String type, int start, int end) {
		String season = BaseInfo.getSeason();
		List<SortedMenu> sortedMenuList = sortedPublicMenuMapper.selectPublicSortedMenu(season, type, start, end);
//		System.out.println(sortedMenuList.toString());
		return sortedMenuList;
	}

	@Override
	public List<SortedMenu> selectPublicMenuByName(String name, int start, int end) {
		List<SortedMenu> sortedMenuList = sortedPublicMenuMapper.selectPublicMenuByName(name, start, end);
		return sortedMenuList;
	}

	@Override
	public int getPrivateNumber() {
		int number = sortedPrivateMenuMapper.getPrivateNumber();
		return number;
	}

	@Override
	public void selectMenuAsPrivate(int id) {
		sortedPrivateMenuMapper.selectMenuAsPrivate(id);
	}

	@Override
	public void removeMenuPrivate(int id) {
		sortedPrivateMenuMapper.removeMenuPrivate(id);
	}

	@Override
	public List<SortedMenu> selectPrivateMenus(int start, int end) {
		List<SortedMenu> sortedMenuList = sortedPrivateMenuMapper.selectPrivateMenus(start, end);
		return sortedMenuList;
	}

	@Override
	public List<SortedMenu> selectPrivateMenuBySeason(String season, int start, int end) {
		List<SortedMenu> sortedMenuList = sortedPrivateMenuMapper.selectPrivateMenuBySeason(season, start, end);
		return sortedMenuList;
	}

	@Override
	public List<SortedMenu> selectPrivateMenuByName(String name, int start, int end) {
		List<SortedMenu> sortedMenuList = sortedPrivateMenuMapper.selectPrivateMenuByName(name, start, end);
		return sortedMenuList;
	}

	@Override
	public List<SortedMenu> selectPrivateMenuByType(String type, int start, int end) {
		String season = BaseInfo.getSeason();
		List<SortedMenu> sortedMenuList = sortedPrivateMenuMapper.selectPrivateMenuByType(season, type, start, end);
		return sortedMenuList;
	}

	@Override
	public List<SortedMenu> selectPrivateSortedMenu(String type, int start, int end) {
		String season = BaseInfo.getSeason();
		List<SortedMenu> sortedMenuList = sortedPrivateMenuMapper.selectPrivateSortedMenu(season, type, start, end);
//		System.out.println(sortedMenuList.toString());
		return sortedMenuList;
	}

	@Override
	public int selectOrderedNumber(String place, String type) {
		if (place.equals("public")) {
			int number = orderedPublicMenuMapper.selectOrderedPublic(type);
			return number;
		} else if (place.equals("private")) {
			int number = orderedPrivateMenuMapper.selectOrderedPrivate(type);
			return number;
		}
		return 0;
	}

	@Override
	public List<OrderedMenu> selectOrderedPrivateMenus(String type, String useTime, int start, int end) {
		List<OrderedMenu> orderedMenuList = orderedPrivateMenuMapper.selectOrderedPrivateMenus(type, useTime, start, end);
		return orderedMenuList;
	}

	@Override
	public List<OrderedMenu> selectOrderedPublicMenus(String type, String useTime, int start, int end) {
		List<OrderedMenu> orderedMenuList = orderedPublicMenuMapper.selectOrderedPublicMenus(type, useTime, start, end);
		return orderedMenuList;
	}

	@Override
	public List<OrderedMenu> selectOrderedPublicMenuNumbers(String type, String restaurant, String useTime, int start, int end) {
		if (restaurant.equals("public")) {
			List<OrderedMenu> orderedMenuList = orderedPublicMenuMapper.selectOrderedPublicMenuNumbers(type, useTime, start, end);
			return orderedMenuList;
		} else if (restaurant.equals("private")) {
			List<OrderedMenu> orderedMenuList = orderedPrivateMenuMapper.selectOrderedPrivateMenuNumbers(type, useTime, start, end);
			return orderedMenuList;
		}
		return null;
	}

	@Override
	public List<OrderedMenu> selectOrderedPrivateMenuNumbers(String type, String useTime, int start, int end) {
		List<OrderedMenu> orderedMenuList = orderedPrivateMenuMapper.selectOrderedPrivateMenuNumbers(type, useTime, start, end);
		return orderedMenuList;
	}
}
