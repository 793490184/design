package com.restaurant.servie;

import com.restaurant.entity.Account;
import com.restaurant.entity.Expand;

import java.util.List;

public interface ManagerService {
	// account
	public int getAccountNumber(String type, String startTime, String endTime);
	public void insertAccount(Account account);
	public void deleteAccount(int id);
	public void updateAccount(Account account);
	public void accountPaid(int id);
	public List<Account> selectAccountByDate(String dateBegin, String dateEnd, int start, int end);

	// expand
	public int getExpandNumber(String type, String startTime, String endTime);
	public void insert(Expand expand);
	public void update(Expand expand);
	public void deleteFromDB(int id);
	public List<Expand> selectExpandByData(String dateBegin, String dateEnd, String type, int start, int end);
	public List<Expand> selectExpandByType(String type, int start, int end);
	public List<Expand> selectExpands(String dateBegin, String dateEnd, String type, int start, int end);


}
