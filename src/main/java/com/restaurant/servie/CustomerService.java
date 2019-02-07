package com.restaurant.servie;

import com.restaurant.entity.OrderedMenu;

import java.util.List;

public interface CustomerService {
	// orderedMenu
	public void selectOrderedAsPublic(int menuId, String account, String type, String useTime, int number);
	public void removeOrderedPublic(int menuId, String account, String type, String useTime);
	public List<OrderedMenu> selectOrderedPublicByCustomer(String account, String type, String useTime);

	public void selectOrderedAsPrivate(int menuId, String account, String type, String useTime, int number);
	public void removeOrderedPrivate(int menuId, String account, String type, String useTime);
	public List<OrderedMenu> selectOrderedPrivateByCustomer(String account, String type, String useTime);


}
