package com.restaurant.dao;

import com.restaurant.entity.SortedMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SortedPublicMenuMapper {

	public int getPublicNumber();
	public void selectMenuAsPublic(int id);
	public void removeMenuPublic(int id);
	public List<SortedMenu> selectPublicMenus(@Param("start") int start, @Param("end") int end);
	public List<SortedMenu> selectPublicSortedMenu(@Param("season") String season, @Param("type") String type, @Param("start") int start, @Param("end") int end);
	public List<SortedMenu> selectPublicMenuByType(@Param("season") String season, @Param("type") String type, @Param("start") int start, @Param("end") int end);
	public List<SortedMenu> selectPublicMenuByName(@Param("name") String name, @Param("start") int start, @Param("end") int end);


}
