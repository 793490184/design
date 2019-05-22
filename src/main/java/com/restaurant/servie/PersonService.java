package com.restaurant.servie;

import com.restaurant.entity.OrderedMenu;
import com.restaurant.entity.Person;
import com.restaurant.entity.SortedMenu;
import com.restaurant.utils.BaseExecution;

import java.util.List;

public interface PersonService {
	// basic message
	public BaseExecution register(String account, String password, String name, String telephone, String position);
	public BaseExecution login(String account, String password);
	public Person getPerson(String account);
	public BaseExecution updatePerson(String account,String name, String telephone, String password);
	public BaseExecution changePassword(String account, String oldPass, String newPass);
	public BaseExecution forgetPassword(String account, String name, String telephone, String password);

	// Ordered
	public List<OrderedMenu> selectOrderedPublicByCustomer(String account, String type, String useTime);
	public List<OrderedMenu> selectOrderedPublicMenus(String type, String useTime, int start, int end);
	public List<OrderedMenu> selectOrderedPublicMenuNumbers(String type, String useTime, int start, int end);
	public List<OrderedMenu> selectOrderedPrivateByCustomer(String account, String type, String useTime);
	public List<OrderedMenu> selectOrderedPrivateMenus(String type, String useTime, int start, int end);

}
