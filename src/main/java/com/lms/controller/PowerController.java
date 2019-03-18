package com.lms.controller;

import com.lms.po.*;
import com.lms.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PowerController {
    @Autowired
    PowerService powerService;
    @Autowired
    MenuService menuService;

    @RequestMapping("/rolePower")
    public String rolePower(HttpServletRequest request){
        List<Role> roleList = powerService.findAllRole();
        request.setAttribute("roleList",roleList);
        return "roleManagement/rolePower";
    }

    @RequestMapping("/updataRolePower")
    public String updataRolePower(Integer roleId, HttpServletRequest request ){
        if (roleId!=null){
            Role role = powerService.findByRoleId(roleId);
            request.setAttribute("role",role);
        }
        return "roleManagement/updataRolePower";
    }

    @RequestMapping("/menuTree")
    @ResponseBody
    public List<Menu> menuTree(){
        /*Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC,"menuNum"));*/
        return menuService.findAll();
    }

    @RequestMapping("/deleteRole")
    public String deleteRole(Integer roleId, HttpServletRequest request){
        System.out.println(roleId);
        if (roleId!=null){
            System.out.println(roleId);
            powerService.deleteRole(roleId);
        }
        return "redirect:"+"/rolePower";
    }

    @RequestMapping("/savePowerRole")
    public String savePowerRole(Role role){
        powerService.saveRole(role);
        return "redirect:"+"/rolePower";
    }
}
