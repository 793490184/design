package com.restaurant.dao;

import com.restaurant.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
	public int insertMenu(Menu menu);
	public int isExists(String name);
	public Menu checkDetail(int id);
	public void updateMenu(Menu menu);
	public void deleteMenu(int id);
	public int selectMenuNumber();
	public int selectMenuNumberBySeason(String season);
	public int selectMenuPublicNumber(String type);
	public int selectMenuPrivateNumber(String type);
	public List<Menu> selectMenu(@Param("start") int start, @Param("end") int end);
	public List<Menu> selectMenuByName(@Param("name") String name, @Param("start") int start, @Param("end") int end);
	public List<Menu> selectMenuBySeason(@Param("season") String season, @Param("start") int start, @Param("end") int end);
	public List<Menu> selectMenuByType(@Param("type") String type, @Param("start") int start, @Param("end") int end);

}
