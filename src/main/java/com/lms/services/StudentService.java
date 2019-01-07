package com.lms.services;

import com.lms.dao.*;
import com.lms.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    ClazzDao clazzDao;
    @Autowired
    CourseDao courseDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    DepartmentDao departmentDao;
    /**
     * 查找单个学生信息
     **/
    public Student findStudentAll(String studentNo){
        Student student;
        student = studentDao.findStudentByStudentNo(studentNo);
        if (student!=null){
            return student;
        }else{
            return null;
        }
    }

    /**
     * 添加学生
     * */
    public int addStudentDo(Student student){
        //MD5加密
        student.setStudentPassword(DigestUtils.md5DigestAsHex(student.getStudentPassword().getBytes()));
        return studentDao.addStudentDo(student);
    }
    /**
     根据studentId查找信息
     * */
    public Student findStudentByStudentId(Integer sutdentId){
        return studentDao.findStudentByStudentId(sutdentId);
    }
    public  int editStudentDo(Student student){
        return  studentDao.editStudentDo(student);
    }
    /**查询所有记录*/
    public List<Student> findAll(){
        return studentDao.findAll();
    }

    public  Integer deleteStudentByStudentId(Integer studentId){
        return  studentDao.deleteStudentByStudentId(studentId);
    }

    /**
     * 根据班级获取学生数
     */
    public Integer countStudentsByClazzNum(Integer clazzNum){
        return studentDao.countStudentsByClazzNum(clazzNum);
    }

    public List<Integer> findDistinctClazzNum(){
        return clazzDao. findDistinctClazzNum();
    }

    public Student findStudentByStudentNo(String studentNo){
        return  studentDao.findStudentByStudentNo(studentNo);
    }

   public  Student findTeacherByStudentNoWithStudentId(String studentNo,Integer studentId){
        return studentDao.findStudentByStudentNoWithStudentId(studentNo,studentId);
   }
}
