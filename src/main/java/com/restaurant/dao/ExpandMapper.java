package com.restaurant.dao;

import com.restaurant.entity.Expand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExpandMapper {

	public void insert(Expand expand);
	public void deleteFromDB(@Param("id") int id);
	public List<Expand> selectExpandByData(@Param("dateBegin") String dateBegin, @Param("dateEnd") String dateEnd,
										   @Param("start") int start, @Param("end") int end);
	public List<Expand> selectExpandByType(@Param("type") String type, @Param("start") int start, @Param("end") int end);
	public List<Expand> selectExpands(@Param("dateBegin") String dateBegin, @Param("dateEnd") String dateEnd,
									  @Param("type") String type, @Param("start") int start, @Param("end") int end);


}
