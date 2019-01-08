package com.lms.services;


import com.lms.dao.*;
import com.lms.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzService {
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
     查询所有班级的所有信息
     */
        public List<Clazz> findClazzAllByClazzNum(Integer clazzNum){
            List<Clazz> clazz;
            clazz = clazzDao.findClazzAllByClazzNum(clazzNum);
            if (clazz!=null){
                return clazz;
            }else{
                return null;
            }
        }
        public Clazz findFirstByClazzNum(Integer clazzNum){
            return clazzDao.findFirstByClazzNum(clazzNum);
        }
        public List<Clazz> findAll(){
        return clazzDao.findAll();
    }

    public int deleteClazzById(Integer id){
         clazzDao.deleteById(id);
        return 1;
    }

    /**
     * 根据courseId删除班级的课程
     */
    public Integer deleteAllByCourseId(Integer courseId){
        return clazzDao.deleteAllByCourseId(courseId);
    }

    /**
     * 根据courseId查找课程
     */
    public List<Clazz> findClazzesByCourseId(Integer courseId){
        return clazzDao.findClazzesByCourseId(courseId);
    }

    /**
    * 添加操作
     */
    public int addClazzDo(Clazz clazz){
        Clazz clazz1 = clazzDao.findClazzByClazzNumAndCourseId(clazz.getClazzNum(),clazz.getCourseId());
        if (clazz1 != null){
            return 0;
        }else {
            return clazzDao.insert(clazz);
        }
    }

    /**
    * 根据id查找Clazz
     */
    public  Clazz findClazzById(Integer id){
            return clazzDao.selectByPrimaryKey(id);
    }
    /**
    * 更新Clazz信息
     */
    public  int editClazzDo(Clazz clazz){
        Clazz clazz1 = clazzDao.findClazzByClazzNumAndCourseId(clazz.getClazzNum(),clazz.getCourseId());
        if (clazz1 != null){
            return 0;
        }else {
            return clazzDao.updateByPrimaryKeySelective(clazz);
        }

    }

    public  List<Department> findAllDepartment(){
        return  departmentDao.findAll();
    }
}
