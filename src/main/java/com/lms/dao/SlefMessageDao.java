package com.lms.dao;


import com.lms.po.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlefMessageDao extends JpaRepository<Student,Integer>{
    Student findAllByStudentNo(Integer StudentNo);

}
