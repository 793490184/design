package com.restaurant.controller;

import com.restaurant.entity.OrderedMenu;
import com.restaurant.servie.CustomerService;
import com.restaurant.utils.BaseExecution;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    CustomerService customerService;

    @RequestMapping("/select_ordered_as_public.do")
    @ResponseBody
    public BaseExecution selectOrderedAsPublic(int menuId, String account, String type, String useTime) {
        int number = 1;
        customerService.selectOrderedAsPublic(menuId, account, type, useTime, number);
        return new BaseExecution(200, "ok", "订餐成功");
    }
    @RequestMapping("/remove_ordered_public.do")
    @ResponseBody
    public BaseExecution removeOrderedPublic(int menuId, String account, String type, String useTime) {
        customerService.removeOrderedPublic(menuId, account, type, useTime);
        return new BaseExecution(200, "ok", "取消订餐成功");
    }
    @RequestMapping("/select_ordered_public_by_customer.do")
    @ResponseBody
    public BaseExecution selectOrderedPublicByCustomer(String account, Integer p, String useTime) {
        System.out.println(account + "," + p + "," + useTime);
        int start = p * 10;
        int end = p * 10 + 9;
        List<OrderedMenu> orderedMenuList = customerService.selectOrderedPublicByCustomer(account, useTime, start, end);
        System.out.println(orderedMenuList.toString());
        return new BaseExecution(200, "ok", orderedMenuList);
    }

    @RequestMapping("/select_ordered_as_private.do")
    @ResponseBody
    public BaseExecution selectOrderedAsPrivate(Integer menuId, String account, String type, String useTime) {
        int number = 1;
        customerService.selectOrderedAsPrivate(menuId, account, type, useTime, number);
        return new BaseExecution(200, "ok", "订餐成功");
    }
    @RequestMapping("/remove_ordered_private.do")
    @ResponseBody
    public BaseExecution removeOrderedPrivate(Integer menuId, String account, String type, String useTime) {
        customerService.removeOrderedPrivate(menuId, account, type, useTime);
        return new BaseExecution(200, "ok", "取消订餐成功");
    }
    @RequestMapping("/select_ordered_private_by_customer.do")
    @ResponseBody
    public BaseExecution selectOrderedPrivateByCustomer(String account, Integer p, String useTime) {
        int start = p * 10;
        int end = p * 10 + 9;
        List<OrderedMenu> orderedMenuList = customerService.selectOrderedPrivateByCustomer(account, useTime, start, end);
        return new BaseExecution(200, "ok", orderedMenuList);
    }

    @RequestMapping("/user_mark.do")
    @ResponseBody
    public BaseExecution customerMark(Integer menuId, String useTime, String place, String account, Integer grade) {
        customerService.customerMark(menuId, useTime, place, account, grade);
        return new BaseExecution(200, "ok", "");
    }


}
