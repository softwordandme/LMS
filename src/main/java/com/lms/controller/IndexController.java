package com.lms.controller;

import com.lms.dao.StudentDao;
import com.lms.po.*;
import com.lms.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *主界面内容
 *
 *@author 神
 * @date 2018.12.7
 */
@Controller
public class IndexController {


    @Autowired
    StudentDao studentDao;


    @RequestMapping("/test")
    public String test(Model model){
        List<Student> c=studentDao.findAll() ;
        model.addAttribute("test",c);
        for(Student cc: c){
            System.out.printf(cc.getStudentNo()+cc.getStudentName()+"噢噢噢噢");
        }
        return "/Admin/test";
    }

}
