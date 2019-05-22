package com.restaurant.controller;

import com.alibaba.fastjson.JSON;
import com.restaurant.entity.Person;
import com.restaurant.servie.PersonService;
import com.restaurant.servie.impl.PersonServiceImpl;
import com.restaurant.utils.BaseExecution;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class PersonController {

	@Resource
	private PersonService personService;


	@RequestMapping("/test.do")
	@ResponseBody
	public BaseExecution test(String param) {
		BaseExecution baseExecution = new BaseExecution(200, "ok", "{");
		System.out.println(param);
		return baseExecution;
	}

	@RequestMapping("/test1.do")
	@ResponseBody
	public BaseExecution test1(@RequestParam("param") String param) {
		BaseExecution baseExecution = new BaseExecution(200, "ok", "{");
		System.out.println(param);
		return baseExecution;
	}

	/**
	 * @param account
	 * @param password
	 * @return
	 * @author lihaimeng 2018/1/14
	 */
	@ResponseBody
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public BaseExecution register(String account, String password, String name, String telephone, String position) {
//		Person person = new Person(account, password, name, telephone);
//		System.out.println(JSON.toJSONString(person));
		BaseExecution baseExecution = personService.register(account, password, name, telephone, position);
		return baseExecution;
	}

	/**
	 * @param account
	 * @param password
	 * @return
	 * @author lihaimeng 2018/1/14
	 */
	@ResponseBody
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public BaseExecution login(@RequestParam("account") String account, @RequestParam("password") String password) {
		BaseExecution baseExecution = personService.login(account, password);
		return baseExecution;
	}

//	@ResponseBody
//	@RequestMapping(value = "/getPerson.do", method = RequestMethod.POST)
//    public BaseExecution getPerson(@RequestParam("account")String account) {
//		BaseExecution baseExecution = personService.getPerson(account);
//		return baseExecution;
//	}

	/**
	 * @author lihaimeng 2018/2/3
	 */
	@ResponseBody
	@RequestMapping(value = "/change_password.do", method = RequestMethod.POST)
	public BaseExecution changePassword(@RequestParam("account") String account, @RequestParam("oldPassword") String oldPassword,
										@RequestParam("newPassword") String newPassword) {
		BaseExecution baseExecution = personService.changePassword(account, oldPassword, newPassword);
		return baseExecution;
	}


	@ResponseBody
	@RequestMapping(value = "/get_person.do", method = RequestMethod.POST)
	public BaseExecution getPerson(@RequestParam("account") String account) {
		Person person = personService.getPerson(account);
		if (person == null) {
			return new BaseExecution(200, "ok", "该用户不存在");
		}
		BaseExecution baseExecution = new BaseExecution(200, "ok", person);
		return baseExecution;
	}


	@ResponseBody
	@RequestMapping(value = "/forget_password.do", method = RequestMethod.POST)
	public BaseExecution forgetPassword(@RequestParam("account") String account, @RequestParam("name") String name,
										@RequestParam("telephone") String telephone, @RequestParam("password") String password) {
		BaseExecution baseExecution = personService.forgetPassword(account, name, telephone, password);
		return baseExecution;
	}

	@ResponseBody
	@RequestMapping(value = "/update_person.do", method = RequestMethod.POST)
	public BaseExecution updatePerson(@RequestParam("account") String account, @RequestParam("name") String name,
									  @RequestParam("telephone") String telephone, @RequestParam("password") String password) {
		BaseExecution baseExecution = personService.updatePerson(account, name, telephone, password);
		return baseExecution;
	}


}
