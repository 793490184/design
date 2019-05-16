package com.restaurant.servie;

import com.restaurant.entity.OrderedMenu;

import java.util.List;

public interface CustomerService {
	// orderedMenu
	public void selectOrderedAsPublic(int menuId, String account, String type, String useTime, int number);
	public void removeOrderedPublic(int menuId, String account, String type, String useTime);
	public List<OrderedMenu> selectOrderedPublicByCustomer(String account, String useTime, int start, int end);

	public void selectOrderedAsPrivate(int menuId, String account, String type, String useTime, int number);
	public void removeOrderedPrivate(int menuId, String account, String type, String useTime);
	public List<OrderedMenu> selectOrderedPrivateByCustomer(String account, String useTime, int start, int end);

	public void customerMark(Integer menuId, String useTime, String place, String account, Integer grade);

}
