package com.lms.dao;

import com.lms.po.Student;

import java.util.List;

public interface StudentDao {

    int deleteByPrimaryKey(Integer studentId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Student selectByStudentNo(String studentNo);

    List<Student> findStudents();

    List<Student> selectByClazzNum(Integer clazz_num);

    Student selectByClazzNumAndStudentNo(String studentNo,Integer studentId);
}