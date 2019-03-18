package com.lms.services;

import com.lms.dao.*;
import com.lms.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class LoginService {

    @Autowired
    StudentDao studentDao;
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    RoleDao roleDao;


    /*对比学生表密码*/
    public Student loginStudentFind(String studentNo,String password){
        Student stu;
        stu = studentDao.selectByStudentNo(studentNo);
        String cpassword = DigestUtils.md5DigestAsHex(password.getBytes());
        if (stu!=null){
            if (stu.getStudentPassword().equals(cpassword)){
                return stu;
            }
            return null;
        }else{
            return null;
        }
    }
    /*对比教师表密码*/
    public Teacher loginTeacherFind(String teacherNo,String password){
        Teacher tea;
        tea = teacherDao.findAllByTeacherNo(teacherNo);
        String cpassword = DigestUtils.md5DigestAsHex(password.getBytes());
        if (tea!=null){
            if(tea.getTeacherPassword().equals(cpassword)){
                return tea;
            }
            return null;
        }else{
            return null;
        }
    }



}
