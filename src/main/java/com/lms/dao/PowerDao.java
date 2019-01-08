package com.lms.dao;


import com.lms.po.Power;

import java.util.List;

/**
 * PowerDao interface
 *
 * @author zz
 * @date 2019
 */
public interface PowerDao{
       /**
        * 查询所有
        * @return List<Power>
        */
       List<Power> findAll();


       int deleteByPrimaryKey(Integer powerId);

       int insert(Power record);

       int insertSelective(Power record);

       Power selectByPrimaryKey(Integer powerId);

       int updateByPrimaryKeySelective(Power record);

       int updateByPrimaryKey(Power record);
}
