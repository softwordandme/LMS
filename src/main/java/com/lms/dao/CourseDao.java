package com.lms.dao;

import com.lms.po.Course;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * Demo class
 *
 * @author zz
 * @date 2019
 */
public interface CourseDao{

    int deleteByPrimaryKey(Integer courseId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);


    Course findCourseByCourseIdAndTermId(Integer courseId, Integer termId);

    List<Course> findCoursesByTermId(Integer termId);

    Course findByTeacherNoAndTermId(String teacherNo,Integer termId);

    List<Course> findCoursesByTeacherNo(String teacherNo);

    /**
     * 查询所有课程
     * @return Integer
     * */
    List<Course> findAll();

    /**
     * 根据TeacherNo删除记录
     * @param teacherNo
     * @return Integer
     * */
    Integer deleteCoursesByTeacherNo(String teacherNo);
}