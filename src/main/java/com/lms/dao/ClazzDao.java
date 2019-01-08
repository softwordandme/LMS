package com.lms.dao;


import com.lms.po.Clazz;

import java.util.List;

/**
 * Demo class
 *
 * @author zz
 * @date 2019
 */
public interface ClazzDao {

    int deleteByPrimaryKey(Integer id);

    int insert(Clazz record);


    int insertSelective(Clazz record);

    /**
     * 根据Id查询Clazz
     * @param id clazzId
     * @return Clazz
     * */
    Clazz selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Clazz record);

    int updateByPrimaryKey(Clazz record);


    Clazz findAllByClazzNum(Integer clazzNum);

    /**
     通过clazzNum（班级编号）查询所有班级的所有信息
     */
    List<Clazz> findClazzAllByClazzNum(Integer clazzNum);

    /**
     通过clazzNum（班级编号）和courseId查询所有班级的所有信息
     */
    Clazz findClazzByClazzNumAndCourseId(Integer clazzNum, Integer courseId);

    List<Clazz> findClazzesByCourseId(Integer courseId);

    /**
     * 根据CourseId删除记录
     * @param courseId
     * @return Integer
     * */
    Integer deleteAllByCourseId(Integer courseId);

    Clazz findFirstByClazzNum(Integer clazzNum);

    /**
     * 查询所有的clazzNum(去除重复)
     * @return List<Integer>
     * */
    List<Integer> findDistinctClazzNum();
}
