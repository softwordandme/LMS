package com.lms.controller;

import com.lms.po.*;
import com.lms.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuController {
    @Autowired
    MenuService menuService;

    @RequestMapping("/MenuList")
    public String menuList(HttpServletRequest request, HttpServletResponse response){
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC,"menuNum"));
        List<Menu> menuList = menuService.findAll(sort);
        List<Menu> parentMenuList = new ArrayList<>();
        List<Menu> chMenuList = new ArrayList<>();
        for(int i=0;i<menuList.size();i++){
            if(menuList.get(i).getMenuParentId()==null){
                parentMenuList.add(menuList.get(i));
            }
            if(menuList.get(i).getMenuParentId()!=null){
                chMenuList.add(menuList.get(i));
            }
        }

        request.setAttribute("parentMenuList",parentMenuList);
        request.setAttribute("chMenuList",chMenuList);
        return "MenuList";
    }

    @RequestMapping("/addOne")
    public String addOne(Integer id,HttpServletRequest request){
        if (id!=null){
            Menu menu = menuService.findMenuByMenuId(id);
            if(menu.getMenuParentId()!=null){
                String pname = menuService.findMenuByMenuId(menu.getMenuParentId()).getMenuName();
                menu.setPname(pname);
            }
            request.setAttribute("menu",menu);
        }
        return "addMenu";
    }

    @RequestMapping("/addTwo")
    public String addTwo(Integer menuParentId,HttpServletRequest request){
        Menu menu = new Menu();
        String pname = menuService.findMenuByMenuId(menuParentId).getMenuName();
        menu.setPname(pname);
        menu.setMenuParentId(menuParentId);
        request.setAttribute("menu",menu);
        return "addMenu";
    }

    @RequestMapping("/saveMenu")
    public String saveMenu(HttpServletRequest request, Menu menu){
        menuService.save(menu);
        return "redirect:"+"/MenuList";
    }

    @RequestMapping("/deleteMenu")
    public String deleteMenu(Integer id){
        menuService.deleteMenu(id);
        return "redirect:"+"/MenuList";
    }
}
