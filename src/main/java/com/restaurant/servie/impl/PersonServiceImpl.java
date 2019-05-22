package com.restaurant.servie.impl;

import com.restaurant.dao.OrderedPrivateMenuMapper;
import com.restaurant.dao.OrderedPublicMenuMapper;
import com.restaurant.dao.PersonMapper;
import com.restaurant.entity.OrderedMenu;
import com.restaurant.entity.Person;
import com.restaurant.servie.PersonService;
import com.restaurant.utils.BaseExecution;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

	@Resource
	private PersonMapper personMapper;
	@Resource
	private OrderedPublicMenuMapper orderedPublicMenuMapper;
	@Resource
	private OrderedPrivateMenuMapper orderedPrivateMenuMapper;

	private static final String KEY_SHA = "SHA";

	/**
	 * @param account
	 * @param password
	 * @return
	 * @author lihaimeng 2018/1/14
	 */
	public BaseExecution register(String account, String password, String name, String telephone, String position) {
//		PersonMapper personMapper = new PersonMapperImpl();
		if (account.contains(" ") || password.contains(" ")) {
			return new BaseExecution(200, BaseExecution.OK, "账号或密码包含空格");
		}
		if (personMapper.isExists(account) == 1) {
				return new BaseExecution(200, BaseExecution.OK, "账号已经存在");
		}
		password = encryption(password);
		System.out.println(password.length());
		System.out.println(account + ", " + password);
		Person person = new Person(account, password, name, telephone, position);
		personMapper.addPerson(person);
		return new BaseExecution(200, BaseExecution.OK, "注册成功");
	}

	/**
	 * @param account
	 * @param password
	 * @return
	 * @author lihaimeng 2018/1/14
	 */
	public BaseExecution login(String account, String password) {
		//  账号检测
		Person person = personMapper.selectPerson(account);
		String passFromFB = person.getPassword();
//		String passFromFB = personMapper.selectPassword(account);
		System.out.println(account + " " + password + " " + passFromFB);
		password = encryption(password);
		if (personMapper.isExists(account) == 0) {
			return new BaseExecution(200, BaseExecution.OK, "账号不存在");
		} else if (account.equals(account) && password.equals(passFromFB)) {
			System.out.println(person.getPosition());
			return new BaseExecution(200, BaseExecution.OK, person.getPosition());
		} else {
			return new BaseExecution(200, BaseExecution.OK, "密码错误");
		}
	}

	/**
	 * @param account
	 * @return
	 * @author lihaimeng 2018/2/3
	 */
	@Override
	public Person getPerson(String account) {
		if (personMapper.isExists(account) == 0) {
			return null;
		} else {
			Person person = personMapper.selectPerson(account);
			return person;
		}
	}

	/**
	 * @author lihaiemng 2018/2/3
	 * @param account
	 * @param name
	 * @param telephone
	 * @param password
	 * @return
	 */
	@Override
	public BaseExecution updatePerson(String account,String name, String telephone, String password) {
		if (personMapper.isExists(account) == 0) {
			return new BaseExecution(202, BaseExecution.OK, "账号不存在");
		} else {
			password = encryption(password);
			Person p = new Person(account, password, name, telephone);
			personMapper.updatePerson(p);
			return new BaseExecution(200, BaseExecution.OK, "密码修改成功");
		}
	}


	@Override
	public BaseExecution changePassword(String account, String oldPassword, String newPassword) {
		if (personMapper.isExists(account) == 0) {
			return new BaseExecution(200, BaseExecution.OK, "账号不存在");
		} else {
			oldPassword = encryption(oldPassword);
			String passwordFromDB = personMapper.selectPassword(account);
			if (passwordFromDB.equals(oldPassword)) {
				newPassword = encryption(newPassword);
				personMapper.changePassword(account, newPassword);
				return new BaseExecution(200, BaseExecution.OK, "密码修改成功");
			}
			else {
				return new BaseExecution(200, BaseExecution.OK, "旧密码输入错误");
			}
		}
	}

	/**
	 * @author lihaimeng 2018/2/3
	 * @param account
	 * @param name
	 * @param telephone
	 * @param password
	 * @return
	 */
	@Override
	public BaseExecution forgetPassword(String account, String name, String telephone, String password) {
		// 鉴定用户是否正确
		if (personMapper.isExists(account) == 0) {
			return new BaseExecution(202, BaseExecution.OK, "账号不存在");
		} else {
			Person person = personMapper.selectPerson(account);
			if (!person.getName().equals(name)) {
				return new BaseExecution(200, BaseExecution.OK, "输入的基本信息不正确");
			} else if (!person.getTelephone().equals(telephone)) {
				return new BaseExecution(200, BaseExecution.OK, "输入的基本信息不正确");
			} else {
				password = encryption(password);
				Person p = new Person(account, password, name, telephone);
				personMapper.updatePerson(p);
				return new BaseExecution(200, BaseExecution.OK, "基本信息修改成功");
			}
		}
	}

	/**
	 * @author lihaimeng 2018/2/17
	 * @param account
	 * @param type
	 * @param useTime
	 * @return
	 */
	@Override
	public List<OrderedMenu> selectOrderedPublicByCustomer(String account, String type, String useTime) {
//		orderedPublicMenuMapper.selectOrderedAsPublic()
		return null;
	}

	@Override
	public List<OrderedMenu> selectOrderedPublicMenus(String type, String useTime, int start, int end) {
		return null;
	}

	@Override
	public List<OrderedMenu> selectOrderedPublicMenuNumbers(String type, String useTime, int start, int end) {
		return null;
	}

	@Override
	public List<OrderedMenu> selectOrderedPrivateByCustomer(String account, String type, String useTime) {
		return null;
	}

	@Override
	public List<OrderedMenu> selectOrderedPrivateMenus(String type, String useTime, int start, int end) {
		return null;
	}


	/**
	 * @param password
	 * @return
	 * @author lihaimeng 2018/1/14
	 */
	private static String encryption(String password) {
		BigInteger sha = null;
		byte[] inputData = password.getBytes();
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
			messageDigest.update(inputData);
			sha = new BigInteger(messageDigest.digest());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sha.toString(32);
	}

}
