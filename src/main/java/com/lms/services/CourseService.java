package com.lms.services;


import com.lms.dao.*;
import com.lms.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
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
    public Course findByCourseIdAndTermId(Integer courseId, Integer termId){
        Course course;
        course = courseDao.findCourseByCourseIdAndTermId(courseId,termId);
        if (course!=null){
            return course;
        }else{
            return null;
        }
    }

    public Course findByTeacherNoAndTermId(String teacherNo,Integer termId){
        Course course;
        course = courseDao.findByTeacherNoAndTermId(teacherNo,termId);
        if (course!=null){
            return course;
        }else{
            return null;
        }
    }
    /**
     * 根据teacherNo查找课程
     */
    public List<Course> findCoursesByTeacherNo(String teacherNo){
        return courseDao.findCoursesByTeacherNo(teacherNo);
    }

    public List<Course> findAllByCourseTerm(String term){

        return null;
    }

    public List<Course> findAll(){
        return courseDao.findAll();
    }
    /**
     * 根据课程id查找课程
     */
    public Course findCourseByCourseId(Integer courseId){
        return courseDao.selectByPrimaryKey(courseId);
    }
    /**
     * 根据课程id删除课程记录
     */
    public   Integer deleteCourseByCourseId(Integer courseId){

        return  courseDao.deleteByPrimaryKey(courseId);
    }
    /**
     * 添加课程记录
     */
    public int addCourseDo(Course course){
        return  courseDao.insert(course);
    }
    /**
     * 修改课程记录
     */
    public int editCourseDo(Course course){
        return  courseDao.insert(course);
    }
    /**根据courseId查询clazz*/
    public List<Clazz> findClazzesByCourseId(Integer courseId){
        return clazzDao.findClazzesByCourseId(courseId);
    }

}
