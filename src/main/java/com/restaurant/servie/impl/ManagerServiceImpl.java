package com.restaurant.servie.impl;

import com.restaurant.dao.AccountMapper;
import com.restaurant.dao.ExpandMapper;
import com.restaurant.entity.Account;
import com.restaurant.entity.Expand;
import com.restaurant.servie.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Resource
	private AccountMapper accountMapper;
	@Resource
	private ExpandMapper expandMapper;

	@Override
	public int getAccountNumber(String type, String startTime, String endTime) {
		return 0;
	}

	@Override
	public void insertAccount(Account account) {
		accountMapper.insertAccount(account);
	}

	@Override
	public void deleteAccount(int id) {
		accountMapper.deleteAccount(id);
	}

	@Override
	public void updateAccount(Account account) {
		accountMapper.updateAccount(account);
	}

	@Override
	public void accountPaid(int id) {
		accountMapper.accountPaid(id);
	}

	@Override
	public List<Account> selectAccountByDate(String dateBegin, String dateEnd, int start, int end) {
		List<Account> accountList = accountMapper.selectAccountByDate(dateBegin, dateEnd, start, end);
		return accountList;
	}

	@Override
	public int getExpandNumber(String type, String startTime, String endTime) {
		int result = expandMapper.getExpandNumber(type, startTime, endTime);
		return result;
	}

	@Override
	public void insert(Expand expand) {
		expandMapper.insert(expand);
	}

	@Override
	public void update(Expand expand) {
		expandMapper.update(expand);
	}

	@Override
	public void deleteFromDB(int id) {
		expandMapper.deleteFromDB(id);
	}

	@Override
	public List<Expand> selectExpandByData(String dateBegin, String dateEnd, String type,  int start, int end) {
		List<Expand> expandList = expandMapper.selectExpandByData(dateBegin, dateEnd, type,  start, end);
		double money = 0;
		for(Iterator iterators = expandList.iterator(); iterators.hasNext();){
			Expand tmp = (Expand) iterators.next();
			money += tmp.getMoney();
		}
		Expand tmp = new Expand(money);
		List<Expand> result = new ArrayList<>();
		result.add(tmp);
		result.addAll(expandList);
		return result;
	}

	@Override
	public List<Expand> selectExpandByType(String type, int start, int end) {
		List<Expand> expandList = expandMapper.selectExpandByType(type, start, end);
		return expandList;
	}

	@Override
	public List<Expand> selectExpands(String dateBegin, String dateEnd, String type, int start, int end) {
		List<Expand> expandList = expandMapper.selectExpands(dateBegin, dateEnd, type, start, end);
		return expandList;
	}
}
