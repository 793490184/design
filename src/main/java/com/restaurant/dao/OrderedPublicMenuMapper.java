package com.restaurant.dao;

import com.restaurant.entity.OrderedMenu;
import com.restaurant.entity.SortedMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.core.annotation.Order;

import java.util.List;

public interface OrderedPublicMenuMapper {

	public int selectOrderedPublic(String type);

	public void selectOrderedAsPublic(@Param("menuId")int menuId, @Param("account")String account,
									   @Param("type")String type, @Param("useTime")String useTime,
									   @Param("number")int number);
	public void removeOrderedPublic(@Param("menuId")int menuId, @Param("account")String account,
									 @Param("type")String type, @Param("useTime")String useTime);
	public List<OrderedMenu> selectOrderedPublicByCustomer(@Param("account")String account, @Param("useTime")String useTime,
														   @Param("start") int start, @Param("end") int end);
	public List<OrderedMenu> selectOrderedPublicMenus(@Param("type")String type, @Param("useTime")String useTime,
													   @Param("start") int start, @Param("end") int end);

	public List<OrderedMenu> selectOrderedPublicMenuNumbers(@Param("type")String type, @Param("useTime")String useTime,
															@Param("start") int start, @Param("end") int end);

}
