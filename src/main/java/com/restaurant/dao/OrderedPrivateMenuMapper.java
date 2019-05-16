package com.restaurant.dao;

import com.restaurant.entity.OrderedMenu;
import com.restaurant.entity.SortedMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderedPrivateMenuMapper {

	public int selectOrderedPrivate(String type);

	public void selectOrderedAsPrivate(@Param("menuId")int menuId, @Param("account")String account,
									   @Param("type")String type, @Param("useTime")String useTime,
									   @Param("number")int number);
	public void removeOrderedPrivate(@Param("menuId")int menuId, @Param("account")String account,
									 @Param("type")String type, @Param("useTime")String useTime);
	public List<OrderedMenu> selectOrderedPrivateByCustomer(@Param("account")String account, @Param("useTime")String useTime,
															@Param("start") int start, @Param("end") int end);
	public List<OrderedMenu> selectOrderedPrivateMenus(@Param("type")String type, @Param("useTime")String useTime,
													   @Param("start") int start, @Param("end") int end);
	public List<OrderedMenu> selectOrderedPrivateMenuNumbers(@Param("type")String type, @Param("useTime")String useTime,
															@Param("start") int start, @Param("end") int end);
	public void customerMark(@Param("menuId") Integer menuId, @Param("useTime") String useTime,
							 @Param("account") String account, @Param("grade") Integer grade);
	public double getAvgMark(Integer menuId);
	public void updateMenuMark(@Param("menuId") Integer menuId, @Param("mark") double mark);

}
