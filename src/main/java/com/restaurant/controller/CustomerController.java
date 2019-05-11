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
    public BaseExecution selectOrderedAsPublic(int menuId, String account, String type, String useTime, int number) {
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
    public BaseExecution selectOrderedPublicByCustomer(String account, String type, String useTime) {
        List<OrderedMenu> orderedMenuList = customerService.selectOrderedPublicByCustomer(account, type, useTime);
        return new BaseExecution(200, "ok", orderedMenuList);
    }

    @RequestMapping("/select_ordered_as_private.do")
    @ResponseBody
    public BaseExecution selectOrderedAsPrivate(int menuId, String account, String type, String useTime, int number) {
        customerService.selectOrderedAsPrivate(menuId, account, type, useTime, number);
        return new BaseExecution(200, "ok", "订餐成功");
    }
    @RequestMapping("/remove_ordered_private.do")
    @ResponseBody
    public BaseExecution removeOrderedPrivate(int menuId, String account, String type, String useTime) {
        customerService.removeOrderedPrivate(menuId, account, type, useTime);
        return new BaseExecution(200, "ok", "取消订餐成功");
    }
    @RequestMapping("/select_ordered_private_by_customer.do")
    @ResponseBody
    public BaseExecution selectOrderedPrivateByCustomer(String account, String type, String useTime) {
        List<OrderedMenu> orderedMenuList = customerService.selectOrderedPrivateByCustomer(account, type, useTime);
        return new BaseExecution(200, "ok", orderedMenuList);
    }

    @RequestMapping("/select_ordered_by_customer")
    @ResponseBody
    public BaseExecution selectOrderedByCustomer(String type, String account) {
         return null;
    }

}
