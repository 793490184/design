package com.restaurant.dao;

import com.restaurant.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {
	public int getAccountNumber(@Param("type") String type, @Param("startTime") String startTime, @Param("endTime") String endTime);
	public void insertAccount(Account account);
	public void deleteAccount(int id);
	public void updateAccount(Account account);
	public void accountPaid(int id);
	public List<Account> selectAccountByDate(@Param("dateBegin") String dateBegin, @Param("dateEnd") String dateEnd,
											 @Param("start") int start, @Param("end") int end);

}
