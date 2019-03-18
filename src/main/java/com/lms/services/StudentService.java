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
        student = studentDao.selectByStudentNo(studentNo);
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
        return studentDao.insert(student);
    }
    /**
     根据studentId查找信息
     * */
    public Student findStudentByStudentId(Integer sutdentId){
        return studentDao.selectByPrimaryKey(sutdentId);
    }
    public  int editStudentDo(Student student){
        return  studentDao.updateByPrimaryKey(student);
    }
    /**查询所有记录*/
    public List<Student> findAll(){
        return studentDao.findStudents();
    }

    public  Integer deleteStudentByStudentId(Integer studentId){
        return  studentDao.deleteByPrimaryKey(studentId);
    }

    /**
     * 根据班级获取学生数
     */
    public Integer countStudentsByClazzNum(Integer clazzNum){
        return studentDao.selectByClazzNum(clazzNum).size();
    }

    public List<Integer> findDistinctClazzNum(){
        return clazzDao. findDistinctClazzNum();
    }

    public Student findStudentByStudentNo(String studentNo){
        return  studentDao.selectByStudentNo(studentNo);
    }

   public  Student findTeacherByStudentNoWithStudentId(String studentNo,Integer studentId){
        return studentDao.selectByClazzNumAndStudentNo(studentNo,studentId);
   }
}
