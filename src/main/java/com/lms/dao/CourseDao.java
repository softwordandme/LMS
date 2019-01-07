package com.lms.dao;

import com.lms.po.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface CourseDao extends JpaRepository<Course,Integer> {

    Course findCourseByCourseIdAndTermId(Integer courseId, Integer termId);

    List<Course> findCoursesByTermId(Integer termId);

    Course findByTeacherNoAndTermId(String teacherNo, Integer termId);

    List<Course> findCoursesByTeacherNo(String teacherNo);

    @Override
    List<Course> findAll();

    Course findCourseByCourseId(Integer courseId);

    @Transactional
    Integer deleteCourseByCourseId(Integer courseId);

    /**
     * 根据TeacherNo删除记录
     * @return Integer
     * */
    Integer deleteCoursesByTeacherNo(String teacherNo);
}