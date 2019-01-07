package com.lms.dao;

import com.lms.po.Student;

public interface StudentMapper {
    int insert(Student record);

    int insertSelective(Student record);
}