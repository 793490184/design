package com.restaurant.controller;

import com.restaurant.entity.Menu;
import com.restaurant.entity.OrderedMenu;
import com.restaurant.entity.SortedMenu;
import com.restaurant.servie.CookerService;
import com.restaurant.servie.ManagerService;
import com.restaurant.servie.StoremanService;
import com.restaurant.utils.BaseExecution;
import com.restaurant.utils.BaseInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/html")
public class CookerController {

    @Resource
    private CookerService cookerService;
    @Resource
    private ManagerService managerService;
    @Resource
    private StoremanService storemanService;

    /**
     * @author lihaimeng
     * @return
     */
    @RequestMapping("/get_menu_number.do")
    @ResponseBody
    public BaseExecution getMenuNumber(String place, String type, String startTime, String endTime) {
        class Number {
            private String number;

            public Number(String number) {
                this.number = number;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }
        }
//        System.out.println(place + type);
        int result;
        System.out.println(type + startTime + endTime);
        if (type.equals("in") || type.equals("out")) {
            if (startTime.equals(""))
                startTime = "1970-01-01";
            result = managerService.getExpandNumber(type, startTime, endTime);
        } else if (type.equals("1") || type.equals("2")|| type.equals("0")) {
            if (startTime.equals(""))
                startTime = "1970-01-01";
            result = managerService.getAccountNumber(type, startTime, endTime);
        } else if (place.equals("food")) {
            result = storemanService.getFoodNumber(type);
        } else {
            result = cookerService.getMenuNumber(place, type);
        }
        Number number = new Number(String.valueOf(result));
        return new BaseExecution(200, "ok", number);
    }

    /**
     * @author lohaimeng
     * @param name
     * @param type
     * @param price
     * @param season
     */
    @RequestMapping("/add_menu.do")
    @ResponseBody
    public BaseExecution addMenu(String name, String type, double price, String season) {
        Menu menu = new Menu(name, type, price, season);
        int result = cookerService.addMenu(menu);
        if (result == 0) {
            return new BaseExecution(200, "ok", "该菜品已经存在");
        } else {
            return new BaseExecution(200, "ok", "插入新菜品成功");
        }
    }

    @RequestMapping("/remove_menu.do")
    @ResponseBody
    public BaseExecution removeMenu(int id, String name) {
        int result = cookerService.removeMenu(id, name);
        if (result == 0) {
            return new BaseExecution(200, "ok", "该菜品不存在");
        } else {
            return new BaseExecution(200, "ok", "删除菜品成功");
        }
    }

    @RequestMapping("/update_menu.do")
    @ResponseBody
    public BaseExecution updateMenu(int id, String name, String type, double price, String season) {
        Menu menu = new Menu(id, name, type, price, season);
        cookerService.updateMenu(menu);
        return new BaseExecution(200, "ok", "更新菜品成功");
    }

    @RequestMapping("/check_detail.do")
    @ResponseBody
    public BaseExecution checkDetail(int id, String name) {
        Menu menu = cookerService.checkDetail(id, name);
        if (menu == null) {
            return new BaseExecution(200, "ok", "该菜品不存在");
        }
        return new BaseExecution(200, "ok", menu);
    }

    @RequestMapping("/select_menu.do")
    @ResponseBody
    public BaseExecution selectMenu(int p) {
        int start = p * 10;
        int end = p * 10 + 9;
        List<Menu> menuList = cookerService.selectMenu(start, end);
        return new BaseExecution(200, "ok", menuList);
    }

    @RequestMapping("/select_menu_by_name.do")
    @ResponseBody
    public BaseExecution selectMenuByName(String name, int page) {
        int start = page * 10;
        int end = page * 10 + 9;
        List<Menu> menuList = cookerService.selectMenuByName(name, start, end);
        return new BaseExecution(200, "ok", menuList);
    }

    @RequestMapping("/select_menu_by_season.do")
    @ResponseBody
    public BaseExecution selectMenuBySeason(String season, int p) {
        int start = p * 10;
        int end = p * 10 + 9;
        List<Menu> menuList = cookerService.selectMenuBySeason(season, start, end);
        return new BaseExecution(200, "ok", menuList);
    }

    @RequestMapping("/select_menu_by_type.do")
    @ResponseBody
    public BaseExecution selectMenuByType(String type, int p) {
        int start = p * 10;
        int end = p * 10 + 9;
        List<Menu> menuList = cookerService.selectMenuByType(type, start, end);
        return new BaseExecution(200, "ok", menuList);
    }

    // Sorted
    @RequestMapping("/get_public_number.do")
    @ResponseBody
    public BaseExecution getPublicNumber(String type) {
        class Number {
            int number;

            public Number(int number) {
                this.number = number;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }
        }
        System.out.println(type);
        int result = cookerService.getPublicNumber();
        System.out.println(result);
        Number number = new Number(result);
        return new BaseExecution(200, "ok", number);
    }

    @RequestMapping("/select_menu_as_public.do")
    @ResponseBody
    public BaseExecution selectMenuAsPublic(int id) {
        cookerService.selectMenuAsPublic(id);
        return new BaseExecution(200, "ok", "选择成功");
    }

    @RequestMapping("/remove_menu_public.do")
    @ResponseBody
    public BaseExecution removeMenuPublic(int id) {
        cookerService.removeMenuPublic(id);
        return new BaseExecution(200, "ok", "移出成功");
    }

    @RequestMapping("/select_public_menus.do")
    @ResponseBody
    public BaseExecution selectPublicMenus(int p, String type) {
        System.out.println("111" + p + type);
        int start = p * 10;
        int end = p * 10 + 9;
        if (p < 0) {
            start = 0;
            end = p * (-1);
        }
        List<SortedMenu> sortedMenuList = cookerService.selectPublicMenuByType(type, start, end);
        return new BaseExecution(200, "ok", sortedMenuList);

    }

    @RequestMapping("/select_public_menu_by_season.do")
    @ResponseBody
    public BaseExecution selectPublicMenuBySeason(String type, int p) {
        int start = p * 10;
        int end = p * 10 + 9;
        if (p <= 0) {
            start = 0;
            end = -1 * p;
        }
        List<SortedMenu> sortedMenuList = cookerService.selectPublicSortedMenu(type, start, end);
        return new BaseExecution(200, "ok", sortedMenuList);
    }

    @RequestMapping("/select_public_menu_by_name.do")
    @ResponseBody
    public BaseExecution selectPublicMenuByName(String name, int start, int end) {
        List<SortedMenu> sortedMenuList = cookerService.selectPublicMenuByName(name, start, end);
        return new BaseExecution(200, "ok", sortedMenuList);
    }

    @RequestMapping("/select_public_menu_by_type.do")
    @ResponseBody
    public BaseExecution selectPublicMenuByType(String type, int start, int end) {
        List<SortedMenu> sortedMenuList = cookerService.selectPublicMenuByType(type, start, end);
        return new BaseExecution(200, "ok", sortedMenuList);
    }

    @RequestMapping("/get_private_number.do")
    @ResponseBody
    public BaseExecution getPrivateNumber() {
        class Number {
            private String number;

            public Number(String number) {
                this.number = number;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }
        }
        int result = cookerService.getPrivateNumber();
        Number number = new Number(String.valueOf(result));
        return new BaseExecution(200, "ok", number);
    }

    @RequestMapping("/select_menu_as_private.do")
    @ResponseBody
    public BaseExecution selectMenuAsPrivate(int id) {
        cookerService.selectMenuAsPrivate(id);
        return new BaseExecution(200, "ok", "选择成功");
    }

    @RequestMapping("/remove_menu_private.do")
    @ResponseBody
    public BaseExecution removeMenuPrivate(int id) {
        cookerService.removeMenuPrivate(id);
        return new BaseExecution(200, "ok", "移出成功");
    }

    @RequestMapping("/select_private_menus.do")
    @ResponseBody
    public BaseExecution selectPrivateMenus(int p, String type) {
        int start = p * 10;
        int end = p * 10 + 9;
        List<SortedMenu> sortedMenuList = cookerService.selectPrivateMenuByType(type, start, end);
        return new BaseExecution(200, "ok", sortedMenuList);

    }

    @RequestMapping("/select_private_menu_by_season.do")
    @ResponseBody
    public BaseExecution selectPrivateMenuBySeason(int p, String type) {
        int start = p * 10;
        int end = p * 10 + 9;
        List<SortedMenu> sortedMenuList = cookerService.selectPrivateSortedMenu(type, start, end);
        return new BaseExecution(200, "ok", sortedMenuList);
    }

    @RequestMapping("/select_private_menu_by_name.do")
    @ResponseBody
    public BaseExecution selectPrivateMenuByName(String name, int start, int end) {
        List<SortedMenu> sortedMenuList = cookerService.selectPrivateMenuByName(name, start, end);
        return new BaseExecution(200, "ok", sortedMenuList);
    }

    @RequestMapping("/select_private_menu_by_type.do")
    @ResponseBody
    public BaseExecution selectPrivateMenuByType(String type, int start, int end) {
        List<SortedMenu> sortedMenuList = cookerService.selectPrivateMenuByType(type, start, end);
        return new BaseExecution(200, "ok", sortedMenuList);
    }

    //ordered
    @RequestMapping("/select_ordered_private_menus.do")
    @ResponseBody
    public BaseExecution selectOrderedPrivateMenus(String type, String useTime, int start, int end) {
        List<OrderedMenu> orderedMenuList = cookerService.selectOrderedPrivateMenus(type, useTime, start, end);
        return new BaseExecution(200, "ok", orderedMenuList);
    }

    @RequestMapping("/select_ordered_public_menus.do")
    @ResponseBody
    public BaseExecution selectOrderedPublicMenus(String type, String useTime, int start, int end) {
        List<OrderedMenu> orderedMenuList = cookerService.selectOrderedPublicMenus(type, useTime, start, end);
        return new BaseExecution(200, "ok", orderedMenuList);
    }

    @RequestMapping("/select_ordered_public_menu_numbers.do")
    @ResponseBody
    public BaseExecution selectOrderedPublicMenuNumbers(String type, String date, Integer p, String restaurant) {
        int start = p < 0 ? 0 : p * 10;
        int end = p < 0 ? p * (-1) : p * 10 + 9;

        List<OrderedMenu> orderedMenuList = cookerService.selectOrderedPublicMenuNumbers(type, restaurant, date, start, end);
        return new BaseExecution(200, "ok", orderedMenuList);
    }

    @RequestMapping("/select_ordered_private_menu_numbers.do")
    @ResponseBody
    public BaseExecution selectOrderedPrivateMenuNumbers(String type, String useTime, int start, int end) {
        List<OrderedMenu> orderedMenuList = cookerService.selectOrderedPrivateMenuNumbers(type, useTime, start, end);
        return new BaseExecution(200, "ok", orderedMenuList);
    }

    @RequestMapping("/select_ordered_number.do")
    @ResponseBody
    public BaseExecution selectOrderedNumber(String place, String type) {
        class Number {
            int number;

            public Number(int number) {
                this.number = number;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }
        }
        int result = cookerService.selectOrderedNumber(place, type);
        Number number = new Number(result);
        return new BaseExecution(200, "ok", number);
    }


}
