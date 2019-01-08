package com.lms.dao;


import com.lms.po.EvaluationType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationTypeDao{

   EvaluationType findAllByRoleId(Integer roleId);

   List<EvaluationType> findAll();

    int deleteByPrimaryKey(Integer evaluationTypeId);

    int insert(EvaluationType record);

    int insertSelective(EvaluationType record);

    /**
     * 通过评教类型ID查找EvaluationType表里的所有字段
     * @param evaluationTypeId
     * @return EvaluationType
     */
    EvaluationType selectByPrimaryKey(Integer evaluationTypeId);

    int updateByPrimaryKeySelective(EvaluationType record);

    int updateByPrimaryKey(EvaluationType record);

}
