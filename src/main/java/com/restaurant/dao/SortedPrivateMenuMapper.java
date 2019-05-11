package com.restaurant.dao;

import com.restaurant.entity.SortedMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SortedPrivateMenuMapper {

	public int getPrivateNumber();
	public void selectMenuAsPrivate(int id);
	public void removeMenuPrivate(int id);
	public List<SortedMenu> selectPrivateMenus(@Param("start") int start, @Param("end") int end);
	public List<SortedMenu> selectPrivateMenuBySeason(@Param("season") String season, @Param("start") int start, @Param("end") int end);
	public List<SortedMenu> selectPrivateMenuByName(@Param("name") String name, @Param("start") int start, @Param("end") int end);
	public List<SortedMenu> selectPrivateMenuByType(@Param("season") String season, @Param("type") String type, @Param("start") int start, @Param("end") int end);



}
