package com.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeachManagementController {

    @RequestMapping("teachManagementStudent")
    public String teachManagementStudent(){
        return "teachManagement/teachManagementStudent";
    }

    @RequestMapping("teachManagementTeacher")
    public String teachManagementTeacher(){
        return "teachManagement/teachManagementTeacher";
    }

    @RequestMapping("teachManagementStudentList")
    @ResponseBody
    public String teachManagementStudentList(){
        String x = "";
        return x;
    }


}
