package com.lms.controller;

import com.lms.po.*;
import com.lms.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SelfMessageController {
    @Autowired
    SelfMessageService selfMessageService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    RoleService roleService;

    /**
     * 个人信息
     */
    @RequestMapping("/myMessage")
    public String message(HttpServletRequest request){
        HttpSession session = request.getSession();
        String roleTypeS = (String) session.getAttribute("roleType");

        Integer roleType = Integer.parseInt(roleTypeS);

        if (roleType == null){
            return "error_no_login";
        }
        if(roleType == 1){
            String userid = (String) session.getAttribute("userId");
            Student student = selfMessageService.findStudentAll(userid);
            Integer departmentId = student.getDepartmentId();
            if(departmentId != null){
                Department department = selfMessageService.findDepartmentAll(departmentId);
                session.setAttribute("userDepartment",department.getDepartmentName());
            }

            session.setAttribute("userSex",student.getStudentSex());

            session.setAttribute("userClazz",student.getClazzNum());
        } else {
            String userid = (String) session.getAttribute("userId");
            Teacher teacher = selfMessageService.findTeacherAll(userid);
            Integer departmentId = teacher.getDepartmentId();
            if(departmentId != null){
                Department department = selfMessageService.findDepartmentAll(departmentId);
                session.setAttribute("userDepartment",department.getDepartmentName());
            }
            session.setAttribute("userSex",teacher.getTeacherSex());
            session.setAttribute("teacherStatus",teacher.getTeacherStatus());
        }
        return "myMessage/myMessage";
    }

    /**
     * 修改密码
     */
    @RequestMapping("/changPassword")
    public String changMessage(){
        return "myMessage/changPassword";
    }

    /**
     * 修改密码提交
     */
    @RequestMapping("changPasswordDo")
    @ResponseBody
    public String changMessageDo(@RequestParam(value = "oldPassword") String oldPassword, @RequestParam(value = "newPassword") String newPassword, HttpServletRequest request){
        HttpSession session = request.getSession();
        String userid = (String) session.getAttribute("userId");
        String roleIdS = (String) session.getAttribute("roleType");
        Integer roleId = Integer.parseInt(roleIdS);
        return selfMessageService.changPasswordByStudentNo(oldPassword,newPassword,userid,roleId);
    }
}
