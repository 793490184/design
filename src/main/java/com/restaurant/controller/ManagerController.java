package com.restaurant.controller;

import com.restaurant.entity.Account;
import com.restaurant.entity.Expand;
import com.restaurant.servie.ManagerService;
import com.restaurant.utils.BaseExecution;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Resource
    private ManagerService managerService;

    @RequestMapping("/insert_account.do")
    @ResponseBody
    public BaseExecution insertAccount(String date, String name, String message, double money, int paidFlag) {
        Account account = new Account(date, name, message, money, paidFlag);
        managerService.insertAccount(account);
        return new BaseExecution(200, "ok", "插入账单成功");
    }

    @RequestMapping("/delete_account.do")
    @ResponseBody
    public BaseExecution deleteAccount(Integer id) {
        managerService.deleteAccount(id);
        return new BaseExecution(200, "ok", "删除账单成功");
    }

    @RequestMapping("/update_account.do")
    @ResponseBody
    public BaseExecution updateAccount(Integer id, String date, String name, String message, double money, int paidFlag) {
        Account account = new Account(id, date, name, message, money, paidFlag);
        managerService.updateAccount(account);
        return new BaseExecution(200, "ok", "更新账单成功");
    }

    @RequestMapping("/account_paid.do")
    @ResponseBody
    public BaseExecution accountPaid(int id) {
        managerService.accountPaid(id);
        return new BaseExecution(200, "ok", "账单支付成功");
    }

    @RequestMapping("/select_account_by_date.do")
    @ResponseBody
    public BaseExecution selectAccountByDate(String dateBegin, String dateEnd, int p) {
        int start = p * 10;
        int end = p * 10 + 9;
        System.out.println(dateBegin + dateEnd + p);
        List<Account> accountList = managerService.selectAccountByDate(dateBegin, dateEnd, start, end);
        return new BaseExecution(200, "ok", accountList);
    }

    // expand
    @RequestMapping("/insert_expand.do")
    @ResponseBody
    public BaseExecution insert(String date, String type, double money, String message) {
        Expand expand = new Expand(date, type, money, message);
        managerService.insert(expand);
        return new BaseExecution(200, "ok", "插入成功");
    }

    @RequestMapping("/delete_expand.do")
    @ResponseBody
    public BaseExecution deleteFromDB(int id) {
        managerService.deleteFromDB(id);
        return new BaseExecution(200, "ok", "删除成功");
    }

    @RequestMapping("/select_expand_by_date.do")
    @ResponseBody
    public BaseExecution selectExpandByDate(String dateBegin, String dateEnd, String type, int p) {
        int start = p * 10;
        int end = p * 10 + 9;
        List<Expand> expandList = managerService.selectExpandByData(dateBegin, dateEnd, type, start, end);
        return new BaseExecution(200, "ok", expandList);
    }

    @RequestMapping("/select_expand_by_type.do")
    @ResponseBody
    public BaseExecution selectExpandByType(String type, int start, int end) {
        List<Expand> expandList = managerService.selectExpandByType(type, start, end);
        return new BaseExecution(200, "ok", expandList);
    }


    @RequestMapping("/update_expand.do")
    @ResponseBody
    public BaseExecution update(int id, String date, double money, String type) {
        Expand expand = new Expand(id, date, type, money);
        managerService.update(expand);
        return new BaseExecution(200, "ok", "已经修改");
    }


    @RequestMapping("/select_expands.do")
    @ResponseBody
    public BaseExecution selectExpands(String dateBegin, String dateEnd, String type, int p) {
        int start = p * 10;
        int end = p * 10 + 9;
        List<Expand> expandList = managerService.selectExpands(dateBegin, dateEnd, type, start, end);
        return new BaseExecution(200, "ok", expandList);
    }


}
