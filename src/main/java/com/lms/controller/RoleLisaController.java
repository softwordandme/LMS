package com.lms.controller;

import com.lms.po.*;
import com.lms.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RoleLisaController {
    @Autowired
    RoleService roleService;

    /*加载列表*/
    @RequestMapping("RoleList")
    public String roleList(HttpServletRequest request, Model model){
        List <Teacher> teacherList = roleService.findAllTeacher();
        for(int i=0; i<teacherList.size(); i++){
            String roleId = teacherList.get(i).getRoleId();
            String roleName=roleService.findByRoleId(roleId).getRoleName();
            System.out.print(roleName);
            teacherList.get(i).setRoleId(roleName);
        }
        model.addAttribute("teacherList",teacherList);
        return "roleManagement/RoleList";
    }

  /*  @RequestMapping("roleChange")
    @ResponseBody
    public String roleChange(@RequestParam(value = "teacherNo") String teacherNo,@RequestParam(value = "roleId") Integer roleId){
        return roleService.saveTeacherRole(teacherNo,roleId);
    }*/

    @RequestMapping("updateRole")
    public String uodateRole(HttpServletRequest request, String teacherNo){
        Teacher teacher = roleService.findByTeacherNo(teacherNo);
        List<Role> roleList = roleService.findAllRole();
        request.setAttribute("roleList",roleList);
        request.setAttribute("teacher",teacher);
        return "roleManagement/updateRole";
    }

    @RequestMapping("saveRole")
    public String saveRole(Teacher teacher){
        System.out.println(teacher.getRoleId());
        roleService.saveTeacherRole(teacher.getTeacherNo(),teacher.getRoleId());
        return "redirect:"+"/RoleList";
    }
}
