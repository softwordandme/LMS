package com.lms.dao;


import com.lms.po.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    Integer deleteAllByCourseId(Integer courseId);

    Clazz findFirstByClazzNum(Integer clazzNum);

    /**
     * 查询所有的clazzNum(去除重复)
     * @return List<Integer>
     * */
    @Query(value = "select distinct clazz_num from clazz",nativeQuery = true)
    List<Integer> findDistinctClazzNum();

    /**
     * 根据CourseId删除记录
     * @return Integer
     * */
    Integer deleteClazzesByCourseId(Integer courseId);
}
